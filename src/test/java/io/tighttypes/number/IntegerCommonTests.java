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

package io.tighttypes.number;

import io.tighttypes.number.NonNegLong;
import org.junit.Assert;
import org.junit.Test;

public abstract class IntegerCommonTests
{
    abstract NonNegLong make(byte number);

    abstract NonNegLong parse(String value);

    @Test
    public void testEqualsSame()
    {
        Assert.assertTrue(make((byte)1).equals(make((byte)1)));
    }

    @Test
    public void testEqualsSameErased()
    {
        Assert.assertTrue(make((byte)1).equals((Object)make((byte)1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNeg10()
    {
        make((byte)-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNeg1()
    {
        make((byte)-1);
    }

    @Test
    public void testOne()
    {
        Assert.assertTrue(1 == make((byte)1).toLong());
    }

    @Test
    public void testParseZero()
    {
        Assert.assertTrue(0 == parse("0").toLong());
    }

    @Test
    public void testParseOne()
    {
        Assert.assertTrue(1 == parse("1").toLong());
    }

    @Test(expected = NumberFormatException.class)
    public void testParseEmpty()
    {
        parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseNeg1()
    {
        parse("-1");
    }

    @Test
    public void testEqualsString()
    {
        //noinspection EqualsBetweenInconvertibleTypes // not a bug, what we are testing for
        Assert.assertFalse(make((byte)1).equals("1"));
    }

    @Test
    public void testEqualsDifferent()
    {
        Assert.assertFalse(make((byte)1).equals(make((byte)2)));
    }

    @Test
    public void testHashCode3()
    {
        Assert.assertEquals(3, make((byte)3).hashCode());
    }

    @Test
    public void testToStringNonNull()
    {
        Assert.assertNotNull(make((byte)3).toString());
    }

    @Test
    public void testCompare1()
    {
        Assert.assertEquals(0, make((byte)1).compareTo(make((byte)1)));
    }

    @Test
    public void testCompare2()
    {
        Assert.assertEquals(1, make((byte)2).compareTo(make((byte)1)));
    }

    @Test
    public void testCompare3()
    {
        Assert.assertEquals(-1, make((byte)1).compareTo(make((byte)2)));
    }
}
