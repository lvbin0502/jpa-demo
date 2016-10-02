package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.UserInfo;

public interface UserInfoDao extends PagingAndSortingRepository<UserInfo, Integer>{

	UserInfo save(UserInfo userinfo);
	
	UserInfo findById(Integer id);

	UserInfo findByEmail(String email);
	
	List<UserInfo> findAll();
	
	@Query("select count(*) from UserInfo ui where email = :em")
	Integer countByEmail(@Param(value="em") String email);
	
	@Transactional
	@Modifying
	@Query("update UserInfo ui set ui.weight = :weight where ui.id = :id")
	void updateWeight(@Param(value="weight")double weight, @Param(value="id")int id);
}
