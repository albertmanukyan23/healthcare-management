package com.example.healthcaremanagement.service.impl;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.repository.DoctorRepository;
import com.example.healthcaremanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Value("${hospital.upload.image.path}")
    private String imageUploadPath;
    @Override
    public List<Doctor> findAllDoctors() {
          return doctorRepository.findAll();
    }

    @Override
    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void addDoctor(MultipartFile multipartFile, Doctor doctor) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            doctor.setProfilePic(fileName);
        }
        doctorRepository.save(doctor);
    }
}
