package com.raca.testbank.services.impl;


import com.raca.testbank.models.User;
import com.raca.testbank.repositories.IUserDao;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findyByUsername(username);

        if(user == null){
            log.info("Not user found : "+username);
            throw  new UsernameNotFoundException("Not user found : "+username);
        }

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(simpleGrantedAuthority -> log.info("authorities : "+simpleGrantedAuthority.getAuthority()))
                .collect(Collectors.toList());

        log.info(user.toString());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true,authorities);
    }
}
