package com.brokul.cateringonline.controller;

import com.brokul.cateringonline.model.dto.AppUserDto;
import com.brokul.cateringonline.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private AppUserService appUserService;


    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/index.html")
    public String getIndex2(){
        return "index";
    }

    @GetMapping("/appUserPage")
    public String getUserPanel(){
        return "appUserPanel";
    }


    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String submitRegisterForm(AppUserDto appUserDto, String passwordConfirm) {


        if (!appUserDto.getPassword().equals(passwordConfirm)) {
            return "redirect:/register?error=Passwords do not match";
        }

        boolean result = appUserService.register(appUserDto.getUsername(), appUserDto.getPassword());

        if (!result) {
            return "redirect:/register?error=Error while registerying. Probably username exists.";
        }

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }



}



