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

package io.github.rmbar.tight_types.string;

/**
 * A non-empty string that is composed only of the characters in the range A-F, a-f, and 0-9.
 *
 * Formally, the Unicode code points of the characters of this string may only be in the inclusive ranges: [65-70],
 * [97-102], or [48-57].
 */
public class HexadecimalStr extends LatinLettersDigitsStr
{
    /**
     * Creates a new string from the given character sequence.
     *
     * @param value the characters of the string. may not be {@code null}.
     * @throws IllegalStringContentException if the given string contains any character that is not in the range A-F,
     *                                       a-f, or 0-9.
     */
    public HexadecimalStr(String value)
    {
        super(value);

        for(int i = 0; i<value.length(); i++)
        {
            int codePoint = value.codePointAt(i);

            // check if hex letter
            if((codePoint >= 65 && codePoint <= 70) || (codePoint >= 97 && codePoint <= 102))
                continue;

            // check if digit
            if(codePoint >= 48 && codePoint <= 57)
                continue;

            throw new IllegalStringContentException("value may only be composed of A-F, a-f, and 0-9 found " +
                                                     value.charAt(i) + " at position " + i + " in " + value);
        }
    }
}
