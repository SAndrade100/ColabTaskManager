package com.ifpb.ads.p5.taskManagerAPI.repositories;

import com.ifpb.ads.p5.taskManagerAPI.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long>{}
