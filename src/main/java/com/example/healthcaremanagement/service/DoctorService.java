package com.example.healthcaremanagement.service;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface DoctorService {
    List<Doctor> findAllDoctors();
    void deleteDoctorById(int id);
    void addDoctor(MultipartFile multipartFile, Doctor doctor) throws IOException;

}
