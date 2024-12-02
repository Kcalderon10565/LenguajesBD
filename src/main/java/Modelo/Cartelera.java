package Modelo;

public class Cartelera {
    private int Pelicula_id;
    private String Titulo;
    private String Genero;
    private double Duracion;
    private int Anio_estreno;
    private int Calificacion;

    public Cartelera() {
    }

    public Cartelera(int Pelicula_id, String Titulo, String Genero, double Duracion, int Anio_estreno, int Calificacion) {
        this.Pelicula_id = Pelicula_id;
        this.Titulo = Titulo;
        this.Genero = Genero;
        this.Duracion = Duracion;
        this.Anio_estreno = Anio_estreno;
        this.Calificacion = Calificacion;
    }

    public int getPelicula_id() {
        return Pelicula_id;
    }

    public void setPelicula_id(int Pelicula_id) {
        this.Pelicula_id = Pelicula_id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getDuracion() {
        return Duracion;
    }

    public void setDuracion(double Duracion) {
        this.Duracion = Duracion;
    }

    public int getAnio_estreno() {
        return Anio_estreno;
    }

    public void setAnio_estreno(int Anio_estreno) {
        this.Anio_estreno = Anio_estreno;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }

    

    
    
}
