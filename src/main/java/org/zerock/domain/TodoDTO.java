package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd") // Date format code
	private Date dueDate; // import java.util.Date;
	
	

}
