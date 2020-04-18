package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import com.github.pangu.toolbox.util.model.Student;
import com.github.pangu.toolbox.util.model.Teacher;
import com.github.pangu.toolbox.util.model.TeacherVO;
import cn.hutool.core.bean.BeanUtil;

/**
 * CollectionsTest
 * 
 * @author xiongchun
 */
public class CollectionsTest {

    @Test
    public void filter() {
        // 测试数据
        List<Student> list = new ArrayList<Student>();
        list.add(new Student().setId(1L).setName("A1").setAge(20));
        list.add(new Student().setId(2L).setName("A2").setAge(60));
        list.add(new Student().setId(3L).setName("A3").setAge(100));

        // 查询并生成新结果集集合
        List<Student> newList = (List<Student>) CollectionUtils.select(list, e -> e.getAge() == 60);
        assertEquals(1, newList.size());

        // 过滤集合
        CollectionUtils.filter(list, e -> e.getId() != 1 && e.getAge() > 60);
        assertEquals(1, newList.size());
        // 过滤集合（结果反转）
        //Collections.filterInverse(list2, e -> e.getId() != 1 && e.getAge() > 22);
    }

    @Test
    public void transform() {
        // 测试数据
        List<Teacher> list = new ArrayList<Teacher>();
        list.add(new Teacher().setId(1L).setGrade(1));
        list.add(new Teacher().setId(2L).setGrade(2));
        // 转换字段
        CollectionUtils.transform(list, e -> {
            if (e.getGrade() == 1) {
                e.setName("一级教师");
            }
            return e;
        });
    }

    @Test
    public void transform2() {
        // 测试数据
        List<Teacher> list = new ArrayList<Teacher>();
        list.add(new Teacher().setId(1L).setGrade(1));
        list.add(new Teacher().setId(2L).setGrade(2));
        // 转换字段
        List<TeacherVO> teacherVOs = (List<TeacherVO>)CollectionUtils.collect(list, new Transformer<Teacher, TeacherVO>() {
            @Override
            public TeacherVO transform(Teacher teacher) {
                TeacherVO teacherVO = new TeacherVO();
                BeanUtil.copyProperties(teacher, teacherVO);
                if (teacher.getGrade() == 1) {
                    teacherVO.setGradeDesc("一级教师");
                }
                return teacherVO;
            }
        });
        assertEquals("一级教师", teacherVOs.get(0).getGradeDesc());
    }

    @Test
    public void ops() {
        // 测试数据
        List<Student> list1 = new ArrayList<Student>();
        list1.add(new Student().setId(1L).setName("A1").setAge(21));
        list1.add(new Student().setId(2L).setName("A2").setAge(22));
        List<Student> list2 = new ArrayList<Student>();
        list2.add(new Student().setId(1L).setName("A1").setAge(21));
        list2.add(new Student().setId(2L).setName("A2").setAge(22));
        list2.add(new Student().setId(3L).setName("A3").setAge(23));

        // 判断2个集合中是否含有相同元素
        assertTrue(CollectionUtils.containsAny(list1, list2));

        // 求两个集合的交集
        List<Student> resultList = (List<Student>) CollectionUtils.intersection(list1, list2);
        assertEquals(2, resultList.size());

        // 求两个集合的并集
        List<Student> resultList2 = (List<Student>) CollectionUtils.union(list1, list2);
        assertEquals(3, resultList2.size());
        // 求差集
        List<Student> resultList3 = (List<Student>) CollectionUtils.subtract(list2, list1);
        assertEquals(1, resultList3.size());
        // 判断A集合是否是B集合的子集
        assertTrue(CollectionUtils.isSubCollection(list1, list2));
    }

}
