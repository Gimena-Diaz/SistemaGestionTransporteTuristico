package transporte;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class VanEjecutiva extends Vehiculo {

    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super (patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

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