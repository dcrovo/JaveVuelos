package co.edu.javeriana.vuelos.negocio;

/**
 * clase silla de JaveVuelos, cada pasajero y vuelo especifico tienen asociadas unas listas de sillas 
 * @author Viviana Leyva
 *@author daniel
 */
public class Silla {

	/**
	 * atributos de silla
	 */
	private String id;
	private boolean comprada;
	private Trayecto trayecto;
	private VueloEspecifico vueloEspecifico;
	private Pasajero pasajero;
	
	/**
	 * Constructor: para instanciar una silla solo se necesita conocer su id
	 * @param id
	 */
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
	/**
	 * metodo para concatenacion de la informacion de una silla, se evaluar "comprada" y se asigna una letra para facilidad de visualizacion del usuario
	 */
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
