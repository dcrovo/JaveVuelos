package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Itinerario {

	private static long CONSECUTIVO;
	private long codigo;
	private String nombre;
	private boolean comprado;
	private Agente agente;
	private ArrayList<Trayecto> trayectos= new ArrayList<Trayecto>();
	private ArrayList<Pasajero> pasajeros= new ArrayList<Pasajero>();
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
	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}
	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
}
