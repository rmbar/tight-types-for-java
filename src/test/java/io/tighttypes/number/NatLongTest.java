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

public class NatLongTest extends NonNegLongTest
{
    @Override
    NatLong make(long value)
    {
        return NatLong.make(value);
    }

    @Override
    public NonNegLong make(byte number)
    {
        return make((long)number);
    }

    @Override
    public NonNegLong parse(String value)
    {
        return NatLong.parse(value);
    }

    @Test(expected = IllegalArgumentException.class)
    @Override
    public void testZero()
    {
        Assert.assertEquals(0, make(0).toLong());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseZero()
    {
        NatLong.parse("0").toLong();
    }

    @Test
    public void testParseOne()
    {
        Assert.assertEquals(1, NatLong.parse("1").toLong());
    }

    @Test(expected = NumberFormatException.class)
    public void testParseEmpty()
    {
        NatLong.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseNeg1()
    {
        NatLong.parse("-1");
    }
}
