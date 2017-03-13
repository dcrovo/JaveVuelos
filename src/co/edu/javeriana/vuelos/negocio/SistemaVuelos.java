package co.edu.javeriana.vuelos.negocio;
import java.time.LocalDateTime;
import java.util.*;

import co.edu.javeriana.vuelos.presentacion.Utils;

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
		Aerolinea aerolinea = aerolineas.get(indexAerolinea);
		Ciudad cOrigen = ciudades.get(buscarCiudadId(origen));
		Ciudad cDestino = ciudades.get(buscarCiudadId(destino));
		VueloPlaneado vueloPlaneado = new VueloPlaneado(codigo,numeroVuelo,diaSemana,horaSalida,horaLlegada,cDestino,cOrigen,aerolinea);
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
	public int buscarCiudadNombre(String nombre){
		int index = -1;
		for(Ciudad ciudad : ciudades){
			if(ciudad.getNombre().equals(nombre)){
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
		VueloPlaneado vueloPlaneado = aerolineas.get(posAerolinea).getVuelosPlaneados().get(posVueloPlaneado);
		long codigoVE = aerolineas.get(posAerolinea).getVuelosPlaneados().get(posVueloPlaneado).crearVueloEspecifico(fecha, tipoAvion, capacidad, tarifa,vueloPlaneado);
		return codigoVE;
	}
	
	public String reporteAgentes(int index){
		return agentes.get(index).toString();
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
	/*
	 * Posicion 0 index aerolinea
	 * posicion 1 index VuelosPlaneados
	 * posicion 2 index Vuelos Especificos
	 */
	public ArrayList<Integer> buscarVueloEspecificoId(long codigoVE){
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i=0; i<aerolineas.size(); i++){
			for(int j=0; j<aerolineas.get(i).getVuelosPlaneados().size();j++){
				for(int k=0; k<aerolineas.get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().size();k++){
					if(aerolineas.get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().get(k).getCodigo() == codigoVE){
						out.add(i);
						out.add(j);
						out.add(k);
						return out;
						
					}
				}
			}
		}
		return out;
	}
	
	/**
	 * Metodo para verificacion de disponibilidad en los vuelos especificos contenidos en un itinerario
	 * @param indAgente
	 * @param indItinerario
	 * @return
	 */
	public boolean VerificarCupoItinerario (int indAgente, int indItinerario){
		return agentes.get(indAgente).VerificarCupoItinerario(indItinerario);
	}
	
	/**
	 * Metodo auxiliar para el calculo del valor de un itinerario de acuerdo a la tarifa y la cantidad de pasajeros
	 * @param indAgente
	 * @param indItinerario
	 * @return
	 */
	public long CalcularValorItinerario(int indAgente, int indItinerario){
		return agentes.get(indAgente).CalcularValorItinerario(indItinerario);
	}
	
	/**
	 * Metodo auxiliar para el cambio del indicador de comprado en un itinerario a true
	 * @param indAgente
	 * @param indItinerario
	 */
	public void ComprarItinerario(int indAgente,int indItinerario){
		agentes.get(indAgente).ComprarItinerario(indItinerario);
	}
	
	/**
	 * Metodo auxiliar para determinar la cantidad de pasajeros de un itinerario
	 * @param indexAgente
	 * @param indexItinerario
	 * @return
	 */
	public int cantidadPasajeros(int indexAgente,int indexItinerario){
		return agentes.get(indexAgente).getItinerarios().get(indexItinerario).getPasajeros().size();
	}
	
	/**
	 * Determina la cantidad de trayectos existentes dentro de un itinerario en especifico
	 * @param indexAgente
	 * @param indexItinerario
	 * @return
	 */
	public int cantidadTrayectos(int indexAgente,int indexItinerario){
		return agentes.get(indexAgente).getItinerarios().get(indexItinerario).cantidadTrayectos();
	}
	
	/**
	 * Metodo auxiliar para el reporte de las sillas de cada vuelo especifico en forma matricial
	 * @param indAgente
	 * @param indItinerario
	 * @param indTrayecto
	 * @param fila
	 * @return
	 */
	public String mostrarSillas(int indAgente,int indItinerario,int indTrayecto,int fila){
		return agentes.get(indAgente).getItinerarios().get(indItinerario).getTrayectos().get(indTrayecto).getVueloespecifico().MostrarFilaSillas(fila);
	}
	
	/**
	 * Metodo auxiliar para la compra de un silla en un vuelo especifico
	 * @param indAgente
	 * @param indItinerario
	 * @param indTrayecto
	 * @param indPasajero
	 * @param silla
	 */
	public void comprarSilla(int indAgente,int indItinerario,int indTrayecto, int indPasajero,String silla){
		int indSilla =agentes.get(indAgente).buscarSillaId(indItinerario,indTrayecto,silla);
		agentes.get(indAgente).comprarSilla(indItinerario,indTrayecto,indPasajero,indSilla);
	}
	
	public String reporteTrayectos (int indAgente, int indItinerario,int indTrayecto){
		return agentes.get(indAgente).getItinerarios().get(indItinerario).getTrayectos().get(indTrayecto).toString();
	}
	
	public ArrayList<VueloEspecifico> vuelosEntreCiudades(SistemaVuelos sistema, int indexOrigen, int indexDestino){
		ArrayList<VueloEspecifico> vuelosPlaneadosEntreCiudades = new ArrayList<VueloEspecifico>();
		Ciudad origen = sistema.getCiudades().get(indexOrigen);
		Ciudad destino = sistema.getCiudades().get(indexDestino);
		LocalDateTime fechaHoy = LocalDateTime.now();
		for(int i=0; i< sistema.getAerolinea().size();i++){
			for(int j=0; j<sistema.getAerolinea().get(i).getVuelosPlaneados().size();j++){
				
				if((origen.getCodigo() == sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getOrigen().getCodigo()) && (destino.getCodigo() == sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getDestino().getCodigo())){
					for(int k=0;k<sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().size();k++){
						LocalDateTime fecha1 = sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().get(k).getFecha();
						if(Utils.diferenciaFechasDias(fecha1, fechaHoy)<= 31){
							vuelosPlaneadosEntreCiudades.add(sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().get(k));
						}
					}
				}
			}
		}
		
		
		return vuelosPlaneadosEntreCiudades;
	}
	/*public void reporteCiudades(){
		for(Ciudad ciudad: ciudades ){
			
		}
	}*/
}
