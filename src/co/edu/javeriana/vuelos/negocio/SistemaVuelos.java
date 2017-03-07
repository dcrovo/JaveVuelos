package co.edu.javeriana.vuelos.negocio;
import java.util.*;
public class SistemaVuelos {
	
	ArrayList<Aerolinea> aereolinea = new ArrayList<Aerolinea>();
	ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	ArrayList<Agente> agentes = new ArrayList<Agente>();
	
	
	public ArrayList<Aerolinea> getAereolinea() {
		return aereolinea;
	}


	public void setAereolinea(ArrayList<Aerolinea> aereolinea) {
		this.aereolinea = aereolinea;
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
	/*public void reporteCiudades(){
		for(Ciudad ciudad: ciudades ){
			
		}
	}*/
}
