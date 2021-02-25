package com.avanade.dio.jwt.service;

import com.avanade.dio.jwt.data.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserData user = findUser(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
    }

    private UserData findUser(String userName) {

        UserData user = new UserData();
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("nimda"));

        return user;
    }


    public List<UserData> listUsers() {
        ArrayList<UserData> lst = new ArrayList<>();
        lst.add(findUser("admin"));
        return lst;
    }
}
