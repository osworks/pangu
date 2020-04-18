package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Maps;

public class MapsTest {

	@Test
	@SuppressWarnings("unused")
	public void map() {
		//创建各种类型的Map
		Map<String, Object> map = Maps.newHashMap();
		Map<String, Object> map2 = Maps.newHashMap(true);
		//...其它类型的Map
		
		//空判断
		assertTrue(Maps.isEmpty(map));
		
		//链式调用
		Map<Object, Object> map4 = Maps.builder().put("name", "XC").put("age", 18).map();
		System.out.println(map4);
		
		//Maps.getDouble(map2, key)
	}
}
