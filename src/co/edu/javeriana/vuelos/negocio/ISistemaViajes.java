package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public interface ISistemaViajes extends Serializable{
	
	//getters and setters
	List<Aerolinea> getAerolinea();
	void setAereolinea(List<Aerolinea> aereolinea);
	List<Ciudad> getCiudades();
	void setCiudades(List<Ciudad> ciudades);
	List<Agente> getAgentes();
	void setAgentes(List<Agente> agentes);
	
	//metodos Test
	String reporteAerolinea(int i);
	int buscarAerolineaId(long codigo);
	String reporteVuelosPlaneados(int indexaerolinea,int indexvueloplaneado);
	int buscarVueloPlaneadoId(int posAerolinea,long codigoVP);
	long crearVueloEspecifico(int posAerolinea,int posVueloPlaneado,LocalDateTime fecha,String tipoAvion,int capacidad,long tarifaBasica, String impuesto, boolean vueloNacional);
	String reporteAgentes(int index);
	int buscarAgenteId(long codigo);
	long crearItinerario(int posAgente,String nomItinerario);
	List<Aerolinea> buscarVueloEspecificoRequerimiento( long codOrigen, long codDestino, LocalDateTime fechaSalida);
	List<Integer> buscarVueloEspecificoId(long codigoVE);
	boolean VerificarCupoItinerario (int indAgente, int indItinerario);
	long CalcularValorItinerario(int indAgente, int indItinerario);
	void ComprarItinerario(int indAgente,int indItinerario);
	int cantidadPasajeros(int indexAgente,int indexItinerario);
	int cantidadTrayectos(int indexAgente,int indexItinerario);
	String mostrarSillas(int indAgente,int indItinerario,int indTrayecto,int fila);
	void comprarSilla(int indAgente,int indItinerario,int indTrayecto, int indPasajero,String silla);
	String reporteTrayectos (int indAgente, int indItinerario,int indTrayecto);
	void crearPasajero(int posAgente,long codItinerario,String identificacion, String nombre, LocalDateTime fechaNacimiento,boolean viajaSolo);
	void crearPasajero(int posAgente,long codItinerario,String identificacion, String nombre, boolean requiereAsistencia,  LocalDateTime fechaNacimiento);

	
	//metodos ManejoArchivo
	void crearCiudad(long codigo,String nombre);
	void crearAgente(long codigo, String nombre, String email);
	void crearAerolinea(long codigo, String nombre, String cuentaBanco);
	void crearVueloPlaneado(long codigo, String numeroVuelo, String diaSemana, String horaSalida, String horaLlegada,long origen, long destino,int indexAerolinea);
	int buscarCiudadNombre(String nombre);
	List<VueloEspecifico> vuelosEntreCiudades(ISistemaViajes sistema, int indexOrigen, int indexDestino);
	
}
