package com.chemco.hrms.service.impl;

import com.chemco.hrms.model.UserPrincipal;
import com.chemco.hrms.model.Users;
import com.chemco.hrms.repository.UserRepository;
import com.chemco.hrms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImplement implements UserService, UserDetailsService {
    private Logger LOGGER =  LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findUserByUsername(username);
        if (users == null) {
            LOGGER.error("user not found by username: " + username);
            throw new UsernameNotFoundException("user not found by username: " + username);
        } else {
            users.setLastLoginDisplay(users.getLastLoginDate());
            users.setLastLoginDisplay(new Date());
            userRepository.save(users);
            UserPrincipal userPrincipal = new UserPrincipal(users);
            LOGGER.info("returning user by username: " + username);
            return  userPrincipal;
        }
    }
}
