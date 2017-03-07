package co.edu.javeriana.vuelos.negocio;

import java.time.*;
import java.util.*;
public class VueloEspecifico {

	private static long CONSECUTIVO=0;
	private long codigo;
	private LocalDate fecha;
	private String tipoAvion;
	private int capacidad;
	private int cuposLibres;
	private long tarifa;
	private ArrayList<Silla> sillas;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTipoAvion() {
		return tipoAvion;
	}
	public void setTipoAvion(String tipoAvion) {
		this.tipoAvion = tipoAvion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCuposLibres() {
		return cuposLibres;
	}
	public void setCuposLibres(int cuposLibres) {
		this.cuposLibres = cuposLibres;
	}
	public long getTarifa() {
		return tarifa;
	}
	public void setTarifa(long tarifa) {
		this.tarifa = tarifa;
	}
	public ArrayList<Silla> getSillas() {
		return sillas;
	}
	public void setSillas(ArrayList<Silla> sillas) {
		this.sillas = sillas;
	}
	
}
