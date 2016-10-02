package com.demo;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.entity.UserInfo;

public class UserInfoTest {

	EntityManagerFactory emf = null;
	
	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("myJPA");
	}
	
	@After
	public void after() {
		if(emf != null) {
			emf.close();
			emf = null;
		}
	}
	
	@Test
	public void testCreate() {
		UserInfo user = generateRadomEntity();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	@Test
	public void testQuery() {
		EntityManager em = emf.createEntityManager();
		UserInfo user = em.find(UserInfo.class, 2);
		user = em.find(UserInfo.class, 2);
		System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		UserInfo user = em.find(UserInfo.class, 2);
		System.out.println(user);
		user.setEmail(randomStr() + "@sina.com");
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		em.getTransaction().commit();
		System.out.println("new Email=" + user.getEmail());
	}
	
	@Test
	public void testUpdateDetach() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		UserInfo user = em.find(UserInfo.class, 2);
		em.clear();
		System.out.println(user);
		
		user.setEmail(randomStr() + "@sina.com");
		em.merge(user);
		em.getTransaction().commit();
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
