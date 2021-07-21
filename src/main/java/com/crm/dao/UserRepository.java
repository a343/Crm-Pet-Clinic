package com.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crm.beans.CrmUser;

public interface UserRepository extends JpaRepository<CrmUser, Integer> {

	@Query("select valor from spring_security_demo_bcrypt.roles")
	List<String> getAuthorities();

}
