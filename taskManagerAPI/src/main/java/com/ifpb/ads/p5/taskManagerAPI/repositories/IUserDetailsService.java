package com.ifpb.ads.p5.taskManagerAPI.repositories;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserDetailsService {
    public UserDetails loadUserByUsername(String username);
}
