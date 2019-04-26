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
public class Copia {
    private int identificador;
    private Libro libro;
    private EstadoCopia estado;

    public Copia(int identificador, Libro libro, EstadoCopia estado) {
        this.identificador = identificador;
        this.libro = libro;
        this.estado = estado;
    }

    public EstadoCopia getEstado() {
        return estado;
    }

    public void setEstado(EstadoCopia estado) {
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String toString() {
      return "\nIdentificador: "   + this.identificador
              + "\nLibro: " + this.libro.toString()
              + "\nEstado: " + this.estado;
    }
    
    
}
