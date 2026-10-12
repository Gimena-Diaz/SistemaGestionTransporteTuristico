package transporte;

/**
 * Clase que representa una lancha turistica.
 * Hereda de Vehiculo y agrega el tipo de motor (NAFTA, DIESEL o ELECTRICO).
 */
public class LanchaTuristica extends Vehiculo {

    private String tipoMotor;

    /**
     * Que hace: crea una lancha y valida que el motor sea NAFTA, DIESEL o ELECTRICO.
     *
     * Parametros:
     *   patente, marca, capacidadPasajeros, anioFabricacion: datos del vehiculo
     *   tipoMotor: NAFTA, DIESEL o ELECTRICO
     *
     * Retorna: nada (constructor).
     */
    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        String motor = tipoMotor.toUpperCase();
        if (!motor.equals("NAFTA") && !motor.equals("DIESEL") && !motor.equals("ELECTRICO")) {
            throw new IllegalArgumentException("El tipo de motor debe ser NAFTA, DIESEL o ELECTRICO.");
        }
        this.tipoMotor = motor;
    }

    /**
     * Que hace: muestra el paseo de la lancha y su tipo de motor.
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getPatente() + " se encuentra realizando un paseo por el rio.");
        System.out.println("El tipo de motor es: " + tipoMotor);
    }
}