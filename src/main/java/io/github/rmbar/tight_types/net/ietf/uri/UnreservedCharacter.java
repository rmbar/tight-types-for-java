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

import io.github.rmbar.tight_types.character.VisibleCharacter;

/**
 * A a character drawn from the set of the "Unreserved Characters" as defined by section 2.3 of
 * <a href="https://tools.ietf.org/html/rfc3986#section-2.3">RFC3976</a>.  Specifically, a character in the range A-Z,
 * a-z, or 0-9 or also one of the characters {@code -} (hyphen), {@code .} (period), {@code _} (underscore), or
 * {@code ~} (tilde).
 */
public class UnreservedCharacter extends VisibleCharacter
{
    /**
     * Creates a new character from the given character.
     *
     * @param value the character value.
     * @throws IllegalArgumentException if the given character is not in the range A-Z, a-z, or 0-9 and is also not any
     *                                  of '-', '.', '_', or '~'.
     */
    public UnreservedCharacter(char value)
    {
       this((Character)value);
    }

    /**
     * Creates a new character from the given character.
     *
     * @param value the character value. may not be {@code null}.
     * @throws IllegalArgumentException if the given character is not in the range A-Z, a-z, or 0-9 and is also not any
     *                                  of '-', '.', '_', or '~'.
     */
    public UnreservedCharacter(Character value)
    {
        super(value);

        if(!isUnreservedCharacter(value))
            throw new IllegalArgumentException("value may only be one of A-Z, a-z, 0-9, '-', '.', '_', or '~'. " +
                                               "given " + value);
    }

    /**
     * Tests if the given Unicode code point specifies a character that is an Unreserved Character.
     *
     * @param codePoint the unicode code point.
     * @return if the described character is in the range A-Z, a-z, or 0-9 os is an of '-', '.', '_', or '~'.
     */
    static boolean isUnreservedCharacter(int codePoint)
    {
        // check if letter
        if((codePoint >= 65 && codePoint <= 90) || (codePoint >= 97 && codePoint <= 122))
            return true;

        // check if digit
        if(codePoint >= 48 && codePoint <= 57)
            return true;

        switch (codePoint)
        {
            case 45:  // -
            case 46:  // .
            case 95:  // _
            case 126: // ~
                return true;
        }

        return false;
    }
}
