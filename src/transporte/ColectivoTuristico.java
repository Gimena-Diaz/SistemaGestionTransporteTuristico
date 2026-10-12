package transporte;

/**
 * Clase que representa un colectivo turistico. Hereda de Vehiculo y agrega la
 * cantidad de pisos (1 o 2).
 */
public class ColectivoTuristico extends Vehiculo {

    private int cantidadPisos;

    /**
     * Que hace: crea un colectivo y valida que tenga 1 o 2 pisos.
     *
     * Parametros: patente, marca, capacidadPasajeros, anioFabricacion: datos
     * del vehiculo cantidadPisos: 1 o 2
     *
     * Retorna: nada (constructor).
     */
    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        if (cantidadPisos != 1 && cantidadPisos != 2) {
            throw new IllegalArgumentException("La cantidad de pisos debe ser 1 o 2.");
        }
        this.cantidadPisos = cantidadPisos;
    }

    @Override
    public void realizarServicio() {
        System.out.println("El colectivo turistico " + getPatente() + " realiza su recorrido turistico en " + cantidadPisos + " piso/s");
    }

}
