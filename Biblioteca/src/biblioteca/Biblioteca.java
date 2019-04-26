/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gabriel
 */
public class Biblioteca {
    public static ArrayList<Libro> libros;
    public static ArrayList<Copia> copias;
    public static ArrayList<Prestamo> prestamos;
    
    public static void inicializar() {
        libros = new ArrayList<Libro>();
        copias = new ArrayList<Copia>();
        prestamos = new ArrayList<Prestamo>();
    }
    
    
    public static void mostrarTodo() {
        mostrarPrestamos();
    }

    private static void mostrarPrestamos() {
        int contador = 0;
        Iterator iterator = prestamos.iterator();
        while(iterator.hasNext()) {
            contador++;
            
            System.out.println("\n-------------- PRESTAMO " + contador + "--------------");
            Prestamo prestamo = (Prestamo) iterator.next();
            System.out.println(prestamo.toString());
        }
    }
}
