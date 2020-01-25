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

/**
 * An immutable arbitrary-precision rational number.
 */
public interface BigRat extends Comparable<BigRat>
{
    /**
     * @return the value of this {@code BigRat} in {@code BigDecimal} form. never {@code null}.
     */
    BigDecimal toBigDecimal();

    /**
     * Returns the sum of this number and the given number.
     *
     * @param value the number to add to this number. may not be {@code null}.
     * @return the sum of the two numbers. never {@code null}.
     */
    default BigRat add(BigRat value)
    {
        return make(toBigDecimal().add(value.toBigDecimal()));
    }

    /**
     * Returns the difference of this number and the given number.  That is {@code (this - value)}.
     *
     * @param value the number to subtract from this number. may not be {@code null}.
     * @return the difference of the two numbers. never {@code null}.
     */
    default BigRat subtract(BigRat value)
    {
        return BigRat.make(toBigDecimal().subtract(value.toBigDecimal()));
    }

    /**
     * @return the absolute value of this number. never {@code null}.
     */
    default BigRat abs()
    {
        return make(toBigDecimal().abs());
    }

    /**
     * Returns the distance on the number line between this number and {@code other}.
     *
     * @param other a point on the number line. may not be {@code null}.
     * @return the absolute value of {@code (this-other}.
     */
    default BigRat distanceTo(BigRat other)
    {
        return subtract(other).abs();
    }

    /**
     * Tests if {@code other} is a non-null instance of {@code BigRational} and also if {@code other} represents
     * the same number as this {@code BigInt}.
     *
     * @param other the value to test. may be {@code null}.
     * @return {@code true} if the two instances have the same numeric value and both are {@code BigRational}s.
     */
    @Override
    boolean equals(Object other);

    /**
     * Tests if {@code other} is a non-null instance of {@code BigRational} and also if {@code other} represents
     * the same number as this {@code BigRational}.
     *
     * @param other the value to test. may be {@code null}.
     * @return {@code true} if the two instances have the same numeric value and both are {@code BigRational}s.
     */
    default boolean equals(BigRat other)
    {
        return other != null && other.toBigDecimal().compareTo(toBigDecimal()) == 0;
    }

    /**
     * @return the same value as {@code toBigDecimal().toBigInteger().hashCode()}.
     */
    @Override
    int hashCode();

    @Override
    default int compareTo(BigRat other)
    {
        return toBigDecimal().compareTo(other.toBigDecimal());
    }

    /**
     * Returns a {@code BigRat} with the same value as the given {@code BigDecimal}.
     *
     * @param value the value of the number to be returned. may not be {@code null}.
     * @return a {@code BigRat} with the same value as the given {@code BigDecimal}c
     */
    static BigRat make(BigDecimal value)
    {
        if(value == null)
            throw new NullPointerException("value");

        return new BigRatBase()
        {
            @Override
            public BigDecimal toBigDecimal()
            {
                return value;
            }
        };
    }
}
