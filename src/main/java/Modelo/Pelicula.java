package Modelo;

public class Pelicula {

    private Long idPelicula;
    private Long idGenero;
    private String titulo;
    private Long duracion;
    private Long anioEstreno;
    private String clasificacion;
    private String imagen;


    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public Long getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Long anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
