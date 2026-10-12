package transporte;

import java.util.*;

public class ComparadorPorCapacidad implements Comparator<Vehiculo>{

    public int compare(Vehiculo v1, Vehiculo v2) {
        return Integer.compare(v2.getCapacidadPasajeros(), v1.getCapacidadPasajeros());
    }

}