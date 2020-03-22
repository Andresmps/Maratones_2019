/**
 * 
 */
package estudianteEntusiasta;

import java.util.Scanner;

/**
 * @author Andres Martinez
 *
 */
public class CompresionMenu {

	public Scanner sc = new Scanner(System.in);
	public CompressionAlgorithm algorithm;
	
	public static void main(String[] args) {
		
		CompresionMenu menu = new CompresionMenu();
		menu.menu();
	}
	
	public void menu() {
		String menu;
		int option;
		
		menu = "\nSeleccione una opción: \n\n"
				+ "1) Comprimir el archivo en zip. \n"
				+ "2) Comprimir el archivo en rar. \n"
				+ "3) Comprimir el archivo en 7z.  \n"
				+ "4) Salir.";
		
		
		System.out.println(menu); 
		option = Integer.valueOf(sc.nextLine());
		options(option);
	}
	
	public void options(int option) {
		
		String filename;
		System.out.println("Digite el nombre del archivo");
		filename = sc.nextLine();
		
		switch(option) {
			case 1:
				algorithm = new Zip();
				break;
			case 2:
				algorithm = new Rar();
				break;
			case 3:
				algorithm = new Zz();
				break;
			case 4:
				System.exit(0);
				break;
		}
		algorithm.compress(filename);
		menu();
	}

}
