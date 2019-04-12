/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpedidos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gabriel
 */
public class Pedido {
    private String fecha;
    private Cliente cliente;
    private double total;
    private ArrayList<LineaPedido> lineasPedido;
    private String estado;
    static final int MAX_UNIDADES = 20;

    public Pedido() {
        this.lineasPedido = new ArrayList<LineaPedido>();
    }

    public Pedido(String fecha, Cliente cliente, double total, ArrayList<LineaPedido> lineasPedido, String estado) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.lineasPedido = lineasPedido;
        this.estado = estado;
    }

    
    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    private int calcularTotalUnidades() {
        Iterator iter = this.lineasPedido.iterator();
        int totalUnidades = 0;
        while(iter.hasNext()) {
            LineaPedido lineaPedido = (LineaPedido) iter.next();
            totalUnidades += lineaPedido.getCantidad();
        }
        return totalUnidades;
    }
    
    public double calcularTotal() {
        Iterator iter = this.lineasPedido.iterator();
        double total = 0;
        while(iter.hasNext()) {
            LineaPedido lineaPedido = (LineaPedido) iter.next();
            total += lineaPedido.getProducto().getPrecio();
        }
        return total;
    }
    
    public void agregarLineaPedido(Producto producto, int cantidad) {
        if(calcularTotalUnidades() <= MAX_UNIDADES) {
            LineaPedido linea = new LineaPedido(producto, cantidad);
            this.lineasPedido.add(linea);
            System.out.println("Se agregó: " + linea.getProducto().toString());
        }
    }
    
    public void finalizar() {
        this.total = this.calcularTotal();
        this.estado = "TERMINADO";
        
        System.out.println("Pedido Finalizado" + toString());       
    }
    
    @Override
    public String toString() {
        return "\nFecha: " + fecha
                + "\nCliente: " + cliente.toString()
                + "\nTotal: " + total
                + "\nEstado: " + estado;
    }
    
    
}
