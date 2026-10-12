package transporte;


public class ColectivoTuristico extends Vehiculo {
    

    private int cantidadPisos;

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