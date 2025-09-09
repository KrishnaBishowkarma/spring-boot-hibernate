package np.com.krishnabk.springboot.demosecurity.dao;

import np.com.krishnabk.springboot.demosecurity.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
