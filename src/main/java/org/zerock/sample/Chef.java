package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Spring이 의존성 처리 해줘!
@Data	   // import lobok.Data; dto 처리용 (getter/setter, toString, equals 등 ...)
public class Chef {

	private String name;
	private int age;
}
