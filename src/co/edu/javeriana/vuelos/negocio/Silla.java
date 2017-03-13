package co.edu.javeriana.vuelos.negocio;

public class Silla {

	private String id;
	private boolean comprada;
	private Trayecto trayecto;
	private VueloEspecifico vueloEspecifico;
	private Pasajero pasajero;
	
	
	public Silla(String id) {

		this.id = id;
		this.comprada = false;

	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isComprada() {
		return comprada;
	}
	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}
	public Trayecto getTrayecto() {
		return trayecto;
	}
	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}
	public VueloEspecifico getVueloEspecifico() {
		return vueloEspecifico;
	}
	public void setVueloEspecifico(VueloEspecifico vueloEspecifico) {
		this.vueloEspecifico = vueloEspecifico;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	@Override
	public String toString() {
		String comp;
		if(comprada==true){
			comp="O";//ocupada
		}
		else{
			comp="D";//disponible
		}
		return String.format("-%s %s-  ", id,comp);
	}
	

}
