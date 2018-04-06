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
 * A non-negative integer in the range [0...2^31-1] inclusive. That is, a non-negative number with a value at most
 * 2,147,483,647.
 */
public interface NonNegInt extends NonNegLong
{
    /**
     * @return the value of the <code>NonNegInt</code> in <code>int</code> form.
     */
    int toInt();

    /**
     * Creates a new <code>NonNegInt</code> from the given value.
     *
     * @param value the value of the <code>NonNegInt</code>.
     * @return the new number.
     * @throws IllegalArgumentException if <code>value</code> is less than zero.
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
     * Creates a new <code>NonNegInt</code> from the given value.
     *
     * @param value the value of the <code>NonNegInt</code>.
     * @throws IllegalArgumentException if <code>value</code> is less than zero.
     * @return the parsed value of the string
     * @throws NumberFormatException if the string does not contain a parsable {@code int}.
     */
    static NonNegInt parse(String value)
    {
        int intValue = Integer.parseInt(value);
        return make(intValue);
    }

}
