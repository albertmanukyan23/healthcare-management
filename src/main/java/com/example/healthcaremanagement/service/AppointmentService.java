package com.example.healthcaremanagement.service;

import com.example.healthcaremanagement.entity.Appointment;
import com.example.healthcaremanagement.entity.User;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findAllAppointments();

    void deleteAppointmentById(int id);

    void addAppointment(User user, Date date, Appointment appointment);

}
