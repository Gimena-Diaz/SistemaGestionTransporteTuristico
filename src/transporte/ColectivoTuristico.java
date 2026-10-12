package transporte;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class ColectivoTuristico extends Vehiculo {
    

    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super (patente, marca, capacidadPasajeros, anioFabricacion); //paso datos al constructor
        this.cantidadPisos = cantidadPisos;
        
    }
    @Override
    public void realizarServicio() {
        System.out.println("El colectivo turistico " + getPatente() + " realiza su recorrido turistico en " + cantidadPisos + " piso/s");
    }

}