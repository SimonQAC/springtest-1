package com.qa.springtest.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Guitarist {

	//organise imports with ctrl shift O
	
	@Id
	@GeneratedValue //Auto-increment
	private long id;
	
	@Column(name="guitarist_name",unique=true)
	@NotNull
	@Size(min=1, max=120)
	private String name;
	
	@Column(name="strings")
	@NotNull
	@Min(4)
	@Max(12)
	private int stringNo;
	
	@Column(name="type")
	@NotNull
	@Size(min=1, max=120)
	private String type;
	
	@ManyToOne(targetEntity = Band.class)
	private Band band;

	//shift + alt + s ---> constructor using fields
	
	public Guitarist(@Size(min = 1, max = 120) String type, @Min(4) @Max(12) int stringNo,
			@Size(min = 1, max = 120) String name) {
		super();
		this.type = type;
		this.stringNo = stringNo;
		this.name = name;
	}
	
	
	
}
