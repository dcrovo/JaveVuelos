package co.edu.javeriana.vuelos.presentacion;

import co.edu.javeriana.vuelos.persistencia.*;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

import co.edu.javeriana.vuelos.negocio.*;

/**
 * Clase del paquete de presentacion, es el puente de comunicacion con el usuario
 * 
 * Cada opcion del menu llama un metodo auxiliar para el desarrollo de las actividades
 * @author Viviana Leyva
 *
 */
public class TestSistemaVuelos {

	public static void main(String[] args) {
		SistemaVuelos sistema = new SistemaVuelos();
		int ope=1;
		Scanner scanner= new Scanner(System.in);
		
		/**
		 * Menu
		 */
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
					ReporteAgentesItinerariosTrayectos(sistema);
					break;
				case 9:
					ComprarItinerario(sistema);
					break;
				case 10:
					MostrarTiqueteElectronico (sistema);
					break;
				case 11:
					reporteArchivoTxt(sistema);
					break;
			}
		}
		scanner.close();


	}
	/**
	 * Metodo auxiliar 1, para lectura del primer archivo "ciudades"
	 * @param sistema
	 */
	public static void IngresarCiudades (SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo de ciudades:");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerCiudades(sistema, nombreArchivo);
	}
		
	/**
	 * Metodo auxiliar 2, para lectura del segundo archivo "aerolineas"
	 * @param sistema
	 */
	public static void AgregarAerolineaYVueloEsp (SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerAerolinea(sistema, nombreArchivo);
	}
	
	/**
	 * Metodo auxiliar 3, para lectura del tercer archivo "agentes"
	 * @param sistema
	 */
	static public void IngresarAgentes(SistemaVuelos sistema){
		Scanner sc2= new Scanner(System.in);
		String nombreArchivo="";
		System.out.println("Ingrese el nombre del archivo");
		nombreArchivo = sc2.nextLine();
		ManejoArchivos.leerAgentes(sistema, nombreArchivo);
	}
	
	/**
	 * Metodo auxiliar 4, para agregar un vuelo especifico a un vuelo planeado
	 * @param sistema
	 */
	static public void AgregarVueloEspecifico(SistemaVuelos sistema){
		/*
		 * informacion de las aerolineas
		 */
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
		
		/**
		 * informacion de los vuelos planeados
		 */
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
		
		/**
		 * creacion del vuelo especifico
		 */
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
	
	/**
	 * Metodo auxiliar 5, para el reporte de las aerolineas, sus vuelos planeados y vuelos especificos
	 * @param sistema
	 */
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
	
	
	/**
	 * Metodo auxiliar 6, para agregar un itinerario
	 * @param sistema
	 */
	static public void AgregarItinerario (SistemaVuelos sistema){
		/**
		 * informacion de los agentes
		 */
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
		
		/**
		 * datos nuevo itinerario
		 */
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
	
	/**
	 * Metodo auxiliar 7, para agregar un trayecto a un itinerario
	 * @param sistema
	 */
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
		long codOrigen = Long.parseLong(sc.nextLine());
		System.out.println("--seleccione el codigo de ciudad de destino ");
		long codDestino = Long.parseLong(sc.nextLine());
		
		System.out.println("--Ingrese fecha de salida del vuelo (yyyy-mm-dd)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime fecha = Utils.addHoraAFecha(LocalDate.parse(sc.nextLine(),formatter), "00:00");
		ArrayList<Aerolinea> auxAerolineas = new ArrayList<Aerolinea>();
		auxAerolineas = sistema.buscarVueloEspecificoRequerimiento(codOrigen, codDestino, fecha);
		if(auxAerolineas.size() == 0){
			System.out.println("--No existen vuelos especificos que cumplan los requerimientos:");	
		}
		if(auxAerolineas.size() != 0){
			System.out.println("Ingrese el código del vuelo especifico:\n--------------------\n\n");
			System.out.println("Codigo 	Fecha 	Tipo Avion 	capacidad 	tarifa(US)");

			reporteVueloEspecifico(auxAerolineas);
			long codVueloEspecifico = Long.parseLong(sc.nextLine());
			ArrayList<Integer> vueloEIndex= sistema.buscarVueloEspecificoId(codVueloEspecifico);
			if(vueloEIndex.size() == 0){
				System.out.println("--Ingrese el codigo de vuelo especifico correctamente");	
			}
			if(vueloEIndex.size() != 0){
				VueloEspecifico auxVueloEspecifico = sistema.getAerolinea().get(vueloEIndex.get(0)).getVuelosPlaneados().get(vueloEIndex.get(1)).getVuelosEspecificos().get(vueloEIndex.get(2));
				Itinerario auxItinerario = sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario);
				sistema.getAgentes().get(indexAgente).crearTrayecto(indexItinerario, auxVueloEspecifico, auxItinerario);
				int tam =sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().size();
				Trayecto auxTrayecto=sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().get(tam-1);
				sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().get(tam-1).getVueloespecifico().agregarTrayecto(auxTrayecto);
				sistema.getAerolinea().get(vueloEIndex.get(0)).getVuelosPlaneados().get(vueloEIndex.get(1)).getVuelosEspecificos().get(vueloEIndex.get(2));
			}
			
		}
	//	System.out.println(sistema.buscarVueloEspecificoRequerimiento(codOrigen, codDestino, fecha));	
		

	}
	
	/**
	 * Metodo auxiliar 8, para Reporte de agentes, itinerarios y trayectos
	 * @param sistema
	 */
	public static void ReporteAgentes(SistemaVuelos sistema){
		
		System.out.println("Codigo --- Nombre ---- Email");
		for (int i=0; i<sistema.getAgentes().size();i++){
			System.out.println(sistema.reporteAgentes(i));
		}
	}

	public static void ReporteAgentesItinerariosTrayectos(SistemaVuelos sistema){
		System.out.println("Codigo --- Nombre ---- Email");
		for (int i=0; i<sistema.getAgentes().size();i++){
			System.out.println(sistema.reporteAgentes(i));
			System.out.println("---------------------------------------------------\n	Itinerarios del agente " + sistema.getAgentes().get(i).getNombre() + ":\n");
			System.out.println("Codigo --- Nombre ---- Comprado");
			for(int j=0;j<sistema.getAgentes().get(i).getItinerarios().size();j++){
				System.out.println(sistema.getAgentes().get(i).reporteItinerarios(j));
				System.out.println("-----------------------------------------------\n	Trayectos del itinerario " + sistema.getAgentes().get(i).getItinerarios().get(j).getNombre() + ":\n");
				System.out.println("Id --- Codigo ---- Fecha Codigo	Num de vuelo	Dia de semana	HoraSalida	HoraLlegada	  Origen   Destino");
				for(int k=0; k<sistema.getAgentes().get(i).getItinerarios().get(j).getTrayectos().size(); k++){
					System.out.println(sistema.getAgentes().get(i).getItinerarios().get(j).reporteTrayectos(k) + " " +sistema.getAgentes().get(i).getItinerarios().get(j).getTrayectos().get(k).getVueloespecifico().toString() );
				}

			}
		}
	}
	

	
	public static void ReporteItinerario (SistemaVuelos sistema, int indexAgente){

		System.out.println("El Agente "+sistema.getAgentes().get(indexAgente).getNombre() + " tiene los siguientes itinerarios:\n------------------------------");
		System.out.println("Codigo	Nombre	Comprado");
		for(int j=0;j<sistema.getAgentes().get(indexAgente).getItinerarios().size();j++){
			
		
			System.out.println(sistema.getAgentes().get(indexAgente).getItinerarios().get(j).toString() + ":\n");
			
		}
	}
	
	/**
	 * Metodo auxiliar 9, para comprar un itinerario
	 * @param sistema
	 */
	static public void ComprarItinerario (SistemaVuelos sistema){
		/**
		 * Reporte de agentes
		 */
		System.out.println("--Bienvenido a la seccion de compras de itinerario");
		System.out.println("Seleccione uno de los siguientes agentes: (codigo)");
		ReporteAgentes(sistema);
		Scanner sc9= new Scanner (System.in);
		long codAgente= Long.parseLong(sc9.nextLine());
		int indexAgente = sistema.buscarAgenteId(codAgente);
		/**
		 * Reporte de itinerarios
		 */
		System.out.println("Seleccione uno de los siguientes itinerarios: (codigo)");
		ReporteItinerario(sistema,indexAgente);
		long codItinerario= Long.parseLong(sc9.nextLine());
		int indexItinerario = sistema.getAgentes().get(indexAgente).buscarItinerarioId(codItinerario);
		/**
		 * Verificacion de disponibilidad en los aviones de vuelos especificos
		 */
		if(sistema.VerificarCupoItinerario (indexAgente,indexItinerario)==true){
			/**
			 * informacion del costo del itinerario 
			 */
			System.out.println("El costo del itinerario: "+codItinerario+" ,es:" +sistema.CalcularValorItinerario(indexAgente, indexItinerario));
			/**
			 * Cambio del estado del itinerario a comprado
			 */
			sistema.ComprarItinerario(indexAgente, indexItinerario);
			/**
			 * Visualizacion de las sillas por cada pasajero y trayecto
			 */
			for(int i=0;i<sistema.cantidadPasajeros(indexAgente,indexItinerario);i++){
				for(int j=0;j<sistema.cantidadTrayectos(indexAgente, indexItinerario);j++){
					System.out.println("Pasajero: "+sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getPasajeros().get(i).getNombre());
					System.out.println("Trayecto: "+sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().get(j).getId());
					System.out.println("Seleccione uno de las sillas disponibles (D):");
					for(int k=0;k<10;k++){
						System.out.println(sistema.mostrarSillas(indexAgente,indexItinerario,j,k));
					}
					String silla= sc9.nextLine();
					sistema.comprarSilla(indexAgente, indexItinerario,j,i, silla);
				}
			}
		}
		else{
			System.out.println("No hay cupo disponible en este itinerario");
		}
	}
	
	/**
	 * Metodo auxiliar 10, para el resumido de la compra del pasajero
	 * @param sistema
	 */
	public static void MostrarTiqueteElectronico (SistemaVuelos sistema){
		/**
		 * Reporte de agentes
		 */
		System.out.println("--Tiquete Electronico");
		System.out.println("Seleccione uno de los siguientes agentes: (codigo)");
		ReporteAgentes(sistema);
		Scanner sc9= new Scanner (System.in);
		long codAgente= Long.parseLong(sc9.nextLine());
		int indexAgente = sistema.buscarAgenteId(codAgente);
		/**
		 * Reporte de itinerarios
		 */
		System.out.println("Seleccione uno de los siguientes itinerarios: (codigo)");
		ReporteItinerario(sistema,indexAgente);
		long codItinerario= Long.parseLong(sc9.nextLine());
		int indexItinerario = sistema.getAgentes().get(indexAgente).buscarItinerarioId(codItinerario);
		if (sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).isComprado()==true){
			ReporteItinerario(sistema,indexAgente);
			System.out.println("El valor del itinerario es: $"+sistema.CalcularValorItinerario(indexAgente, indexItinerario));
			System.out.println("id----codigo-----fecha");
			for(int k=0;k<sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().size();k++){
				System.out.println(sistema.reporteTrayectos(indexAgente, indexItinerario, k));
				System.out.println("Codigo	Num de vuelo	Dia de semana	HoraSalida	HoraLlegada	  Origen   Destino");
				System.out.println(sistema.getAgentes().get(indexAgente).getItinerarios().get(indexItinerario).getTrayectos().get(k).getVueloespecifico().getVueloPlaneado().toString());
			}
		}
		else{
			System.out.println("el itinerario no ha sido comprado, operacion cancelada");
		}
	}
	

	public static void reporteVueloEspecifico (ArrayList<Aerolinea> aerolinea){
		for(int i = 0; i<aerolinea.size();i++){
			for(int j= 0; j<aerolinea.get(i).getVuelosPlaneados().size();j++){
				for(int k=0; k<aerolinea.get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().size();k++){
					System.out.println(aerolinea.get(i).getVuelosPlaneados().get(j).getVuelosEspecificos().get(k).toString());
				}
			}
		}
	}
	
	/**
	 * Metodo auxiliar 11, para generar el reporte de los vuelos especificos solicitados
	 * @param sistema
	 */
	public static void reporteArchivoTxt(SistemaVuelos sistema){
		Scanner sc0= new Scanner(System.in);
		System.out.println("Ingrese la ciudad de origen");
		String origen = sc0.nextLine();
		System.out.println("Ingrese la ciudad de destino");
		String destino = sc0.nextLine();
		System.out.println("Ingrese el nombre con el cual quiere guardar el archivo mseguido de .txt");
		String nombreArchivo = sc0.nextLine();
		ManejoArchivos.reporteArchivoTxt(sistema, origen, destino, nombreArchivo);
	}

}
