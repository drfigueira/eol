package com.eol.web;

import com.eol.model.request.SignUpRequest;
import com.eol.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String registry() {
        return "usuario-form";
    }

    @PostMapping
    public String registryProcess(@Valid SignUpRequest signUpRequest) {
        authService.registerUser(signUpRequest);
        return "/home";
    }
}
