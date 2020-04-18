package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Beans;
import com.github.osworks.pangu.toolbox.util.Objects;
import com.github.pangu.toolbox.util.model.Student;
import com.github.pangu.toolbox.util.model.Teacher;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;

/**
 * BeansTest
 * @author xiongchun
 */
public class BeansTest {
	
	@Test
	public  void copy() {
		Student student = new Student();
		student.setId(1L);
		student.setName("XC");
		Student student2 = new Student();
		Beans.copyProperties(student, student2);
		Teacher teacher = new Teacher();
		Beans.copyProperties(student, teacher, true);
		assertTrue(Objects.equal(student.getName(), teacher.getName()));
		Teacher teacher2 = new Teacher();
		Beans.copyProperties(student, teacher2, "id");
		assertTrue(Objects.isNull(teacher2.getId()));
	}
	
	@Test
	public  void toMap() {
		Student student = new Student();
		student.setId(1L).setName("XC").setIsBoy(1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 18);
		Beans.beanToMap(student, map, false, true);
		assertTrue(Objects.equal("1", MapUtil.getStr(map, "id")));
		Beans.beanToMap(student, map, true, true);
		assertTrue(Objects.equal("1", MapUtil.getStr(map, "is_boy")));
		Map<String, Object> map2 = Beans.beanToMap(student);
		assertTrue(Objects.equal("1", MapUtil.getStr(map2, "id")));		
	}
	
	@Test
	public  void toBean() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1L);
		map1.put("name", "XC");
		Student student = Beans.mapToBean(map1, Student.class);
		assertTrue(Objects.equal("XC", student.getName()));
		Student student2 = Beans.mapToBean(map1, Student.class, new CopyOptions().setIgnoreProperties("name"));
		assertTrue(Objects.equal(null, student2.getName()));
		//Beans.getBeanDesc(clazz)
	}

}
