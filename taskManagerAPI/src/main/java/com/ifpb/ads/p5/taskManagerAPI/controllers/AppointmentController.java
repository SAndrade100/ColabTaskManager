package com.ifpb.ads.p5.taskManagerAPI.controllers;

import com.ifpb.ads.p5.taskManagerAPI.models.Appointment;
import com.ifpb.ads.p5.taskManagerAPI.models.Task;
import com.ifpb.ads.p5.taskManagerAPI.models.User;
import com.ifpb.ads.p5.taskManagerAPI.services.AppointmentService;
import com.ifpb.ads.p5.taskManagerAPI.services.TaskService;
import com.ifpb.ads.p5.taskManagerAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

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

    @PostMapping("/schedule")
    public ResponseEntity<Appointment> scheduleAppointment(@RequestParam long userId, @RequestParam long taskId) {
        User user = userService.findById(userId);
        Task task = taskService.findById(taskId);

        if(user == null || task == null) {
            return ResponseEntity.notFound().build();
        }

        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setTask(task);
        appointment.setDataHora(new Date());

        Appointment savedAppointment = appointmentService.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @DeleteMapping("/unschedule")
    public ResponseEntity<Void> unscheduleAppointment(@RequestParam long userId, @RequestParam long taskId) {
        Optional<Appointment> appointment = appointmentService.findByUserIdAndTaskId(userId, taskId);
        if (appointment.isPresent()) {
            appointmentService.delete(appointment.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}