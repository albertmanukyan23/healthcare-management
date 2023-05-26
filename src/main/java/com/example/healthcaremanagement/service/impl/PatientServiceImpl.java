package com.example.healthcaremanagement.service.impl;

import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repository.PatientRepository;
import com.example.healthcaremanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAllPatients() {
        return  patientRepository.findAll();
    }

    @Override
    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void addPatient(Date birthDate, Patient patient) {
        patient.setDateOfBirthday(birthDate);
        patientRepository.save(patient);
    }
}
