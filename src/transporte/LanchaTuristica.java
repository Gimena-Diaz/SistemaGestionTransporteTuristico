package transporte;


/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class LanchaTuristica extends Vehiculo {

    private String tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor) {
        super (patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }
    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getPatente() + " se encuentra realizando un paseo por el rio. ");
        System.out.println("El tipo de motor es: " + tipoMotor);
        
    }

}