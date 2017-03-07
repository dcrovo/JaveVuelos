package co.edu.javeriana.vuelos.persistencia;

import java.util.*;
import java.io.*;

import co.edu.javeriana.vuelos.negocio.*;

public class ManejoArchivos {

	ArrayList<Aerolinea> aereolinea;
	ArrayList<Ciudad> ciudades;
	ArrayList<Agente> agentes;
	
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
}
