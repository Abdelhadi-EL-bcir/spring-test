package com.springsec.springsec.servicesImpl;

import com.springsec.springsec.beans.User;
import com.springsec.springsec.repositoris.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CoustomServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository ;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsRepository.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("user not found"+username);
        }
        return user;
    }
}
