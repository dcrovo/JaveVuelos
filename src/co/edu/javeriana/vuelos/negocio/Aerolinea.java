package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.util.*;
/**
 * Clase aerolinea del proyecto JaveVuelos, el sistema tiene varias aerolineas que se instancian a partir del archivo "Aerolineas" con ayuda del manejador de archivos
 * @author Viviana Leyva
 * @author Daniel Crovo
 *
 */
public class Aerolinea {
	/**
	 * Atributos de una aerolinea
	 */
	private long codigo;
	private String nombre;
	private String cuentaBanco;
	private List<VueloPlaneado> vuelosPlaneados = new ArrayList<VueloPlaneado>();
	
	/**
	 * Constructor: para instanciar una aerolinea no es necesario conocer sus vuelos planeados
	 * @param codigo
	 * @param nombre
	 * @param cuentaBanco
	 */
	public Aerolinea(long codigo, String nombre, String cuentaBanco) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuentaBanco = cuentaBanco;
	}
	
	/**
	 * Getters y setters de los atributos de aerolinea
	 * @return
	 */
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
	public List<VueloPlaneado> getVuelosPlaneados() {
		return vuelosPlaneados;
	}
	public void setVuelosPlaneados(List<VueloPlaneado> vuelosPlaneados) {
		this.vuelosPlaneados = vuelosPlaneados;
	}
	
	@Override
	public String toString() {
		String cod=String.valueOf(codigo);
		return String.format("%s     %s",cod,nombre);
	}
	
	/**
	 * Metodo para generar el reporte de un vuelo planeado de una aerolinea
	 * @param indexvueloplaneado
	 * @return Informacion del vuelo planeado concatenada en un String
	 */
	public String reporteVuelosPlaneados(int indexvueloplaneado){
			return vuelosPlaneados.get(indexvueloplaneado).toString();
	}

	/**
	 * Metodo para buscar el indice de un vuelo planeado especifico a partir de su codigo
	 * @param codigoVP
	 * @return indice del vuelo planeado buscado
	 */
	public int buscarVueloPlaneadoId(long codigoVP){ 
		for (int i=0 ; i< vuelosPlaneados.size();i++){
			if(vuelosPlaneados.get(i).getCodigo() == codigoVP){
				return vuelosPlaneados.indexOf(vuelosPlaneados.get(i));
			}
		}
		return -1;
	}
	
	/**
	 * Metodo para agregar a la lista de vuelos planeados de una aerolinea un vuelo planeado
	 * @param vueloPlaneado
	 */
	public void agregarVueloPlaneado(VueloPlaneado vueloPlaneado){
		this.vuelosPlaneados.add(vueloPlaneado);
	}
	
	/**
	 * Metodo para buscar los vuelos planeados que cumplen con los requerimientos de ciudad destino y ciudad origen
	 * @param codOrigen codigo de la ciudad origen
	 * @param codDestino codigo de la ciudad destina
	 * @param fechaSalida fecha de salida del vuelo planeado
	 * @return retorna un arreglo de vuelos planeados que cumplen los requerimientos de ciudad destino, origen y fecha de salida
	 */
	public List<VueloPlaneado> buscarVueloEspecificoRequerimiento( long codOrigen, long codDestino, LocalDateTime fechaSalida){
		List<VueloPlaneado> VP = new ArrayList<VueloPlaneado>();
		List<VueloEspecifico> VE = new ArrayList<VueloEspecifico>();
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
