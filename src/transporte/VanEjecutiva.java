package transporte;

/**
 * Clase que representa una van ejecutiva.
 * Hereda de Vehiculo y agrega si tiene aire acondicionado.
 */
public class VanEjecutiva extends Vehiculo {

    private boolean aireAcondicionado;

    /**
     * Que hace: crea una van ejecutiva.
     *
     * Parametros:
     *   patente, marca, capacidadPasajeros, anioFabricacion: datos del vehiculo
     *   aireAcondicionado: true si tiene aire, false si no
     *
     * Retorna: nada (constructor).
     */
    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super (patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    /**
     * Que hace: muestra el traslado de la van y si tiene aire acondicionado.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    @Override
    public void realizarServicio() {
        if (aireAcondicionado) {
            System.out.println("La van ejecutiva " + getPatente() + " realiza un traslado ejecutivo.");
            System.out.println("Esta Van TIENE aire acondicionado");
        } else {
            System.out.println("La van ejecutiva " + getPatente() + " realiza un traslado ejecutivo.");
            System.out.println("IMPORTANTE: Esta Van NO TIENE aire acondicionado.");
        }
    }
}