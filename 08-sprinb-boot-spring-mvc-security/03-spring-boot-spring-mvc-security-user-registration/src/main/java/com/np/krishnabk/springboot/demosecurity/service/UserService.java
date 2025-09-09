package com.np.krishnabk.springboot.demosecurity.service;

import com.np.krishnabk.springboot.demosecurity.entity.User;
import com.np.krishnabk.springboot.demosecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
