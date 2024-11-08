package com.ifpb.ads.p5.taskManagerAPI.services;

import com.ifpb.ads.p5.taskManagerAPI.models.Task;
import com.ifpb.ads.p5.taskManagerAPI.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private ITaskRepository taskRepository;

    public List<Task> listAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }

    public Task save(Task user){
        return taskRepository.save(user);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    public Task update(Task user){
        return taskRepository.save(user);
    }

}
