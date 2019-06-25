package com.siemens.tracker.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.siemens.tracker.backend.dao.User;

public interface UserRepository extends JpaRepository<User, String> {
	

	@Query("select u from User u")
	List<User> getUserList();
	
	@Query("select u from User u where u.username LIKE %:username%")
	List<User> findByUsernameContaining(@Param("username") String username);
	
	@Query("select u from User u where u.name LIKE %:name%")
	List<User> findByNameContaining(@Param("name")String name);
	
	/*@Query("select u.password from User u where u.password LIKE %:oldPassword%")
	 * String findByOldPassword(@Param("oldPassword")String oldPassword);*/
	@Query("select u.password from User u where u.name LIKE %:name%")
	String findByOldPassword(@Param("name")String name);
	
	
	@Modifying(clearAutomatically=false)
	@Transactional
	@Query("UPDATE User u SET u.password = :password  where u.name = :name")
	void updatePassword(@Param("name")String name,@Param("password")String newPassword);
		  
	
	/**
	 * Insert new users.
	 *
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into employee_details (username,password,name) VALUES (:uname,:pwd,:name)", nativeQuery = true)
	void insertUser(@Param("uname") String username, @Param("pwd") String password,@Param("name") String name);

}

	
/*@Query("select u from employee_details u where u.username=?1")
List<User> findbyname(String username);	*/


/*@Query("select u from employee_details u where u.username LIKE %:username%")
List<User> findByUsernameContaining(@Param("username") String username);
*/
/*public void findByUsernameContaining(@Param("username") String username);*/

