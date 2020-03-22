package bronson;

import java.util.ArrayList;

/**
 * @author Andres Martinez
 *
 */

public class Carga extends Avion{
	
	private ArrayList<Paquete> paquetes = new ArrayList<>();
	
	public ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}

	public void addPaquete(Paquete paquete) {
		paquetes.add(paquete);
	}
	
	public void visualizar() {
		System.out.println("Avión de carga matrícula: "+super.getMatricula()+
				", velocidad: "+super.getVelocidad()+" km/h"+", continue:");
		paquetes.forEach(paquete -> paquete.visualizar()); 
	}
}
