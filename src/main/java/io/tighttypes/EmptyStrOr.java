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
 * An immutable string that's content is defined by an encapsulated inner immutable string that is either the empty
 * string or an instance of a descendant of {@code NonEmptyString}.
 *
 * This interface is useful for describing a value that is restricted to being either an instance of {@code S} or the
 * empty string. Namely it models the union of {@code S} and the empty string.
 *
 * @param <S> the type of the inner string that may be encapsulated by this wrapper if the wrapper is in the non-empty
 *           state.
 */
public interface EmptyStrOr<S extends NonEmptyString>
{
    /**
     * Performs one of two operations (both encapsulated in {@code cases}) depending on whether this string
     * is empty or not.
     *
     * If this string is empty, performs {@code cases.forEmpty()}. Otherwise performs
     * {@code cases.forNonEmpty(S)} passing in the inner string value.
     *
     * @param cases the two possible operations. may not be {@code null}.
     * @param <R> the result type of executing either of the operations.
     * @param <T> the type of the exception that may be raised by performing either of the operations.
     * @return the result of performing one of the two given operations.
     * @throws T if there is an exception while performing the operation.
     */
    <R, T extends Throwable> R which(EmptyStrOrCases<R, S, T> cases) throws T;

    /**
     * @return {@code true} if this string's content is empty, otherwise {@code false}
     */
    boolean isEmptyString();

    /**
     * @return {@code false} if this string's content is empty, otherwise {@code true}
     */
    default boolean isNonEmptyString()
    {
        return !isEmptyString();
    }

    /**
     * Retrieves the inner non-empty string value if this string is non-empty, otherwise returns {@code defaultValue}.
     *
     * @param defaultValue the value to return if this string is empty. may be {@code null}.
     * @return the inner string or {@code defaultValue}.
     */
    S getOrDefault(S defaultValue);

    /**
     * @return if non-empty returns {@link NonEmptyString#toString()} otherwise {@code ""}.
     */
    String toString();

    /**
     * @return a {@code EmptyStrOr<S>} instance with an inner empty string as content. never {@code null}.
     */
    static <S extends NonEmptyString> EmptyStrOr<S> make()
    {
        return new EmptyStrOrEmpty<>();
    }

    /**
     * @param string the non-empty string value to use as the returned string's content. may not be {@code null}.
     * @return a {@code EmptyStrOr<S>} instance with the given inner string as content. never {@code null}.
     */
    static <S extends NonEmptyString> EmptyStrOr<S> make(S string)
    {
        if(string == null)
            throw new NullPointerException("string");
        
        return new EmptyStrOrNonEmpty<>(string);
    }
}
