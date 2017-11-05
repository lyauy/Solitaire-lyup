package soliter;

import java.util.ArrayList;

public class Fonctions {
	public static String NumTranslate(int NbrNum) { //Convertir les dernières cartes 11,12 et 13 en Valet (Va), Dame (Da) et Roi (Ro)
		String NumCarte = "NULL";
		switch (NbrNum) {
		case 10:
			NumCarte = "" + 10;
			break;
		case 11:
			NumCarte = "Va";
			break;
		case 12:
			NumCarte = "Da";
			break;
		case 13:
			NumCarte = "Ro";
			break;
		default:
			NumCarte = "0" + NbrNum;
		}
		return (NumCarte);
	}

	public static void DistributionColonne(ArrayList<Carte> Paquet, ArrayList<Carte> Colonne, int CarteDistrib,
			int IStart) {
		for (int i = IStart; i != (CarteDistrib + IStart); i++) {
			Colonne.add(Paquet.get(i));
		}
	}

	public static int CompteCartesFaceCachées(ArrayList<Carte> Colonne) { //On met les cartes faces cachées de chaque colonne (sauf les dernières cartes de chaque colonne)
		int CCFC = 0;
		for (int i = 0; i != Colonne.size(); i++) {
			if (!((Carte) Colonne.get(i)).GetFaceCarte())
				CCFC++;
		}
		return CCFC;
	}

	public static int SizeMax(ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
			ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6,
			ArrayList<Carte> Colonne7) { //On affecte à SizeMax la valeur de la taille d'une colonne

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
	public static void Affichage2(ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
			ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6,
			ArrayList<Carte> Colonne7) {

		int SizeMax = SizeMax(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);

		for (int i = 0; i != SizeMax; i++) // val max..
		{
			if (i < Colonne1.size()) {
				if (((Carte) Colonne1.get(i)).GetFaceCarte() && !Colonne1.isEmpty())
					System.out.print(Colonne1.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne2.size()) {
				if (((Carte) Colonne2.get(i)).GetFaceCarte()&& !Colonne2.isEmpty())
					System.out.print(Colonne2.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne3.size()) {
				if (((Carte) Colonne3.get(i)).GetFaceCarte()&& !Colonne3.isEmpty())
					System.out.print(Colonne3.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne4.size()) {
				if (((Carte) Colonne4.get(i)).GetFaceCarte()&& !Colonne4.isEmpty())
					System.out.print(Colonne4.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne5.size()) {
				if (((Carte) Colonne5.get(i)).GetFaceCarte()&& !Colonne5.isEmpty())
					System.out.print(Colonne5.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne6.size()) {
				if (((Carte) Colonne6.get(i)).GetFaceCarte()&& !Colonne6.isEmpty())
					System.out.print(Colonne6.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne7.size()) {
				if (((Carte) Colonne7.get(i)).GetFaceCarte()&& !Colonne7.isEmpty())
					System.out.print(Colonne7.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			System.out.println("");

		}
	}

	public static ArrayList<Carte> Choix2Colonne(int choix2, ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2,
			ArrayList<Carte> Colonne3, ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5,
			ArrayList<Carte> Colonne6, ArrayList<Carte> Colonne7) {
		switch (choix2) {
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
			return null;
		default:
			return null;

		}
	}

	public static ArrayList<Carte> Choix1Colonne(int choix1, ArrayList<Carte> Colonne0, ArrayList<Carte> Colonne1,
			ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3, ArrayList<Carte> Colonne4,
			ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6, ArrayList<Carte> Colonne7) {
		switch (choix1) { //On retourne la colonne choisie par l'utilisateur (choix 1)
		case 2:
			return Colonne1;
		case 3:
			return Colonne2;
		case 4:
			return Colonne3;
		case 5:
			return Colonne4;
		case 6:
			return Colonne5;
		case 7:
			return Colonne6;
		case 8:
			return Colonne7;
		case 9:
			return Colonne0;
		default:
			return null;

		}
	}

	public static boolean ConditionNUM(Carte CarteBase, Carte CarteDessus)
	{
		if ((CarteBase.GetNumCarteInt()+1) != (CarteDessus.GetNumCarteInt()) || !ConditionCouleur(CarteBase, CarteDessus))
			{
				System.out.println("Carte Base : "+(CarteBase.GetNumCarteInt())+" Carte Dessus : "+(CarteDessus.GetNumCarteInt()));
				System.out.println("Déplacement interdit !");
				return false;
			}
		else 
		{
			System.out.println("Carte Base : "+(CarteBase.GetNumCarteInt())+" Carte Dessus : "+(CarteDessus.GetNumCarteInt()));
			System.out.println("Déplacement autorisé !");
			return true;
		}
	}

	public static boolean ConditionCouleur(Carte CarteBase, Carte CarteDessus) {
		switch (CarteBase.GetSymboleCarte()) {
		case "Pi":
			switch (CarteDessus.GetSymboleCarte()) {
			case "Pi":
				return false;
			case "Ca":
				return true;
			case "Tr":
				return false;
			case "Co":
				return true;
			}
		case "Ca":
			switch (CarteDessus.GetSymboleCarte()) {
			case "Pi":
				return true;
			case "Ca":
				return false;
			case "Tr":
				return true;
			case "Co":
				return false;
			}
		case "Tr":

			switch (CarteDessus.GetSymboleCarte()) {
			case "Pi":
				return false;
			case "Ca":
				return true;
			case "Tr":
				return false;
			case "Co":
				return true;
			}
		case "Co":

			switch (CarteDessus.GetSymboleCarte()) {
			case "Pi":
				return true;
			case "Ca":
				return false;
			case "Tr":
				return true;
			case "Co":
				return false;
			}
		default:
			return true;
		}
	}
	public static void SetDerniereCarteTrue(ArrayList<Carte> Colonne0, ArrayList<Carte> Colonne1, ArrayList<Carte> Colonne2, ArrayList<Carte> Colonne3,
			ArrayList<Carte> Colonne4, ArrayList<Carte> Colonne5, ArrayList<Carte> Colonne6,
			ArrayList<Carte> Colonne7)
	{
		if (!Colonne0.isEmpty())
			Colonne0.get(0).SetFaceCarteTrue();
		if (!Colonne1.isEmpty())
			Colonne1.get((Colonne1.size() - 1)).SetFaceCarteTrue();
		if (!Colonne2.isEmpty())
			Colonne2.get((Colonne2.size() - 1)).SetFaceCarteTrue();
		if (!Colonne3.isEmpty())
			Colonne3.get((Colonne3.size() - 1)).SetFaceCarteTrue();
		if (!Colonne4.isEmpty())
			Colonne4.get((Colonne4.size() - 1)).SetFaceCarteTrue();
		if (!Colonne5.isEmpty())
			Colonne5.get((Colonne5.size() - 1)).SetFaceCarteTrue();
		if (!Colonne6.isEmpty())
			Colonne6.get((Colonne6.size() - 1)).SetFaceCarteTrue();
		if (!Colonne7.isEmpty())
			Colonne7.get((Colonne7.size() - 1)).SetFaceCarteTrue();
	}
}
