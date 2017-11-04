package soliter;

import java.util.ArrayList;
import java.util.Scanner;

public class PlateauDeJeu {

	ArrayList<Object> Colonne1 = new ArrayList<Object>();
	ArrayList<Object> Colonne2 = new ArrayList<Object>();
	ArrayList<Object> Colonne3 = new ArrayList<Object>();
	ArrayList<Object> Colonne4 = new ArrayList<Object>();
	ArrayList<Object> Colonne5 = new ArrayList<Object>();
	ArrayList<Object> Colonne6 = new ArrayList<Object>();
	ArrayList<Object> Colonne7 = new ArrayList<Object>();

	ArrayList<Object> Colonne0 = new ArrayList<Object>();
	private Scanner sc;

	public PlateauDeJeu(ArrayList<Object> Paquet) {
		Fonctions.DistributionColonne(Paquet, Colonne1, 1, 0);
		Fonctions.DistributionColonne(Paquet, Colonne2, 2, 1);
		Fonctions.DistributionColonne(Paquet, Colonne3, 3, 3);
		Fonctions.DistributionColonne(Paquet, Colonne4, 4, 6);
		Fonctions.DistributionColonne(Paquet, Colonne5, 5, 10);
		Fonctions.DistributionColonne(Paquet, Colonne6, 6, 15);
		Fonctions.DistributionColonne(Paquet, Colonne7, 7, 21);

		Fonctions.DistributionColonne(Paquet, Colonne0, 24, 28);
		// System.out.println(Colonne1.toString());
		// System.out.println(Colonne2.toString());
		// System.out.println(Colonne3.toString());
		// System.out.println(Colonne4.toString());
		// System.out.println(Colonne5.toString());
		// System.out.println(Colonne6.toString());
		// System.out.println(Colonne7.toString());
		// System.out.println(Colonne0.toString());
		((Carte) Colonne1.get(0)).SetFaceCarteTrue();
		((Carte) Colonne2.get(1)).SetFaceCarteTrue();
		((Carte) Colonne3.get(2)).SetFaceCarteTrue();
		((Carte) Colonne4.get(3)).SetFaceCarteTrue();
		((Carte) Colonne5.get(4)).SetFaceCarteTrue();
		((Carte) Colonne6.get(5)).SetFaceCarteTrue();
		((Carte) Colonne7.get(6)).SetFaceCarteTrue();
	}

	public void Dessin() {
		System.out.println(
				"\n------------------------------------------------- SOLITAIRE -------------------------------------------------");
		System.out.println("[" + Colonne0.get(0) + "]\n\n");
		Fonctions.Affichage2(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------");
	}

	public void Menu() {
		sc = new Scanner(System.in);
		System.out.println(
				"Que voulez-vous selectionner ? \n1. Une nouvelle Carte \n2. La carte de la 1ère Colonne\n3. La carte de la 2ième Colonne"
						+ "\n4. La carte de la 3ième Colonne\n5. La carte de la 4ième Colonne\n6. La carte de la 5ième Colonne"
						+ "\n7. La carte de la 6ième Colonne\n8. La carte de la 7ième Colonne\n9. La carte du Deck");
		int choix1 = sc.nextInt();

		if (choix1 != 1) {
			System.out.println(
					"Ou voulez-vous déplacer cette carte ?\n 1. Dans le 1er paquet\n 2. Dans le 2ième paquet\n 3. Dans le 3ième paquet"
							+ "\n 4. Dans le 4ième paquet\n 5. Dans le 5ième paquet\n 6. Dans le 6ième paquet\n 7. Dans le 7ième paquet \n 8. Retour");
			int choix2 = sc.nextInt();

			// Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2,
			// Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
			// Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3,
			// Colonne4, Colonne5, Colonne6, Colonne7);
			
			//Erreur out of bounds . . . .. .  .. . 
			Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							.get(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							.size());
			Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							.remove(Fonctions
							.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							.size());

		} else {
			Colonne0.add(Colonne0.get(0));
			Colonne0.remove(0);
		}
	}
}
