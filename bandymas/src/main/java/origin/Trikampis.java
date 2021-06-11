package origin;

public class Trikampis {

	public double a;
	public double b;
	public double c;
	public double s;
	public double plotas;
	
	public Trikampis(){}
	
	public Trikampis(double k1, double k2, double k3){
		a = k1;
		b = k2;
		c = k3;
		s=(a+b+c)/2;
		plotas=Math.sqrt(s*(s-a)*(s-b)*(s-c));	
	}
	
	public boolean arTrikampis() {
		return (((a + b) > c) && ((b + c) > a) && ((c + a) > b));
	}
	
	public static boolean arTrikampis(double a, double b, double c) {
		return (((a + b) > c) && ((b + c) > a) && ((c + a) > b));
	}
	public boolean arLygiasonis() {
		return ((a == b ) || (a == c) || (b == c));
	}
	
	public static boolean arLygiasonis(double a, double b, double c) {
		return ((a == b ) || (a == c) || (b == c));
	}
	
	public  boolean arStatusis() {
		return (((a*a)+(b*b)==(c*c)) || ((a*a)+(c*c)==(b*b)) || ((c*c)+(b*b)==(a*a)));
	}
	
	public static boolean arStatusis(double a, double b, double c) {
		return (((a*a)+(b*b)==(c*c)) || ((a*a)+(c*c)==(b*b)) || ((c*c)+(b*b)==(a*a)));
	}
	
	public boolean arLygiakrastis() {
		return ((a == b) && (a == c) && (b == c));
	}
	
	public static boolean arLygiakrastis(double a, double b, double c) {
		return ((a == b) && (a == c) && (b == c));
	}
		
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	
	
	
}
