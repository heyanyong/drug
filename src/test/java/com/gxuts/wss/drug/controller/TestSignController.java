package com.gxuts.wss.drug.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.gxuts.wss.dms.controller.hr.UserController;

public class TestSignController {
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		this.mockMvc = standaloneSetup(new UserController())
//			       .defaultRequest(get("/")
//			       .accept(MediaType.APPLICATION_JSON))
			       .alwaysExpect(status().isOk())
//			       .alwaysExpect(content().contentType("application/json;charset=UTF-8"))
			       .build();	
	}
	
	@Test
	public void testSave() throws Exception {
		this.mockMvc.perform(get("/user/save")
				.param("id", "5")//
				.param("name", "李丽"))//
				.andExpect(status().isOk())
				.andExpect(view().name("test"));
	}
}
