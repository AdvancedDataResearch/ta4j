/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 Marc de Verdelhan & respective authors (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eu.verdelhan.ta4j;

import eu.verdelhan.ta4j.Order.OrderType;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    Order opEquals1, opEquals2, opNotEquals1, opNotEquals2;

    @Before
    public void setUp() {
        opEquals1 = Order.buyAt(1);
        opEquals2 = Order.buyAt(1);

        opNotEquals1 = Order.sellAt(1);
        opNotEquals2 = Order.buyAt(2);
    }

    @Test
    public void type() {
        assertEquals(OrderType.SELL, opNotEquals1.getType());
        assertFalse(opNotEquals1.isBuy());
        assertTrue(opNotEquals1.isSell());
        assertEquals(OrderType.BUY, opNotEquals2.getType());
        assertTrue(opNotEquals2.isBuy());
        assertFalse(opNotEquals2.isSell());
    }

    @Test
    public void overrideToString() {
        assertEquals(opEquals1.toString(), opEquals2.toString());

        assertNotEquals(opEquals1.toString(), opNotEquals1.toString());
        assertNotEquals(opEquals1.toString(), opNotEquals2.toString());
    }
}
