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
 * Thrown to indicate that a string value provided as an argument is of invalid length.
 */
public class IllegalStringLengthException extends IllegalArgumentException
{
    public enum Violation
    {
        TooLong,
        TooShort
    }

    private final String _message;

    /**
     * Constructs a new exception specifying that the given string is not of the given length.
     *
     * @param string the offending string. may not be {@code null}.
     * @param expectedLength the expected, but not found, length of the given string.
     */
    IllegalStringLengthException(NonEmptyString string, int expectedLength)
    {
        _message = "Expecting a string of length " + expectedLength + " but given a string of length " +
                    string.toString().length() + ". Offender: " + string.toString();

    }

    /**
     * Constructs a new exception specifying that the given string is not of valid length.
     *
     * @param string the offending string. may not be {@code null}.
     * @param limit the expected length limitation value.
     * @param violation the reason the given string length is in violation relative to the given limit. may not be
     *                  {@code null}.
     */
    IllegalStringLengthException(NonEmptyString string, int limit, Violation violation)
    {
        if (violation == Violation.TooLong)
        {
            _message = "Expecting a string of length of at most" + limit + " but given a string of length " +
                       string.toString().length() + ". Offender: " + string.toString();
        }
        else
        {
            _message = "Expecting a string of length of at least" + limit + " but given a string of length " +
                        string.toString().length() + ". Offender: " + string.toString();
        }

    }

    @Override
    public String getMessage()
    {
        return _message;
    }
}
