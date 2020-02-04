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

package io.github.rmbar.tight_types.number;

import java.math.BigInteger;

/**
 * An immutable arbitrary-precision integer with minimum value {@code 0}.
 */
public interface NonNegBigInt extends BigInt
{
    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default NonNegBigInt add(NonNegBigInt value)
    {
        return make(toBigInteger().add(value.toBigInteger()));
    }

    /**
     * @return the absolute value of this number. never {@code null}.
     */
    default NonNegBigInt abs()
    {
        return make(toBigInteger().abs());
    }

    /**
     * Returns a {@code NonNegBigInt} with the same value as the given {@code BigInteger}.
     *
     * @param value the value of the number to be returned. may not be {@code null}.
     * @return a {@code NonNegBigInt} with the same value as the given {@code BigInteger}. never {@code null}.
     * @throws IllegalArgumentException if {@code value < 0}.
     */
    static NonNegBigInt make(BigInteger value)
    {
        if(value == null)
            throw new NullPointerException("value");

        if(value.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("value must be at least 0. found " + value);

        return new NonNegBigIntBase()
        {
            @Override
            public BigInteger toBigInteger()
            {
                return value;
            }
        };
    }

    /**
     * Returns a {@code NonNegBigInt} with the same value as the given {@code long}.
     *
     * @param value the value of the number to be returned.
     * @return a {@code NonNegBigInt} with the same value as the given {@code long}. never {@code null}.
     * @throws IllegalArgumentException if {@code value < 0}.
     */
    static NonNegBigInt make(long value)
    {
        return make(BigInteger.valueOf(value));
    }

}
