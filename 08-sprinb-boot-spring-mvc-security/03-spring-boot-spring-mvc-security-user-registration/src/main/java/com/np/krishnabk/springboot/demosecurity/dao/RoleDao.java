package com.np.krishnabk.springboot.demosecurity.dao;

import com.np.krishnabk.springboot.demosecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
