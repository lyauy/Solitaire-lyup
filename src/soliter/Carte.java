package soliter;

public class Carte {
	private String Symbole;
	private String NumeroCarte;
	private boolean FaceCarte;
	private int NumCarteInt;
	public Carte(int i,String Psymbole) {
		NumCarteInt = i;
		NumeroCarte = Fonctions.NumTranslate(i);
		Symbole = Psymbole;
		FaceCarte = true;
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
