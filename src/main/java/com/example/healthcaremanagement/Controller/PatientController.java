package com.example.healthcaremanagement.Controller;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repository.DoctorRepository;
import com.example.healthcaremanagement.repository.PatientRepository;
import com.example.healthcaremanagement.service.PatientService;
import com.example.healthcaremanagement.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private  final PatientService patientService;
    @GetMapping
    public String patients(ModelMap modelMap) {
        modelMap.addAttribute("patients", patientService.findAllPatients());
        return "patients";
    }

    @GetMapping("/remove")
    public String patientRemove(@RequestParam("id") int id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }

    @GetMapping("/create")
    public String createPatient() {
        return "createPatient";
    }

    @PostMapping("/create")
    public String createPatient(@ModelAttribute Patient patient,
                                @RequestParam("birthdayDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate) {
        patientService.addPatient(birthDate, patient);
        return "redirect:/patients";
    }
}
