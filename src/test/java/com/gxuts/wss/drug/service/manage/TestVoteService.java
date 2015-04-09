package com.gxuts.wss.drug.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		UserInfo user = new UserInfo(102);
		voteService.vote(user, 1, 1);
	}
	@Test
	//@Ignore
	public void show(){
		VoteInfo vote=voteService.get(VoteInfo.class, 1);
		System.out.println(vote.getName());
		List<VoteItem> items=vote.getItems();
		for (VoteItem i:items) {
			System.out.print("项目："+i.getName());
			System.out.print("-票数："+i.getVoteNum());
			System.out.println("-人数："+i.getUsers());
		}
	}
	
	@Test
	@Ignore
	public void testSave(){
		VoteInfo vote=new VoteInfo();
		vote.setName("放假天数");
		vote.setContent("说明。。。。。。。。。。");
		
		VoteItem v1=new VoteItem();
		v1.setName("1天");
		VoteItem v2=new VoteItem();
		v2.setName("2天");
		
		List<VoteItem> items=new ArrayList<VoteItem>();
		items.add(v1);
		items.add(v2);
		
		vote.setItems(items);
		voteService.save(vote);
		
	}
}
