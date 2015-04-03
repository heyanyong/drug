package com.gxuts.wss.drug.service.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.manage.ArticleInfo;
import com.gxuts.wss.dms.service.manage.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestArticleService {
	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testSave(){
		ArticleInfo article =new ArticleInfo();
		article.setName("df");
		article.setContent("dddddd");
		articleService.save(article);
	}
}
