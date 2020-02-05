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

public class EmptyStrOrTest
{
    @Test
    public void testConstruction_Empty()
    {
        Assert.assertTrue(new EmptyStrOr<VisibleString>().isEmptyString());
    }

    @Test
    public void testConstruction_NonEmpty()
    {
        VisibleString dog = new VisibleString("dog");
        Assert.assertTrue(new EmptyStrOr<>(dog).isNonEmptyString());
    }

    @Test(expected = NullPointerException.class)
    public void testConstruction_Null()
    {
        new EmptyStrOr<>(null);
    }


    @Test
    public void testIsEmptyString_Empty()
    {
        Assert.assertTrue(new EmptyStrOr<>().isEmptyString());
    }

    @Test
    public void testIsEmptyString_NonEmpty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertFalse(new EmptyStrOr<>(dog).isEmptyString());
    }

    @Test
    public void testIsNonEmptyString_Empty()
    {
        Assert.assertFalse(new EmptyStrOr<>().isNonEmptyString());
    }

    @Test
    public void testIsNonEmptyString_NonEmpty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertTrue(new EmptyStrOr<>(dog).isNonEmptyString());
    }



    @Test
    public void testGetOrDefault_Empty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertSame(dog, new EmptyStrOr<>().getOrDefault(dog));
    }

    @Test
    public void testGetOrDefault_NonEmpty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertEquals(dog, new EmptyStrOr<>(dog).getOrDefault(null));
    }


    @Test
    public void testWhich_Empty()
    {
        Assert.assertTrue(new EmptyStrOr<>().which(
                new EmptyStrOrCases<Boolean, NonEmptyString, RuntimeException>()
                {
                    @Override
                    public Boolean forEmpty()
                    {
                        return true;
                    }

                    @Override
                    public Boolean forNonEmpty(NonEmptyString nonEmpty)
                    {
                        return false;
                    }
                }));
    }

    @Test
    public void testWhich_NonEmpty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertTrue(new EmptyStrOr<>(dog).which(
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
    public void testToString_Empty()
    {
        Assert.assertEquals("", new EmptyStrOr<>().toString());
    }

    @Test
    public void testToString_NonEmpty()
    {
        NonEmptyString dog = new NonEmptyString("dog");
        Assert.assertEquals("dog", new EmptyStrOr<>(dog).toString());
    }
}
