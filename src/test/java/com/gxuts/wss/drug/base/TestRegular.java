package com.gxuts.wss.drug.base;

import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegular {
	@Test
	public  void textUrl() {
		String str="/userdfas/t/y";
		boolean b=Pattern.compile("/.*/.*").matcher(str).find();
		System.out.println(b);
	}
}
