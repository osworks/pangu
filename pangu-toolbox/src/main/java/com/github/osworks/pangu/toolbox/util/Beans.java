package com.github.osworks.pangu.toolbox.util;

import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * Bean工具类
 * @author xiongchun
 */
public class Beans extends BeanUtil{
	
	/**
	 * Map转换为Bean对象
	 *
	 * @param <T> Bean类型
	 * @param map {@link Map}
	 * @param beanClass Bean Class
	 * @return Bean
	 */
	public static <T> T mapToBean(Map<?, ?> map, Class<T> beanClass) {
		return mapToBean(map, beanClass, false);
	}
	
}
