package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Objects;
import com.github.pangu.toolbox.util.model.Student;
import com.github.pangu.toolbox.util.model.Teacher;

/**
 * ObjectsTest
 * @author xiongchun
 */
public class ObjectsTest {
		
	@Test
	public void equal() {
		assertTrue(Objects.equal(1, 1));
		assertFalse(Objects.equal(1, 1.0));
		assertTrue(Objects.equal(1F, 1.0F));
		assertTrue(Objects.equal(null, null));
		
		Student student = new Student();
		Student studentVO2 = new Student();
		assertTrue(Objects.equal(student, studentVO2));
		student.setId(1L);
		assertFalse(Objects.equal(student, studentVO2));
		
		Teacher teacher = new Teacher();
		assertFalse(Objects.equal(student, teacher));
		
		assertTrue(Objects.equal("abc", "abc"));
		assertFalse(Objects.equal("abc", "abc "));
		assertFalse(Objects.equal("abc", "Abc"));
	}
	
	@Test
	public void length() {
		assertEquals(0, Objects.length(null));
		assertEquals(4, Objects.length("ABCD"));
		assertEquals(3, Objects.length(Arrays.asList("a","b","c")));
		assertEquals(3, Objects.length(new int[]{1, 2, 3}));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 1);
		assertEquals(1, Objects.length(map));
	}
	
	@Test
	public void contains() {
		assertTrue(Objects.contains("abcd", "bc"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "XC");
		assertTrue(Objects.contains(map, "XC"));
		assertTrue(Objects.contains(new int[] {1,2,3}, 3));
		
	}
	
	@Test
	public void cloneTest() {
		Student student = new Student();
		student.setName("XC");
		Student studentVO2 =  Objects.clone(student);
		student.setName("XC2");
		assertEquals("XC", studentVO2.getName());
	}
	
	@Test
	public void isEmpty() {
		assertTrue(Objects.isEmpty(""));
		assertFalse(Objects.isEmpty("  "));
		Map<String, Object> map = new HashMap<String, Object>();
		assertTrue(Objects.isEmpty(map));
		map.put("name", "XC");
		assertFalse(Objects.isEmpty(map));
		List<String> aList = new ArrayList<String>();
		assertTrue(Objects.isEmpty(aList));
	}
	
	@Test
	public void compare() {
		assertEquals(1, Objects.compare(2, 1));
		assertEquals(0, Objects.compare(BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5)));
		assertEquals(-1, Objects.compare(BigDecimal.valueOf(5), BigDecimal.valueOf(10)));
	}
	
}
