package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Role;
import com.demo.models.RoleInfo;

@Repository
public interface RoleRepositoryUser extends CrudRepository<Role, Integer> {

	@Query("select new com.demo.models.RoleInfo(roleId, roleName, description, status) from Role ")
	public List<RoleInfo> findAllRole();
	
	@Query("select new com.demo.models.RoleInfo(roleId, roleName, description, status) from Role where roleId = :roleId")
	public RoleInfo findById(@Param("roleId") String roleId);
	
	
}
