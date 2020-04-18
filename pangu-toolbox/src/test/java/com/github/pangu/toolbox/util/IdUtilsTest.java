package com.github.pangu.toolbox.util;

import org.junit.Test;
import com.github.osworks.pangu.toolbox.util.IDs;
import cn.hutool.core.lang.Snowflake;

public class IdUtilsTest {
	
	@Test
	public void id() {
		String uuid = IDs.simpleUUID();
		System.out.println(uuid);
		String objectId = IDs.objectId();
		System.out.println(objectId);
		Snowflake snowflake = IDs.createSnowflake(1, 1);
		System.out.println(snowflake.nextId());
	}
	
}
