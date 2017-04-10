package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VueloEspecificoInternacional extends VueloEspecifico {
	
	private long impuestoSalida;
	
	public VueloEspecificoInternacional (LocalDateTime fecha, String tipoAvion, int capacidad, long tarifaBasica,VueloPlaneado vueloPlaneado, String impuestoSalida){
		super (fecha, tipoAvion, capacidad, tarifaBasica, vueloPlaneado);
		this.impuestoSalida = Long.parseLong(impuestoSalida);
	}
	
	public long calcularValorPasaje(){
		long valorPasaje=super.getTarifaBasica();
		int mes = super.getFecha().getMonthValue();
		if((mes==6) || (mes==12)){
			
			valorPasaje = (long) (valorPasaje*1.2);
			return impuestoSalida + valorPasaje;

		}else{
	
		return impuestoSalida + valorPasaje;

		}
	}
	public String toString3() {
		String cod=String.valueOf(super.codigo);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = super.fecha.format(formato);
		String tarf = String.valueOf(super.tarifaBasica);
		return String.format("%s      %s      %s         %d          %d              %s          %d",cod,formattedDate,tipoAvion,capacidad,cuposLibres,tarf,impuestoSalida);
	}
}
