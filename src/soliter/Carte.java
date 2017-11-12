package soliter;


public class Carte { //Paramètres de la carte : symbole, numéro et face carte (cachée ou montrée)
	private String Symbole;
	private String NumeroCarte;
	private boolean FaceCarte;
	private int NumCarteInt;
	
	public Carte(int i,String Psymbole) { //Constructeur de la classe carte
		NumCarteInt = i;
		NumeroCarte = NumTranslate(i);
		Symbole = Psymbole;
		FaceCarte = true;
	}

	public String getNumCarte() {
		return NumeroCarte;
	}
	public int getNumCarteInt()
	{
		return NumCarteInt;
	}
	public String getSymboleCarte() {
		return Symbole;
	}
	public boolean getFaceCarte()
	{
		return FaceCarte;
	}
	public void setFaceCarteTrue()
	{
		this.FaceCarte = true;
	}
	public String toString() { 
	    return getNumCarte()+" de "+getSymboleCarte();
	} 
	public String getCouleur()
	{
		if (this.getSymboleCarte() == "Pi" || this.getSymboleCarte() == "Tr")
			return "Noir";
		else
			return "Rouge";
	}
	public String NumTranslate(int NbrNum) { //Convertir les dernières cartes 11,12 et 13 en Valet (Va), Dame (Da) et Roi (Ro)
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
}
