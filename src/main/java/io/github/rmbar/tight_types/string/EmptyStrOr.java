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
 * An immutable string that's content is defined by an encapsulated inner immutable string that is either the empty
 * string or an instance of a descendant of {@code NonEmptyString}.
 *
 * This interface is useful for describing a value that is restricted to being either an instance of {@code S} or the
 * empty string. Namely it models the union of {@code S} and the empty string.
 *
 * @param <S> the type of the inner string that may be encapsulated by this wrapper if the wrapper is in the non-empty
 *           state.
 */
public class EmptyStrOr<S extends NonEmptyString>
{
    /**
     * {@code null} if the string represents the empty string, otherwise the string content of the outer string.
     */
    private final S _innerString;

    /**
     * Creates a new string with an empty string as the inner value.
     */
    public EmptyStrOr()
    {
        _innerString = null;
    }

    /**
     * Creates a new string with the given string as the inner value.
     *
     * @param innerString the string value the constructed string represents. may not be {@code null}.
     */
    public EmptyStrOr(S innerString)
    {
        if(innerString == null)
            throw new NullPointerException("innerString");

        _innerString = innerString;
    }

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
    public final <R, T extends Throwable> R which(EmptyStrOrCases<R, S, T> cases) throws T
    {
        if(_innerString == null)
            return cases.forEmpty();

        return cases.forNonEmpty(_innerString);
    }

    /**
     * @return {@code true} if this string's content is empty, otherwise {@code false}
     */
    public final boolean isEmptyString()
    {
        return _innerString == null;
    }

    /**
     * @return {@code false} if this string's content is empty, otherwise {@code true}
     */
    public final boolean isNonEmptyString()
    {
        return !isEmptyString();
    }

    /**
     * Retrieves the inner non-empty string value if this string is non-empty, otherwise returns {@code defaultValue}.
     *
     * @param defaultValue the value to return if this string is empty. may be {@code null}.
     * @return the inner string or {@code defaultValue}.
     */
    public final S getOrDefault(S defaultValue) // TODO rename orElse to match JDK 8 convention
    {
        if(_innerString == null)
            return defaultValue;

        return _innerString;
    }

    /**
     * @return if non-empty returns {@link NonEmptyString#toString()} otherwise {@code ""}.
     */
    public String toString()
    {
        if(_innerString == null)
            return  "";

        return _innerString.toString();
    }
}
