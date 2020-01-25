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

public class NonNegIntTest extends NonNegCommonTests
{
    NonNegInt make(int value)
    {
        return NonNegInt.make(value);
    }

    @Override
    public NonNegLong parse(String value)
    {
        return NonNegInt.parse(value);
    }

    @Test
    public void testZero()
    {
        Assert.assertEquals(0, make(0).toInt());
    }

    @Test
    public void testZeroTLong()
    {
        Assert.assertEquals(0, make(0).toLong());
    }

    @Test
    public void testMax()
    {
        Assert.assertEquals(Integer.MAX_VALUE, make(Integer.MAX_VALUE).toInt());
    }

    @Test
    public void testAdd_2_2()
    {
        Assert.assertEquals(make(4), make(2).add(make(2)));
    }

    @Test
    public void testAddChecked_2_2() throws OverflowException
    {
        Assert.assertEquals(make(4), make(2).addChecked(make(2)));
    }

    @Test
    public void testAddUnchecked_2_2()
    {
        Assert.assertEquals(make(4), make(2).addUnchecked(make(2)));
    }

    @Test
    public void testSubtractChecked_2_2() throws InvalidArgumentException
    {
        Assert.assertEquals(make(1), make(2).subtractChecked(make(1)));
    }

    @Test(expected = InvalidArgumentException.class)
    public void testSubtractChecked_2_3() throws InvalidArgumentException
    {
        make(2).subtractChecked(make(3));
    }

    @Test(expected = InvalidArgumentException.class)
    public void testSubtractChecked_Max() throws InvalidArgumentException
    {
        make(0).subtractChecked(make(Integer.MAX_VALUE));
    }


    @Test
    public void testSubtractUnchecked_2_2()
    {
        Assert.assertEquals(make(4), make(2).addUnchecked(make(2)));
    }

    @Test(expected = OverflowException.class)
    public void testAdd_overflow() throws OverflowException
    {
        make(1).addChecked(NonNegInt.make(Integer.MAX_VALUE));
    }


}
