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
import java.math.BigInteger;

public class BigRatTest extends NumberCommonTests
{
    @Override
    BigRat make(int number)
    {
        return BigRat.make(BigDecimal.valueOf(number));
    }

    @Test
    public void testMake_maxLong()
    {
        Assert.assertEquals(BigDecimal.valueOf(Long.MAX_VALUE), BigRat.make(Long.MAX_VALUE).toBigDecimal());
    }

    @Test(expected = NullPointerException.class)
    public void testMake_null()
    {
        BigRat.make(null);
    }

    @Override
    BigRat parse(String value)
    {
        return BigRat.make(new BigDecimal(value));
    }

    @Test
    public void testIs_1_in_1_2_3_double()
    {
        Assert.assertTrue(BigRat.make(1).is(1.0, 2.0, 3.0));
    }

    @Test
    public void testIs_2_in_1_2_3_double()
    {
        Assert.assertTrue(BigRat.make(2).is(1.0, 2.0, 3.0));
    }

    @Test
    public void testIs_3_in_1_2_3_double()
    {
        Assert.assertTrue(BigRat.make(3).is(1.0, 2.0, 3.0));
    }

    @Test
    public void testIs_5_in_1_2_3_double()
    {
        Assert.assertFalse(BigRat.make(5).is(1.0, 2.0, 3.0));
    }

    @Test
    public void testIs_1_in_1_2_3_BigRat()
    {
        Assert.assertTrue(BigRat.make(1).is(BigRat.make(1.0), BigRat.make(2.0), BigRat.make(3.0)));
    }

    @Test
    public void testIs_2_in_1_2_3_BigRat()
    {
        Assert.assertTrue(BigRat.make(2).is(BigRat.make(1.0), BigRat.make(2.0), BigRat.make(3.0)));
    }

    @Test
    public void testIs_3_in_1_2_3_BigRat()
    {
        Assert.assertTrue(BigRat.make(3).is(BigRat.make(1.0), BigRat.make(2.0), BigRat.make(3.0)));
    }

    @Test
    public void testIs_5_in_1_2_3_BigRat()
    {
        Assert.assertFalse(BigRat.make(5).is(BigRat.make(1.0), BigRat.make(2.0), BigRat.make(3.0)));
    }
}
