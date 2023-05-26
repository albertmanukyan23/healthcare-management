package com.example.healthcaremanagement.Controller;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.repository.DoctorRepository;
import com.example.healthcaremanagement.security.CurrentUser;
import com.example.healthcaremanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private  DoctorService doctorService;
    @GetMapping
    public String doctors(ModelMap modelMap) {
        modelMap.addAttribute("doctors", doctorService.findAllDoctors());
        return "doctors";
    }

    @GetMapping("/remove")
    public String doctorsRemove(@RequestParam("id") int id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }

    @GetMapping("/create")
    public String createDoctor() {
        return "createDoctor";
    }

    @PostMapping("/create")
    public String createDoctor(@ModelAttribute Doctor doctor,
                               @RequestParam("image") MultipartFile multipartFile) throws IOException {
        doctorService.addDoctor(multipartFile,doctor);
        return "redirect:/doctors";
    }
}
