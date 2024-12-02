package com.project.Lenguajes.controller;

import Modelo.Pelicula;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Cartelera")
public class CarteleraController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String obtenerTodasLasPeliculas(Model model) {
        String sql = "SELECT ID_PELICULA, ID_GENERO, TITULO, DURACION, ANIO_ESTRENO, CLASIFICACION, IMAGEN FROM PELICULAS";
        List<Pelicula> peliculas = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Pelicula pelicula = new Pelicula();
            pelicula.setIdPelicula(rs.getLong("ID_PELICULA"));
            pelicula.setIdGenero(rs.getLong("ID_GENERO"));
            pelicula.setTitulo(rs.getString("TITULO"));
            pelicula.setDuracion(rs.getLong("DURACION"));
            pelicula.setAnioEstreno(rs.getLong("ANIO_ESTRENO"));
            pelicula.setClasificacion(rs.getString("CLASIFICACION"));
            pelicula.setImagen(rs.getString("IMAGEN"));
            return pelicula;
        });
        model.addAttribute("datos", peliculas);
        return "Cartelera";
    }
    @PostMapping("/insertar")
public String insertarPelicula(@RequestParam String titulo, @RequestParam Long duracion,
                               @RequestParam Long anioEstreno, @RequestParam String clasificacion,
                               @RequestParam String imagen, HttpSession session) {
    String tipoUsuario = (String) session.getAttribute("tipo_usuario");
    if ("ADMINISTRADOR".equals(tipoUsuario)) {
        String sql = "BEGIN insertar_pelicula(?, ?, ?, ?, ?); END;";
        jdbcTemplate.update(sql, titulo, duracion, anioEstreno, clasificacion, imagen);
        return "redirect:/Cartelera";
    } else {
        return "redirect:/Home";
    }
}


    @PostMapping("/actualizar")
    public String actualizarPelicula(@RequestParam Long idPelicula, @RequestParam String titulo, 
                                      @RequestParam Long duracion, @RequestParam Long anioEstreno, 
                                      @RequestParam String clasificacion, @RequestParam String imagen,
                                      HttpSession session) {
        String tipoUsuario = (String) session.getAttribute("tipo_usuario");
        if ("ADMINISTRADOR".equals(tipoUsuario)) {
            String sql = "BEGIN actualizar_pelicula(?, ?, ?, ?, ?, ?); END;";
            jdbcTemplate.update(sql, idPelicula, titulo, duracion, anioEstreno, clasificacion, imagen);
            return "redirect:/Cartelera"; 
        } else {
            return "redirect:/Home";
        }
    }

    @PostMapping("/eliminar")
    public String eliminarPelicula(@RequestParam Long idPelicula, HttpSession session) {
        String tipoUsuario = (String) session.getAttribute("tipo_usuario");
        if ("ADMINISTRADOR".equals(tipoUsuario)) {
            String sql = "BEGIN eliminar_pelicula(?); END;";
            jdbcTemplate.update(sql, idPelicula);
            return "redirect:/Cartelera"; 
        } else {
            return "redirect:/Home";
        }
    }
}
