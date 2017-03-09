package co.edu.javeriana.vuelos.negocio;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class VueloEspecifico {

	private static long CONSECUTIVO=0;
	private long codigo;
	private LocalDateTime fecha;
	private String tipoAvion;
	private int capacidad;
	private int cuposLibres;
	private long tarifa;
	private ArrayList<Silla> sillas = new ArrayList<Silla>();
	
	
	public VueloEspecifico(LocalDateTime fecha, String tipoAvion, int capacidad, long tarifa) {
		CONSECUTIVO++;
		this.codigo = CONSECUTIVO;
		this.fecha = fecha;
		this.tipoAvion = tipoAvion;
		this.capacidad = capacidad;
		this.cuposLibres = capacidad;
		this.tarifa = tarifa;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
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
	@Override
	public String toString() {
		String cod=String.valueOf(codigo);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = fecha.format(formato);
		String tarf = String.valueOf(tarifa);
		return String.format("%s      %s      %s      %d      %d     %s",cod,formattedDate,tipoAvion,capacidad,cuposLibres,tarf);
	}
	
	
}
