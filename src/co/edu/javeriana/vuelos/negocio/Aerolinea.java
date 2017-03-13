package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.util.*;

public class Aerolinea {

	private long codigo;
	private String nombre;
	private String cuentaBanco;
	private ArrayList<VueloPlaneado> vuelosPlaneados = new ArrayList<VueloPlaneado>();
	

	public Aerolinea(long codigo, String nombre, String cuentaBanco) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuentaBanco = cuentaBanco;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuentaBanco() {
		return cuentaBanco;
	}
	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}
	public ArrayList<VueloPlaneado> getVuelosPlaneados() {
		return vuelosPlaneados;
	}
	public void setVuelosPlaneados(ArrayList<VueloPlaneado> vuelosPlaneados) {
		this.vuelosPlaneados = vuelosPlaneados;
	}
	
	@Override
	public String toString() {
		String cod=String.valueOf(codigo);
		return String.format("%s     %s",cod,nombre);
	}
	
	public String reporteVuelosPlaneados(int indexvueloplaneado){
			return vuelosPlaneados.get(indexvueloplaneado).toString();
	}

	public int buscarVueloPlaneadoId(long codigoVP){ 
		for (int i=0 ; i< vuelosPlaneados.size();i++){
			if(vuelosPlaneados.get(i).getCodigo() == codigoVP){
				return vuelosPlaneados.indexOf(vuelosPlaneados.get(i));
			}
		}
		return -1;
	}
	
	public void agregarVueloPlaneado(VueloPlaneado vueloPlaneado){
		this.vuelosPlaneados.add(vueloPlaneado);
	}
	public ArrayList<VueloPlaneado> buscarVueloEspecificoRequerimiento( long codOrigen, long codDestino, LocalDateTime fechaSalida){
		ArrayList<VueloPlaneado> VP = new ArrayList<VueloPlaneado>();
		ArrayList<VueloEspecifico> VE = new ArrayList<VueloEspecifico>();
		int i= 0;
		for(VueloPlaneado vueloPlaneado : vuelosPlaneados){
			if((vueloPlaneado.getOrigen().getCodigo() == codOrigen) && (vueloPlaneado.getDestino().getCodigo() == codDestino)){
					VE = vueloPlaneado.buscarVueloEspecificoRequerimientos(fechaSalida);
					if(VE.size() != 0){
					VP.add(vueloPlaneado);
					VP.get(i).setVuelosEspecificos(VE);
					i++;
					}
			}
			
		}
		return VP;
	}

}
