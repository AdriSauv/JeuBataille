package bataille;
import java.util.*;


public class Paquet {
	
	private List<Carte> paquet = new ArrayList<Carte>();
	
	public Paquet() {
        for (Carte.COULEUR couleur : Carte.COULEUR.values()) {
            for (Carte.VALEUR valeur : Carte.VALEUR.values()) {
                paquet.add(new Carte(valeur, couleur));
            }
        }
    }
	
	public String toString() {
		String result = "";
		for(Carte carte : paquet) {
			result += carte;
		}
		return result;
	}
	
	public int size() {
		return paquet.size();
	}
	
	public void shuffle() {
		Collections.shuffle(paquet);
	}
	
	public Carte pioche() {
		Random random = new Random();
		int index = random.nextInt(paquet.size());
		Carte carte = paquet.remove(index);
		return carte;
	}

	

	
	public void JeuDeBataille() {
		Scanner scanner = new Scanner(System.in);
		Paquet paquet = new Paquet();
		int scoreJ = 0;
		int scoreO = 0;
		paquet.shuffle();
		
		while(paquet.size() > 0) {
			
			Carte carteJoueur = paquet.pioche();
			System.out.println("\nLe joueur pioche  : " + carteJoueur);
					
			scanner.nextLine();
			
			Carte carteOrdi = paquet.pioche();
			System.out.println("L'ordinateur pioche : " + carteOrdi);
			
			scanner.nextLine();
			
			int result = carteJoueur.compareTo(carteOrdi);
			if(result>0) {
				scoreJ += 2;
				System.out.println("Le joueur remport la bataille, +2 points.");
				scanner.nextLine();
			}
			if(result<0) {
				scoreO += 2;
				System.out.println("L'ordinateur remport la bataille, +2 points.");
				scanner.nextLine();
			} 
			if(result==0){
				System.out.println("Egalité, piochez une carte chacun");
				scanner.nextLine();
				
				Carte carteJoueur2 = paquet.pioche();
				System.out.println(carteJoueur2);
				
				scanner.nextLine();
				
				Carte carteOrdi2 = paquet.pioche();	
				System.out.println(carteOrdi2);
				
				scanner.nextLine();
				
				int result2 = carteJoueur2.compareTo(carteOrdi2);
				
				if(result2>0) {
					scoreJ += 3;
					System.out.println("Le joueur remport la bataille, +3 points.");
					scanner.nextLine();
				}
				if(result2<0) {
					scoreO += 3;
					System.out.println("L'ordinateur remport la bataille, +3 points.");
					scanner.nextLine();
				} 
			}
			
		}
		
		int scoreFinal = scoreJ - scoreO;
		if(scoreFinal > 0) {
			System.out.println("Le joueur a remporté la partie avec " + scoreFinal + " points.");
		} else {
			System.out.println("L'ordinateur a remporté la partie avec " + Math.abs(scoreFinal) + " points.");
		}
	}
	
}
