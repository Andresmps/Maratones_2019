package bronson;

/**
 * @author Andres Martinez
 *
 */

public abstract class Avion {

	private int velocidad;
	private String matricula;
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad < 0 ? 0: velocidad;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public abstract void visualizar();
}
