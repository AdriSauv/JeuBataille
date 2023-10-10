package bataille;

import java.util.*;

public class Carte {
	
	enum VALEUR {
		DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS
	}
	
	enum COULEUR {
		COEUR, CARREAU, TREFLE, PIQUE
	}

	private VALEUR valeurCarte;
    private COULEUR couleurCarte;

    public Carte(VALEUR valeur, COULEUR couleur) {
        this.valeurCarte = valeur;
        this.couleurCarte = couleur;
    }
	
	
	public VALEUR getValeurCarte() {
		return valeurCarte;
	}


	public COULEUR getCouleurCarte() {
		return couleurCarte;
	}


	
	public String toString() {
		return valeurCarte + " de " + couleurCarte + "\n";
	}

	public int compareTo(Carte otherCarte) {
	    return this.getValeurCarte().compareTo(otherCarte.getValeurCarte());
	}
	
}
