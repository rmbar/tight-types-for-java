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
 * An {@code EmptyStrOr<S>} with non-empty string content.
 */
class EmptyStrOrNonEmpty<S extends NonEmptyString> implements EmptyStrOr<S>
{
    private final S _innerString;

    EmptyStrOrNonEmpty(S string)
    {
        if(string == null)
            throw new NullPointerException("string");

        _innerString = string;
    }

    @Override
    public <R, T extends Throwable> R which(EmptyStrOrCases<R, S, T> cases) throws T
    {
        return cases.forNonEmpty(_innerString);
    }

    @Override
    public boolean isEmptyString()
    {
        return false;
    }

    @Override
    public S getOrDefault(S defaultValue)
    {
        return _innerString;
    }

    @Override
    public String toString()
    {
        return _innerString.toString();
    }
}
