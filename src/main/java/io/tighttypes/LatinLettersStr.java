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
 * A non-empty string that is composed only of the characters A-Z and a-z.
 *
 * Formally, the Unicode code points of the characters of a <code>VisibleLatinLettersDigitsStr</code> may only be in
 * the inclusive ranges: [65-90] or [97-122].
 */
public interface LatinLettersStr extends LatinLettersDigitsStr
{
    /**
     * Creates a new <code>LatinLettersStr</code> from the given value.
     *
     * @param value the value of the <code>LatinLettersStr</code>.
     * @return a string composed of the characters of <code>value</code>
     * @throws IllegalArgumentException if <code>value</code> is empty or contains a unicode character not in the ranges
     *                                  [65-90] or [97-122]
     * @throws NullPointerException if value is <code>null</code>
     */
    static LatinLettersStr parse(String value)
    {
        if(value == null)
            throw new NullPointerException();

        return new LatinLettersStrDefault(value);
    }
}
