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

package io.github.rmbar.tight_types.character;

/**
 * A character that is not a non-whitespace character as defined by {@link Character#isWhitespace(char)}.
 */
public class VisibleCharacter implements Comparable<VisibleCharacter>
{
    /**
     * The character in char form.
     */
    private final char _value;

    /**
     * Constructs a new non-whitespace character.
     *
     * @param value the character value.
     * @throws IllegalArgumentException if the character is a whitespace character as tested by
     * {@link Character#isWhitespace(char)}.
     */
    public VisibleCharacter(char value)
    {
        if(Character.isWhitespace(value))
            throw new IllegalArgumentException("character is whitespace character. found code point " + (int)value);

        _value = value;
    }

    /**
     * Constructs a new non-whitespace character.
     *
     * @param value the character value. may not be {@code null}.
     * @throws IllegalArgumentException if the character is a whitespace character as tested by
     * {@link Character#isWhitespace(char)}.
     */
    public VisibleCharacter(Character value)
    {
        this(value.charValue());
    }

    /**
     * @return returns the character in {@code Character} form. never {@code null}.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final Character toCharacter()
    {
        return _value;
    }

    /**
     * @return returns the character in {@code char} form.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final char toChar()
    {
        return _value;
    }

    /**
     * @return returns the same value as {@code toCharacter().hashCode()}.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final int hashCode()
    {
        return toCharacter().hashCode();
    }

    /**
     * Compares this character to the given object. The result is {@code true} if and only if the argument is
     * not {@code null} and is a {@code VisibleCharacter} object that represents the same character as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the character represent the same character as this character.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final boolean equals(Object other)
    {
        return other instanceof VisibleCharacter && ((VisibleCharacter)other).equals(this);
    }

    /**
     * Compares this character to the given character. The result is {@code true} if and only if the argument is
     * not {@code null} and represents the same character as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the character represent the same character as this character.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final boolean equals(VisibleCharacter other)
    {
        return other != null && other.toChar() == toChar();
    }

    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    @Override
    public final int compareTo(VisibleCharacter other)
    {
        return toCharacter().compareTo(other.toCharacter());
    }

    /**
     * @return the value of this character in {@code String} form. never {@code null}.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final String toString()
    {
        return _value + "";
    }
}
