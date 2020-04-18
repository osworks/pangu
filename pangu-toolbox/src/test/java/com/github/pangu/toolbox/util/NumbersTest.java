package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Numbers;

/**
 * NumbersTest
 * @author xiongchun
 */
public class NumbersTest {

	@Test
	public void calc() {
		BigDecimal aBigDecimal = new BigDecimal(1.5);
		BigDecimal bBigDecimal = new BigDecimal(2);
		assertTrue(Numbers.equals(new BigDecimal(3.5), Numbers.add(aBigDecimal, bBigDecimal)));
		assertTrue(Numbers.equals(new BigDecimal(2), Numbers.add(null, bBigDecimal)));
	}
	
	@Test
	public void format() {
		assertEquals("123456.510", Numbers.decimalFormat("0.000", 123456.51));
		assertEquals("123,456.58", Numbers.decimalFormat(",###.##", 123456.578));
		assertEquals("157.90%", Numbers.decimalFormat("#.00%", 1.57898));
	}

}
