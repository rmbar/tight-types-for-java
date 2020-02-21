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

package io.github.rmbar.tight_types.string;

import org.junit.Assert;
import org.junit.Test;

public class MaxNTest
{
    protected int getMaxLength()
    {
        return 3;
    }

    protected MaxN<NonEmptyString> make(NonEmptyString value)
    {
        return new MaxN<>(value, getMaxLength());
    }

    private MaxN<NonEmptyString> make(StringBuilder builder)
    {
        return make(new NonEmptyString(builder.toString()));
    }

    @Test
    public void testCorrectAtMaxLength()
    {
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i<getMaxLength(); i++)
        {
            buffer.append("A");
        }

        Assert.assertEquals(buffer.toString(), make(buffer).toString());
    }

    @Test
    public void testCorrectAtLength1()
    {
        Assert.assertEquals("A", make(new NonEmptyString("A")).toString());
    }

    @Test(expected = IllegalStringLengthException.class)
    public void testIncorrectOver()
    {
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i<getMaxLength()+1; i++)
        {
            buffer.append("A");
        }

        make(buffer);
    }

    @Test
    public void testToS()
    {
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i<getMaxLength(); i++)
        {
            buffer.append("A");
        }

        NonEmptyString str = new NonEmptyString(buffer.toString());
        Assert.assertEquals(str, make(str).toS());
    }
}
