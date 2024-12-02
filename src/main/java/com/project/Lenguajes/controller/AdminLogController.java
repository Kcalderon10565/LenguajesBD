/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.Lenguajes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kenca
 */
@Controller
public class AdminLogController {
    @GetMapping("/AdminLog")
    public String adminLog() {
        return "AdminLog"; 
    }
    
}
