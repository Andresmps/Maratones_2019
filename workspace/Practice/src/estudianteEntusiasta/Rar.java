/**
 * 
 */
package estudianteEntusiasta;

/**
 * @author Andres Martinez
 *
 */
public class Rar implements CompressionAlgorithm {

	@Override
	public void compress(String filename) {
		System.out.println("creating "+filename+".rar");
	}

}
