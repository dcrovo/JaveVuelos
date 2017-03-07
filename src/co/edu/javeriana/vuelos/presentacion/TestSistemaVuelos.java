package co.edu.javeriana.vuelos.presentacion;

import java.util.Scanner;

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
			System.out.println("2: ingresar aerolíneas y vuelos planeados del sistema");
			System.out.println("3: ingresar agentes del sistema");
			System.out.println("4: agregar un vuelo específico para un vuelo planeado");
			System.out.println("5: mostrar aerolíneas, vuelos planeados y vuelos específicos del sistema");
			System.out.println("6: agregar un itinerario para un agente");
			System.out.println("7: agregar un trayecto asociado a un itinerario");
			System.out.println("8: mostrar agentes, itinerarios y trayectos");
			System.out.println("9: comprar un itinerario asignando a cada pasajero una silla sobre cada trayecto del itinerario");
			System.out.println("10: tiquete electrónico: para un itinerario comprado mostrar su valor,sus trayectos, las sillas reservadas y los pasajeros asociados");
			System.out.println("11: reporte vuelos específicos: dado el nombre de una ciudad de origen y el de una ciudad destino");
			System.out.println("12: terminar");
			String leido= scanner.nextLine();
			ope=Integer.parseInt(leido);
			
			switch(ope){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
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
	
	public void IngresarCiudades (){
		
	}
	
	public void IngresarAgentes(){
		
	}
	
	public void AgregarVueloEsp (){
		
	}
	
	public void ReporteAerolinea (){
		
	}
	
	public void AgregarItinerario (){
		
	}
	
	public void AgregarTrayecto (){
		
	}
	
	public void ReporteAgentes (){
		
	}
	
	public void ComprarItinerario (){
		
	}

	public void MostrarTiqueteElectronico (){
		
	}
	
	public void ReporteVueloEspecifico (){
		
	}


}
