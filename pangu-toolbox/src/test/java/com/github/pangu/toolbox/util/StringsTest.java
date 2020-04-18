package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Strings;

/**
 * StringsTest
 * @author xiongchun
 */
public class StringsTest {

	@Test
	public void format() {
		String aString = Strings.format("{}今年{}", "XC", 18);
		assertEquals("XC今年18", aString);
	}

}
