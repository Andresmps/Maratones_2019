/**
 * 
 */
package bronson;

/**
 * @author Andres Martinez
 *
 */

public class Pasajero extends Avion{

	private int numPasajeros;
	
	public int getNumPasajeros() {
		return numPasajeros;
	}
	
	public void setNumeroPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}
	
	//@Override
	public void visualizar() {
		System.out.println("Avión de pasajeros matrícula: "+super.getMatricula()+
				", capacidad: "+this.numPasajeros+", velocidad: "+super.getVelocidad()+" km/h"); 
	}
	
}
