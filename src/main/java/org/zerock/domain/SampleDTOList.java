package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	private List<SampleDTO> list; // DTO object List

	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	} // constructor
	  // new SampleDTOList() -> generate object which list has dto.
	
}
