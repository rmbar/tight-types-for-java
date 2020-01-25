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
 * A non-negative integer in the range [0...2^31-1] inclusive. That is, a non-negative number with a value at most
 * 2,147,483,647.
 */
public interface NonNegInt extends NonNegLong
{
    /**
     * @return the value of the {@code NonNegInt} in {@code int} form.
     */
    int toInt();

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default NonNegBigInt add(NonNegInt value)
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
    default NonNegInt addChecked(NonNegInt value) throws OverflowException
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
    default NonNegInt addUnchecked(NonNegInt value)
    {
        return make(Math.addExact(toInt(), value.toInt()));
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     */
    default int subtract(NonNegInt value)
    {
        return toInt() - value.toInt();
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     * @throws InvalidArgumentException if the result overflows a long.
     */
    default NonNegInt subtractChecked(NonNegInt value) throws InvalidArgumentException
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
    default NonNegInt subtractUnchecked(NonNegInt value)
    {
        return make(subtract(value));
    }

    /**
     * Creates a new {@code NonNegInt} from the given value.
     *
     * @param value the value of the {@code NonNegInt}.
     * @return the number.
     * @throws IllegalArgumentException if {@code value} is less than zero.
     */
    static NonNegInt make(int value)
    {
        if(value < 0)
            throw new IllegalArgumentException("value may not be less than zero.");

        return new NonNegIntBase()
        {
            @Override
            public int toInt()
            {
                return value;
            }

            @Override
            public long toLong()
            {
                return value;
            }
        };
    }

    /**
     * Creates a {@code NonNegInt} from the given string value.
     *
     * @param value the value of the {@code NonNegInt}. may not be {@code null}.
     * @return the parsed value of the given string. never {@code null}.
     * @throws NullPointerException if the given value is {@code null}.
     * @throws NumberFormatException if the given string is not parsable into a {@code int}.
     * @throws IllegalArgumentException if {@code value} is less than zero.
     */
    static NonNegInt parse(String value)
    {
        if(value == null)
            throw new NullPointerException("value");

        int intValue = Integer.parseInt(value);
        return make(intValue);
    }

}
