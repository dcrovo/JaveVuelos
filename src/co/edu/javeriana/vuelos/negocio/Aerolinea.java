package co.edu.javeriana.vuelos.negocio;

import java.util.*;

public class Aerolinea {

	private long codigo;
	private String nombre;
	private String cuentaBanco;
	private ArrayList<VueloPlaneado> vuelosPlaneados = new ArrayList<VueloPlaneado>();
	

	public Aerolinea(long codigo, String nombre, String cuentaBanco, ArrayList<VueloPlaneado> vuelosPlaneados) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuentaBanco = cuentaBanco;
		this.vuelosPlaneados = vuelosPlaneados;
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
}
