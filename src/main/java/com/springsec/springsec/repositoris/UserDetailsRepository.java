package com.springsec.springsec.repositoris;

import com.springsec.springsec.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
