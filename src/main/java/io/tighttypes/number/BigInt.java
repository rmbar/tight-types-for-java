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

package io.tighttypes.number;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * An immutable arbitrary-precision integer.
 */
public interface BigInt extends BigRat
{
    /**
     * @return the value of this {@code BigInt} in {@code BigInteger} form. never {@code null}.
     */
    BigInteger toBigInteger();

    @Override
    default BigDecimal toBigDecimal()
    {
        return new BigDecimal(toBigInteger());
    }

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default BigInt add(BigInt value)
    {
        return make(toBigInteger().add(value.toBigInteger()));
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     */
    default BigInt subtract(BigInt value)
    {
        return BigInt.make(toBigInteger().subtract(value.toBigInteger()));
    }

    /**
     * @return the absolute value of this number. never {@code null}.
     */
    default NonNegBigInt abs()
    {
        return NonNegBigInt.make(toBigInteger().abs());
    }

    /**
     * Returns a {@code BigInt} with the same value as the given {@code BigInteger}.
     *
     * @param value the value of the number to be returned. may not be {@code null}.
     * @return a {@code BigInt} with the same value as the given {@code BigInteger}. never {@code null}.
     */
    static BigInt make(BigInteger value)
    {
        if(value == null)
            throw new NullPointerException("value");

        return new BigIntBase()
        {
            @Override
            public BigInteger toBigInteger()
            {
                return value;
            }
        };
    }

    /**
     * Returns a {@code BigInt} with the same value as the given {@code long}.
     *
     * @param value the value of the number to be returned.
     * @return a {@code BigInt} with the same value as the given {@code long}. never {@code null}.
     */
    static BigInt make(long value)
    {
        return make(BigInteger.valueOf(value));
    }
}
