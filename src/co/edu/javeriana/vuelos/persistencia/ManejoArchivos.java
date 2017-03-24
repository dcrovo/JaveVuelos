package co.edu.javeriana.vuelos.persistencia;

import java.util.*;
import java.io.*;

import co.edu.javeriana.vuelos.negocio.*;

public class ManejoArchivos {
	/**
	 * Metodo para extraer los datos del archivo ciudades
	 * @param sistema
	 * @param nombreArchivo
	 */
	public static void leerCiudades(SistemaVuelos sistema, String nombreArchivo){
		long codigo;
		String nombre;
		try{
			File f = new File("./" + nombreArchivo);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line="";
			
			while(!(line = b.readLine()).equals("0")){
				line.trim();

				if (!line.startsWith("#") && !line.equals("0")){

					StringTokenizer tokens = new StringTokenizer(line,"*");
					codigo = Long.parseLong(tokens.nextToken().trim());
					nombre = tokens.nextToken().trim();
					sistema.crearCiudad(codigo, nombre);
				}
				
			}
			b.close();
		}
			
		catch (IOException e) {
            e.printStackTrace();

		}
		
		
	}
	/**
	 * Metodo para extraer los datos del archivo de Agentes
	 * @param sistema
	 * @param nombreArchivo
	 */
	public static void leerAgentes(SistemaVuelos sistema,String nombreArchivo){
		
		long codigo;
		String nombre,email;
		try{
			File f = new File("./" + nombreArchivo);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line="";
			
			while(!(line = b.readLine()).equals("0")){
				line.trim();

				if (!line.startsWith("#") && !line.equals("0")){

					StringTokenizer tokens = new StringTokenizer(line,"*");
					codigo = Long.parseLong(tokens.nextToken().trim());
					nombre = tokens.nextToken().trim();
					email = tokens.nextToken().trim();

					sistema.crearAgente(codigo, nombre,email);
				}
				
			}
			b.close();
		}
			
		catch (IOException e) {
            e.printStackTrace();

		}
	}
	/**
	 * Metodo para extraer los datos del archivo de Aerolinea
	 * @param sistema
	 * @param nombreArchivo
	 */

	public static void leerAerolinea(SistemaVuelos sistema, String nombreArchivo){
		int i=-1;
		long codigo,codigoVuelo,origen,destino;
		String nombre, cuentaBanco,numeroVuelo,diaSemana,horaSalida,horaLlegada;
		try{
			File f = new File("./" + nombreArchivo);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String line="";
			while(!(line = b.readLine().trim()).equals("#FIN")){
				
				if(line.equals("#AEROLINEA")){
					i++;
					line = b.readLine();
					line = b.readLine();
					StringTokenizer tokens = new StringTokenizer(line,"*");
					codigo = Long.parseLong(tokens.nextToken().trim());
					nombre = tokens.nextToken().trim();
					cuentaBanco = tokens.nextToken().trim();
					sistema.crearAerolinea(codigo, nombre, cuentaBanco);
					line = b.readLine();
					
					if(line.startsWith("#vuelos")){
						line = b.readLine();
						
					
						while(!(line = b.readLine().trim()).equals("0")){
							
							StringTokenizer tokens1 = new StringTokenizer(line,"*");
							codigoVuelo = Long.parseLong(tokens1.nextToken().trim());
							numeroVuelo = tokens1.nextToken().trim();
							diaSemana = tokens1.nextToken().trim();
							horaSalida = tokens1.nextToken().trim();
							horaLlegada = tokens1.nextToken().trim();
							origen = Long.parseLong(tokens1.nextToken().trim());
							destino = Long.parseLong(tokens1.nextToken().trim());
							sistema.crearVueloPlaneado(codigoVuelo, numeroVuelo, diaSemana, horaSalida, horaLlegada, origen, destino, i);

						}

					}
						
				}
			}
			b.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para generar el archivo de reporte
	 * @param sistema
	 * @param nombreArchivo
	 * @param destino
	 * @param origen
	 */

	public static void reporteArchivoTxt(SistemaVuelos sistema, String origen, String destino, String nombreArchivo){
		int indexOrigen = sistema.buscarCiudadNombre(origen);
		int indexDestino = sistema.buscarCiudadNombre(destino);
		ArrayList<VueloEspecifico> vuelosPlaneadosEntreCiudades = new ArrayList<VueloEspecifico>();
		File outFile = new File("./"+nombreArchivo);
		FileOutputStream outStream = null;
		PrintWriter dataOutStream = null;
		vuelosPlaneadosEntreCiudades = sistema.vuelosEntreCiudades(sistema, indexOrigen, indexDestino);
		if(vuelosPlaneadosEntreCiudades.size() != 0){
			
			try {
			outStream = new FileOutputStream(outFile);
			dataOutStream = new PrintWriter(outStream);
			dataOutStream.println("#Vuelos Planeados entre " + origen +" y" + destino + ":");
			dataOutStream.println("#NumeroVuelo---DiaSemana---HoraSalida---HoraLlegada---Fecha");
				for(int i=0;i<vuelosPlaneadosEntreCiudades.size();i++){
					dataOutStream.println(vuelosPlaneadosEntreCiudades.get(i).toString2());

				}
				dataOutStream.println("#FIN");

			}
			catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
			}
			finally {
			try {
			dataOutStream.close();
			outStream.close();
			}
			catch (Exception e) {
			System.out.println("excepcion cerrando el archivo:" + e.getMessage());
			}
			}
		}
	}
}
