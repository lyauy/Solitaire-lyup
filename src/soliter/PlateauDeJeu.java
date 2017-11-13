package soliter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlateauDeJeu extends FonctionsES{
	
	private ArrayList<Carte> Paquet = new ArrayList<Carte>();
	
	//on initialise les 7 colonnes du jeu
	private ArrayList<ArrayList<Carte>> nbColonne = new ArrayList<ArrayList<Carte>>();
	
	private ArrayList<Carte> Colonne = new ArrayList<Carte>();
	
	private ArrayList<ArrayList<Carte>> ArraydArray4 = new ArrayList<ArrayList<Carte>>();
	private Carte Carte0 = new Carte(0, "♠");
	private Carte Carte1 = new Carte(0, "♦");
	private Carte Carte2 = new Carte(0, "♣");
	private Carte Carte3 = new Carte(0, "♥");
	private Scanner sc;

	public PlateauDeJeu() {//On distribue dans chaque colonne un nombre de cartes (1,2,3,4,5,6,7)
		DistributionPaquet();
		Collections.shuffle(Paquet); //On mélange le paquet de cartes
		DistributionPversColonne();
		Creation4Array();
	}
	
	
	public void Creation4Array(){
        for (int i=0;i<4;i++)
        {
            ArrayList<Carte> newPile = new ArrayList<Carte>();
            ArraydArray4.add(newPile);
        }
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
	
	public void DistributionPversColonne(){

        int total=0;
        for (int i=1;i<8;i++)
        {
            ArrayList <Carte> newColonne = new ArrayList <Carte>();
            DistributionColonne(Paquet, newColonne, i, total);
            total=total+i;
            nbColonne.add(newColonne);
        }
        DistributionColonne(Paquet, Colonne, 24, 28);
        nbColonne.add(Colonne);
         }
	
	public void DistributionColonne(ArrayList<Carte> Paquet, ArrayList<Carte> Colonne, int CarteDistrib,
			int IStart) { //On répartit les cartes dans chaque colonne (28 cartes à répartir)
		for (int i = IStart; i != (CarteDistrib + IStart); i++) {
			Colonne.add(Paquet.get(i));
		}
	}
	
	
	public ArrayList<Carte> Choix2Colonne(int choix2) {
		switch (choix2) { //On retourne la colonne choisie par l'utilisateur (choix 2), ce choix est l'ajout d'une carte dans une colonne
		case 1:
			return nbColonne.get(0);
		case 2:
			return nbColonne.get(1);
		case 3:
			return nbColonne.get(2);
		case 4:
			return nbColonne.get(3);
		case 5:
			return nbColonne.get(4);
		case 6:
			return nbColonne.get(5);
		case 7:
			return nbColonne.get(6);
		case 8:
			return nbColonne.get(7);
		default:
			return null;
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
	
	public boolean EstUnRoi(int choix1, int choix2, int NumLigneDeplace)
	{
		if (Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - NumLigneDeplace).getNumCarte() == "Ro")
			return true;
		else 
			return false;
	}
	
	public boolean ConditionPourWin()
	{
		if (nbColonne.get(0).isEmpty()&&nbColonne.get(1).isEmpty()&&nbColonne.get(2).isEmpty()&&nbColonne.get(3).isEmpty()
				&&nbColonne.get(4).isEmpty()&&nbColonne.get(5).isEmpty()&&nbColonne.get(6).isEmpty())
		{
			System.out.println("Félicitations vous avez gagné ! (╯°□°）╯︵ ┻━┻");
			return true;
		}
		else
			return false;
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
	
	public void DeplaceUneCarte(int choix1, int choix2) {
		if (ConditionNUM(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1),
				Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1)))
		{
			Choix2Colonne(choix2).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1));
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size() - 1);
		}
	}
	
	public void DeplaceUneCarteDeck(int choix1, int choix2)
	{
		if (ConditionNUM(nbColonne.get(7).get(0), Choix2Colonne(choix2).get(Choix2Colonne(choix2).size() - 1))) {
			Choix2Colonne(choix2).add(nbColonne.get(7).get(0));
			nbColonne.get(7).remove(0);
		}
	}

	public void DeplaceUneCarteDeckRoi(int choix1, int choix2)
	{
			Choix2Colonne(choix2).add(nbColonne.get(7).get(0));
			nbColonne.get(7).remove(0);
	}
	
	
	public void Deplacement4pile(int choix1, int choix2)
	{
		int x = 0;
			switch (Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1).getSymboleCarte())
			{
			case "♠":
				x = 0;
				break;
			case "♦":
				x = 1;
				break;
			case "♣":
				x = 2;
				break;
			case "♥":
				x = 3;
				break;
			}
		if((Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-1).getNumCarteInt()-1) == (ArraydArray4.get(x).get(ArraydArray4.get(x).size()-1).getNumCarteInt()))
		{	
			System.out.println("Carte Base : "+(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-1).toString()+" / Carte Dessus : "+(ArraydArray4.get(x).get(ArraydArray4.get(x).size()-1).toString())));
			ArraydArray4.get(x).add(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size() - 1));
			Choix2Colonne(choix1).remove(Choix2Colonne(choix1).size() - 1);	
		}
		else
		{
			System.out.println("Déplacement interdit !");
			System.out.println("Carte Base : "+(Choix2Colonne(choix1).get(Choix2Colonne(choix1).size()-1).toString()+" / Carte Dessus : "+(ArraydArray4.get(x).get(ArraydArray4.get(x).size()-1).toString())));
		}
	}
	
	
	public void Deplacement4pileDeck(int choix1, int choix2)
	{
		int x = 0;
		switch (nbColonne.get(7).get(0).getSymboleCarte()) {
		case "♠":
			x = 0;
			break;
		case "♦":
			x = 1;
			break;
		case "♣":
			x = 2;
			break;
		case "♥":
			x = 3;
			break;
		}
		if ((nbColonne.get(7).get(0).getNumCarteInt() - 1) == (ArraydArray4.get(x).get(ArraydArray4.get(x).size() - 1)
				.getNumCarteInt())) {
			System.out.println("Carte Base : " + (nbColonne.get(7).get(0).toString() + " / Carte Dessus : "
					+ (ArraydArray4.get(x).get(ArraydArray4.get(x).size() - 1).toString())));
			ArraydArray4.get(x).add(nbColonne.get(7).get(0));
			nbColonne.get(7).remove(0);
		} else {
			System.out.println("Déplacement interdit !");
			System.out.println("Carte Base : " + (nbColonne.get(7).get(0)).toString() + " / Carte Dessus : "
					+ (ArraydArray4.get(x).get(ArraydArray4.get(x).size() - 1).toString()));
		}
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
	
		
	public void PiocheSuivante()
	{
		nbColonne.get(7).add(nbColonne.get(7).get(0));
		nbColonne.get(7).remove(0);
	}
		
	public void setDerniereCarteTrue()//On affiche la dernière carte de chaque colonne
	{
		if (!nbColonne.get(7).isEmpty())
			nbColonne.get(7).get(0).setFaceCarteTrue();
		if (!nbColonne.get(0).isEmpty())
			nbColonne.get(0).get((nbColonne.get(0).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(1).isEmpty())
			nbColonne.get(1).get((nbColonne.get(1).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(2).isEmpty())
			nbColonne.get(2).get((nbColonne.get(2).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(3).isEmpty())
			nbColonne.get(3).get((nbColonne.get(3).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(4).isEmpty())
			nbColonne.get(4).get((nbColonne.get(4).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(5).isEmpty())
			nbColonne.get(5).get((nbColonne.get(5).size() - 1)).setFaceCarteTrue();
		if (!nbColonne.get(6).isEmpty())
			nbColonne.get(6).get((nbColonne.get(6).size() - 1)).setFaceCarteTrue();
	}
	
	public void Affichage() {

		int SizeMax = SizeMax(nbColonne.get(0), nbColonne.get(1), nbColonne.get(2), nbColonne.get(3), nbColonne.get(4), nbColonne.get(5), nbColonne.get(6));

		for (int i = 0; i != SizeMax; i++) // On met face cachée toutes les cartes d'une colonne sauf la dernière carte de la colonne
		{
			if (i < nbColonne.get(0).size()) {
				if (((Carte) nbColonne.get(0).get(i)).getFaceCarte() && !nbColonne.get(0).isEmpty())
					System.out.print(nbColonne.get(0).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(1).size()) {
				if (((Carte) nbColonne.get(1).get(i)).getFaceCarte()&& !nbColonne.get(1).isEmpty())
					System.out.print(nbColonne.get(1).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(2).size()) {
				if (((Carte) nbColonne.get(2).get(i)).getFaceCarte()&& !nbColonne.get(2).isEmpty())
					System.out.print(nbColonne.get(2).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(3).size()) {
				if (((Carte) nbColonne.get(3).get(i)).getFaceCarte()&& !nbColonne.get(3).isEmpty())
					System.out.print(nbColonne.get(3).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(4).size()) {
				if (((Carte) nbColonne.get(4).get(i)).getFaceCarte()&& !nbColonne.get(4).isEmpty())
					System.out.print(nbColonne.get(4).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(5).size()) {
				if (((Carte) nbColonne.get(5).get(i)).getFaceCarte()&& !nbColonne.get(5).isEmpty())
					System.out.print(nbColonne.get(5).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			if (i < nbColonne.get(6).size()) {
				if (((Carte) nbColonne.get(6).get(i)).getFaceCarte()&& !nbColonne.get(6).isEmpty())
					System.out.print(nbColonne.get(6).get(i) + "  ");
				else
					System.out.print("[???????]" + "  ");
			} else
				System.out.print("           ");
			System.out.println("");

		}
	}
	
	public void AutoWin()
	{
		nbColonne.get(0).clear();
		nbColonne.get(1).clear();
		nbColonne.get(2).clear();
		nbColonne.get(3).clear();
		nbColonne.get(4).clear();
		nbColonne.get(5).clear();
		nbColonne.get(6).clear();
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
	
	public void Dessin() {//"Interface" du jeu avec le titre et les piles de carte
		setDerniereCarteTrue();
		System.out.println(
				"\n---------------------------------------------- SOLITAIRE ♠ ♣ ♥ ♦ -------------------------------------------------");
		System.out.println(nbColonne.get(7).get(0) + "\t\t\t\t "+ArraydArray4.get(0).get(ArraydArray4.get(0).size()-1)+" "+ArraydArray4.get(1).get(ArraydArray4.get(1).size()-1)+" "
				+ ""+ArraydArray4.get(2).get(ArraydArray4.get(2).size()-1)+" "+ArraydArray4.get(3).get(ArraydArray4.get(3).size()-1)+" \n\n");
		Affichage();
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------");
	}
	
	public void Menu() 
	{
		sc = new Scanner(System.in);		
		System.out.println(
				"Que voulez-vous selectionner ? \n 0. Une nouvelle Carte \n 1. La/les carte de la 1ère Colonne\n 2. La/les carte de la 2ième Colonne"
						+ "\n 3. La/les carte de la 3ième Colonne\n 4. La/les carte de la 4ième Colonne\n 5. La/les carte de la 5ième Colonne"
						+ "\n 6. La/les carte de la 6ième Colonne\n 7. La/les carte de la 7ième Colonne\n 8. La carte du Deck");
		try
		{
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
					System.out.println("\nVous avez la carte : "+nbColonne.get(7).get(0)+" en main.");
				else
					CarteEnMain(choix1, NumLigneDeplace);	
				System.out.println(
						"\nOu voulez-vous déplacer cette/ces carte(s) ?\n 1. Dans le 1er paquet\n 2. Dans le 2ième paquet\n 3. Dans le 3ième paquet"
								+ "\n 4. Dans le 4ième paquet\n 5. Dans le 5ième paquet\n 6. Dans le 6ième paquet\n 7. Dans le 7ième paquet \n 8. Retour\n 9. Dans les piles");
				int choix2 = sc.nextInt();
				if (choix2 == 8) 
					return;
				if (NumLigneDeplace == 1) 
				{
					if(choix2 == 9 && choix1 != 8)
					{
						Deplacement4pile(choix1, choix2);
					}
					else if (choix2 == 9 && choix1 == 8)
						Deplacement4pileDeck(choix1, choix2);
					else
					{
						if (choix1 != 8 && !EstUnRoi(choix1, choix2, NumLigneDeplace)) 
							DeplaceUneCarte(choix1, choix2);
						else if (EstUnRoi(choix1, choix2, NumLigneDeplace)&& Choix2Colonne(choix2).isEmpty())
							DeplaceRoi(choix1, choix2, NumLigneDeplace);
						else if(nbColonne.get(7).get(0).getNumCarte() == "Ro")
							DeplaceUneCarteDeckRoi(choix1, choix2);
						else 
							DeplaceUneCarteDeck(choix1, choix2);
					}
				} else
					if(EstUnRoi(choix1, choix2, NumLigneDeplace))
						DeplacePileAkRoi(choix1, choix2, NumLigneDeplace);
					else
						DeplacePile(choix1, choix2, NumLigneDeplace);
				 }
		}
		catch(InputMismatchException | java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException | IllegalArgumentException e)
		{
			System.out.println(e+" Veuillez saisir un nombre valide !");
		}
	}
}
