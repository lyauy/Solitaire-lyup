package soliter;

import java.util.ArrayList;
import java.util.Scanner;

public class PlateauDeJeu {
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

	public PlateauDeJeu(ArrayList<Carte> Paquet) {//On distribue dans chaque colonne un nombre de cartes (1,2,3,4,5,6,7)
		Fonctions.DistributionColonne(Paquet, Colonne1, 1, 0);
		Fonctions.DistributionColonne(Paquet, Colonne2, 2, 1);
		Fonctions.DistributionColonne(Paquet, Colonne3, 3, 3);
		Fonctions.DistributionColonne(Paquet, Colonne4, 4, 6);
		Fonctions.DistributionColonne(Paquet, Colonne5, 5, 10);
		Fonctions.DistributionColonne(Paquet, Colonne6, 6, 15);
		Fonctions.DistributionColonne(Paquet, Colonne7, 7, 21);

		Fonctions.DistributionColonne(Paquet, Colonne0, 24, 28);
//		((Carte) Colonne1.get(0)).SetFaceCarteTrue();
//		((Carte) Colonne2.get(1)).SetFaceCarteTrue();
//		((Carte) Colonne3.get(2)).SetFaceCarteTrue();
//		((Carte) Colonne4.get(3)).SetFaceCarteTrue();
//		((Carte) Colonne5.get(4)).SetFaceCarteTrue();
//		((Carte) Colonne6.get(5)).SetFaceCarteTrue();
//		((Carte) Colonne7.get(6)).SetFaceCarteTrue();
	}

	public void Dessin() {//"Interface" du jeu avec le titre et les piles de carte
		Fonctions.SetDerniereCarteTrue(Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
		System.out.println(
				"\n------------------------------------------------- SOLITAIRE -------------------------------------------------");
		System.out.println("[" + Colonne0.get(0) + "]\t\t\t\t\t [] [] [] [] \n\n");
		Fonctions.Affichage2(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------");
	}

	public void Menu() 
	{
		sc = new Scanner(System.in);
		System.out.println(
				"Que voulez-vous selectionner ? \n1. Une nouvelle Carte \n2. La carte de la 1�re Colonne\n3. La carte de la 2i�me Colonne"
						+ "\n4. La carte de la 3i�me Colonne\n5. La carte de la 4i�me Colonne\n6. La carte de la 5i�me Colonne"
						+ "\n7. La carte de la 6i�me Colonne\n8. La carte de la 7i�me Colonne\n9. La carte du Deck");

		int choix1 = sc.nextInt();//on demande � l'utilisateur de piocher une nouvelle carte, ou bien de r�cup�rer une carte des 7 colonnes ou du deck

		
		
		if (choix1 != 1) 
		{
			int i=1;
			int compte = Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).get(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
					.size() - get(Fonctions.CompteCach�(choix1,Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7));
			System.out.println(compte);
			System.out.println("Vous avez la carte '"+Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).get(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
					.size() - 1)+"' en main.");
			System.out.println(
					"Ou voulez-vous d�placer cette carte ?\n 1. Dans le 1er paquet\n 2. Dans le 2i�me paquet\n 3. Dans le 3i�me paquet"
							+ "\n 4. Dans le 4i�me paquet\n 5. Dans le 5i�me paquet\n 6. Dans le 6i�me paquet\n 7. Dans le 7i�me paquet \n 8. Retour");
			int choix2 = sc.nextInt();//on demande � l'utilisateur de poser sa carte dans une colonne. Il peut retourner � l'�tape d'avant avec retour.

			if(choix2 == 8)
			{
				return; //retour � la premi�re �tape "que voulez-vous s�l�ctionner"
			}
						

				if (choix1 != 9) 
				{
					if (Fonctions.ConditionNUM(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).get(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							.size() - 1),Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).get(Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).size() - 1) ))
					{	
					for (i=1;i <= compte; i++)
						Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
										.add(Fonctions
										.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
										.get(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
										.size() - i));
						
						Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
								.remove(Fonctions.Choix1Colonne(choix1, Colonne0, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
							    .size() - i);
				}
				}
				else
				{
					if( Fonctions.ConditionNUM(Colonne0.get(0), Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).get(Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7).size() - 1) ))
					{
						Fonctions.Choix2Colonne(choix2, Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7)
						.add(Colonne0.get(0));
						Colonne0.remove(0);
					}
				}
			
			
		} 
		else {
					Colonne0.add(Colonne0.get(0));
					Colonne0.remove(0);
			}
	}

	private int get(int compteCach�) {
		// TODO Auto-generated method stub
		return 0;
	}
}
