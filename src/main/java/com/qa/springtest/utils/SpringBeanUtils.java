package com.qa.springtest.utils;

import org.springframework.beans.BeanUtils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpringBeanUtils {

	public static void mergeObject(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}
	
}
