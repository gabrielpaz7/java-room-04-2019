/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
class Multa {
    private Date fecha;
    private int diasPenalidad;

    public static final int PENALIDAD_POR_DIA = 2;
    
    public Multa() {
    }
    
    public Multa(Date fecha, int diasRetraso) {
        this.fecha = fecha;
        
        // Calcula la cantidad de dias que el socio va a estar suspendido
        this.diasPenalidad = diasRetraso * PENALIDAD_POR_DIA;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDiasPenalidad() {
        return diasPenalidad;
    }

    public void setDiasPenalidad(int diasPenalidad) {
        this.diasPenalidad = diasPenalidad;
    }
    
    
    
    
}
