package com.ifpb.ads.p5.taskManagerAPI.repositories;

import com.ifpb.ads.p5.taskManagerAPI.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.user.id = :userId")
    Optional<Appointment> findByUserId(@Param("userId") Long userId);

    @Query("SELECT a FROM Appointment  a WHERE a.task.id = :taskId")
    Optional<Appointment> findByTaskId(@Param("taskId") Long taskId);

    @Query("SELECT a FROM Appointment a WHERE a.user.id = :userId AND a.id = :appointmentId")
    Optional<Appointment> findByUserIdAndAppointmentId(@Param("userId") Long userId, @Param("appointmentId") Long appointmentId);

    @Query("SELECT a FROM Appointment a WHERE a.task.id = :taskId AND a.id = :appointmentId")
    Optional<Appointment> findByTaskIdAndAppointmentId(@Param("taskId") Long taskId, @Param("appointmentId") Long appointmentId);

    @Query("SELECT a FROM Appointment a WHERE a.user.id = :userId AND a.task.id = :taskId")
    Optional<Appointment> findByUserIdAndTaskId(@Param("userId") Long userId, @Param("taskId") Long taskId);
}