package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.UserScore;
import com.demo.entity.UserScoreDTO;

@RepositoryDefinition(domainClass=UserScore.class, idClass=Integer.class)
public interface UserScoreDao {

	@Transactional
	void save(UserScore uscore);
	
	@Query("select new com.demo.entity.UserScoreDTO(u.id, u.userName, s.score) from UserInfo u, UserScore s where u.id=s.userId and u.id=:id")
	List<UserScoreDTO> findScoreById(@Param(value="id") Integer uid);
}
