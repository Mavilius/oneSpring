package origin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TrikampisMusuIsFailo extends TrikampisMusuIsIvedimo {
	
	public String failas;
	
	public TrikampisMusuIsFailo() {
		
		super();
	}
	
	public TrikampisMusuIsFailo( String failas) {
		
		super();
		this.failas = failas;
	}
	public Double[] atiduokSarasa() throws IOException{
		
		File trikampio_failas = new File("C:\\Users\\Mavi\\Desktop\\trikampis.csv");
        BufferedReader krastines = new BufferedReader( new FileReader(trikampio_failas ) );
        String krastine;  
        Double[] atkarpos = new Double[ 20 ];		
        int n = 0;
        
		while ((krastine = krastines.readLine())!=null) {
			System.out.print("Iveskite krastine: ");	
			atkarpos[ n ] = Double.parseDouble(krastine);
			n++;
		
		}        
		this.n = n;
		return atkarpos;
	}
}
