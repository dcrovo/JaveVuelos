package co.edu.javeriana.vuelos.negocio;

import java.util.*;

public class Aerolinea {

	private long codigo;
	private String nombre;
	private String cuentaBanco;
	private ArrayList<VueloPlaneado> vuelosPlaneados;
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
}
