/**
 * 
 */
package bronson;

import java.util.*;
import java.io.*;

/**
 * @author Andres Martinez
 *
 */
public class Inventario {

	/**
	 * @param args
	 */
	private ArrayList<Avion> aviones = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Inventario in = new Inventario();
		
		Pasajero av1 = new Pasajero();
		av1.setMatricula("HK345"); av1.setVelocidad(300);
		av1.setNumeroPasajeros(299);
		
		Pasajero av2 = new Pasajero();
		av2.setMatricula("HK346"); av2.setVelocidad(300);
		av2.setNumeroPasajeros(150);
		
		Carga c1 = new Carga();
		c1.setMatricula("GOD2412"); c1.setVelocidad(1000);
		
		Paquete p = new Paquete();
		p.setNombre("Cartas al niño Dios"); p.setPeso(255000.0);
		c1.addPaquete(p);
		
		Paquete p2 = new Paquete();
		p2.setNombre("Regalos"); p2.setPeso(255000.2);
		c1.addPaquete(p2);
		
		Paquete p3 = new Paquete();
		p3.setNombre("Mirra"); p3.setPeso(12000.0);
		c1.addPaquete(p3);
		
		in.addAviones(av1);
		in.addAviones(av2);
		in.addAviones(c1);
		in.listarAviones();
		
	}
	
	public ArrayList<Avion> getAviones(){
		return aviones;
	}
	
	public void addAviones(Avion avion) {
		aviones.add(avion);
	} 
	
	public void listarAviones() {
		
		for(Avion avion: aviones) {
			avion.visualizar(); 
		}
	}

}
