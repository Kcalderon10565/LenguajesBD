package com.project.Lenguajes.dao;

import Modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarteleraDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para obtener todas las películas desde el procedimiento almacenado
    public List<Pelicula> mostrar() {
        // Definir la llamada al procedimiento almacenado
        String query = "{ call PLENGUAJES.ObtenerTodasLasPeliculas(?) }";

        // Llamar al procedimiento almacenado y mapear los resultados
        return jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
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
    }
}
