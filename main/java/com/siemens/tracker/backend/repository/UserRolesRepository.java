package com.siemens.tracker.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.siemens.tracker.backend.dao.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, String> {
	

@Query("select u from UserRoles u where u.role='ROLE_USER'")
List<UserRoles> getUserRolesList();
	
	/**
	* Set priveleges
	*
	*/
@Modifying
@Transactional	
@Query(value="insert into user_roles (username,role,name) VALUES (:uname,:role,:name)",nativeQuery = true)
void insertUserRole(@Param("uname") String username, @Param("role") String role,@Param("name")String name);
}

	