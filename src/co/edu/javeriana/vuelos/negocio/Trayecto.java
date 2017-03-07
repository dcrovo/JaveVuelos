package co.edu.javeriana.vuelos.negocio;

import java.util.*;
public class Trayecto {
	
		private static int CONSECUTIVO=0;
		private int id;
		private VueloEspecifico vueloespecifico;
		private ArrayList<Silla> sillas= new ArrayList<Silla>(); 
		private Itinerario itinerario;
		
		
		public Trayecto(VueloEspecifico vueloespecifico, ArrayList<Silla> sillas, Itinerario itinerario) {
			CONSECUTIVO++;
			this.id = CONSECUTIVO;
			this.vueloespecifico = vueloespecifico;
			this.sillas = sillas;
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
}
