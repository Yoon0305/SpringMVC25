package org.zerock.domain;

import lombok.Data;

@Data // lombok manage DTO
public class SampleDTO {
	
	String name;
	int age;

	// JAVA BEANS
	// 1. Set Field as private
	// 2. need basic Constructor
	// 3. using Getter/Setter
	// 4. using lombok for automatic generation of Getter/Setters.
	
}
