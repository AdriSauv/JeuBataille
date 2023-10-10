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
	
	public void compareTo() {
		
	}
	
	public void JeuDeBataille() {
		Scanner scanner = new Scanner(System.in);
		Paquet paquet = new Paquet();
		paquet.shuffle();
		
		while(paquet.size() > 0) {
		
			System.out.println("Le joueur pioche  : ");
			scanner.nextLine();
			System.out.println(paquet.pioche());
			
			scanner.nextLine();
			
			System.out.println("\nL'ordinateur pioche : ");
			scanner.nextLine();
			System.out.println(paquet.pioche());
			
			scanner.nextLine();
			//System.out.println(paquet.toString());
			//System.out.println(carte1.compareTo(carte2));
		}
		
	}
	
}
