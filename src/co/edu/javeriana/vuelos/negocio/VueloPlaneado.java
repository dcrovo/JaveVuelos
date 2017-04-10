package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.util.*;
public class VueloPlaneado {
	
	private long codigo;
	private String numeroVuelo;
	private String diaSemana;
	private String horaSalida;
	private String horaLlegada;
	private List<VueloEspecifico> vuelosEspecificos = new ArrayList<VueloEspecifico>();
	private Ciudad destino;
	private Ciudad origen;
	private Aerolinea aerolinea;
	
	
	public VueloPlaneado(long codigo, String numeroVuelo, String diaSemana, String horaSalida, String horaLlegada,
			 Ciudad destino, Ciudad origen,Aerolinea aerolinea) {
		
		this.codigo = codigo;
		this.numeroVuelo = numeroVuelo;
		this.diaSemana = diaSemana;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.destino = destino;
		this.origen = origen;
		this.aerolinea = aerolinea;
	
	}
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public List<VueloEspecifico> getVuelosEspecificos() {
		return vuelosEspecificos;
	}
	public void setVuelosEspecificos(List<VueloEspecifico> vuelosEspecificos) {
		this.vuelosEspecificos = vuelosEspecificos;
	}
	public Ciudad getDestino() {
		return destino;
	}
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	public Ciudad getOrigen() {
		return origen;
	}
	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}


	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}


	@Override
	public String toString() {
		String cod=String.valueOf(codigo);
		return String.format("%s      %s      %s      %s      %s      %s       %s",cod, numeroVuelo,diaSemana, horaSalida, horaLlegada,origen.getNombre(), destino.getNombre());
	}
	
	public String toString2(String fechaVE) {
		return String.format("%s      %s      %s      %s      %s", numeroVuelo,diaSemana, horaSalida, horaLlegada,fechaVE);
	}
	
	/**
	 * Metodo modificado para crear vuelos especificos nacionales o internacionales
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifa es la tarifa Basica
	 * @param vueloPlaneado
	 * @param impuestoSalida si es nacional es cero si es internacional esta dado en dolares
	 * @param opcion 1 para nacional 2 para internacional en otro caso se retorna -1
	 * @return 
	 */
	public long crearVueloEspecifico(LocalDateTime fecha,String tipoAvion,int capacidad,long tarifa,VueloPlaneado vueloPlaneado, String impuesto, boolean vueloNacional){
		if(vueloNacional==true){ //nacional
			VueloEspecifico vueloespecificoaux = new VueloEspecificoNacional(fecha,tipoAvion,capacidad,tarifa,vueloPlaneado,impuesto);
			vuelosEspecificos.add(vueloespecificoaux);
			return vuelosEspecificos.get(vuelosEspecificos.size()-1).getCodigo();
		}
		else{ //internacional
			VueloEspecifico vueloespecificoaux = new VueloEspecificoInternacional(fecha,tipoAvion,capacidad,tarifa,vueloPlaneado,impuesto);
			vuelosEspecificos.add(vueloespecificoaux);
			return vuelosEspecificos.get(vuelosEspecificos.size()-1).getCodigo();
		}	
	}
	
	public List<VueloEspecifico> buscarVueloEspecificoRequerimientos(LocalDateTime fecha){
		
	List<VueloEspecifico> VE = new ArrayList<VueloEspecifico>();
		for(VueloEspecifico vueloEspecifico : vuelosEspecificos){
			
		
			if(vuelosEspecificos.get(vuelosEspecificos.indexOf(vueloEspecifico)).getFecha().equals(fecha)){
				
			VE.add(vueloEspecifico);	
			}
		}

	return VE;
	}
	
}
