package com.brokul.cateringonline.controller;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.dto.CateringDto;
import com.brokul.cateringonline.service.AppUserService;
import com.brokul.cateringonline.service.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class CateringController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private CateringService cateringService;

    @GetMapping("/createOrder")
    public String getCreateOrderPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<AppUser> appUser = appUserService.findByUsername(user.getUsername());
        AppUser optionaAppuser = appUser.get();

        model.addAttribute("user", optionaAppuser);
        return "createOrder";
    }

    @GetMapping("/createOrder/{id}")
    public String createOrder(Model model,
                              @PathVariable(name = "id") Long id,
                              @RequestParam(name = "cateringType") String cateringType,
                              @RequestParam(name = "durationDays") String durationDays) {
        model.addAttribute("userId", id);
        model.addAttribute("kalorycznosc", cateringType);
        model.addAttribute("dniowosc", durationDays);
        return "createOrder2";
    }

    @PostMapping("/createOrder/{id}")
    public String createOrder(@PathVariable(name = "id") Long id, CateringDto cateringDto) {
        cateringService.createOrder(id, cateringDto);
        return "orderSummary";
    }


}

