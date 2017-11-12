package soliter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlateauDeJeu {
	
	private ArrayList<Carte> Paquet = new ArrayList<Carte>();
	
	//on initialise les 7 colonnes du jeu
	private ArrayList<Carte> Colonne1 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne2 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne3 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne4 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne5 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne6 = new ArrayList<Carte>();
	private ArrayList<Carte> Colonne7 = new ArrayList<Carte>();

	private ArrayList<Carte> Colonne0 = new ArrayList<Carte>();
	private Scanner sc;

	public PlateauDeJeu() {//On distribue dans chaque colonne un nombre de cartes (1,2,3,4,5,6,7)
		DistributionPaquet();
		Collections.shuffle(Paquet); //On m�lange le paquet de cartes
		System.out.println(Paquet.toString());
		DistributionPversColonne();
	}
	public void DistributionPaquet()
	{
		for (int i = 1; i < 14; i++) { //On affecte aux cartes leurs symboles
			Carte CarteGen = new Carte(i, "Pi");
			Paquet.add(CarteGen);
			Carte CarteGen1 = new Carte(i, "Ca");
			Paquet.add(CarteGen1);
			Carte CarteGen2 = new Carte(i, "Tr");
			Paquet.add(CarteGen2);
			Carte CarteGen3 = new Carte(i, "Co");
			Paquet.add(CarteGen3);
		}
	}
	public void DistributionPversColonne()
	{
		DistributionColonne(Paquet, Colonne1, 1, 0);
		DistributionColonne(Paquet, Colonne2, 2, 1);
		DistributionColonne(Paquet, Colonne3, 3, 3);
		DistributionColonne(Paquet, Colonne4, 4, 6);
		DistributionColonne(Paquet, Colonne5, 5, 10);
		DistributionColonne(Paquet, Colonne6, 6, 15);
		DistributionColonne(Paquet, Colonne7, 7, 21);

		DistributionColonne(Paquet, Colonne0, 24, 28);
	}
	public void DeplacePile(int choix1, int choix2, int NumLigneDeplace)
	{
		if (Fonctions.ConditionNUM(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-NumLigneDeplace),
				Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1)))
		{
			for (int i = NumLigneDeplace ; i != 0 ; i--)
			{			
				Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-i));			
				Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size()-i);
			}
		}
	}
	public int NbrCarteAgir(Scanner sc)
	{
		System.out.println("Voulez-vous d�placer \n 1. Une carte ?\n 2. Plusieurs cartes ?");
		int ChoixBase = sc.nextInt();
		int NumLigneDeplace = 0;
		if (ChoixBase == 2) {
			System.out.println("Indiquer le nombre de cartes � deplacer !");
			NumLigneDeplace = sc.nextInt();
			return NumLigneDeplace;
		} else
			return 1;
	}
	public void DeplaceUneCarte(int choix1, int choix2) {
		if (Fonctions.ConditionNUM(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1),
				Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1)))
		{
			Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1));
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size() - 1);
		}
	}
	public void DeplaceUneCarteDeck(int choix1, int choix2)
	{
		if (Fonctions.ConditionNUM(Colonne0.get(0), Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1))) {
			Choix2Colonne(choix2).add(Colonne0.get(0));
			Colonne0.remove(0);
		}
	}
	public void PiocheSuivante()
	{
		Colonne0.add(Colonne0.get(0));
		Colonne0.remove(0);
	}
	
	public static void DistributionColonne(ArrayList<Carte> Paquet, ArrayList<Carte> Colonne, int CarteDistrib,
			int IStart) { //On r�partit les cartes dans chaque colonne (28 cartes � r�partir)
		for (int i = IStart; i != (CarteDistrib + IStart); i++) {
			Colonne.add(Paquet.get(i));
		}
	}
	public void Affichage() {

		int SizeMax = Fonctions.SizeMax(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);

		for (int i = 0; i != SizeMax; i++) // On met face cach�e toutes les cartes d'une colonne sauf la derni�re carte de la colonne
		{
			if (i < Colonne1.size()) {
				if (((Carte) Colonne1.get(i)).getFaceCarte() && !Colonne1.isEmpty())
					System.out.print(Colonne1.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne2.size()) {
				if (((Carte) Colonne2.get(i)).getFaceCarte()&& !Colonne2.isEmpty())
					System.out.print(Colonne2.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne3.size()) {
				if (((Carte) Colonne3.get(i)).getFaceCarte()&& !Colonne3.isEmpty())
					System.out.print(Colonne3.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne4.size()) {
				if (((Carte) Colonne4.get(i)).getFaceCarte()&& !Colonne4.isEmpty())
					System.out.print(Colonne4.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne5.size()) {
				if (((Carte) Colonne5.get(i)).getFaceCarte()&& !Colonne5.isEmpty())
					System.out.print(Colonne5.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne6.size()) {
				if (((Carte) Colonne6.get(i)).getFaceCarte()&& !Colonne6.isEmpty())
					System.out.print(Colonne6.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne7.size()) {
				if (((Carte) Colonne7.get(i)).getFaceCarte()&& !Colonne7.isEmpty())
					System.out.print(Colonne7.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			System.out.println("");

		}
	}
	public ArrayList<Carte> Choix2Colonne(int choix2) {
		switch (choix2) { //On retourne la colonne choisie par l'utilisateur (choix 2), ce choix est l'ajout d'une carte dans une colonne
		case 1:
			return Colonne1;
		case 2:
			return Colonne2;
		case 3:
			return Colonne3;
		case 4:
			return Colonne4;
		case 5:
			return Colonne5;
		case 6:
			return Colonne6;
		case 7:
			return Colonne7;
		case 8:
			return Colonne0;
		default:
			return null;

		}
	}
	public void Dessin() {//"Interface" du jeu avec le titre et les piles de carte
		Fonctions.setDerniereCarteTrue(Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
		System.out.println(
				"\n------------------------------------------------- SOLITAIRE -------------------------------------------------");
		System.out.println("[" + Colonne0.get(0) + "]\t\t\t\t\t [] [] [] [] \n\n");
		Affichage();
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------");
	}
	public void Menu() 
	{
		sc = new Scanner(System.in);
		int NumLigneDeplace = NbrCarteAgir(sc);
		
		System.out.println(
				"Que voulez-vous selectionner ? \n 0. Une nouvelle Carte \n 1. La/les carte de la 1�re Colonne\n 2. La/les carte de la 2i�me Colonne"
						+ "\n 3. La/les carte de la 3i�me Colonne\n 4. La/les carte de la 4i�me Colonne\n 5. La/les carte de la 5i�me Colonne"
						+ "\n 6. La/les carte de la 6i�me Colonne\n 7. La/les carte de la 7i�me Colonne\n 8. La carte du Deck");

		int choix1 = sc.nextInt();	
		
		if (choix1 == 0) 
		{
			PiocheSuivante();
		} 
		else {
			for (int y = NumLigneDeplace; y != 0; y--)
				System.out.println("\nVous avez la/les carte(s) '"+Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-y)+"' en main.");
			/**
			 * PROBLEME AK LE DECK . . . .. . .. . . . . . . . . . .  .. . . . . .. . .. . .  . . . .. . ......................... . . . ..  . .
			 */
			System.out.println(
					"\nOu voulez-vous d�placer cette/ces carte(s) ?\n 1. Dans le 1er paquet\n 2. Dans le 2i�me paquet\n 3. Dans le 3i�me paquet"
							+ "\n 4. Dans le 4i�me paquet\n 5. Dans le 5i�me paquet\n 6. Dans le 6i�me paquet\n 7. Dans le 7i�me paquet \n 8. Retour");
			int choix2 = sc.nextInt();
			if (choix2 == 8) 
				return;
			if (NumLigneDeplace == 1) 
			{
				if (choix1 != 8) 
					DeplaceUneCarte(choix1, choix2);
				else 
					DeplaceUneCarteDeck(choix1, choix2);
			} else
				DeplacePile(choix1, choix2, NumLigneDeplace);
			 }
	}
}
