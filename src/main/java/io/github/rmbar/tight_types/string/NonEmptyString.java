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
public interface NonEmptyString extends Comparable<NonEmptyString>
{
    /**
     * @return returns the same value as {@code toString().hashCode()}.
     */
    int hashCode();

    /**
     * Compares this string to the given  object. The result is {@code true} if and only if the argument is
     * not {@code null} and is a {@code NonEmptyString} object that represents the same sequence of characters
     * as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the strings represent the same character content.
     */
    boolean equals(Object other);

    /**
     * Compares this string to the given  string. The result is {@code true} if and only if the argument is
     * not {@code null} and represents the same sequence of characters as this object.
     *
     * @param other the other object. may be {@code null}.
     * @return {@code true} if the strings represent the same character content.
     */
    default boolean equals(NonEmptyString other)
    {
        return other != null && other.toString().equals(toString());
    }

    @Override
    default int compareTo(NonEmptyString other)
    {
        return toString().compareTo(other.toString());
    }

    /**
     * @return the value of this string in {@code String} form. never {@code null}.
     */
    String toString();

    /**
     * Creates a non-empty string from the given string.
     *
     * @param value the characters of the {@code NonEmptyString}. may not be {@code null}.
     * @return the given value of in {@code NonEmptyString} form.
     * @throws IllegalArgumentException if {@code value} has length zero.
     */
    static NonEmptyString make(String value)
    {
        if(value == null)
            throw new NullPointerException();

        return new NonEmptyStringDefault(value);
    }
}
