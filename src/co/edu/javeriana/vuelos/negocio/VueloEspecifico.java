package co.edu.javeriana.vuelos.negocio;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * clase VueloEspecifico de JaveVuelos, cada trayecto tiene asociado un vuelo especifico y cada vuelo planeado puede tener asociado varios vuelo especificos
 * @author Viviana Leyva
 *@author daniel
 */
public class VueloEspecifico {

	private static long CONSECUTIVO=0;
	private long codigo;
	private LocalDateTime fecha;
	private String tipoAvion;
	private int capacidad;
	private int cuposLibres;
	private long tarifa;
	private ArrayList<Silla> sillas = new ArrayList<Silla>();
	private ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
	private VueloPlaneado vueloPlaneado;
	
	/**
	 * Constructor: no es necesario indicar el codigo, el sistema lo genera automaticamente. 
	 * No es neceario indicar las sillas ni los trayectos para la creacion de un vuelo especifico
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifa
	 * @param vueloPlaneado
	 */
	public VueloEspecifico(LocalDateTime fecha, String tipoAvion, int capacidad, long tarifa,VueloPlaneado vueloPlaneado) {
		CONSECUTIVO++;
		this.codigo = CONSECUTIVO;
		this.fecha = fecha;
		this.tipoAvion = tipoAvion;
		this.capacidad = capacidad;
		this.cuposLibres = capacidad;
		this.tarifa = tarifa;
		this.vueloPlaneado = vueloPlaneado;
		this.sillas = CrearSillas();
		
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
	public VueloPlaneado getVueloPlaneado() {
		return vueloPlaneado;
	}
	public void setVueloPlaneado(VueloPlaneado vueloPlaneado) {
		this.vueloPlaneado = vueloPlaneado;
	}
	
	public ArrayList<Trayecto> getTrayectos() {
		return trayectos;
	}
	public void setTrayectos(ArrayList<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}
	@Override
	public String toString() {
		String cod=String.valueOf(codigo);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = fecha.format(formato);
		String tarf = String.valueOf(tarifa);
		return String.format("%s      %s      %s      %d      %d     %s",cod,formattedDate,tipoAvion,capacidad,cuposLibres,tarf);
	}
	public String toString2() {
		String numeroVuelo = vueloPlaneado.getNumeroVuelo();
		String diaSemana = vueloPlaneado.getDiaSemana();
		String horaSalida = vueloPlaneado.getHoraSalida();
		String horaLlegada = vueloPlaneado.getHoraLlegada();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = fecha.format(formato);
		return String.format("%s      %s      %s      %s      %s", numeroVuelo,diaSemana, horaSalida, horaLlegada,formattedDate);
	}
	
	
	/**
	 * metodo para la creacion de las 150 sillas posibles a partir de su id
	 * @return el arreglo de sillas para la asociacion al vuelo especifico
	 */
	public ArrayList<Silla> CrearSillas(){
		ArrayList<Silla> sillasaux = new ArrayList<Silla>();
		String ids = "1A 1B 1C 1D 1E 2A 2B 2C 2D 2E 3A 3B 3C 3D 3E "
				   + "4A 4B 4C 4D 4E 5A 5B 5C 5D 5E 6A 6B 6C 6D 6E "
				   + "7A 7B 7C 7D 7E 8A 8B 8C 8D 8E 9A 9B 9C 9D 9E "
				   + "10A 10B 10C 10D 10E 11A 11B 11C 11D 11E 12A 12B 12C 12D 12E "
				   + "13A 13B 13C 13D 13E 14A 14B 14C 14D 14E 15A 15B 15C 15D 15E "
				   + "16A 16B 16C 16D 16E 17A 17B 17C 17D 17E 18A 18B 18C 18D 18E "
				   + "19A 19B 19C 19D 19E 20A 20B 20C 20D 20E 21A 21B 21C 21D 21E "
				   + "22A 22B 22C 22D 22E 23A 23B 23C 23D 23E 24A 24B 24C 24D 24E "
				   + "25A 25B 25C 25D 25E 26A 26B 26C 26D 26E 27A 27B 27C 27D 27E "
				   + "28A 28B 28C 28D 28E 29A 29B 29C 29D 29E 30A 30B 30C 30D 30E ";
		StringTokenizer tokens = new StringTokenizer(ids," ");

		for(int i=0;i<150;i++){
			Silla sillaaux=new Silla(tokens.nextToken().trim());
			sillasaux.add(sillaaux);
		}
		return sillasaux;	
	}
	/**
	 * metodo auxiiar para la visualizacion de las sillas de forma ordenada
	 * @param fila entero de 0 a 10 
	 * @return la concatenacion de los indices y disponibilidad de las sillas
	 */
	public String MostrarFilaSillas(int fila){
		int SillaInicial=fila*15;
		int SillaFinal=SillaInicial+14;
		String resultado="";

		for(int i=SillaInicial;i<SillaFinal;i++){
			resultado=resultado.concat(sillas.get(i).toString());
		}
		return resultado;
	}
	/**
	 * metodo para buscar el indice de una silla a partir de su id
	 * @param silla id de la silla
	 * @return indice de la silla deseada
	 */
	public int buscarSillaId(String silla){
		int index=-1;
		for(int i=0;i<sillas.size();i++){
			if((sillas.get(i).getId()).equals(silla)){
				index=sillas.indexOf(sillas.get(i));
				return index;
			}
		}
		return index;
	}
	/**
	 * metodo para cambiar el estado de una silla asociada al vuelo especifico
	 * @param indSilla indice de la silla deseada
	 */
	public void comprarSilla(int indSilla){
		sillas.get(indSilla).setComprada(true);
	}
	/**
	 * metodo para asociar un trayecto al vuelo especifico
	 * @param trayecto
	 */
	public void agregarTrayecto(Trayecto trayecto) {
		trayectos.add(trayecto);
	}
	

}
