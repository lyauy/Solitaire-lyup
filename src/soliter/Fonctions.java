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

	public static int SizeMax(ArrayList<Object> Colonne1, ArrayList<Object> Colonne2, ArrayList<Object> Colonne3,
			ArrayList<Object> Colonne4, ArrayList<Object> Colonne5, ArrayList<Object> Colonne6,
			ArrayList<Object> Colonne7) {

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
		
		int SizeMax = SizeMax(Colonne1, Colonne2, Colonne3, Colonne4, Colonne5, Colonne6, Colonne7);
		
		for (int i = 0; i != SizeMax; i++) // val max..
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

	public static ArrayList Choix2Colonne(int choix2, ArrayList<Object> Colonne1, ArrayList<Object> Colonne2,
			ArrayList<Object> Colonne3, ArrayList<Object> Colonne4, ArrayList<Object> Colonne5,
			ArrayList<Object> Colonne6, ArrayList<Object> Colonne7) {
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
	public static ArrayList Choix1Colonne(int choix1, ArrayList<Object> Colonne0 ,ArrayList<Object> Colonne1, ArrayList<Object> Colonne2,
			ArrayList<Object> Colonne3, ArrayList<Object> Colonne4, ArrayList<Object> Colonne5,
			ArrayList<Object> Colonne6, ArrayList<Object> Colonne7) {
		switch (choix1) {
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
		case 9:
			return Colonne0;
		default:
			return null;

		}
	}
}
