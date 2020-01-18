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
 * An integer in the range [1...2^31-1] inclusive.  That is, a natural number with a value at most 2,147,483,647.
 */
public interface NatInt extends NonNegInt
{
    /**
     * Creates a {@code NatInt} from the given value.
     *
     * @param value the numeric value of the {@code NatInt}.
     * @return the natural number. never {@code null}.
     * @throws IllegalArgumentException if {@code value} is less than one.
     */
    static NatInt make(int value)
    {
        if(value < 1)
            throw new IllegalArgumentException("value may not be less than one. Given " + value);

        return new NatIntBase()
        {
            @Override
            public long toLong()
            {
                return value;
            }

            @Override
            public int toInt()
            {
                return value;
            }
        };
    }

    /**
     * Creates a {@code NatInt} from the given string value.
     *
     * @param value the value of the {@code NatInt}. may not be {@code null}.
     * @return the parsed value of the given string. never {@code null}.
     * @throws NullPointerException if the given value is {@code null}.
     * @throws NumberFormatException if the given string is not parsable into an {@code int}.
     * @throws IllegalArgumentException if {@code value} is less than one.
     */
    static NatInt parse(String value)
    {
        if(value == null)
            throw new NullPointerException("value");

        int intValue = Integer.parseInt(value);
        return make(intValue);
    }
}
