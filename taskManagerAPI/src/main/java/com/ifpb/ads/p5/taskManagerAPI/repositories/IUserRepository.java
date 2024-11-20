package com.ifpb.ads.p5.taskManagerAPI.repositories;

import com.ifpb.ads.p5.taskManagerAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
