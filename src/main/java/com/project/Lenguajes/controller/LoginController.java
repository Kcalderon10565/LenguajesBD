package com.project.Lenguajes.controller;

import Modelo.Conexion;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Controller
public class LoginController {

    Conexion c = new Conexion();

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("contrasena") String contrasena,
                               Model model,
                               HttpSession session) {
        try (Connection con = c.conectar()) {
            if (con == null) {
                model.addAttribute("error", "No se pudo conectar con la base de datos");
                return "Login";
            }

            String emailLimpio = email.trim();
            String contrasenaLimpia = contrasena.trim();

            System.out.println("Email enviado al procedimiento: [" + emailLimpio + "]");
            System.out.println("Contraseña enviada al procedimiento: [" + contrasenaLimpia + "]");

            CallableStatement cs = con.prepareCall("{CALL LOGIN_UNIFICADO(?, ?, ?)}");
            cs.setString(1, emailLimpio);
            cs.setString(2, contrasenaLimpia);
            cs.registerOutParameter(3, Types.VARCHAR);

            cs.execute();


            String tipoUsuario = cs.getString(3);
            System.out.println("Tipo de usuario retornado: [" + tipoUsuario + "]");


            if (tipoUsuario != null) {
                tipoUsuario = tipoUsuario.trim();
            }

            if ("CLIENTE".equals(tipoUsuario)) {
                session.setAttribute("tipo_usuario", "CLIENTE");
                return "redirect:/Home";
            } else if ("ADMINISTRADOR".equals(tipoUsuario)) {
                session.setAttribute("tipo_usuario", "ADMINISTRADOR");
                return "redirect:/Home";
            } else {
                model.addAttribute("error", "Credenciales inválidas o usuario desconocido");
                return "Login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al procesar la solicitud: " + e.getMessage());
            return "Login";
        }
    }
}
