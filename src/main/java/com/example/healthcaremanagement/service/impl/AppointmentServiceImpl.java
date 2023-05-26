package com.example.healthcaremanagement.service.impl;

import com.example.healthcaremanagement.entity.Appointment;
import com.example.healthcaremanagement.entity.User;
import com.example.healthcaremanagement.repository.AppointmentRepository;
import com.example.healthcaremanagement.repository.DoctorRepository;
import com.example.healthcaremanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointmentById(int id) {
        appointmentRepository.deleteById(id);

    }

    @Override
    public void addAppointment(User user, Date date, Appointment appointment) {
        appointment.setUser(user);
        appointment.setDateTime(date);
        appointmentRepository.save(appointment);
    }
}
