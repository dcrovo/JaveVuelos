package co.edu.javeriana.vuelos.presentacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Utils {
	
public static LocalDateTime addHoraAFecha(LocalDate fecha, String hora){
		
		StringTokenizer tokens = new StringTokenizer(hora,":");
		int horaI = Integer.parseInt(tokens.nextToken());
		int minutoI = Integer.parseInt(tokens.nextToken());
		
		return fecha.atTime(horaI, minutoI);
	}
	
	public static long obtenerEdad(LocalDate fechaNacimiento){
		
		LocalDate fechaHoy = LocalDate.now();
		long edad = fechaNacimiento.until(fechaHoy, ChronoUnit.YEARS);
		return edad;
	}
	
	public static long diferenciaFechasDias(LocalDateTime fecha1, LocalDateTime fecha2){
		
		long dif = fecha1.until(fecha2, ChronoUnit.DAYS);
		
		return dif;
	}


}
