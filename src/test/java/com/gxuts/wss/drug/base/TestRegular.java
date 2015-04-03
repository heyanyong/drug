package com.gxuts.wss.drug.base;

import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegular {
	@Test
	public  void textUrl() {
		String str="/userf/df/123";
		boolean b=Pattern.compile("/u/df/").matcher(str).find();
		System.out.println(b);
	}
}
