package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Agente {

	private long codigo;
	private String nombre;
	private String email;
	private ArrayList<Itinerario> itinerarios= new          ArrayList<Itinerario>();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Itinerario> getItinerarios() {
		return itinerarios;
	}
	public void setItinerarios(ArrayList<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
	}
	
}