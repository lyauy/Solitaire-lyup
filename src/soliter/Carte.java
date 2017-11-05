package soliter;

public class Carte {
	private String Symbole;
	private String NumeroCarte;
	private boolean FaceCarte;
	public Carte(int i,String Psymbole) {
		NumeroCarte = Fonctions.NumTranslate(i);
		Symbole = Psymbole;
		FaceCarte = true;
	}

	public String GetNumCarte() {
		return NumeroCarte;
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
