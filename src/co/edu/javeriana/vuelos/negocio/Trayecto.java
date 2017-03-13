package co.edu.javeriana.vuelos.negocio;

import java.time.format.DateTimeFormatter;
import java.util.*;
public class Trayecto {
	
		private static int CONSECUTIVO=0;
		private int id;
		private VueloEspecifico vueloespecifico;
		private ArrayList<Silla> sillas= new ArrayList<Silla>(); 
		private Itinerario itinerario;
		
		
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
		public ArrayList<Silla> getSillas() {
			return sillas;
		}
		public void setSillas(ArrayList<Silla> sillas) {
			this.sillas = sillas;
		}
		public Itinerario getItinerario() {
			return itinerario;
		}
		public void setItinerario(Itinerario itinerario) {
			this.itinerario = itinerario;
		}
		
		public long ValorTrayecto(){
			return vueloespecifico.getTarifa();
		}
		
		public int buscarSillaId(String silla){
			return vueloespecifico.buscarSillaId(silla);
		}
		
		public void comprarSilla(int indSilla){
			vueloespecifico.comprarSilla(indSilla);
		}
		
		public void agregarSilla(int indSilla){
			sillas.add(vueloespecifico.getSillas().get(indSilla));
		}
		
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
		
		

}
