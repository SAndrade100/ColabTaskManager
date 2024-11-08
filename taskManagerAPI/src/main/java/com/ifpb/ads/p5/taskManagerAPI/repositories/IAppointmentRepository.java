package com.ifpb.ads.p5.taskManagerAPI.repositories;

import com.ifpb.ads.p5.taskManagerAPI.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long>{}
