package com.demo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.UserScoreDao;
import com.demo.entity.UserScore;
import com.demo.entity.UserScoreDTO;

public class UserScoreDaoTest {
	
	
	private UserScoreDao dao = null;
	
	@Before
	public void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		dao = ctx.getBean(UserScoreDao.class);
	}

	@Test
	public void testSave() {
		UserScore uscore = buildUserScore();
		dao.save(uscore);
	}
	
	@Test
	public void testFindScoreById() {
		List<UserScoreDTO> list = dao.findScoreById(1);
		System.out.println(list.size());
		for (UserScoreDTO score : list) {
			System.out.println(score);
		}
	}

	private UserScore buildUserScore() {
		UserScore score = new UserScore();
		score.setUserId(1);
		score.setScore(56.6);
		score.setCourseId(3375);
		return score;
	}
}
