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

/**
 * An integer in the range [1...2^63-1] inclusive.  That is, a natural number with a value at most
 * 9,223,372,036,854,775,807.
 */
public interface NatLong extends NonNegLong
{
    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default NatBigInt add(NatLong value)
    {
        return NatBigInt.make(toBigInteger().add(value.toBigInteger()));
    }

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     * @throws OverflowException if the result overflows a long.
     */
    default NatLong addChecked(NatLong value) throws OverflowException
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
    default NatLong addUnchecked(NatLong value)
    {
        return make(Math.addExact(toLong(), value.toLong()));
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     * @throws InvalidArgumentException if the result overflows a long.
     */
    default NatLong subtractChecked(NatLong value) throws InvalidArgumentException
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
     * @throws IllegalArgumentException if the resulting difference is less than zero.
     */
    default NatLong subtractUnchecked(NatLong value)
    {
        return make(Math.subtractExact(toLong(), value.toLong()));
    }

    /**
     * Creates a new {@code NatLong} from the given value.
     *
     * @param value the value of the {@code NatLong}.
     * @return the new number.
     * @throws IllegalArgumentException if {@code value} is less than one.
     */
    static NatLong make(long value)
    {
        if (value < 1)
            throw new IllegalArgumentException("value may not be less than one. Given " + value);

        return new NatLongBase()
        {
            @Override
            public long toLong()
            {
                return value;
            }
        };

    }

    /**
     * Creates a {@code NatLong} from the given string value.
     *
     * @param value the value of the {@code NatLong}. may not be {@code null}.
     * @return the parsed value of the given string. never {@code null}.
     * @throws NullPointerException if the given value is {@code null}.
     * @throws NumberFormatException if the given string is not parsable into a {@code long}.
     * @throws IllegalArgumentException if {@code value} is less than one.
     */
    static NatLong parse(String value)
    {
        if(value == null)
            throw new NullPointerException("value");

        long longValue = Long.parseLong(value);
        return make(longValue);
    }
}
