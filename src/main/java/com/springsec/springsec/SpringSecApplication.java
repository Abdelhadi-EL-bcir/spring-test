package com.springsec.springsec;

import com.springsec.springsec.beans.Authority;
import com.springsec.springsec.beans.User;
import com.springsec.springsec.repositoris.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecApplication {

    private PasswordEncoder passwordEncoder ;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecApplication.class, args);
    }

    @PostConstruct
    protected void init() {

        List<Authority> authorityList=new ArrayList<>();
        authorityList.add(createAuthority("USER","User role"));
        //authorityList.add(createAuthority("ADMIN","Admin role"));

        User user=new User();

        user.setUserName("abdo2002");
        user.setFirstName("Pardeep");
        user.setLastName("K");

        user.setPassword(passwordEncoder.encode("abdo"));
        user.setEnabled(true);
        user.setAuthorities(authorityList);

        userDetailsRepository.save(user);

    }


    private Authority createAuthority(String roleCode,String roleDescription) {
        Authority authority=new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }
}
