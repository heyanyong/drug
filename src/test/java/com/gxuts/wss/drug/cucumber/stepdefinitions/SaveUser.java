package com.gxuts.wss.drug.cucumber.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SaveUser {

@Given("^系统中存在用户，该用户的编号为\"(.*?)\"$")
public void 系统中存在用户_该用户的编号为(String arg1) throws Throwable {
}

@When("^添加一个新的用户时，该用户编号为\"(.*?)\"，用户名为\"(.*?)\"$")
public void 添加一个新的用户时_该用户编号为_用户名为(String arg1, String arg2) throws Throwable {
}

@When("^保存这个用户$")
public void 保存这个用户() throws Throwable {
}

@Then("^未启用设置用户为未启用状态$")
public void 未启用设置用户为未启用状态() throws Throwable {
}

@Then("^保存时提示用户已经存在$")
public void 保存时提示用户已经存在() throws Throwable {
}

@Then("^页面跳转到用户列表页面$")
public void 页面跳转到用户列表页面() throws Throwable {
}

@Then("^保存时提示用户保存成功$")
public void 保存时提示用户保存成功() throws Throwable {
}

@Then("^页面跳转到添加用户页面$")
public void 页面跳转到添加用户页面() throws Throwable {
}

}
