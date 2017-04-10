package co.edu.javeriana.vuelos.negocio;

import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * clase trayecto, cada itinerario tiene asociados varios trayectos
 * @author Viviana Leyva
 *@author daniel
 */
public class Trayecto {
	/**
	 * atributos de la clase trayecto
	 */
		private static int CONSECUTIVO=0;
		private int id;
		private VueloEspecifico vueloespecifico;
		private List<Silla> sillas= new ArrayList<Silla>(); 
		private Itinerario itinerario;
		
		/**
		 * constructor: para instanciar un trayecto solo necesita vuelo especifico e itinerario; el id se genera de fomar automatica con ayuda del consecutivo
		 * @param vueloespecifico
		 * @param itinerario
		 */	
		public Trayecto(VueloEspecifico vueloespecifico,  Itinerario itinerario) {
			CONSECUTIVO++;
			this.id = CONSECUTIVO;
			this.vueloespecifico = vueloespecifico;
			//this.sillas = sillas;
			this.itinerario = itinerario;
		}
		
		
		public int getId() {
			return id;
		}
		public VueloEspecifico getVueloespecifico() {
			return vueloespecifico;
		}
		public void setVueloespecifico(VueloEspecifico vueloespecifico) {
			this.vueloespecifico = vueloespecifico;
		}
		public List<Silla> getSillas() {
			return sillas;
		}
		public void setSillas(List<Silla> sillas) {
			this.sillas = sillas;
		}
		public Itinerario getItinerario() {
			return itinerario;
		}
		public void setItinerario(Itinerario itinerario) {
			this.itinerario = itinerario;
		}
		/**
		 * metodo para obtener la tarifa de un vuelo especifico asociado al trayecto
		 * @return tarifa
		 */
		public long ValorTrayecto(){
			return  vueloespecifico.calcularValorPasaje();
		}
		
		
		/**
		 * metodo para hallar el indice de una silla a partir de su id 
		 * @param silla id de la silla
		 * @return indice de la silla
		 */
		public int buscarSillaId(String silla){
			return vueloespecifico.buscarSillaId(silla);
		}
		/**
		 * metodo para comprar una silla asociada a un vuelo especifico del trayecto
		 * @param indSilla indice de la silla deseada
		 */
		public void comprarSilla(int indSilla){
			vueloespecifico.comprarSilla(indSilla);
		}
		/**
		 * metodo para asociar una silla al vuelo especifico del trayecto
		 * @param indSilla indice de la silla deseada
		 */
		public void agregarSilla(int indSilla){
			sillas.add(vueloespecifico.getSillas().get(indSilla));
		}
		/**
		 * metodo para disminuir el cupo disponible enun vuelo especifico
		 */
		public void disminuirCuposVueloEspecifico(){
			vueloespecifico.setCuposLibres(vueloespecifico.getCuposLibres()-1);
		}


		@Override
		public String toString() {
			String cod=String.valueOf(vueloespecifico.getCodigo());
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDate = vueloespecifico.getFecha().format(formato);
			return String.format("%d   		 %s     %s",id,cod,formattedDate);
		}
		
		public String toString2(){
			String NomAerolinea = vueloespecifico.getVueloPlaneado().getAerolinea().getNombre();
			String NumVuelo = vueloespecifico.getVueloPlaneado().getNumeroVuelo();
			String origen = vueloespecifico.getVueloPlaneado().getOrigen().getNombre();
			String destino = vueloespecifico.getVueloPlaneado().getDestino().getNombre();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String fecha = vueloespecifico.getFecha().format(formato);
			String Hsal= vueloespecifico.getVueloPlaneado().getHoraSalida();
			String Hlle= vueloespecifico.getVueloPlaneado().getHoraLlegada();
			return String.format("%d   %s     %s    %s     %s     %s    %s  %s",id,NomAerolinea,NumVuelo,origen,destino,fecha, Hsal, Hlle);
		}
		

		

}
