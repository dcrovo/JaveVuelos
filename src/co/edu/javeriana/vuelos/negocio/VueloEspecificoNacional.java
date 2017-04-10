package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**Subclase Vuelo Especifico Nacional
 * 
 * @author daniel
 *
 */
public class VueloEspecificoNacional extends VueloEspecifico{
	
	private final int iva;
	/**
	 * 
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifaBasica
	 * @param vueloPlaneado
	 * @param impuesto
	 */
	public VueloEspecificoNacional (LocalDateTime fecha, String tipoAvion, int capacidad, long tarifaBasica,VueloPlaneado vueloPlaneado, String impuesto){
		super (fecha, tipoAvion, capacidad, tarifaBasica, vueloPlaneado);
		this.iva=Integer.parseInt(impuesto);
	}
	

	public int getIva() {
		return iva;
	}

	
	public long calcularValorPasaje(){
		long valorPasaje=super.getTarifaBasica();
		int mes = super.getFecha().getMonthValue();
		if((mes==6) || (mes==12)){
			
			valorPasaje = (long) (valorPasaje*1.2);
			return ((valorPasaje*iva)/100) + valorPasaje;

		}else{
	
		return ((valorPasaje*iva)/100) + valorPasaje;

		}
	}
	
	public String toString3() {
		String cod=String.valueOf(super.codigo);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = super.fecha.format(formato);
		String tarf = String.valueOf(super.tarifaBasica);
		return String.format("%s      %s      %s         %d          %d              %s          %d",cod,formattedDate,tipoAvion,capacidad,cuposLibres,tarf,iva);
	}
}
