package soliter;


public class Carte { //Paramètres de la carte : symbole, numéro et face carte (cachée ou montrée)
	private String Symbole;
	private String NumeroCarte;
	private boolean FaceCarte;
	private int NumCarteInt;
	public Carte(int i,String Psymbole) { //Constructeur de la classe carte

		NumCarteInt = i;
		NumeroCarte = Fonctions.NumTranslate(i);
		Symbole = Psymbole;
		FaceCarte = false;
	}

	public String GetNumCarte() {
		return NumeroCarte;
	}
	public int GetNumCarteInt()
	{
		return NumCarteInt;
	}
	public String GetSymboleCarte() {
		return Symbole;
	}
	public boolean GetFaceCarte()
	{
		return FaceCarte;
	}
	public void SetFaceCarteTrue()
	{
		this.FaceCarte = true;
	}
	public String toString() { 
	    return GetNumCarte()+" de "+GetSymboleCarte();
	} 
}
