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

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public abstract class NumberCommonTests
{
    abstract BigRat make(int number);

    abstract BigRat parse(String value);

    @Test
    public void testEqualsSame()
    {
        Assert.assertTrue(make(1).equals(make(1)));
    }

    @Test
    public void testEqualsSameErased()
    {
        Assert.assertEquals(make(1), (Object)make(1));
    }


    @Test
    public void testOne()
    {
        Assert.assertEquals(BigDecimal.ONE, make(1).toBigDecimal());
    }

    @Test
    public void testParseOne()
    {
        Assert.assertEquals(BigDecimal.ONE, parse("1").toBigDecimal());
    }

    @Test(expected = NullPointerException.class)
    public void testParseNull()
    {
        parse(null);
    }


    @Test(expected = NumberFormatException.class)
    public void testParseEmpty()
    {
        parse("");
    }

    @Test
    public void testEqualsString()
    {
        // not a bug, what we are testing for
        Assert.assertNotEquals("1", make( 1));
    }

    @Test
    public void testEqualsDifferent()
    {
        Assert.assertFalse(make(1).equals(make(2)));
    }

    @Test
    public void testHashCode3()
    {
        Assert.assertEquals(3, make(3).hashCode());
    }

    @Test
    public void testToStringNonNull()
    {
        Assert.assertNotNull(make(3).toString());
    }

    @Test
    public void testCompare1()
    {
        Assert.assertEquals(0, make(1).compareTo(make(1)));
    }

    @Test
    public void testCompare2()
    {
        Assert.assertEquals(1, make(2).compareTo(make(1)));
    }

    @Test
    public void testCompare3()
    {
        Assert.assertEquals(-1, make(1).compareTo(make(2)));
    }

    @Test
    public void testAdd_2_2()
    {
        Assert.assertEquals(make(4), make(2).add(make(2)));
    }

    @Test
    public void testSubtract_2_2()
    {
        Assert.assertEquals(make(1), make(2).subtract(make(1)));
    }

    @Test
    public void testHashIntMax()
    {
        Assert.assertEquals(new BigDecimal(Integer.MAX_VALUE).toBigInteger().hashCode(),
                            make(Integer.MAX_VALUE).hashCode());
    }

    @Test
    public void testAbs()
    {
        Assert.assertEquals(make(1), make(1).abs());
    }

    @Test
    public void testDistanceTo()
    {
        Assert.assertEquals(make(4), make(1).distanceTo(make(5)));
    }

    @Test
    public void testIs_1_in_1_2_3()
    {
        Assert.assertTrue(make(1).is(1, 2, 3));
    }

    @Test
    public void testIs_2_in_1_2_3()
    {
        Assert.assertTrue(make(2).is(1, 2, 3));
    }

    @Test
    public void testIs_3_in_1_2_3()
    {
        Assert.assertTrue(make(3).is(1, 2, 3));
    }

    @Test
    public void testIs_5_in_1_2_3()
    {
        Assert.assertFalse(make(5).is(1, 2, 3));
    }
}
