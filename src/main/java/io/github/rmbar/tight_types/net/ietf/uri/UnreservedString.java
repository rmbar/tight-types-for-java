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

package io.github.rmbar.tight_types.net.ietf.uri;

import io.github.rmbar.tight_types.string.VisibleString;

/**
 * A non-empty string composed only of the "Unreserved Characters" as defined by section 2.3 of
 * <a href="https://tools.ietf.org/html/rfc3986#section-2.3">RFC3976</a>.  Specifically, characters in the ranges A-Z,
 * a-z, 0-9 and also the characters {@code -} (hyphen), {@code .} (period), {@code _} (underscore), and {@code ~}
 * (tilde).
 */
public class UnreservedString extends VisibleString
{
    /**
     * Creates a new string from the given character sequence.
     *
     * @param value the characters of the string. may not be {@code null}.
     * @throws IllegalArgumentException if the given string contains any character that is not in the range A-Z, a-z,
     *                                  or 0-9 and is also not any of '-', '.', '_', or '~'.
     */
    public UnreservedString(String value)
    {
        super(value);

        for(int i = 0; i<value.length(); i++)
        {
            int codePoint = value.codePointAt(i);

            if(UnreservedCharacter.isUnreservedCharacter(codePoint))
                continue;

            throw new IllegalArgumentException("value may only be composed of A-Z, a-z, 0-9, '-', '.', '_', and '~'. " +
                                               " found " + value.charAt(i) + " at position " + i + " in " + value);
        }
    }
}
