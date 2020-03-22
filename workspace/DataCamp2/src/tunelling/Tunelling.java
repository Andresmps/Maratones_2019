package tunelling;

public class Tunelling {

	public static void main(String[] args) {
		double a = 30.058056;
		double b = 31.228889;
		double x = 43.466667;
		double y = -80.516667;
		double r = 6371009;
		double c = 2*Math.PI*r;
		
		double AxB = (a*x) + (b*y);
		double AxBl = Math.sqrt((a*a) + (b*b))*Math.sqrt((x*x) + (y*y));
		double theta = (Math.acos(AxB/AxBl)*180)/Math.PI;
		
		double p = (c*theta)/360;
		double q = 2*r*Math.sin(theta/2);
		
		System.out.println(q-p);
		System.out.println(theta);
		System.out.println(AxB);
		System.out.println(AxBl);
	}

}
