package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Pasajero {

	private String identificacion;
	private String nombre;
	private ArrayList<Silla> sillas= new ArrayList<Silla>(); //preguntar!
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
	
}
