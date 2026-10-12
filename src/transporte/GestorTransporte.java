package transporte;

import java.util.*;

/**
 * Administra la lista de vehiculos: alta, busqueda, filtro y ordenamientos.
 */
public class GestorTransporte {

    private ArrayList<Vehiculo> listaVehiculos;

    /**
     * Que hace: crea el gestor con la lista de vehiculos vacia.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada (constructor).
     */
    public GestorTransporte() {
        listaVehiculos = new ArrayList<>();
    }

    /**
     * Que hace: agrega un vehiculo a la lista si su patente no existe.
     *
     * Parametros:
     *   nuevoVehiculo: el vehiculo a agregar
     *
     * Retorna: nada. Lanza PatenteDuplicadaException si la patente ya existe.
     */
    public void agregarVehiculo(Vehiculo nuevoVehiculo) throws PatenteDuplicadaException {
        if (existePatente(nuevoVehiculo.getPatente())) {
            throw new PatenteDuplicadaException("Ya existe un vehiculo con la patente " + nuevoVehiculo.getPatente() + ".");
        }
        listaVehiculos.add(nuevoVehiculo);
    }

    /**
     * Que hace: muestra todos los vehiculos cargados.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    public void mostrarTodos() {
        mostrarLista(listaVehiculos);
    }

    /**
     * Que hace: cada vehiculo realiza su servicio (polimorfismo).
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    public void realizarServicios() {
        if (listaVehiculos.size() == 0) {
            System.out.println("No hay vehiculos cargados.");
        } else {
            for (Vehiculo vehiculoActual : listaVehiculos) {
                vehiculoActual.realizarServicio();
            }
        }
    }

    /**
     * Que hace: busca un vehiculo por patente y lo muestra.
     *
     * Parametros:
     *   patente: la patente a buscar
     *
     * Retorna: nada.
     */
    public void buscarPorPatente(String patente) {
        boolean encontrado = false;
        for (Vehiculo vehiculoActual : listaVehiculos) {
            if (vehiculoActual.getPatente().equals(patente)) {
                mostrarVehiculo(vehiculoActual);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun vehiculo con la patente " + patente + ".");
        }
    }

    /**
     * Que hace: muestra los vehiculos con capacidad mayor al limite.
     *
     * Parametros:
     *   limite: la capacidad minima a superar
     *
     * Retorna: nada.
     */
    public void filtrarPorCapacidad(int limite) {
        ArrayList<Vehiculo> filtrados = new ArrayList<>();
        for (Vehiculo vehiculoActual : listaVehiculos) {
            if (vehiculoActual.getCapacidadPasajeros() > limite) {
                filtrados.add(vehiculoActual);
            }
        }
        if (filtrados.size() == 0) {
            System.out.println("No hay vehiculos con capacidad mayor a " + limite + ".");
        } else {
            mostrarLista(filtrados);
        }
    }

    /**
     * Que hace: ordena los vehiculos por anio, del mas nuevo al mas viejo,
     *           y los muestra.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    public void mostrarPorAnioDescendente() {
        Collections.sort(listaVehiculos);
        mostrarLista(listaVehiculos);
    }

    /**
     * Que hace: ordena los vehiculos por capacidad, de mayor a menor,
     *           y los muestra.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    public void mostrarPorCapacidadDescendente() {
        Collections.sort(listaVehiculos, new ComparadorPorCapacidad());
        mostrarLista(listaVehiculos);
    }

    /**
     * Que hace: revisa si ya hay un vehiculo con esa patente.
     *
     * Parametros:
     *   patente: la patente a revisar
     *
     * Retorna: true si existe, false si no.
     */
    public boolean existePatente(String patente) {
        boolean existe = false;
        for (Vehiculo vehiculoActual : listaVehiculos) {
            if (vehiculoActual.getPatente().equals(patente)) {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Que hace: muestra los vehiculos de una lista, o avisa si esta vacia.
     *
     * Parametros:
     *   lista: la lista a mostrar
     *
     * Retorna: nada.
     */
    private void mostrarLista(ArrayList<Vehiculo> lista) {
        if (lista.size() == 0) {
            System.out.println("No hay vehiculos cargados.");
        } else {
            for (Vehiculo vehiculoActual : lista) {
                mostrarVehiculo(vehiculoActual);
            }
        }
    }

    /**
     * Que hace: muestra los datos de un vehiculo en una linea.
     *
     * Parametros:
     *   vehiculoAMostrar: el vehiculo a mostrar
     *
     * Retorna: nada.
     */
    private void mostrarVehiculo(Vehiculo vehiculoAMostrar) {
        System.out.println("Patente: " + vehiculoAMostrar.getPatente()
                + " | Marca: " + vehiculoAMostrar.getMarca()
                + " | Capacidad: " + vehiculoAMostrar.getCapacidadPasajeros()
                + " | Anio: " + vehiculoAMostrar.getAnioFabricacion());
    }
}