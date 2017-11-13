package soliter;

import java.util.ArrayList;
import java.util.Scanner;

public class FonctionsES
{
	
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
		
	public int SizeMax(ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
			ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6,
			ArrayList<Carte> Colonne7) { //On affecte à SizeMax la valeur de la taille d'une colonne, on en a besoin pour ne pas cacher la dernière carte d'une colonne

		int SizeMax = Colonne1.size();
		if (SizeMax < Colonne2.size())
			SizeMax = Colonne2.size();
		if (SizeMax < Colonne3.size())
			SizeMax = Colonne3.size();
		if (SizeMax < Colonne4.size())
			SizeMax = Colonne4.size();
		if (SizeMax < Colonne5.size())
			SizeMax = Colonne5.size();
		if (SizeMax < Colonne6.size())
			SizeMax = Colonne6.size();
		if (SizeMax < Colonne7.size())
			SizeMax = Colonne7.size();
		return SizeMax;
	}
	
	public boolean ConditionCouleur(Carte CarteBase, Carte CarteDessus) {// On compare la valeur de la carte choisie par choix1 (carte que l'utilisateur choisit) et la carte choisie par choix2 
		//(colonne où l'utilisateur compte poser sa carte)
	
		if(CarteBase.getCouleur() == CarteDessus.getCouleur())
		{
			return false;
		}
		else 
			return true;
	}
	
	public boolean ConditionNUM(Carte CarteBase, Carte CarteDessus) //On indique si l'ajout de la carte dans tel colonne est possible
	{
		if ((CarteBase.getNumCarteInt()+1) != (CarteDessus.getNumCarteInt()) || !ConditionCouleur(CarteBase, CarteDessus))
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
		
}
