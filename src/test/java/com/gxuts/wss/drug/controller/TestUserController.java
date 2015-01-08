package com.gxuts.wss.drug.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.gxuts.wss.drug.controller.hr.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TestUserController {
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
