package ac.cr.cenfotec.bejarano.m.ui;

import ac.cr.cenfotec.bejarano.m.bl.*;

import java.util.Scanner;

/**
 * Clase encargada de manejar toda la interacción con el usuario.
 * Presenta menús, solicita datos y delega la lógica al {@link Controller}.
 * Esta clase forma parte de la capa UI dentro del patrón MVC.
 *
 * @author Mauricio Bejarano
 * @version 2.0
 */
public class UI {

        private Scanner sc = new Scanner(System.in);
        private Controller controller = new Controller();

    /**
     * Inicia el menú principal de la aplicación y gestiona
     * las opciones seleccionadas por el usuario.
     */

        public void iniciarMenu() {

            int opcion = -1;

            while (opcion != 0) {

                System.out.println("\n======= MENÚ PRINCIPAL =======");
                System.out.println("1. Registrar cliente");
                System.out.println("2. Registrar producto");
                System.out.println("3. Registrar compra");
                System.out.println("4. Listar clientes");
                System.out.println("5. Listar productos");
                System.out.println("0. Salir");
                System.out.print("Elija una opción: ");

                opcion = leerEntero("");

                switch (opcion) {

                    case 1 -> registrarClienteUI();
                    case 2 -> registrarProductoUI();
                    case 3 -> registrarCompraUI();
                    case 4 -> listarClientes();
                    case 5 -> listarProductos();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            }
        }
        /**
         * Solicita los datos necesarios para registrar un cliente
         * y envía la información al controlador.
         */
        private void registrarClienteUI() {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();

            controller.registrarCliente(nombre, correo, telefono);
            System.out.println("Cliente registrado.");
        }

        /**
         * Solicita los datos necesarios para registrar un producto
         * y notifica al controlador para almacenarlo.
         */
        private void registrarProductoUI() {
            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            double precio = leerDouble("Precio: ");

            controller.registrarProducto(nombre, precio);
            System.out.println("Producto registrado.");
        }

        /**
         * Permite registrar una compra mediante la creación de una factura.
         * Incluye selección de cliente, productos y cantidades.
         */
        private void registrarCompraUI() {

            if (controller.getClientes().isEmpty() || controller.getProductos().isEmpty()) {
                System.out.println("Debe registrar al menos un cliente y un producto primero.");
                return;
            }

            Cliente cliente = seleccionarCliente();
            Factura factura = new Factura(cliente);

            boolean continuar = true;

            while (continuar) {

                Producto producto = seleccionarProducto();
                int cantidad = leerEntero("Cantidad: ");

                factura.agregarLinea(producto, cantidad);

                int op = leerEntero("¿Agregar otro producto? 1=Sí | 0=No: ");
                continuar = (op == 1);
            }

            controller.getFacturas().add(factura);

            System.out.println("\nFactura registrada con éxito:");
            System.out.println(factura);
        }

        // LISTADOS

        /**
         * Muestra la lista de clientes registrados.
         */

        private void listarClientes() {
            System.out.println("\n--- Clientes registrados ---");
            for (int i = 0; i < controller.getClientes().size(); i++) {
                System.out.println((i + 1) + ". " + controller.getClientes().get(i));
            }
        }

        private void listarProductos() {
            System.out.println("\n--- Productos registrados ---");
            for (int i = 0; i < controller.getProductos().size(); i++) {
                System.out.println((i + 1) + ". " + controller.getProductos().get(i));
            }
        }
        /**
         * Permite seleccionar un cliente de la lista.
         *
         * @return El cliente seleccionado.
         */
        private Cliente seleccionarCliente() {
            while (true) {
                listarClientes();
                int index = leerEntero("Seleccione un cliente: ") - 1;

                if (index >= 0 && index < controller.getClientes().size()) {
                    return controller.getClientes().get(index);
                }

                System.out.println("Numero invalido. Intente nuevamente.\n");
            }
        }

    private Producto seleccionarProducto() {
        while (true) {
            listarProductos();
            int index = leerEntero("Seleccione un producto: ") - 1;

            if (index >= 0 && index < controller.getProductos().size()) {
                return controller.getProductos().get(index);
            }
            System.out.println(" Numero invalido. Intente nuevamente.\n");
        }
    }
    /**
         * Lee un número entero del usuario de forma segura.
         *
         * @param mensaje Mensaje a mostrar.
         * @return El número entero ingresado.
         */
        // LECTURA SEGURA
        private int leerEntero(String mensaje) {
            while (true) {
                try {
                    System.out.print(mensaje);
                    return Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }
        }

        /**
         * Lee un número decimal del usuario de forma segura.
         *
         * @param mensaje Mensaje a mostrar.
         * @return El número decimal ingresado.
         */
        private double leerDouble(String mensaje) {
            while (true) {
                try {
                    System.out.print(mensaje);
                    return Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }
        }
    }
