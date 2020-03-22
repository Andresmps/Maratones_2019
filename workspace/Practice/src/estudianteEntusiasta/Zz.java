/**
 * 
 */
package estudianteEntusiasta;

/**
 * @author Andres Martinez
 *
 */
public class Zz implements CompressionAlgorithm {

	@Override
	public void compress(String filename) {
		System.out.println("creating "+filename+".7z");
	}
}
