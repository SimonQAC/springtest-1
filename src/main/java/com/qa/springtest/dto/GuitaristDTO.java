package com.qa.springtest.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//converts guitarist entity to json to view in front end

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GuitaristDTO {

	private long id;
	private String name;
	private int stringNo;
	private String type;
}
