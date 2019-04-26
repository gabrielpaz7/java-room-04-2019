/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Terminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Biblioteca.inicializar();
        
        // Crearmos una fecha, que va a usarse para crear un autor, que va a usarse para crear un libro
        String stringDate = "19/01/1809";
        Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        Autor autor = new Autor("Edgar Allan Poe", "US", fechaNacimiento);
        Libro libro = new Libro("The Raven", TipoLibro.NOVELA, autor, "American Review", 1845);
        
        Copia copia = new Copia(666, libro, EstadoCopia.DISPONIBLE);
        
        
        Socio socio = new Socio(1, "Cosme Fulanito");
        
        Date hoy = new Date();
        Prestamo prestamo = new Prestamo(socio, hoy);
        
        prestamo.agregarLineaPrestamo(copia);
        
       
        // Agrego una segunda copia del libro al prestamo que es del mismo socio
        // ---------------------------------------
        
        copia = new Copia(999, libro, EstadoCopia.DISPONIBLE);
        prestamo.agregarLineaPrestamo(copia);
        
        
        // Guardo el prestamo
        // ---------------------------------------
        
        prestamo.registrarPrestarmo();
        Biblioteca.prestamos.add(prestamo);
        
        
        // Muestro el prestamo
        // ---------------------------------------
        
        Biblioteca.mostrarTodo();
    }
    
}
