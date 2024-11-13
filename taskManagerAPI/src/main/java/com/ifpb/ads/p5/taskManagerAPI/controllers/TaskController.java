package com.ifpb.ads.p5.taskManagerAPI.controllers;

import com.ifpb.ads.p5.taskManagerAPI.models.Task;
import com.ifpb.ads.p5.taskManagerAPI.services.TaskService;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        Task task = taskService.findById(id);
        if(task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskDetails) {
        Task task = taskService.findById(id);
        if(task != null) {
            task.setDescription(taskDetails.getDescription());
            task.setDate(taskDetails.getDate());
            task.setUsers(taskDetails.getUsers());
            task.setAppointments(taskDetails.getAppointments());
            return ResponseEntity.ok(taskService.save(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
