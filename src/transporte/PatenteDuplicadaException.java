package transporte;

/**
 * Excepcion propia que se lanza cuando se quiere agregar
 * un vehiculo con una patente que ya existe.
 */
public class PatenteDuplicadaException extends Exception {

    /**
     * Que hace: crea la excepcion con el mensaje de error.
     *
     * Parametros:
     *   mensaje: el texto que se muestra al usuario
     *
     * Retorna: nada (constructor).
     */
    public PatenteDuplicadaException(String mensaje) {
        super(mensaje);
    }
}