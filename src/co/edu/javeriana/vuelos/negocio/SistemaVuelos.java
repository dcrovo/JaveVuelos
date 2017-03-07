package co.edu.javeriana.vuelos.negocio;
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
		
		Ciudad cOrigen = ciudades.get(buscarCiudadId(origen));
		Ciudad cDestino = ciudades.get(buscarCiudadId(destino));
		VueloPlaneado vueloPlaneado = new VueloPlaneado(codigo,numeroVuelo,diaSemana,horaSalida,horaLlegada,cDestino,cOrigen);
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
	/*public void reporteCiudades(){
		for(Ciudad ciudad: ciudades ){
			
		}
	}*/
}
