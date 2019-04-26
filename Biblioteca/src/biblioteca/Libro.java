/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Gabriel
 */
class Libro {
    String nombre;
    TipoLibro tipo;
    Autor autor;
    String editorial;
    int anio;

    public Libro(String nombre, TipoLibro tipo, Autor autor, String editorial, int anio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoLibro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
      return "Nombre: "   + this.nombre
              + " - Tipo: " + this.tipo
              + " - Editorial: " + this.editorial
              + " - Autor: " + this.autor.getNombre()
              + " - Anio: " + this.anio;
    }    
    
    
}
