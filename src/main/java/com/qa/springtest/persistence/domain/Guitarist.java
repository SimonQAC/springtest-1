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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class Guitarist {

	//organise imports with ctrl shift O
	
	@Id
	@GeneratedValue //Auto-increment
	private Long id;
	
	@Column(name="guitarist_name",unique=true)
	@Size(min=1, max=120)
	private String name;
	
	@Column(name="strings")
	@Min(4)
	@Max(12)
	private Integer stringNo;
	
	@Column(name="type")
	@Size(min=1, max=120)
	private String type;
	
	@ManyToOne(targetEntity = Band.class)
	private Band band;

	//shift + alt + s ---> constructor using fields
	

	
	
}
