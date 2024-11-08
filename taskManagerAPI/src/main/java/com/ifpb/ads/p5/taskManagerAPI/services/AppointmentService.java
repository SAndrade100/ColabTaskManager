package com.ifpb.ads.p5.taskManagerAPI.services;

import com.ifpb.ads.p5.taskManagerAPI.models.Appointment;
import com.ifpb.ads.p5.taskManagerAPI.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;

    public List<Appointment> listAll(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(Long id){
        return appointmentRepository.findById(id).get();
    }

    public Appointment save(Appointment user){
        return appointmentRepository.save(user);
    }

    public void delete(Long id){
        appointmentRepository.deleteById(id);
    }

    public Appointment update(Appointment user){
        return appointmentRepository.save(user);
    }

    public Optional<Appointment> findByUserId(Long userId){
        return appointmentRepository.findByUserId(userId);
    }

    public Optional<Appointment> findByTaskId(Long taskId){
        return appointmentRepository.findByTaskId(taskId);
    }

    public Optional<Appointment> findByUserIdAndAppointmentId(Long userId, Long appointmentId){
        return appointmentRepository.findByUserIdAndAppointmentId(userId, appointmentId);
    }

    public Optional<Appointment> findByTaskIdAndAppointmentId(Long taskId, Long appointmentId){
        return appointmentRepository.findByTaskIdAndAppointmentId(taskId, appointmentId);
    }

    public Optional<Appointment> findByUserIdAndTaskId(Long userId, Long taskId){
        return appointmentRepository.findByUserIdAndTaskId(userId, taskId);
    }
}
