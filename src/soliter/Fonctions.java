package soliter;

import java.util.ArrayList;

public class Fonctions {
	public static String NumTranslate(int NbrNum) {
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

	public static void DistributionColonne(ArrayList<Object> Paquet, ArrayList<Object> Colonne, int CarteDistrib,
			int IStart) {
		for (int i = IStart; i != (CarteDistrib + IStart); i++) {
			Colonne.add(Paquet.get(i));
		}
	}

	public static int CompteCartesFaceCachées(ArrayList<Object> Colonne) {
		int CCFC = 0;
		for (int i = 0; i != Colonne.size(); i++) {
			if (!((Carte) Colonne.get(i)).GetFaceCarte())
				CCFC++;
		}
		return CCFC;
	}

	public static Carte RecupCarte(ArrayList<Object> Colonne0, ArrayList<Object> Colonne1, ArrayList<Object> Colonne2,
			ArrayList<Object> Colonne3, ArrayList<Object> Colonne4, ArrayList<Object> Colonne5,
			ArrayList<Object> Colonne6, ArrayList<Object> Colonne7, Carte Récup, int choix1) {

		for (int i = 0; i != Colonne7.size(); i++) {

			switch (choix1) {

			case 1: {
				Récup = (Carte) Colonne0.get(0);
				System.out.println(Récup);
				return Récup;
			}
			case 2:
				if (i < Colonne1.size()) // + CONDITION FACE CACHE
				{

					Récup = (Carte) Colonne1.get(i);
				}

			case 3:
				if (i < Colonne2.size())// + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne2.get(i);
				}

			case 4:
				if (i < Colonne3.size())// + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne3.get(i);
				}

			case 5:
				if (i < Colonne4.size())// + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne4.get(i);
				}

			case 6:
				if (i < Colonne5.size())// + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne5.get(i);
				}

			case 7:
				if (i < Colonne6.size())// + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne6.get(i);
				}

			case 8:
				if (i < Colonne7.size()) // + CONDITION FACE CACHE
				{
					Récup = (Carte) Colonne7.get(i);
				}
			}
		}
		return Récup;
	}

	public static void Affichage2(ArrayList<Object> Colonne1, ArrayList<Object> Colonne2, ArrayList<Object> Colonne3,
			ArrayList<Object> Colonne4, ArrayList<Object> Colonne5, ArrayList<Object> Colonne6,
			ArrayList<Object> Colonne7) {
		for (int i = 0; i != Colonne7.size(); i++) // val max..
		{
			if (i < Colonne1.size()) {
				if (((Carte) Colonne1.get(i)).GetFaceCarte())
					System.out.print(Colonne1.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne2.size()) {
				if (((Carte) Colonne2.get(i)).GetFaceCarte())
					System.out.print(Colonne2.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne3.size()) {
				if (((Carte) Colonne3.get(i)).GetFaceCarte())
					System.out.print(Colonne3.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne4.size()) {
				if (((Carte) Colonne4.get(i)).GetFaceCarte())
					System.out.print(Colonne4.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne5.size()) {
				if (((Carte) Colonne5.get(i)).GetFaceCarte())
					System.out.print(Colonne5.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne6.size()) {
				if (((Carte) Colonne6.get(i)).GetFaceCarte())
					System.out.print(Colonne6.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			if (i < Colonne7.size()) {
				if (((Carte) Colonne7.get(i)).GetFaceCarte())
					System.out.print(Colonne7.get(i) + "  ");
				else
					System.out.print("????????" + "  ");
			} else
				System.out.print("          ");
			System.out.println("");

		}
	}
}
