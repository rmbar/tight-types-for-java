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
 * An immutable string of non-zero length.
 */
public class NonEmptyString implements Comparable<NonEmptyString>
{
    /**
     * The string value in Java String form.
     */
    private final String _value;

    /**
     * Creates a new string from the given non-empty character sequence.
     *
     * @param value the characters of the string. may not be {@code null}.
     * @throws IllegalArgumentException if the given string is empty.
     */
    public NonEmptyString(String value)
    {
        if(value.isEmpty())
            throw new IllegalArgumentException("value may not be empty.");

        _value = value;
    }

    /**
     * @return returns the same value as {@code toString().hashCode()}.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final int hashCode()
    {
        return toString().hashCode();
    }

    /**
     * Compares this string to the given  object. The result is {@code true} if and only if the argument is
     * not {@code null} and is a {@code NonEmptyString} object that represents the same sequence of characters
     * as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the strings represent the same character content.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final boolean equals(Object other)
    {
        return other instanceof NonEmptyString && ((NonEmptyString)other).equals(this);
    }

    /**
     * Compares this string to the given  string. The result is {@code true} if and only if the argument is
     * not {@code null} and represents the same sequence of characters as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the strings represent the same character content.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final boolean equals(NonEmptyString other)
    {
        return other != null && other.toString().equals(toString());
    }

    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    @Override
    public final int compareTo(NonEmptyString other)
    {
        return toString().compareTo(other.toString());
    }

    /**
     * @return the value of this string in {@code String} form. never {@code null}.
     */
    // final so security sensitive users of the library can reason about the behavior of the method with confidence.
    public final String toString()
    {
        return _value;
    }
}
