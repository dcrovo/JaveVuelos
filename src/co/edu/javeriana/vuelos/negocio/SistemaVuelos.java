package co.edu.javeriana.vuelos.negocio;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaVuelos {
	
	ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
	ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	ArrayList<Agente> agentes = new ArrayList<Agente>();
	
	
	public ArrayList<Aerolinea> getAerolinea() {
		return aerolineas;
	}


	public void setAereolinea(ArrayList<Aerolinea> aereolinea) {
		this.aerolineas = aereolinea;
	}


	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}


	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}


	public ArrayList<Agente> getAgentes() {
		return agentes;
	}


	public void setAgentes(ArrayList<Agente> agentes) {
		this.agentes = agentes;
	}


	public void crearCiudad(long codigo,String nombre){
		Ciudad ciudad = new Ciudad(codigo,nombre);
		ciudades.add(ciudad);
	}
	
	public void crearAgente(long codigo, String nombre, String email){
		Agente agente = new Agente(codigo,nombre,email);
		agentes.add(agente);
	}
	public void crearAerolinea(long codigo, String nombre, String cuentaBanco){
		Aerolinea aerolinea = new Aerolinea(codigo,nombre,cuentaBanco);
		aerolineas.add(aerolinea);
	}
	public void crearVueloPlaneado(long codigo, String numeroVuelo, String diaSemana, String horaSalida, String horaLlegada,
			long origen, long destino,int indexAerolinea){
		long codigoAerolinea = aerolineas.get(indexAerolinea).getCodigo();
		Ciudad cOrigen = ciudades.get(buscarCiudadId(origen));
		Ciudad cDestino = ciudades.get(buscarCiudadId(destino));
		VueloPlaneado vueloPlaneado = new VueloPlaneado(codigo,numeroVuelo,diaSemana,horaSalida,horaLlegada,cDestino,cOrigen,codigoAerolinea);
		aerolineas.get(indexAerolinea).getVuelosPlaneados().add(vueloPlaneado);
		
		
	}
	public int buscarCiudadId(long codigo){
		int index = -1;
		for(Ciudad ciudad : ciudades){
			if(ciudad.getCodigo() == codigo){
				return ciudades.indexOf(ciudad);
			}
			
		}
		return index;
	}
	
	public String reporteAerolinea(int i){
		return aerolineas.get(i).toString();
	}
	
	public int buscarAerolineaId(long codigo){
		int index = -1;
		for(Aerolinea aerolinea : aerolineas){
			if(aerolinea.getCodigo() == codigo){
				return aerolineas.indexOf(aerolinea);
			}
			
		}
		return index;
	}
	
	public String reporteVuelosPlaneados(int indexaerolinea,int indexvueloplaneado){
		return aerolineas.get(indexaerolinea).reporteVuelosPlaneados(indexvueloplaneado);
	}
	
	public int buscarVueloPlaneadoId(int posAerolinea,long codigoVP){
		return aerolineas.get(posAerolinea).buscarVueloPlaneadoId(codigoVP);
	}
	
	public long crearVueloEspecifico(int posAerolinea,int posVueloPlaneado,LocalDateTime fecha,String tipoAvion,int capacidad,long tarifa){
		long codigoVE = aerolineas.get(posAerolinea).getVuelosPlaneados().get(posVueloPlaneado).crearVueloEspecifico(fecha, tipoAvion, capacidad, tarifa);
		return codigoVE;
	}
	
	public String reporteAgentes(int i){
		return agentes.get(i).toString();
	}
	

	public int buscarAgenteId(long codigo){
		int index = -1;
		for(Agente agente : agentes){
			if(agente.getCodigo() == codigo){
				return agentes.indexOf(agente);
			}
			
		}
		return index;
	}
	
	public long crearItinerario(int posAgente,String nomItinerario){
		
		return agentes.get(posAgente).crearItinerario(nomItinerario, agentes.get(posAgente));
		
	}
	
	public void crearPasajero(int posAgente,long codItinerario,String identificacion, String nombre){
		agentes.get(posAgente).crearPasajero(agentes.get(posAgente).buscarItinerarioId(codItinerario),identificacion,nombre);
	}
	
	public ArrayList<Aerolinea> buscarVueloEspecificoRequerimiento( long codOrigen, long codDestino, LocalDateTime fechaSalida){
		int i=0;
		ArrayList<Aerolinea> aerolineasVER = new ArrayList<Aerolinea>();
		ArrayList<VueloPlaneado> VP = new ArrayList<VueloPlaneado>();

		for(Aerolinea aerolinea : aerolineas){
			VP=aerolinea.buscarVueloEspecificoRequerimiento(codOrigen, codDestino, fechaSalida);
			if(VP.size() != 0){
				
			aerolineasVER.add(aerolinea);
			aerolineasVER.get(i).setVuelosPlaneados(VP);
			i++;

			}
			
		}
		return aerolineasVER;
	}
	/*public void reporteCiudades(){
		for(Ciudad ciudad: ciudades ){
			
		}
	}*/
}
