package np.com.krishnabk.springboot.demosecurity.dao;

import np.com.krishnabk.springboot.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}