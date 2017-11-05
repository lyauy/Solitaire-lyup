package soliter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		boolean GG = false ;
		ArrayList<Carte> Paquet = new ArrayList<Carte>();

		for (int i = 1; i < 14; i++) {//On affecte aux cartes leurs symboles
			Carte CarteGen = new Carte(i, "Pi");
			Paquet.add(CarteGen);
			Carte CarteGen1 = new Carte(i, "Ca");
			Paquet.add(CarteGen1);
			Carte CarteGen2 = new Carte(i, "Tr");
			Paquet.add(CarteGen2);
			Carte CarteGen3 = new Carte(i, "Co");
			Paquet.add(CarteGen3);
		}
		Collections.shuffle(Paquet);//On mélange le paquet de cartes
		System.out.println(Paquet.toString());
		PlateauDeJeu A = new PlateauDeJeu(Paquet);	
//		System.out.print(((Carte) Paquet.get(0)).GetFaceCarte());
//		System.out.print(((Carte) Paquet.get(0)).AffichageC());
	
		while(!GG)
		{
			A.Dessin();
			A.Menu();
		}
		System.out.println("e");
	}
}
