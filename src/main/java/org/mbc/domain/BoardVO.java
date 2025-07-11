package org.mbc.domain;

import java.util.Date;

import lombok.Data;

@Data // 생성자, getter/setter, toString 등 담당
public class BoardVO {
	
	//객체용 VO는 읽기전용 속성이 강하게 만드는 객체(getter위주로 셋팅)
	//dto 는 getter/setter 모두 가지고 활용하는 객체
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
	
}
