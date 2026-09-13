package com.nt.security.service;

import com.nt.security.model.User;
import com.nt.security.model.UserPrincipal;
import com.nt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Database has not "+username+" username  404");
        }

        return new UserPrincipal(user);
    }
}
