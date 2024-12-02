package com.project.Lenguajes.controller;

import com.project.Lenguajes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Registro")
    public String mostrarRegistro() {
        return "Registro";  // Devuelve la vista del formulario de registro
    }

    @PostMapping("/registrar")
    public ModelAndView registrarCliente(@RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("contrasenna") String contrasenna) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Email: " + email);
        System.out.println("Contraseña: " + contrasenna);

        try {
            usuarioService.guardarCliente(nombre, apellido, email, contrasenna);
            System.out.println("Cliente guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/Home");
    }

}
