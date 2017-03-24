package co.edu.javeriana.vuelos.negocio;

import java.util.*;

/**
 * Clase pasajero de JaveVuelos, cada itinerario tiene asociada una lista de pasajeros de longitud desconocida
 * @author Viviana Leyva
 *@author daniel
 */
public class Pasajero {

	/**
	 * atributos de pasajero
	 */
	private String identificacion;
	private String nombre;
	private ArrayList<Silla> sillas= new ArrayList<Silla>(); //preguntar!
	
	/**
	 * constructor: para instanciar un pasajero no es necesario asoaciarle sillas desde el comienzo
	 * @param identificacion
	 * @param nombre
	 */
	public Pasajero(String identificacion, String nombre) {
		this.identificacion = identificacion;
		this.nombre = nombre;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Silla> getSillas() {
		return sillas;
	}
	public void setSillas(ArrayList<Silla> sillas) {
		this.sillas = sillas;
	}
	
	/**
	 * metodo para agregar una silla a la lista de sillas asociadas a pasajero
	 * @param indSilla
	 */
	public void agregarSilla(ArrayList<Silla> auxSillas, int indSilla){
		sillas.add(auxSillas.get(indSilla));
	}
}
