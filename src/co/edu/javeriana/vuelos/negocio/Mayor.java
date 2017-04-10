package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.time.format.*;

public class Mayor extends Pasajero{
	
	private boolean requiereAsistencia;
	
	
	public Mayor(String identificacion, String nombre, LocalDateTime fechaNacimiento, boolean requiereAsistencia) {
		super(identificacion,nombre,fechaNacimiento);	
		this.setRequiereAsistencia(requiereAsistencia);
	}
	
	@Override
	public long calcularValorItinerario (){
		return 100;
	}

	public boolean isRequiereAsistencia() {
		return requiereAsistencia;
	}

	public void setRequiereAsistencia(boolean requiereAsistencia) {
		this.requiereAsistencia = requiereAsistencia;
	}
	public String toString (){
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String fecha = super.fechaNacimiento.format(formato);
		String opcion="NO";
		if(requiereAsistencia==true){
			opcion ="SI";
		}
		else opcion ="NO";
		long valor = calcularValorItinerario();
		return String.format("%s     %s               %s           %s          --     %l", super.identificacion, super.nombre,fecha,opcion,valor);
	}
	
}
