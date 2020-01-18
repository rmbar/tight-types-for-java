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

package io.tighttypes.string;

import io.tighttypes.string.EmptyStrOrCases;
import io.tighttypes.string.EmptyStrOrNonEmpty;
import io.tighttypes.string.NonEmptyString;
import org.junit.Assert;
import org.junit.Test;

public class EmptyStrOrNonEmptyTest
{
    @Test
    public void testIsEmptyString()
    {
        NonEmptyString dog = NonEmptyString.make("dog");
        Assert.assertFalse(new EmptyStrOrNonEmpty<>(dog).isEmptyString());
    }

    @Test
    public void testIsNonEmptyString()
    {
        NonEmptyString dog = NonEmptyString.make("dog");
        Assert.assertTrue(new EmptyStrOrNonEmpty<>(dog).isNonEmptyString());
    }

    @Test
    public void testGetOrDefault()
    {
        NonEmptyString dog = NonEmptyString.make("dog");
        Assert.assertEquals("dog", new EmptyStrOrNonEmpty<>(dog).getOrDefault(null).toString());
    }

    @Test
    public void testWitch()
    {
        NonEmptyString dog = NonEmptyString.make("dog");
        Assert.assertTrue(new EmptyStrOrNonEmpty<>(dog).which(
            new EmptyStrOrCases<Boolean, NonEmptyString, RuntimeException>()
            {
                @Override
                public Boolean forEmpty()
                {
                    return false;
                }

                @Override
                public Boolean forNonEmpty(NonEmptyString nonEmpty)
                {
                    return true;
                }
            }));
    }

    @Test
    public void testToString()
    {
        NonEmptyString dog = NonEmptyString.make("dog");
        Assert.assertEquals("dog", new EmptyStrOrNonEmpty<>(dog).toString());
    }
}
