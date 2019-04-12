/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpedidos;

/**
 *
 * @author Gabriel
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;
    private DetalleProducto detalleProducto;
    public Producto() {
    }

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion, double precio, DetalleProducto detalleProducto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.detalleProducto = detalleProducto;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }
    
    public String toString() {
        return "{ codigo: " + codigo
                + " - descripcion: " + descripcion
                + " - precio: " + precio + " }";
    }
    
    
}
