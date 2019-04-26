/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import sun.util.calendar.CalendarUtils;

/**
 *
 * @author Gabriel
 */
public class Prestamo {
    private Socio socio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private ArrayList<LineaPrestamo> lineas;
    private EstadoPrestamo estado;
    
    public static final int MAX_LINEAS_PRESTAMO = 3;
    public static final int MAX_DIAS_PRESTAMO = 30;

    public Prestamo() {
        this.lineas = new ArrayList<LineaPrestamo>();
    }

    public Prestamo(Socio socio, Date fechaPrestamo) {
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        this.lineas = new ArrayList<LineaPrestamo>();
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
    
    public void agregarLineaPrestamo(Copia copia) {
        if(this.lineas.size() < MAX_LINEAS_PRESTAMO) {
            LineaPrestamo linea = new LineaPrestamo(copia);
            this.lineas.add(linea);
            System.out.println("Se agregó: " + linea.getCopia().toString());
        } else {
            System.out.println("Error: max. de copias alcanzado. (" + MAX_LINEAS_PRESTAMO +")");
        }
    }
    
    public void registrarPrestarmo() {
        /**
         *  Verificamos que el socio no posea ninguna multa
         */
        if(!socio.estaPenalizado()) {
            this.estado = EstadoPrestamo.INICIADO;
            
            // A cada copia se cambia el estado a prestada.
            for(LineaPrestamo linea : this.lineas) {
                linea.getCopia().setEstado(EstadoCopia.PRESTADA);
            }
            
            System.out.println("Prestramo registrado.");
        } else {
            System.out.println("Error: el usuario esta penalizado por multa.");
            
            
            Date hoy = new Date();
            // Obtengo la fecha cuando realizo la multa
            Calendar fechaPenalidad = Calendar.getInstance();
            fechaPenalidad.setTime(socio.getMulta().getFecha());
            
            // A esa fecha le sumo la cantidad de dias de penalidad que tiene el socio
            // para determinar cuando termina su penalidad y puede volver a solicitar prestamos
            fechaPenalidad.add(Calendar.DATE, socio.getMulta().getDiasPenalidad());            
            Date fechaFinPenalidad = fechaPenalidad.getTime();

            // veo cuantos dias le faltan para volver a alquilar desde el dia de hoy
            int diasEspera = (int) Math.abs(hoy.getTime() - fechaFinPenalidad.getTime());
            System.out.println(String.format("Socio debe esperar %d dias", diasEspera));
        }
    }
    
    public int contarDiasRetraso(Date fechaDevolucion) {
        int diferenciaDias = 0;
        
        // convertimos el tiempo en milisegundos para poder operar matematicamente
        long diferenciaMillieSeconds = Math.abs(fechaDevolucion.getTime() - this.getFechaPrestamo().getTime());
        
        // con el resultado obtenido en milisegundos, lo convertirmos en cantidad de dias y lo casteamos como entero
        diferenciaDias = (int) TimeUnit.DAYS.convert(diferenciaMillieSeconds, TimeUnit.MILLISECONDS);
        
        // retornamos la cantidad de dias de retraso
        return diferenciaDias;
    }
    
    public void regristrarDevolucion() {
        
    }
    
    public void regirarMulta(Socio socio, Date fecha, int diasRetraso) {
        Multa multa = new Multa(fecha, diasRetraso);
        socio.setMulta(multa);
    }
    
    @Override
    public String toString() {
        String texto = "";
        
        texto += "\nSocio: " + this.socio.getNombre();
        texto += "\nLibros: ";
        
        int contador = 0;
        Iterator iterator = this.lineas.iterator();
        while(iterator.hasNext()){
            contador++;
            LineaPrestamo linea = (LineaPrestamo) iterator.next();
            texto += String.format("\n\tLibro %d: %s [%d]", contador, linea.getCopia().getLibro(), linea.getCopia().getIdentificador());
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDevolucion  = this.fechaDevolucion != null ? sdf.format(this.fechaDevolucion) : "";
        
        texto += "\nFechaPrestamo: " + sdf.format(this.fechaPrestamo);
        texto += "\nFechaDevolucion: " + fechaDevolucion;
        texto += "\nEstado: " + this.estado;

        return texto;
    }
}
