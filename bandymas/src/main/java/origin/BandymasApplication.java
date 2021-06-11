package origin;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BandymasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandymasApplication.class, args);
		
		TrikampisMusuIsMaigykles atkarposx = new TrikampisMusuIsMaigykles();
		Double[] atkarpos = atkarposx.atkarpos;
		int n = atkarposx.n;
//		System.out.print("Iveskite krastine: ");	
//		Scanner scan = new Scanner(System.in);
//		Double[] atkarpos = new Double[ 20 ];		
//		Double nuskaityta_atkarpa = scan.nextDouble();
//				
//		int n = 0;
//		
//		while ( nuskaityta_atkarpa != 0) {
//			System.out.print("Iveskite krastine: ");	
//			atkarpos[ n ] = nuskaityta_atkarpa;
//			n++;
//			nuskaityta_atkarpa = scan.nextDouble();
//		}
//		scan.close();			
		
		ArrayList<TrikampisMusu> trikampiai= galimiTrikampiai(atkarpos, n);		
		ArrayList<TrikampisMusu> tikri_trikampiai= new ArrayList<TrikampisMusu>();		
			
										
		//System.out.println(Arrays.toString(atkarpos));
		
		
		System.out.println("Galimi trikampiai: ");
		
		for (TrikampisMusu trikampis:trikampiai){
			
			System.out.println(trikampis.toString() + " " + trikampis.plotas);			
		}
		System.out.println("Galimi status trikampiai: ");
		for (TrikampisMusu trikampis:trikampiai){
			
			if (trikampis.arStatusis()){
				
				System.out.println(trikampis.toString() + " " + trikampis.plotas);
			}	
		}
		System.out.println("Galimi lygiasoniai trikampiai: ");
		for (TrikampisMusu trikampis:trikampiai){
			
			if (trikampis.arLygiasonis()){
				
				System.out.println(trikampis.toString() + " " + trikampis.plotas);
			}	
		}
		System.out.println("Galimi lygiakrasciai trikampiai: ");
		for (TrikampisMusu trikampis:trikampiai){
			
			if (trikampis.arLygiakrastis()){
				
				System.out.println(" Pirma " + "Antra " + "Trecia " + "Plotas ");
				System.out.println(trikampis.toString() + "  " + trikampis.plotas);
			}	
		}
		System.out.println("Trikampio plotai: ");
		for (TrikampisMusu trikampis:trikampiai) {
			
			System.out.println("Plotas: " + trikampis.plotas); 
		}

		System.out.println("Pries: " + trikampiai.size());
		
		while (trikampiai.size() != 0) {
			int	maxIndex=maxPlotoTrikampioNr(trikampiai);
			double max = trikampiai.get(maxIndex).plotas;	
			tikri_trikampiai.add(trikampiai.get(maxIndex));
			System.out.println("Didziausias trikampio plotas: " + max);		
			System.out.println("Didziausio ploto pozicija sarase: " + maxIndex);
			n = atkarposTrynimas(atkarpos, n, trikampiai.get(maxIndex).ai);
			trikampiai= galimiTrikampiai(atkarpos, n);
			
		}
		System.out.println("Po: " + trikampiai.size());		
		
	}

	public static int maxPlotoTrikampioNr(ArrayList<TrikampisMusu> trikampiai) {
		
		double max = trikampiai.get(0).plotas;	
		int maxIndex = 0;
		for (int i=0; i<trikampiai.size(); i++){
			
			if (trikampiai.get(i).plotas > max){
				
				maxIndex=i;
				max = trikampiai.get(i).plotas;				
			}			
		}
		
		return maxIndex;
		
	}
	
	/**
	* metodas, kuris sudaro trikampiu arraylista(sarasa) 
	* sudaryti metoda, kuris is atkarpu masyvo pasalintu nurodyto numerio atkarpa
	* trintiPirmas trintiAntras trintiTrecias
	*/
	private static ArrayList<TrikampisMusu> galimiTrikampiai(Double[] atkarpos, int n){
		
		ArrayList<TrikampisMusu> trikampiai= new ArrayList<TrikampisMusu>();
		
		for (int i = 0; i < n - 2; i++ ) {
		
			for (int  j = i +1; j < n-1; j++ ) {
			
				for (int t = j + 1; t < n; t++ ) { 

					if (Trikampis.arTrikampis ( atkarpos [ i ], atkarpos [ j ], atkarpos [ t ] )) {
							
						trikampiai.add(new TrikampisMusu(atkarpos [ i ], atkarpos [ j ], atkarpos [ t ],i,j,t));
															
					}
				}
			}
		}
		return trikampiai;		
	}
	
	
	public static int atkarposTrynimas(Double[] atkarpos, int n, int numeris){
		
		for (int i = numeris; n > i - 1; i++){
		    atkarpos[i] = atkarpos[i + 1];		    
		}
		n--;
		return n;
	}
	
	public static void trintuve(TrikampisMusu trikampis, Double[] atkarpos) {
		
		int pirmas_trinamas = trikampis.ai;
		int antras_trinamas = trikampis.bi;
		int trecias_trinamas = trikampis.ci;		
		int tarpinis;
		
		if ((antras_trinamas > pirmas_trinamas) && (antras_trinamas > trecias_trinamas)) {
			
			tarpinis = pirmas_trinamas;
			
			pirmas_trinamas = antras_trinamas;
			
			antras_trinamas = tarpinis;
		} else {
			if((trecias_trinamas > pirmas_trinamas) && (antras_trinamas < trecias_trinamas)) {
				
				tarpinis = pirmas_trinamas;
				
				pirmas_trinamas = trecias_trinamas;
				
				trecias_trinamas = tarpinis;
				
				if(trecias_trinamas > antras_trinamas) {
					tarpinis = antras_trinamas;
					
					antras_trinamas = trecias_trinamas;
					
					trecias_trinamas = tarpinis;
				}
			}
		}
	}
		
		
	}


