package co.edu.javeriana.vuelos.negocio;

/**
 * Clase ciudad del proyecto JaveVuelos, el sistema tiene varias ciudades que se instancian a partir del archivo "Ciudades" con ayuda del manejador de archivos
 * @author Viviana Leyva
 *@author daniel
 */
public class Ciudad {

	/**
	 * atributos de la clase ciudad
	 */
	private long codigo;
	private String nombre;
	
	/**
	 * constructor: requiere un codigo un numbre para la instanciacion
	 * @param codigo codigo de la ciudad leida del archivo Ciudades
	 * @param nombre nombre de a ciudad leido del archivo Ciudades
	 */
	public Ciudad(long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	/**
	 * Getters y Setters de los atributos de Ciudades
	 * @return
	 */
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
