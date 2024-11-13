package com.ifpb.ads.p5.taskManagerAPI.controllers;

import com.ifpb.ads.p5.taskManagerAPI.models.Appointment;
import com.ifpb.ads.p5.taskManagerAPI.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable long id) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable long id, @RequestBody Appointment appointmentDetails) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment != null) {
            appointment.setDataHora(appointmentDetails.getDataHora());
            appointment.setUser(appointmentDetails.getUser());
            appointment.setTask(appointmentDetails.getTask());
            return ResponseEntity.ok(appointmentService.save(appointment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}