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

package io.tighttypes.string;

class LatinLettersDigitsStrDefault extends NonEmptyStringDefault implements VisibleString, LatinLettersDigitsStr
{
    LatinLettersDigitsStrDefault(String string)
    {
        super(string);

        for(int i = 0; i<string.length(); i++)
        {
            int codePoint = string.codePointAt(i);

            // check if letter
            if((codePoint >= 65 && codePoint <= 90) || (codePoint >= 97 && codePoint <= 122))
                continue;

            // check if digit
            if(codePoint >= 48 && codePoint <= 57)
                continue;

            throw new IllegalArgumentException("string may only be composed of A-Z, a-z, and 0-9 found " +
                                                string.charAt(i) + " at position " + i + " in " + string);
        }
    }
}
