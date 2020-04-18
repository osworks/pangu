package com.github.pangu.toolbox.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.Dates;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.TimeInterval;

public class DatesTest {

	@Test
	public void test() {
		Date date = Dates.parse("2015-03-10 10:59:20");
		// 缺省日期格式
		assertEquals("2015-03-10", Dates.formatDate(date));
		// 缺省日期时间格式
		assertEquals("2015-03-10 10:59:20", Dates.formatDateTime(date));
		// 缺省时间格式
		assertEquals("10:59:20", Dates.formatTime(date));
		// 自定义格式
		assertEquals("2015年03月10日", Dates.format(date, "yyyy年MM月dd日"));
		
		//获取某天的开始时间和结束时间
		assertEquals("2015-03-10 00:00:00", Dates.beginOfDay(date).toString());
		assertEquals("2015-03-10 23:59:59", Dates.endOfDay(date).toString());
		//获取某月的开始时间和结束时间
		assertEquals("2015-03-01 00:00:00", Dates.beginOfMonth(date).toString());
		assertEquals("2015-03-31 23:59:59", Dates.endOfMonth(date).toString());
		//获取某季度的开始时间和结束时间
		assertEquals("2015-01-01 00:00:00", Dates.beginOfQuarter(date).toString());
		assertEquals("2015-03-31 23:59:59", Dates.endOfQuarter(date).toString());
		
		//减2天
		assertEquals("2015-03-08 10:59:20", Dates.offset(date, DateField.DAY_OF_MONTH, -2).toString());
		//加1月
		date = Dates.parse("2015-03-10 10:59:20");
		assertEquals("2015-04-10 10:59:20", Dates.offset(date, DateField.MONTH, 1).toString());
		
		Date date1 = Dates.parse("2015-03-10 10:59:20");
		Date date2 = Dates.parse("2015-04-01 00:00:00");
		assertEquals(21, Dates.between(date1, date2, DateUnit.DAY));
		
		
		TimeInterval timer = Dates.timer();
		//........................
		//返回耗费毫秒数
		timer.interval();
		//返回耗费毫秒数并重新开始计时
		timer.intervalRestart();
	}
}
