/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.proyecto2_listasenlazadas.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregarProducto(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }

    public List<Producto> obtenerInventario() {
        List<Producto> inventario = new ArrayList<>();
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            inventario.add(nodoActual.producto);
            nodoActual = nodoActual.siguiente;
        }
        return inventario;
    }

    public boolean buscarProducto(int codigo) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.producto.getCodigo() == codigo) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

    public Producto obtenerProducto(int codigo) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.producto.getCodigo() == codigo) {
                return nodoActual.producto;
            }
            nodoActual = nodoActual.siguiente;
        }
        return null;
    }

    public boolean eliminarProducto(int codigo) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.producto.getCodigo() == codigo) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo nodoActual = cabeza;
        while (nodoActual.siguiente != null) {
            if (nodoActual.siguiente.producto.getCodigo() == codigo) {
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

}
