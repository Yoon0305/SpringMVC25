package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2(); // abstract method
	// 이 method가 호출되면 myBatis에서 xml을 찾는다.
	//src/main/resources/org/zerock/mapper/TimeMapper.xml
	
}
