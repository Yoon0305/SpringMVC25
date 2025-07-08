package org.zerock.persistence;

import static org.junit.Assert.fail;
import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;
import org.zerock.sample.SampleTests;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@RunWith(SpringJUnit4ClassRunner.class) // 메서드단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 테스트시 사용될 코드
@Log4j2 // Log4j가 취약해서 Log4j2로 교체함.

public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		//interface-abstract method annotation code execution
		log.info("타임매퍼 테스트 getname: " + timeMapper.getClass().getName());
		log.info("타임매퍼 결과:" + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		//interface-abstract method, mapper xml code execution
		log.info("타임매퍼2 테스트 getname: " + timeMapper.getClass().getName());
		log.info("타임매퍼2 결과:" + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2Log4jdbc() {
		//interface-abstract method, mapper xml code execution
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
}
