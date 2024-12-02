package com.project.Lenguajes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void guardarCliente(String nombre, String apellido, String email, String contrasenna) {
        String sql = "BEGIN PLENGUAJES.insertar_cliente(?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, nombre, apellido, email, contrasenna);
    }
}
