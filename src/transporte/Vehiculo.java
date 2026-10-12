package transporte;
import java.time.LocalDate;

public abstract class Vehiculo implements Comparable<Vehiculo> {

    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

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

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public abstract void realizarServicio();

    @Override
    public int compareTo(Vehiculo vehiculo2) {
        return Integer.compare(vehiculo2.getAnioFabricacion(), this.getAnioFabricacion());
    }

}