package soliter;

import java.util.ArrayList;

public class Fonctions {

	public static int SizeMax(ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
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

	public static boolean ConditionNUM(Carte CarteBase, Carte CarteDessus) //On indique si l'ajout de la carte dans tel colonne est possible
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

	public static boolean ConditionCouleur(Carte CarteBase, Carte CarteDessus) {// On compare la valeur de la carte choisie par choix1 (carte que l'utilisateur choisit) et la carte choisie par choix2 
		//(colonne où l'utilisateur compte poser sa carte)
	
		if(CarteBase.getCouleur() == CarteDessus.getCouleur())
		{
			return false;
		}
		else 
			return true;
	}
	public static void setDerniereCarteTrue(ArrayList<Carte> Colonne0, ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
			ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6,
			ArrayList<Carte> Colonne7)//On affiche la dernière carte de chaque colonne
	{
		if (!Colonne0.isEmpty())
			Colonne0.get(0).setFaceCarteTrue();
		if (!Colonne1.isEmpty())
			Colonne1.get((Colonne1.size() - 1)).setFaceCarteTrue();
		if (!Colonne2.isEmpty())
			Colonne2.get((Colonne2.size() - 1)).setFaceCarteTrue();
		if (!Colonne3.isEmpty())
			Colonne3.get((Colonne3.size() - 1)).setFaceCarteTrue();
		if (!Colonne4.isEmpty())
			Colonne4.get((Colonne4.size() - 1)).setFaceCarteTrue();
		if (!Colonne5.isEmpty())
			Colonne5.get((Colonne5.size() - 1)).setFaceCarteTrue();
		if (!Colonne6.isEmpty())
			Colonne6.get((Colonne6.size() - 1)).setFaceCarteTrue();
		if (!Colonne7.isEmpty())
			Colonne7.get((Colonne7.size() - 1)).setFaceCarteTrue();
	}
}
