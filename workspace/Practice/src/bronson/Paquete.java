/**
 * 
 */
package bronson;

/**
 * @author Andres Martinez
 *
 */
public class Paquete {

	private String nombre;
	private double peso;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return peso;
	}
	 
	public void visualizar() {
		System.out.println("Nombre: "+this.nombre+", peso: "+this.peso+" kg");
	}
}
