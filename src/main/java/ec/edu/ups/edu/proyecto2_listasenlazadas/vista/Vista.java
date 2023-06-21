/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.proyecto2_listasenlazadas.vista;


import ec.edu.ups.edu.proyecto2_listasenlazadas.controlador.Controlador;
import ec.edu.ups.edu.proyecto2_listasenlazadas.modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class Vista {
    private Controlador controlador;
    private Scanner scanner;

    public Vista() {
        this.controlador = new Controlador();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    mostrarHistorial();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("=== TIENDA ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Realizar venta");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Mostrar historial de transacciones");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarProducto() {
        System.out.println("=== AGREGAR PRODUCTO ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = scanner.nextInt();

        controlador.agregarProducto(nombre, codigo, precio, cantidadDisponible);
        System.out.println("Producto agregado correctamente.");
    }

    private void realizarVenta() {
        System.out.println("=== REALIZAR VENTA ===");
        System.out.println("Inventario actual:");
        mostrarInventario();

        System.out.print("Seleccione el código del producto a vender: ");
        int codigo = scanner.nextInt();
        System.out.print("Cantidad a vender: ");
        int cantidad = scanner.nextInt();

        List<Producto> inventario = controlador.obtenerInventario();
        Producto producto = buscarProductoPorCodigo(inventario, codigo);

        if (producto != null) {
            controlador.realizarVenta(producto, cantidad);
            System.out.println("Venta realizada correctamente.");
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }

    private void mostrarInventario() {
        List<Producto> inventario = controlador.obtenerInventario();
        System.out.println("=== INVENTARIO ===");
        for (Producto producto : inventario) {
            System.out.println(producto.getNombre() + " - Código: " + producto.getCodigo()
                    + " - Precio: " + producto.getPrecio() + " - Cantidad disponible: " + producto.getCantidadDisponible());
        }
    }

    private void mostrarHistorial() {
        List<String> historial = controlador.obtenerHistorial();
        System.out.println("=== HISTORIAL DE TRANSACCIONES ===");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }

    private Producto buscarProductoPorCodigo(List<Producto> inventario, int codigo) {
        for (Producto producto : inventario) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

}
