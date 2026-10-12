package transporte;

public class LanchaTuristica extends Vehiculo {

    private String tipoMotor;

        public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        String motor = tipoMotor.toUpperCase(); 
        if (!motor.equals("NAFTA") && !motor.equals("DIESEL") && !motor.equals("ELECTRICO")) {
            throw new IllegalArgumentException("El tipo de motor debe ser NAFTA, DIESEL o ELECTRICO.");
        }
        this.tipoMotor = motor;
    }
    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getPatente() + " se encuentra realizando un paseo por el rio. ");
        System.out.println("El tipo de motor es: " + tipoMotor);
        
    }

}