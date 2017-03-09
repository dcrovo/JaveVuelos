package co.edu.javeriana.vuelos.presentacion;

import co.edu.javeriana.vuelos.persistencia.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.vuelos.negocio.*;

public class TestSistemaVuelos {

	public static void main(String[] args) {
		SistemaVuelos sistema = new SistemaVuelos();
		int ope=1;
		Scanner scanner= new Scanner(System.in);
		

		while (ope!=12){
			System.out.println("Seleccione una de las siguientes opciones:");
			//menu
			System.out.println("1: ingresar ciudades del sistema");
			System.out.println("2: ingresar aerolineas y vuelos planeados del sistema");
			System.out.println("3: ingresar agentes del sistema");
			System.out.println("4: agregar un vuelo especifico para un vuelo planeado");
			System.out.println("5: mostrar aerolineas, vuelos planeados y vuelos espec�ficos del sistema");
			System.out.println("6: agregar un itinerario para un agente");
			System.out.println("7: agregar un trayecto asociado a un itinerario");
			System.out.println("8: mostrar agentes, itinerarios y trayectos");
			System.out.println("9: comprar un itinerario asignando a cada pasajero una silla sobre cada trayecto del itinerario");
			System.out.println("10: tiquete electronico: para un itinerario comprado mostrar su valor,sus trayectos, las sillas reservadas y los pasajeros asociados");
			System.out.println("11: reporte vuelos especificos: dado el nombre de una ciudad de origen y el de una ciudad destino");
			System.out.println("12: terminar");
			String leido= scanner.nextLine();
			ope=Integer.parseInt(leido);
			
			switch(ope){
				case 1:
					IngresarCiudades (sistema);
					System.out.println("Operaci�n terminada: Ciudades listas");
					
					break;
				case 2:
					AgregarAerolineaYVueloEsp (sistema);
					System.out.println("Operaci�n terminada: Aerolineas listas");
					break;
				case 3:
					IngresarAgentes(sistema);
					System.out.println("Operaci�n terminada: Agentes listos");
					break;
				case 4:
					AgregarVueloEspecifico(sistema);
					break;
				case 5:
					ReporteContenidoAerolineas(sistema);
					break;
				case 6:
					AgregarItinerario (sistema);
					break;
				case 7:
					AgregarTrayecto(sistema);
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
			}
		}
		scanner.close();


	}
	
	public static void IngresarCiudades (SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo de ciudades:");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerCiudades(sistema, nombreArchivo);
	}
		
	public static void AgregarAerolineaYVueloEsp (SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerAerolinea(sistema, nombreArchivo);
	}
	
	static public void IngresarAgentes(SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerAgentes(sistema, nombreArchivo);
	}
	
	static public void AgregarVueloEspecifico(SistemaVuelos sistema){
		//informacion de las aerolineas
		System.out.println(" ");
		System.out.println("Estas son las aerolineas disponibles:");
		Scanner sc3= new Scanner (System.in);
		System.out.println("Codigo --- Nombre");
		for (int i=0; i<sistema.getAerolinea().size();i++){
			System.out.println(sistema.reporteAerolinea(i));
		}
		System.out.println("");
		System.out.println("--�cual es el codigo de la aerolinea al cual pertenece el nuevo vuelo especifico?");
		String codAero= sc3.nextLine();
		long codigo= Long.parseLong(codAero);
		int posAerolinea=sistema.buscarAerolineaId(codigo);
		
		//informacion de los vuelos planeados
		System.out.println("--Estos son los vuelos planeados de:"+ sistema.getAerolinea().get(posAerolinea).getNombre());
		System.out.println("Codigo	Num de vuelo	Dia de semana	HoraSalida	HoraLlegada	  Origen   Destino");
		for (int i=0; i<sistema.getAerolinea().get(posAerolinea).getVuelosPlaneados().size();i++){
			System.out.println(sistema.reporteVuelosPlaneados(posAerolinea,i));
		}
		System.out.println("");
		System.out.println("--�cual es el codigo del vuelo planeado al cual pertenece el nuevo vuelo especifico?");
		String codVueloPlaneado= sc3.nextLine();
		long codigoVP= Long.parseLong(codVueloPlaneado);
		int posVueloPlaneado=sistema.buscarVueloPlaneadoId(posAerolinea,codigoVP);
		
		//creacion del vuelo especifico
		System.out.println("");
		System.out.println("--Indique datos del vuelo espec�fico: fecha(YYYY-MM-DD) tipoAvion capacidad tarifa(US)");
		String InfoVueloEspecifico= sc3.nextLine();
		StringTokenizer tokens = new StringTokenizer(InfoVueloEspecifico," ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate fechal=LocalDate.parse(tokens.nextToken(), formatter);
			LocalDateTime fecha = Utils.addHoraAFecha(fechal, "00:00");
			String tipoAvion= tokens.nextToken();
			int capacidad=Integer.parseInt(tokens.nextToken());
			long tarifa=Long.parseLong(tokens.nextToken());
			long codigoVE= sistema.crearVueloEspecifico(posAerolinea,posVueloPlaneado, fecha, tipoAvion,capacidad,tarifa);
			System.out.println("");
			System.out.println("El vuelo espec�fico ha sido creado con el codigo:" + codigoVE);
				
		
	}

	static public void ReporteContenidoAerolineas (SistemaVuelos sistema){
		System.out.println("--REPORTE DE AEROLINEAS, VUELOS PLANEADOS Y VUELOS ESPECIFICOS");
		for(int i=0;i< sistema.getAerolinea().size();i++){
			System.out.println("AEROLINEA:" +sistema.getAerolinea().get(i).getNombre());
			System.out.println("Codigo      Cuenta Bancaria");
			System.out.println(sistema.getAerolinea().get(i).getCodigo()   +   sistema.getAerolinea().get(i).getCuentaBanco());
			System.out.println("--- Vuelos planeados:");
			System.out.println("----codigo---numero vuelo--dia Semana--Hora Salida--Hora Llegada--Origen--Destino");
			for(int j=0; j< sistema.getAerolinea().get(i).getVuelosPlaneados().size();j++){
				System.out.println("     "+sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).toString());
				if(sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().isEmpty() == true){
					System.out.println(" ");
				}
				else{
					System.out.println("            Vuelos especificos para el vuelo planeado" + sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getCodigo() +":");
					System.out.println("            codigo    fecha       Tipo Avion     Capacidad    Cupos Libres    Tarifa(US)");
					System.out.println("            ----------------------------------------------------------------------------");
					
					for(int k=0;k< sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().size();k++){
						System.out.println("            "+sistema.getAerolinea().get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().get(k).toString());
						System.out.println(" ");
					}
				}
			}
		}
	}
	
	static public void AgregarItinerario (SistemaVuelos sistema){
		//informacion de los agentes
		System.out.println(" ");
		System.out.println("Estos son los agentes disponibles:");
		Scanner sc= new Scanner (System.in);
		System.out.println("Codigo --- Nombre");
		for (int i=0; i<sistema.getAgentes().size();i++){
			System.out.println(sistema.reporteAgentes(i));
		}
		System.out.println("");
		System.out.println("--�cual es el codigo de agente al cual pertenece el nuevo itinerario?");
		String codAge= sc.nextLine();
		long codigo= Long.parseLong(codAge);
		int posAgente=sistema.buscarAgenteId(codigo);
		
		//datos nuevo itinerario
		System.out.println("--indique el nombre del nuevo itinerario");
		String nomItinerario = sc.nextLine();
		System.out.println(" ");
		System.out.println("--�Cuantos pasajeros realizan el itinerario?");
		String numpasajeros= sc.nextLine();
		int numpas=Integer.parseInt(numpasajeros);
		long codItinerario=sistema.crearItinerario(posAgente, nomItinerario);
		System.out.println("--indique una l�nea para cada pasajero con identificaci�n y nombre separados por *");
		for (int i=0;i<numpas;i++){
			String infopasajeroaux = sc.nextLine();
			StringTokenizer tokens = new StringTokenizer(infopasajeroaux,"*");
			String identificacion= tokens.nextToken().trim();
			String nombrePas= tokens.nextToken().trim();
			sistema.crearPasajero(posAgente,codItinerario,identificacion,nombrePas);
		}
		System.out.println("El itinerario ha sido creado con el codigo:" + codItinerario);		
		//sc.close();
	}
	
	public static void AgregarTrayecto (SistemaVuelos sistema){
		Scanner sc = new Scanner(System.in);
		ReporteAgentes(sistema);
		System.out.println("--cual es el codigo de agente al cual pertenece el nuevo trayecto?");
		long codAge= Long.parseLong(sc.nextLine());
		int indexAgente = sistema.buscarAgenteId(codAge);
		ReporteItinerario(sistema,indexAgente);
		
		System.out.println("--cual es el codigo del itinerario ?");
		long codItinerario = Long.parseLong(sc.nextLine());
		int indexItinerario = sistema.getAgentes().get(indexAgente).buscarItinerarioId(codItinerario);
		System.out.println("--seleccione el codigo de ciudad de origen ");
		long codCiudadOrigen = Long.parseLong(sc.nextLine());
		System.out.println("--seleccione el codigo de ciudad de destino ");
		long codCiudadDestino = Long.parseLong(sc.nextLine());
		
		System.out.println("--Ingrese fecha de salida del vuelo (yyyy-mm-dd)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime fecha = Utils.addHoraAFecha(LocalDate.parse(sc.nextLine(),formatter), "00:00");

		
		


		
	}
	
	
	public static void ReporteAgentes (SistemaVuelos sistema){
		System.out.println("Codigo --- Nombre");
		for (int i=0; i<sistema.getAgentes().size();i++){
			System.out.println(sistema.reporteAgentes(i));
		}
		System.out.println("");
	}
	
	public static void ReporteItinerario (SistemaVuelos sistema, int indexAgente){

		System.out.println("El Agente "+sistema.getAgentes().get(indexAgente).getNombre() + " tiene los siguientes itinerarios:\n------------------------------");
		System.out.println("Codigo	Nombre	Comprado");
		for(int j=0;j<sistema.getAgentes().get(indexAgente).getItinerarios().size();j++){
			
		
			System.out.println(sistema.getAgentes().get(indexAgente).getItinerarios().get(j).toString() + ":\n");
			
		}
	}
	
	public void ComprarItinerario (){
		
	}

	public void MostrarTiqueteElectronico (){
		
	}
	
	public void ReporteVueloEspecifico (){
		
	}


}
