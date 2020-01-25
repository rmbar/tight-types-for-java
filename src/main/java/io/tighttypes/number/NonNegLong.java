/*
 * MIT License
 *
 * Copyright (c) 2018 rmbar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.tighttypes.number;

import java.math.BigInteger;

/**
 * A non-negative integer in the range [0...2^63-1] inclusive. That is, a non-negative integer with a value at most
 * 9,223,372,036,854,775,807.
 */
public interface NonNegLong extends BigInt
{
    /**
     * @return the value of this object as a {@code long}.
     */
    long toLong();

    default BigInteger toBigInteger()
    {
        return BigInteger.valueOf(toLong());
    }

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default NonNegBigInt add(NonNegLong value)
    {
        return NonNegBigInt.make(toBigInteger().add(value.toBigInteger()));
    }

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     * @throws OverflowException if the result overflows a long.
     */
    default NonNegLong addChecked(NonNegLong value) throws OverflowException
    {
        try
        {
            return addUnchecked(value);
        }
        catch (ArithmeticException e)
        {
            throw new OverflowException();
        }
    }

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     * @throws ArithmeticException if the result overflows a long.
     */
    default NonNegLong addUnchecked(NonNegLong value)
    {
        return make(Math.addExact(toLong(), value.toLong()));
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     * @throws IllegalArgumentException if the resulting difference is less than zero.
     */
    default NonNegLong subtractChecked(NonNegLong value) throws InvalidArgumentException
    {
        try
        {
            return subtractUnchecked(value);
        }
        catch (IllegalArgumentException e)
        {
            throw new InvalidArgumentException();
        }
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     * @throws ArithmeticException if the result overflows a long.
     * @throws IllegalArgumentException if the resulting difference is less than zero.
     */
    default NonNegLong subtractUnchecked(NonNegLong value)
    {
        return make(Math.subtractExact(toLong(), value.toLong()));
    }

    /**
     * Returns the distance on the number line between this number and {@code other}.
     *
     * @param other a point on the number line. may not be {@code null}.
     * @return the absolute value of {@code (this-other}.
     */
    default NonNegLong distanceTo(NonNegLong other)
    {
        long value = other.toBigInteger().subtract(toBigInteger()).abs().longValueExact();
        return NonNegLong.make(value);
    }

    /**
     * Creates a {@code NonNegLong} from the given value.
     *
     * @param value the value of the {@code NonNegLong}.
     * @return the new number.
     * @throws IllegalArgumentException if {@code value} is less than zero.
     */
    static NonNegLong make(long value)
    {
        if(value < 0)
            throw new IllegalArgumentException("value may not be less than zero.");

       return new NonNegLongBase()
       {
           @Override
           public long toLong()
           {
               return value;
           }
       };
    }

    /**
     * Creates a {@code NonNegLong} from the given string value.
     *
     * @param value the value of the {@code NonNegLong}. may not be {@code null}.
     * @return the parsed value of the given string. never {@code null}.
     * @throws NullPointerException if the given value is {@code null}.
     * @throws NumberFormatException if the given string is not parsable into a {@code long}.
     * @throws IllegalArgumentException if {@code value} is less than zero.
     */
    static NonNegLong parse(String value)
    {
        if(value == null)
            throw new NullPointerException("value");

        long longValue = Long.parseLong(value);
        return make(longValue);
    }
}
