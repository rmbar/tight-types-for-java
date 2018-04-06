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

package io.tighttypes;

/**
 * A non-negative integer in the range [0...2^63-1] inclusive. That is, a non-negative integer with a value at most
 * 9,223,372,036,854,775,807.
 */
public interface NonNegLong extends Comparable<NonNegLong>
{
    /**
     * @return the value of this object as a <code>long</code>.
     */
    long toLong();

    /**
     * Tests if <code>other</code> is a non-null instance of <code>NonNegLong</code> and also <code>other</code> represents
     * the same number as this <code>NonNegLong</code>.
     *
     * @param other the value to test
     * @return <code>true</code> if the two instances have the same numeric value and both are <code>NonNegLong</code>s.
     */
    @Override
    boolean equals(Object other);

    /**
     * Tests if the <code>NonNegLong</code> and <code>other</code> represent the same number.
     *
     * @param other the value to test
     * @return <code>true</code> if the two instances have the same numeric value.
     */
    default boolean equals(NonNegLong other)
    {
        return other != null && other.toLong() == toLong();
    }

    /**
     * @return the numeric value of the integer modulus {@link Integer#MAX_VALUE}.
     */
    @Override
    int hashCode();

    @Override
    default int compareTo(NonNegLong other)
    {
        return Long.compare(toLong(), other.toLong());
    }

    /**
     * Creates a new <code>NonNegLong</code> from the given value.
     *
     * @param value the value of the <code>NonNegLong</code>.
     * @return the new number.
     * @throws IllegalArgumentException if <code>value</code> is less than zero.
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
     * Creates a new <code>NonNegLong</code> from the given value.
     *
     * @param value the value of the <code>NonNegLong</code>.
     * @throws IllegalArgumentException if <code>value</code> is less than zero.
     * @return the parsed value of the string
     * @throws NumberFormatException if the string does not contain a parsable <code>long</code>.
     */
    static NonNegLong parse(String value)
    {
        long longValue = Long.parseLong(value);
        return make(longValue);
    }
}
