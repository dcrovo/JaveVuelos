package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Itinerario {

	private static long CONSECUTIVO = 0;
	private long codigo;
	private String nombre;
	private boolean comprado;
	private Agente agente;
	private ArrayList<Trayecto> trayectos= new ArrayList<Trayecto>();
	private ArrayList<Pasajero> pasajeros= new ArrayList<Pasajero>();
	
	public Itinerario(String nombre, Agente agente) {
		CONSECUTIVO++;
		this.codigo = CONSECUTIVO;
		this.nombre = nombre;
		this.comprado = true;;
		this.agente = agente;
	}
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
	public void crearPasajero(String identificacion,String nombre){
		Pasajero pasajeroaux= new Pasajero (identificacion,nombre);
		pasajeros.add(pasajeroaux);
	}
	@Override
	public String toString() {
		return String.format("%-3d %-15s %-5b", codigo,nombre,comprado);
	}
	public void crearTrayecto(VueloEspecifico vueloEspecifico, Itinerario itinerario){
		Trayecto trayecto = new Trayecto(vueloEspecifico, itinerario);
		trayectos.add(trayecto);
	}
	
	
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
	
	public long CalcularValorItinerario(){
		long costo=0;
		for (int i=0;i<trayectos.size();i++){
			costo=costo+((trayectos.get(i).ValorTrayecto())*(pasajeros.size()));
		}
		return costo;
	}
	
	public int cantidadTrayectos(){
		return trayectos.size();
	}
	
	public int buscarSillaId(int indTrayecto,String silla){
		return trayectos.get(indTrayecto).buscarSillaId(silla);
	}
	
	public void comprarSilla(int indTrayecto,int indPasajero,int indSilla){
		trayectos.get(indTrayecto).comprarSilla(indSilla);
	}
	public String reporteTrayectos(int index){
		return trayectos.get(index).toString();
	}
}
