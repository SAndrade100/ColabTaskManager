package com.ifpb.ads.p5.taskManagerAPI.services;

import com.ifpb.ads.p5.taskManagerAPI.models.User;
import com.ifpb.ads.p5.taskManagerAPI.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(User user){
        return userRepository.save(user);
    }

}
