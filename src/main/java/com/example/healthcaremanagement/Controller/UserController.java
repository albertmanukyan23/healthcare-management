package com.example.healthcaremanagement.Controller;

import com.example.healthcaremanagement.entity.User;
import com.example.healthcaremanagement.entity.UserType;
import com.example.healthcaremanagement.repository.UserRepository;
import com.example.healthcaremanagement.security.CurrentUser;
import com.example.healthcaremanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/";
    }
    @GetMapping("/admin")
    public  String admin(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap){
        modelMap.addAttribute("user",currentUser);
        return "admin";
    }

}
