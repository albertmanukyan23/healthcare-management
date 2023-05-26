package com.example.healthcaremanagement.Controller;

import com.example.healthcaremanagement.entity.Appointment;
import com.example.healthcaremanagement.security.CurrentUser;
import com.example.healthcaremanagement.service.AppointmentService;
import com.example.healthcaremanagement.service.DoctorService;
import com.example.healthcaremanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping
    public String appointments(ModelMap modelMap) {
        modelMap.addAttribute("appointments", appointmentService.findAllAppointments());
        return "appointments";
    }

    @GetMapping("/remove")
    public String appRemove(@RequestParam("id") int id) {
        appointmentService.deleteAppointmentById(id);
        return "redirect:/appointments";
    }

    @GetMapping("/create")
    public String createApp(ModelMap modelMap) {
        modelMap.addAttribute("doctors", doctorService.findAllDoctors());
        modelMap.addAttribute("patients", patientService.findAllPatients());
        return "createAppointment";
    }

    @PostMapping("/create")
    public String createApp(@ModelAttribute Appointment appointment,
                            @AuthenticationPrincipal CurrentUser user,
                            @RequestParam("date.time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date date) {
        appointmentService.addAppointment(user.getUser(), date, appointment);
        return "redirect:/appointments";
    }


}
