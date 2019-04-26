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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gabriel", "Rivadavia 1050", "3815982851", "cgabrielpaz87@gmail.com");
        
        Pedido pedido = new Pedido();
        pedido.setFecha("12-04-2019");
        pedido.setCliente(cliente);
        
        Producto producto1 = new Producto(1, "Jacket", 100);
        Producto producto2 = new Producto(2, "Jeans", 99.99);
        
        pedido.agregarLineaPedido(producto1, 10);
        pedido.agregarLineaPedido(producto2, 10);
        
        pedido.finalizar();
        
    }
    
}
