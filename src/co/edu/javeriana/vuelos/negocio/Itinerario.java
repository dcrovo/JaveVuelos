package co.edu.javeriana.vuelos.negocio;

import java.util.*;
import co.edu.javeriana.vuelos.presentacion.*;
import java.time.*;

/**
 * Clase Itinerario de JaveVuelos, cada agente tiene una cierta cantidad de itinerarios desconocida
 * @author Viviana Leyva
 *@author daniel
 */
public class Itinerario {

	/**
	 * atributos de la clase Itinerario
	 */
	private static long CONSECUTIVO = 0;
	private long codigo;
	private String nombre;
	private boolean comprado;
	private Agente agente;
	private List<Trayecto> trayectos= new ArrayList<Trayecto>();
	private List<Pasajero> pasajeros= new ArrayList<Pasajero>();
	
	/**
	 * Constructor: Para instanciar un itinerario solo es necesario el nombre y el agente asociado al itinerario
	 * @param nombre nombre del nuevo itinerario
	 * @param agente Agente asociado al itinerario
	 */
	public Itinerario(String nombre, Agente agente) {
		/**
		 * el codigo se genera a partir del consecutivo de manera automatica
		 */
		CONSECUTIVO++;
		this.codigo = CONSECUTIVO;
		this.nombre = nombre;
		this.comprado = true;;
		this.agente = agente;
	}
	
	/**
	 * Getters y Setters de los atributos de Itinerario
	 * @return
	 */
	public long getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isComprado() {
		return comprado;
	}
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	public Agente getAgente() {
		return agente;
	}
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	public List<Trayecto> getTrayectos() {
		return trayectos;
	}
	public void setTrayectos(List<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	
	/**
	 * Metodo para instanciar un pasajero asociado al itinerario
	 * @param identificacion numero de identificacion del pasajero
	 * @param nombre nombre del nuevo pasajero
	 */
	public void crearPasajero(String identificacion,String nombre,boolean viajaSolo, LocalDateTime fechaNacimiento){
		
		Pasajero pasajeroaux= new Menor (identificacion,nombre, fechaNacimiento, viajaSolo);
		pasajeros.add(pasajeroaux);
	
		
	}
	public void crearPasajero(String identificacion,String nombre,LocalDateTime fechaNacimiento, boolean requiereAsistencia){
		
		Pasajero pasajeroaux= new Mayor (identificacion,nombre,fechaNacimiento, requiereAsistencia);
		pasajeros.add(pasajeroaux);
	
		
	}
	
	
	@Override
	public String toString() {
		String compra = "C";
		if(comprado == true){
			compra="Comprado";
		}
		else 
			compra="Disponible";
		return String.format("%-3d      %-15s                 %-15s", codigo,nombre,compra);
	}
	
	public String toString2(){
		int numPas = pasajeros.size();
		String compra = "C";
		if(comprado == true){
			compra="Comprado";
		}
		else 
			compra="Disponible";
		return String.format("%d    %s            %s       %s", codigo, nombre, numPas,compra);
	}
	
	/**
	 * Metodo para instanciacion de un nuevo trayecto 
	 * @param vueloEspecifico vuelo especifico asociado al trayecto
	 * @param itinerario itinerario al cual se asociara el trayecto 
	 */
	public void crearTrayecto(VueloEspecifico vueloEspecifico, Itinerario itinerario){
		Trayecto trayecto = new Trayecto(vueloEspecifico, itinerario);
		trayectos.add(trayecto);
	}
	
	/**
	 * Metodo para verificacion de disponibilidad de cupo en los vuelos especificos asociados a un itinerario especifico
	 * @return si o no hay cupo
	 */
	public boolean VerificarCupoItinerario(){
		boolean hayCupo=false;
		for (int i=0;i<trayectos.size();i++){
			if(trayectos.get(i).getVueloespecifico().getCapacidad()>=pasajeros.size()){
				continue;
			}
			else{
				return hayCupo;
			}
		}
		hayCupo=true;
		return hayCupo;
	}
	
	/**
	 * Metodo para calcular el costo de un itinerario de acuerdo a valor de un trayecto y la cantidad de pasajeros asociados l itinerario
	 * @return
	 */
	public long CalcularValorItinerario(){
		long costo=0;
		for (int i=0;i<trayectos.size();i++){
			costo=costo+((trayectos.get(i).ValorTrayecto())*(pasajeros.size()));
		}
		return costo;
	}
	public long CalcularValorItinerarioPasajero(){
		long costo=0;
		for (int i=0;i<trayectos.size();i++){
			costo=costo+((trayectos.get(i).ValorTrayecto()));
		}
		return costo;
	}
	
	
	/**
	 * metodo para conocer la cantidad de trayectos existentes en un itinerario
	 * @return cantidad de trayectos
	 */
	public int cantidadTrayectos(){
		return trayectos.size();
	}
	
	/**
	 * metodo para encontrar el indice de una silla a partir del id de una silla
	 * @param indTrayecto indice del trayecto que tiene asociado la silla
	 * @param silla id de la silla
	 * @return indice de la silla deseada
	 */
	public int buscarSillaId(int indTrayecto,String silla){
		return trayectos.get(indTrayecto).buscarSillaId(silla);
	}
	
	/**
	 * Metodo para comprar una silla, cambiar su estado de compra a true
	 * @param indTrayecto indice del trayecto asociado a la silla
	 * @param indPasajero indice del pasajero asociado a la silla
	 * @param indSilla indice de la silla deseada
	 */
	public void comprarSilla(int indTrayecto,int indPasajero,int indSilla){
		trayectos.get(indTrayecto).comprarSilla(indSilla);
	}
	
	/**
	 * 
	 * Metodo para el reporte de un trayecto en especifico
	 * @param index indice del trayecto deseado
	 * @return informacion concatenada del trayecto
	 */
	public String reporteTrayectos(int index){
		return trayectos.get(index).toString();
	}
}
