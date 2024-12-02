package com.project.Lenguajes.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeLogController {

    @GetMapping("/HomeLog")
    public String homeLog(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("user_id");

        if (userId != null) {

            System.out.println(String.valueOf(userId));
        } else {

            return "redirect:/Login";
        }

        return "HomeLog";
    }
}
