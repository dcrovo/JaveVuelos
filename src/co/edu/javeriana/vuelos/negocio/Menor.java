package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menor extends Pasajero{
	
	private boolean viajaSolo;
	
	public Menor(String identificacion, String nombre, LocalDateTime fechaNacimiento, boolean viajaSolo) {
		super(identificacion,nombre, fechaNacimiento);
		this.setViajaSolo(viajaSolo);
	}
	public Menor(String identificacion, String nombre, LocalDateTime fechaNacimiento) {
		super(identificacion,nombre, fechaNacimiento);
		
	}
	
	@Override 
	public long calcularValorItinerario (){
		return 50;
	}

	public boolean isViajaSolo() {
		return viajaSolo;
	}

	public void setViajaSolo(boolean viajaSolo) {
		this.viajaSolo = viajaSolo;
	}
	public String toString (){
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String fecha = super.fechaNacimiento.format(formato);
		String opcion="NO";
		if(viajaSolo==true){
			opcion ="SI";
		}
		else opcion ="NO";
		long valor = calcularValorItinerario();
		return String.format("%s     %s               %s           --          %s     %l", super.identificacion, super.nombre,fecha,opcion,valor);
	}
}
