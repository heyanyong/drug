package com.gxuts.wss.drug.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
import com.gxuts.wss.dms.entity.manage.VoteItem;
import com.gxuts.wss.dms.service.manage.VoteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestVoteService {
	@Autowired
	private VoteService voteService;
	
	
	@Test
	public void testVote(){
		UserInfo user = new UserInfo();
		user.setName("李5");
		user.setNo("NF05");
		Json j=voteService.vote(user,1 ,1);
		System.out.println(j);
	}

	@Test
	//@Ignore
	public void show(){
		VoteInfo vote=voteService.get(VoteInfo.class,1);
		System.out.println(vote);
		System.out.println(vote.getName());
		List<VoteItem> items=vote.getItems();
		for (VoteItem i:items) {
			System.out.print("项目："+i.getName());
			System.out.print("-NUM："+i.getVoteNum());
			System.out.println("-参与："+i.getUsers());
		}
	}
	
	@Test
//	@Ignore
	public void testSave(){
		VoteInfo vote=new VoteInfo();
		vote.setName("AB");
		VoteItem v1=new VoteItem("A");
		VoteItem v2=new VoteItem("B");
		VoteItem v3=new VoteItem("C");
		
		List<VoteItem> items=new ArrayList<VoteItem>();
		items.add(v1);
		items.add(v2);
		items.add(v3);
		
		vote.setItems(items);
		voteService.save(vote);
	}
	
 
}
