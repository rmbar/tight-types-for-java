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
 * An immutable string value that encapsulates either an empty string or an instance of <code>NonEmptyString</code>.
 */
public interface EmptyStrOr<S extends NonEmptyString>
{
    /**
     * Performs one of two operations (both encapsulated in <code>cases</code>) depending on whether the string
     * is empty or not.
     *
     * If this string is empty, performs {@code cases.forEmpty()}. Otherwise performs
     * {@code cases.forNonEmpty(S)} passing in the string value.
     *
     * @param cases the two possible operations
     * @param <R> the result type of executing either of the operations
     * @param <T> the type of exception that may be raised by performing either of the operations
     * @return the result of performing one of the two given operations
     * @throws T if there is a problem performing the operation
     */
    <R, T extends Throwable> R which(EmptyStrOrCases<R, S, T> cases) throws T;

    /**
     * @return <code>true</code> if this string is empty, otherwise <code>false</code>
     */
    boolean isEmptyString();

    /**
     * @return <code>true</code> if this string is non-empty, otherwise <code>false</code>
     */
    boolean isNonEmptyString();

    /**
     * Retrieves the non-empty string value if this string is non-empty, otherwise returns <code>defaultValue</code>.
     *
     * @param defaultValue the value to return if this string is empty.
     * @return the value of the string or <code>defaultValue</code>.
     */
    S getOrDefault(S defaultValue);

    /**
     * @return if non-empty returns {@link NonEmptyString#toString()} otherwise <code>""</code>.
     */
    String toString();

    /**
     * @param <S> the specific type of <code>NonEmptyString</code>
     * @return an object of this class in the empty state.
     */
    static <S extends NonEmptyString> EmptyStrOr<S> make()
    {
        return new EmptyStrOrEmpty<>();
    }

    /**
     * @param string the non-empty string value.
     * @param <S> the specific type of <code>NonEmptyString</code>
     * @return an object of this class in the non-empty state.
     */
    static <S extends NonEmptyString> EmptyStrOr<S> make(S string)
    {
        return new EmptyStrOrNonEmpty<>(string);
    }
}
