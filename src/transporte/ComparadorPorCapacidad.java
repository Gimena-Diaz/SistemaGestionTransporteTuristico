package transporte;

import java.util.*;

/**
 * Comparador para ordenar vehiculos por capacidad de pasajeros de mayor a
 * menor.
 */
public class ComparadorPorCapacidad implements Comparator<Vehiculo> {

    /**
     * Que hace: compara dos vehiculos por capacidad, de mayor a menor.
     *
     * Parametros: v1, v2: los vehiculos a comparar
     *
     * Retorna: negativo, 0 o positivo segun cual va primero.
     */
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Integer.compare(v2.getCapacidadPasajeros(), v1.getCapacidadPasajeros());
    }

}
