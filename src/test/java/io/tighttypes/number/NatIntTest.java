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

public class NatIntTest extends NonNegIntTest
{
    @Override
    NatInt make(int value)
    {
        return NatInt.make(value);
    }

    @Override
    public NonNegLong make(byte number)
    {
        return make((int)number);
    }

    @Override
    public NonNegLong parse(String value)
    {
        return NatInt.parse(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseZero()
    {
        NatInt.parse("0").toInt();
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void testZero()
    {
        Assert.assertEquals(0, make(0).toInt());
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void testZeroTLong()
    {
        Assert.assertEquals(0, make(0).toLong());
    }

}
