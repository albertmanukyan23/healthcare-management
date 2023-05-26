package com.example.healthcaremanagement.service;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.entity.Patient;

import java.util.Date;
import java.util.List;

public interface PatientService {
    List<Patient> findAllPatients();
    void deletePatientById(int id);
    void addPatient(Date birthDate,Patient patient);

}
