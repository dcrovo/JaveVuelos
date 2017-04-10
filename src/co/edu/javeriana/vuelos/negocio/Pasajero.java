package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Clase pasajero de JaveVuelos, cada itinerario tiene asociada una lista de pasajeros de longitud desconocida
 * @author Viviana Leyva
 *@author daniel
 */
public abstract class Pasajero {

	/**
	 * atributos de pasajero
	 */
	protected String identificacion;
	protected String nombre;
	protected LocalDateTime fechaNacimiento;
	private List<Silla> sillas= new ArrayList<Silla>(); //preguntar!
	
	/**
	 * constructor: para instanciar un pasajero no es necesario asoaciarle sillas desde el comienzo
	 * @param identificacion
	 * @param nombre
	 */
	public Pasajero(String identificacion, String nombre, LocalDateTime fechaNacimiento) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
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
	public List<Silla> getSillas() {
		return sillas;
	}
	public void setSillas(List<Silla> sillas) {
		this.sillas = sillas;
	}
	
	/**
	 * metodo para agregar una silla a la lista de sillas asociadas a pasajero
	 * @param indSilla
	 */
	public void agregarSilla(List<Silla> auxSillas, int indSilla){
		sillas.add(auxSillas.get(indSilla));
	}
	
	/**
	 * Metodo abstracto que permite calcular sobre cada sub clase de pasajero el valor del itinerario de acuerdo a si es mayor o menor
	 * @return retorna el valor del itinerario de acuerdo a la definicion en cada sub clase
	 */
	public abstract long calcularValorItinerario ();
	public abstract String toString();
	
}
