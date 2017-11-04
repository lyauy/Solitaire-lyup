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

	public static void Affichage(ArrayList<Object> Colonne1, ArrayList<Object> Colonne2, ArrayList<Object> Colonne3,
			ArrayList<Object> Colonne4, ArrayList<Object> Colonne5, ArrayList<Object> Colonne6,
			ArrayList<Object> Colonne7) {
		String temp = String.valueOf(Colonne1.get(0));
		int IntTemp = temp.length() - 1;
		String temp2 = String.valueOf(Colonne2.get(0));
		int IntTemp2 = temp2.length() - 1 + IntTemp;
		String temp3 = String.valueOf(Colonne3.get(0));
		int IntTemp3 = temp3.length() - 1 + IntTemp2;
		String temp4 = String.valueOf(Colonne4.get(0));
		int IntTemp4 = temp4.length() - 1 + IntTemp3;
		String temp5 = String.valueOf(Colonne5.get(0));
		int IntTemp5 = temp5.length() - 1 + IntTemp4;
		String temp6 = String.valueOf(Colonne6.get(0));
		int IntTemp6 = temp6.length() - 1 + IntTemp5;
		for (int i = 0; i != Colonne7.size(); i++) {
			switch (i) {
			case 1:
				for (int x = 0; x != IntTemp; x++)
					System.out.print(" ");
				break;
			case 2:
				for (int x = 0; x != IntTemp2; x++)
					System.out.print(" ");
				break;
			case 3:
				for (int x = 0; x != IntTemp3; x++)
					System.out.print(" ");
				break;
			case 4:
				for (int x = 0; x != IntTemp4; x++)
					System.out.print(" ");
				break;
			case 5:
				for (int x = 0; x != IntTemp5; x++)
					System.out.print(" ");
				break;
			case 6:
				for (int x = 0; x != IntTemp6; x++)
					System.out.print(" ");
				break;
			}
	
			if (i < Colonne1.size()) // + CONDITION FACE CACHE
			{
				if (((Carte) Colonne1.get(i)).GetFaceCarte())
					System.out.print(Colonne1.get(i));
				else
					System.out.print("????????");
			}
			else
				System.out.print(" ");
			System.out.print("  ");
			if (i < Colonne2.size())// + CONDITION FACE CACHE
			{
				if (((Carte) Colonne2.get(i)).GetFaceCarte())
					System.out.print(Colonne2.get(i));
				else
					System.out.print("????????");
			} else
				System.out.print(" ");
			System.out.print("  ");
			if (i < Colonne3.size())// + CONDITION FACE CACHE
			{
				if (((Carte) Colonne3.get(i)).GetFaceCarte())
					System.out.print(Colonne3.get(i));
				else
					System.out.print("????????");
			}
			else
				System.out.print(" ");
			System.out.print("  ");
			if (i < Colonne4.size())// + CONDITION FACE CACHE
			{
				if (((Carte) Colonne4.get(i)).GetFaceCarte())
					System.out.print(Colonne4.get(i));
				else
					System.out.print("????????");
			}
			else
				System.out.print(" ");
			System.out.print("  ");
			if (i < Colonne5.size())// + CONDITION FACE CACHE
			{
				if (((Carte) Colonne5.get(i)).GetFaceCarte())
					System.out.print(Colonne5.get(i));
				else
					System.out.print("????????");
			}
			else
				System.out.print(" ");
			System.out.print("  ");
			if (i < Colonne6.size())// + CONDITION FACE CACHE
			{
				if (((Carte) Colonne6.get(i)).GetFaceCarte())
					System.out.print(Colonne6.get(i));
				else
					System.out.print("????????");
			}
			else
				System.out.print(" ");
			System.out.print("  ");
			 if (i < Colonne7.size()) // + CONDITION FACE CACHE
			{
				if (((Carte) Colonne7.get(i)).GetFaceCarte())
					System.out.print(Colonne7.get(i));
				else
					System.out.print("????????");
			}
			System.out.print("\n");
		}
	}
	public static void RecupCarte (ArrayList<Object> Colonne0, ArrayList<Object> Colonne1, ArrayList<Object> Colonne2, ArrayList<Object> Colonne3,
			ArrayList<Object> Colonne4, ArrayList<Object> Colonne5, ArrayList<Object> Colonne6,
			ArrayList<Object> Colonne7, Carte Récup, int choix1)
	{
		for (int i = 0; i != Colonne7.size(); i++) {
			
			switch (choix1){
			
			case 1:
			{
				Récup = (Carte) Colonne0.get(0);
				System.out.println(Récup);
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
	}
}

