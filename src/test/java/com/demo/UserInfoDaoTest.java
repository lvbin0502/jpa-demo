package com.demo;

import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.demo.dao.UserInfoDao;
import com.demo.entity.UserInfo;
import com.demo.entity.UserScoreDTO.STATUS;

public class UserInfoDaoTest {
	
	private UserInfoDao dao = null;

	@Before
	public void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		dao = (UserInfoDao) ctx.getBean(UserInfoDao.class);
	}
	
	@Test
	public void testSave() {
		UserInfo user = generateRadomEntity();
		dao.save(user);
	}
	
	@Test
	public void testUpdate() {
		UserInfo user = dao.findById(3);
		System.out.println(user);
	}
	
	@Test
	public void testFindByEmail() {
		UserInfo user = dao.findByEmail("8158@sina.com");
		System.out.println(user);
	}
	
	@Test
	public void testCountByEmail() {
		Integer count = dao.countByEmail("test@skynet.com");
		System.out.println("total count: " + count);
	}
	
	@Test
	public void testFindById() {
		UserInfo u = dao.findById(3);
		System.out.println(u);
	}
	
	@Test
	public void testUpdateWeight() {
		final int id = 3;
		UserInfo u = dao.findById(id);
		double weight = u.getWeight();
		Double expect = weight + 10;
		dao.updateWeight(expect, id);
		
		UserInfo u2 = dao.findById(id);
		System.out.println(u2);
		Assert.assertEquals(expect, u2.getWeight());
	}
	
	@Test
	public void testPaging() {
		Sort sort = new Sort(Direction.DESC, "weight", "id");
		Pageable page = new PageRequest(0, 10, sort);
		Page<UserInfo> list = dao.findAll(page);
		for (UserInfo u : list) {
			System.out.println(u);
		}
	}
	
	private String randomStr() {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<4; i++) {
			builder.append(new Random().nextInt(10));
		}
		return builder.toString();
	}

	private UserInfo generateRadomEntity() {
		UserInfo user = new UserInfo();
		user.setUserName("michael");
		user.setEmail("test@skynet.com");
		user.setWeight(75.42);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		return user;
	}
}
