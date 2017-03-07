package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class VueloPlaneado {
	
	private long codigo;
	private String numeroVuelo;
	private String diaSemana;
	private String horaSalida;
	private String horaLlegada;
	private ArrayList<VueloEspecifico> vuelosEspecificos;
	private Ciudad destino;
	private Ciudad origen;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public ArrayList<VueloEspecifico> getVuelosEspecificos() {
		return vuelosEspecificos;
	}
	public void setVuelosEspecificos(ArrayList<VueloEspecifico> vuelosEspecificos) {
		this.vuelosEspecificos = vuelosEspecificos;
	}
	public Ciudad getDestino() {
		return destino;
	}
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	public Ciudad getOrigen() {
		return origen;
	}
	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}
}
