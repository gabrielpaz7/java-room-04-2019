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
public class LineaPrestamo {
    private Copia copia;

    public LineaPrestamo(Copia copia) {
        this.copia = copia;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }
    
}
