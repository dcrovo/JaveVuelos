package co.edu.javeriana.vuelos.negocio;


import java.util.*;
import java.time.*;
/**
 * Clase agente del proyecto JaveVuelos, el sistema tiene varios agentes que se instancian a partir del archivo "Agentes" con ayuda del manejador de archivos
 * @author Viviana Leyva
 * @author daniel 
 */
public class Agente {

	/**
	 * Atributos de un agente
	 */
	private long codigo;
	private String nombre;
	private String email;
	private List<Itinerario> itinerarios= new ArrayList<Itinerario>();
	
	
	/**
	 * Constructor: No necesita conocer los itinerarios para instanciar una agencia
	 * @param codigo 
	 * @param nombre
	 * @param email
	 */
	public Agente(long codigo, String nombre, String email) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
	}
	
	/**
	 * 
	 * Getters y Setters de los atributos de agente
	 * @return
	 */
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
	public List<Itinerario> getItinerarios() {
		return itinerarios;
	}
	public void setItinerarios(List<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
	}

	@Override
	public String toString() {
		String cod = String.valueOf(codigo);
		
		return String.format("%s      %s		%s", cod, nombre,email);
	}
	
	
	/**
	 * Metodo para la instanciacion y asociacion de un itinerario con un agente 
	 * @param nomItinerario nombre del itinerario 
	 * @param agente Agente al que se asociara el itinerario
	 * @return Retorna el codigo con el que quedo registrado el itinerario en el sistema de forma automatica
	 */
	public long crearItinerario(String nomItinerario,Agente agente){
		Itinerario itinerarioaux= new Itinerario (nomItinerario,agente);
		
		itinerarios.add(itinerarioaux);
	
		return itinerarios.get(itinerarios.size()-1).getCodigo();
	}
	/**
	 * Metodo para buscar el indice de un itinerario especifico a partir de su codigo
	 * @param codigo codigo del itinerario a buscar
	 * @return indice del itinerario deseado
	 */
	public int buscarItinerarioId(long codigo){
		int index = -1;
		for(Itinerario itinerario : itinerarios){
			if(itinerario.getCodigo() == codigo){
				return itinerarios.indexOf(itinerario);
			}
			
		}
		return index;
	}
	/**
	 * Metodo intermedio para crear un pasajero
	 * @param indexItinerario indice del itinerario asociado al pasajero
	 * @param identificacion numero de identificacion del nuevo pasajero 
	 * @param nombre nombre del nuevo pasajero
	 */
	public void crearPasajero(int indexItinerario,String identificacion,String nombre, boolean viajaSolo, LocalDateTime fechaNacimiento){
		itinerarios.get(indexItinerario).crearPasajero(identificacion, nombre,viajaSolo, fechaNacimiento);
	}
	public void crearPasajero(int indexItinerario,String identificacion,String nombre, LocalDateTime fechaNacimiento, boolean requiereAsistencia){
		itinerarios.get(indexItinerario).crearPasajero(identificacion, nombre,requiereAsistencia,fechaNacimiento);
	}
	
	/**
	 * metodo intermedio para la creacion de un trayecto asociado a un itinerario de un agente
	 * @param indexItinerario 
	 * @param vueloEspecifico
	 * @param itinerario
	 */
	public void crearTrayecto(int indexItinerario, VueloEspecifico vueloEspecifico, Itinerario itinerario){
	 itinerarios.get(indexItinerario).crearTrayecto(vueloEspecifico, itinerario);
	}
	
	/**
	 * Metodo para verificacion de disponibilidad de cupo en un itinerario
	 * @param indItinerario indice del itinerario deseado
	 * @return si o no dependiendo de la disponibilidad
	 */
	public boolean VerificarCupoItinerario (int indItinerario){
		return itinerarios.get(indItinerario).VerificarCupoItinerario();
	}
	
	/**
	 * metodo intermedio para el calculo del costo de un itinerario existente asociado a un agente
	 * @param indItinerario
	 * @return
	 */
	public long CalcularValorItinerario(int indItinerario){
		return itinerarios.get(indItinerario).CalcularValorItinerario();
	}
	
	/**
	 * metodo para el cambio del indicador de compra de un itinerario 
	 * @param indItinerario
	 */
	public void ComprarItinerario(int indItinerario){
		itinerarios.get(indItinerario).setComprado(true);
	}
	
	/**
	 * metodo para buscar el indice de una silla a partir del id de una silla
	 * @param indItinerario indice del itinerario asociado al trayecto que contiene la silla buscada
	 * @param indTrayecto indice del trayecto que contiene la silla buscada
	 * @param silla id de la silla buscada
	 * @return indice de la silla deseada
	 */
	public int buscarSillaId(int indItinerario,int indTrayecto,String silla){
		return itinerarios.get(indItinerario).buscarSillaId(indTrayecto, silla);
	}
	
	/**
	 * metodo para comprar una silla, se cambia el estado de la silla a comprado, se asocia a un trayecto y un pasajero y se disminuye la capacidad de un vuelo especifico
	 * @param indItinerario indice del itinerario donde esta la silla
	 * @param indTrayecto indice del trayecto donde esta la silla
	 * @param indPasajero indice del pasajero que compro la silla 
	 * @param indSilla indice de la silla deseada
	 */
	public void comprarSilla(int indItinerario,int indTrayecto,int indPasajero,int indSilla){
		List<Silla>Sillas = itinerarios.get(indItinerario).getTrayectos().get(indTrayecto).getVueloespecifico().getSillas();
		itinerarios.get(indItinerario).comprarSilla(indTrayecto,indPasajero, indSilla);
		itinerarios.get(indItinerario).getPasajeros().get(indPasajero).agregarSilla(Sillas,indSilla);
		itinerarios.get(indItinerario).getTrayectos().get(indTrayecto).agregarSilla(indSilla);
		itinerarios.get(indItinerario).getTrayectos().get(indTrayecto).disminuirCuposVueloEspecifico();
	}
	/**
	 * metodo auxiliar para la generacion del reporte de un itinerario 
	 * @param index indice del itinerario deseado
	 * @return la concatenacion de la informacion del itinerario
	 */
	public String reporteItinerarios(int index){
		return itinerarios.get(index).toString();
	}
}


