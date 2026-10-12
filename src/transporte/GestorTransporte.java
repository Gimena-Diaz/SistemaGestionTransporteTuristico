package transporte;

import java.util.*;

public class GestorTransporte {

    private ArrayList<Vehiculo> listaVehiculos;

    public GestorTransporte() {
        listaVehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo nuevoVehiculo) throws PatenteDuplicadaException {
        if (existePatente(nuevoVehiculo.getPatente())) {
            throw new PatenteDuplicadaException("Ya existe un vehiculo con la patente " + nuevoVehiculo.getPatente() + ".");
        }
        listaVehiculos.add(nuevoVehiculo);
    }

    public void mostrarTodos() {
        mostrarLista(listaVehiculos);
    }

    public void realizarServicios() {
        if (listaVehiculos.size() == 0) {
            System.out.println("No hay vehiculos cargados.");
        } else {
            for (Vehiculo vehiculoActual : listaVehiculos) {
                vehiculoActual.realizarServicio();
            }
        }
    }

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

    public void mostrarPorAnioDescendente() {
        Collections.sort(listaVehiculos);
        mostrarLista(listaVehiculos);
    }

    public void mostrarPorCapacidadDescendente() {
        Collections.sort(listaVehiculos, new ComparadorPorCapacidad());
        mostrarLista(listaVehiculos);
    }

    public boolean existePatente(String patente) {
        boolean existe = false;
        for (Vehiculo vehiculoActual : listaVehiculos) {
            if (vehiculoActual.getPatente().equals(patente)) {
                existe = true;
            }
        }
        return existe;
    }

    private void mostrarLista(ArrayList<Vehiculo> lista) {
        if (lista.size() == 0) {
            System.out.println("No hay vehiculos cargados.");
        } else {
            for (Vehiculo vehiculoActual : lista) {
                mostrarVehiculo(vehiculoActual);
            }
        }
    }

    private void mostrarVehiculo(Vehiculo vehiculoAMostrar) {
        System.out.println("Patente: " + vehiculoAMostrar.getPatente()
                + " | Marca: " + vehiculoAMostrar.getMarca()
                + " | Capacidad: " + vehiculoAMostrar.getCapacidadPasajeros()
                + " | Anio: " + vehiculoAMostrar.getAnioFabricacion());
    }
}