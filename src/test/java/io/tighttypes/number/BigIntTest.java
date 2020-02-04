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

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BigIntTest extends NumberCommonTests
{
    BigInt make(int number)
    {
        return BigInt.make(BigInteger.valueOf(number));
    }

    @Test(expected = NullPointerException.class)
    public void testMake_null()
    {
        BigInt.make(null);
    }

    @Test
    public void testMake_maxLong()
    {
        Assert.assertEquals(BigInteger.valueOf(Long.MAX_VALUE), BigInt.make(Long.MAX_VALUE).toBigInteger());
    }

    @Override
    BigInt parse(String value)
    {
        return BigInt.make(new BigInteger(value));
    }

    @Test
    public void testAdd_2_2()
    {
        Assert.assertEquals(make(4), make(2).add(make(2)));
    }

    @Test
    public void testAbs_Neg1()
    {
        Assert.assertEquals(make(1), make(-1).abs());
    }

    @Test
    public void testSubtract()
    {
        Assert.assertEquals(make(0), make(2).subtract(make(2)));
    }
}
