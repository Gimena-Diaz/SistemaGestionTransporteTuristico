package transporte;
import java.time.LocalDate;

/**
 * Clase abstracta que representa un vehiculo turistico.
 * Guarda los datos comunes a todos los vehiculos.
 * Implementa Comparable para ordenarlos por anio de fabricacion.
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {

    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    /**
     * Que hace: crea un vehiculo y valida patente, capacidad y anio.
     *
     * Parametros:
     *   patente: 6 o 7 caracteres, no vacia
     *   marca: marca del vehiculo
     *   capacidadPasajeros: mayor a cero
     *   anioFabricacion: entre 1990 y el anio actual
     *
     * Retorna: nada (constructor).
     */
    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        if (patente == null || patente.isBlank()) {
            throw new IllegalArgumentException("La patente del vehiculo no puede estar vacia.");
        }
        if (patente.length() < 6 || patente.length() > 7) {
            throw new IllegalArgumentException("La patente debe tener entre 6 o 7 caracteres.");
        }
        if (capacidadPasajeros <= 0) {
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a cero.");
        }
        int anioActual = LocalDate.now().getYear();
        if (anioFabricacion < 1990 || anioFabricacion > anioActual) {
            throw new IllegalArgumentException("El anio debe estar entre 1990 y " + anioActual + ".");
        }

        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * Que hace: devuelve la patente.
     *
     * Parametros: ninguno.
     *
     * Retorna: la patente (String).
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Que hace: devuelve la marca.
     *
     * Parametros: ninguno.
     *
     * Retorna: la marca (String).
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Que hace: devuelve la capacidad de pasajeros.
     *
     * Parametros: ninguno.
     *
     * Retorna: la capacidad (int).
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Que hace: devuelve el anio de fabricacion.
     *
     * Parametros: ninguno.
     *
     * Retorna: el anio (int).
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Que hace: muestra el servicio del vehiculo. Cada clase hija
     *           lo implementa a su manera (polimorfismo).
     *
     * Parametros: ninguno.
     *
     * Retorna: nada.
     */
    public abstract void realizarServicio();

    /**
     * Que hace: compara por anio, del mas nuevo al mas viejo.
     *           Lo usa Collections.sort.
     *
     * Parametros:
     *   vehiculo2: el vehiculo con el que se compara
     *
     * Retorna: negativo, 0 o positivo segun cual va primero.
     */
    @Override
    public int compareTo(Vehiculo vehiculo2) {
        return Integer.compare(vehiculo2.getAnioFabricacion(), this.getAnioFabricacion());
    }

}