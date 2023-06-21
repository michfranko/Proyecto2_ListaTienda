/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.proyecto2_listasenlazadas.controlador;
import ec.edu.ups.edu.proyecto2_listasenlazadas.modelo.ListaEnlazada;
import ec.edu.ups.edu.proyecto2_listasenlazadas.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controlador {
    private ListaEnlazada inventario;
    private Stack<String> historial;

    public Controlador() {
        this.inventario = new ListaEnlazada();
        this.historial = new Stack<>();
    }

    public void agregarProducto(String nombre, int codigo, double precio, int cantidadDisponible) {
        Producto producto = new Producto(nombre, codigo, precio, cantidadDisponible);
        inventario.agregarProducto(producto);
    }

    public List<Producto> obtenerInventario() {
        return inventario.obtenerInventario();
    }

    public void realizarVenta(Producto producto, int cantidad) {
        if (producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            String registroVenta = "Venta - Producto: " + producto.getNombre() + ", Cantidad: " + cantidad;
            historial.push(registroVenta);
        } else {
            System.out.println("No hay suficiente stock disponible para realizar la venta.");
        }
    }

    public List<String> obtenerHistorial() {
        List<String> historialList = new ArrayList<>();
        for (String registro : historial) {
            historialList.add(registro);
        }
        return historialList;
    }

    // Otros métodos para la lógica de negocio
    // ...
}
