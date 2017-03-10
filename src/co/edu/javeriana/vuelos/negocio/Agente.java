package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Agente {

	private long codigo;
	private String nombre;
	private String email;
	private ArrayList<Itinerario> itinerarios= new ArrayList<Itinerario>();
	
	public Agente(long codigo, String nombre, String email) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
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

	@Override
	public String toString() {
		String cod = String.valueOf(codigo);
		return String.format("%s      %s", cod, nombre);
	}
	
	public long crearItinerario(String nomItinerario,Agente agente){
		Itinerario itinerarioaux= new Itinerario (nomItinerario,agente);
		
		itinerarios.add(itinerarioaux);
	
		return itinerarios.get(itinerarios.size()-1).getCodigo();
	}
	
	public int buscarItinerarioId(long codigo){
		int index = -1;
		for(Itinerario itinerario : itinerarios){
			if(itinerario.getCodigo() == codigo){
				return itinerarios.indexOf(itinerario);
			}
			
		}
		return index;
	}
	public void crearPasajero(int indexItinerario,String identificacion,String nombre){
		itinerarios.get(indexItinerario).crearPasajero(identificacion, nombre);
	}
}

