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

	ArrayList<ArrayList<Carte>> ArraydArray4 = new ArrayList<ArrayList<Carte>>();
	Carte Carte0 = new Carte(0, "♠");
	Carte Carte1 = new Carte(0, "♦");
	Carte Carte2 = new Carte(0, "♣");
	Carte Carte3 = new Carte(0, "♥");
	
	private ArrayList<Carte> Colonne0 = new ArrayList<Carte>();
	private Scanner sc;

	public PlateauDeJeu() {//On distribue dans chaque colonne un nombre de cartes (1,2,3,4,5,6,7)
		DistributionPaquet();
		Collections.shuffle(Paquet); //On mélange le paquet de cartes
		System.out.println(Paquet.toString());
		DistributionPversColonne();
		Creation4Array();
	}
	
	public void Creation4Array()
	{
		ArrayList<Carte> Case1 = new ArrayList<Carte>();
		ArrayList<Carte> Case2 = new ArrayList<Carte>();
		ArrayList<Carte> Case3 = new ArrayList<Carte>();
		ArrayList<Carte> Case4 = new ArrayList<Carte>();
		ArraydArray4.add(Case1);	
		ArraydArray4.add(Case2);
		ArraydArray4.add(Case3);
		ArraydArray4.add(Case4);	
		ArraydArray4.get(0).add(Carte0);
		ArraydArray4.get(1).add(Carte1);
		ArraydArray4.get(2).add(Carte2);
		ArraydArray4.get(3).add(Carte3);		
	}
	
	public void DistributionPaquet()
	{
		for (int i = 1; i < 14; i++) { //On affecte aux cartes leurs symboles
			Carte CarteGen = new Carte(i, "♠");
			Paquet.add(CarteGen);
			Carte CarteGen1 = new Carte(i, "♦");
			Paquet.add(CarteGen1);
			Carte CarteGen2 = new Carte(i, "♣");
			Paquet.add(CarteGen2);
			Carte CarteGen3 = new Carte(i, "♥");
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
		if (ConditionNUM(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-NumLigneDeplace),
				Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1)) && ConditionDeplacePile(choix1, choix2, NumLigneDeplace))
		{
			for (int i = NumLigneDeplace ; i != 0 ; i--)
			{			
				Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-i));			
				Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size()-i);
			}
		}
	}
	
	public void DeplacePileAkRoi(int choix1, int choix2, int NumLigneDeplace)
	{
		for (int i = NumLigneDeplace ; i != 0 ; i--)
		{			
			Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-i));			
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size()-i);
		}
	}
	
	public int NbrCarteAgir(Scanner sc)
	{
		System.out.println("Voulez-vous déplacer \n 1. Une carte ?\n 2. Plusieurs cartes ?");
		int ChoixBase = sc.nextInt();
		int NumLigneDeplace = 0;
		if (ChoixBase == 2) {
			System.out.println("Indiquer le nombre de cartes à deplacer !");
			NumLigneDeplace = sc.nextInt();
			return NumLigneDeplace;
		} else
			return 1;
	}
	
	public void DeplaceUneCarte(int choix1, int choix2) {
		if (ConditionNUM(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1),
				Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1)))
		{
			Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1));
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size() - 1);
		}
	}
	
	public boolean ConditionNUM(Carte CarteBase, Carte CarteDessus) //On indique si l'ajout de la carte dans tel colonne est possible
	{
		if ((CarteBase.getNumCarteInt()+1) != (CarteDessus.getNumCarteInt()) || !Fonctions.ConditionCouleur(CarteBase, CarteDessus))
			{
			//Cas où la carte ne peut pas être déplacée dans la colonne choisie (cas où par exemple la valeur n'est pas un rang en dessous de la carte de la colonne choisie ET la couleur est la même que la carte de colonne choisie
			System.out.println("Carte Base : "+CarteBase.toString()+" / Carte Dessus : "+CarteDessus.toString());
				System.out.println("Déplacement interdit !");
				return false;
			}
		else 
		{	//Cas où la carte peut être déplacée dans la colonne choisie (cas où par exemple la valeur est un rang en dessous de la carte de la colonne choisie 
			 //ET la couleur est différente de la carte de colonne choisie
			System.out.println("Carte Base : "+CarteBase.toString()+" / Carte Dessus : "+CarteDessus.toString());
			System.out.println("Déplacement autorisé !");
			return true;
		}
	}
	
	public boolean ConditionDeplacePile(int choix1, int choix2, int NumLigneDeplace) {
		int x = 0;
		for (int i = NumLigneDeplace; i != 0; i--) {
			if (Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - i).getFaceCarte()) {
				x++;
			}
		}
		if (x == NumLigneDeplace)
			return true;
		else
			{System.out.println("impossible de deplacer des cartes non retournés");
			return false;}
	}
	
	public void DeplaceRoi(int choix1, int choix2, int NumLigneDeplace) {
		if (EstUnRoi(choix1, choix2, NumLigneDeplace)&& Choix2Colonne(choix2).isEmpty()) 
		{
			System.out.println("Déplacement autorisé ! Roi");
			Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - NumLigneDeplace));
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - NumLigneDeplace));
		} else
			{
			System.out.println("Déplacement interdit ! Roi");
			}
	}
	
	public boolean EstUnRoi(int choix1, int choix2, int NumLigneDeplace)
	{
		if (Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - NumLigneDeplace).getNumCarte() == "Ro")
			return true;
		else 
			return false;
	}
		
	public void DeplaceUneCarteDeck(int choix1, int choix2)
	{
		if (ConditionNUM(Colonne0.get(0), Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1))) {
			Choix2Colonne(choix2).add(Colonne0.get(0));
			Colonne0.remove(0);
		}
	}
	
	public void PiocheSuivante()
	{
		Colonne0.add(Colonne0.get(0));
		Colonne0.remove(0);
	}
	public boolean ConditionPourWin()
	{
		if (Colonne1.isEmpty()&&Colonne2.isEmpty()&&Colonne3.isEmpty()&&Colonne4.isEmpty()
				&&Colonne5.isEmpty()&&Colonne6.isEmpty()&&Colonne7.isEmpty())
		{
			System.out.println("Félicitations vous avez gagné ! (╯°□°）╯︵ ┻━┻");
			return true;
		}
		else
			return false;
	}
	public static void DistributionColonne(ArrayList<Carte> Paquet, ArrayList<Carte> Colonne, int CarteDistrib,
			int IStart) { //On répartit les cartes dans chaque colonne (28 cartes à répartir)
		for (int i = IStart; i != (CarteDistrib + IStart); i++) {
			Colonne.add(Paquet.get(i));
		}
	}
	public void Affichage() {

		int SizeMax = Fonctions.SizeMax(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);

		for (int i = 0; i != SizeMax; i++) // On met face cachée toutes les cartes d'une colonne sauf la dernière carte de la colonne
		{
			if (i < Colonne1.size()) {
				if (((Carte) Colonne1.get(i)).getFaceCarte() && !Colonne1.isEmpty())
					System.out.print(Colonne1.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne2.size()) {
				if (((Carte) Colonne2.get(i)).getFaceCarte()&& !Colonne2.isEmpty())
					System.out.print(Colonne2.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne3.size()) {
				if (((Carte) Colonne3.get(i)).getFaceCarte()&& !Colonne3.isEmpty())
					System.out.print(Colonne3.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne4.size()) {
				if (((Carte) Colonne4.get(i)).getFaceCarte()&& !Colonne4.isEmpty())
					System.out.print(Colonne4.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne5.size()) {
				if (((Carte) Colonne5.get(i)).getFaceCarte()&& !Colonne5.isEmpty())
					System.out.print(Colonne5.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne6.size()) {
				if (((Carte) Colonne6.get(i)).getFaceCarte()&& !Colonne6.isEmpty())
					System.out.print(Colonne6.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < Colonne7.size()) {
				if (((Carte) Colonne7.get(i)).getFaceCarte()&& !Colonne7.isEmpty())
					System.out.print(Colonne7.get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
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
				"\n---------------------------------------------- SOLITAIRE ♠ ♣ ♥ ♦ -------------------------------------------------");
		System.out.println(Colonne0.get(0) + "\t\t\t\t "+ArraydArray4.get(1).get(0)+" "+ArraydArray4.get(0).get(0)+" "
				+ ""+ArraydArray4.get(2).get(0)+" "+ArraydArray4.get(3).get(0)+" \n\n");
		Affichage();
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------");
	}
	public void AutoWin()
	{
		Colonne1.clear();
		Colonne2.clear();
		Colonne3.clear();
		Colonne4.clear();
		Colonne5.clear();
		Colonne6.clear();
		Colonne7.clear();
	}
	public void CarteEnMain(int choix1, int NumLigneDeplace) {
		int x = 0;
		for (int y = NumLigneDeplace; y != 0; y--) {
			if (Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - y).getFaceCarte())
				x++;	
		}
		if (x == NumLigneDeplace) {
			System.out.print("\nVous avez la/les carte(s) : ");
			for (int y = NumLigneDeplace; y != 0; y--)
				System.out.print(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - y)+" ");
			System.out.println("en main.");
		}
	}
	public void Menu() 
	{
		sc = new Scanner(System.in);		
		System.out.println(
				"Que voulez-vous selectionner ? \n 0. Une nouvelle Carte \n 1. La/les carte de la 1ère Colonne\n 2. La/les carte de la 2ième Colonne"
						+ "\n 3. La/les carte de la 3ième Colonne\n 4. La/les carte de la 4ième Colonne\n 5. La/les carte de la 5ième Colonne"
						+ "\n 6. La/les carte de la 6ième Colonne\n 7. La/les carte de la 7ième Colonne\n 8. La carte du Deck");

		int choix1 = sc.nextInt();	
		int NumLigneDeplace =0;
		if (choix1 == 8 || choix1 == 0)
			NumLigneDeplace = 1;
		else
			NumLigneDeplace = NbrCarteAgir(sc);
		
		if (choix1 == 0) 
		{
			PiocheSuivante();
		} 
		else {
			if (choix1 == 8)	
				System.out.println("\nVous avez la carte : "+Colonne0.get(0)+" en main.");
			else
				CarteEnMain(choix1, NumLigneDeplace);	
			System.out.println(
					"\nOu voulez-vous déplacer cette/ces carte(s) ?\n 1. Dans le 1er paquet\n 2. Dans le 2ième paquet\n 3. Dans le 3ième paquet"
							+ "\n 4. Dans le 4ième paquet\n 5. Dans le 5ième paquet\n 6. Dans le 6ième paquet\n 7. Dans le 7ième paquet \n 8. Retour");
			int choix2 = sc.nextInt();
			if (choix2 == 8) 
				return;
			if (NumLigneDeplace == 1) 
			{
				if (choix1 != 8 && !EstUnRoi(choix1, choix2, NumLigneDeplace)) 
					DeplaceUneCarte(choix1, choix2);
				else if (EstUnRoi(choix1, choix2, NumLigneDeplace)&& Choix2Colonne(choix2).isEmpty())
					DeplaceRoi(choix1, choix2, NumLigneDeplace);
				else 
					DeplaceUneCarteDeck(choix1, choix2);
			} else
				if(EstUnRoi(choix1, choix2, NumLigneDeplace))
					DeplacePileAkRoi(choix1, choix2, NumLigneDeplace);
				else
					DeplacePile(choix1, choix2, NumLigneDeplace);
			 }
	}
}
