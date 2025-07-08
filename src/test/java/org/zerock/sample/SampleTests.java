package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)// method 단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml") // 테스트시 사용될 코드
@Log4j2 // Log4j 가 취약하여 Log4j2로 교체함.

public class SampleTests {

	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant; // 필드 선언
	
	@Test // 메서드 별로 테스트가 가능하다.
	public void testExist() {
		// 테스트용 메서드

		assertNotNull(restaurant); //객체가 NULL인지를 판단한다. NULL이 아니어야만 테스트가 성공!
		
		log.info(restaurant); // toString가능
		log.info("=============================================");
		log.info(restaurant.getChef()); // retaurant 객체에서 쉐프를 요청함.
	}
	
}
