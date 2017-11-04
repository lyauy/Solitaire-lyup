package soliter;

public class Carte {
	String Symbole;
	String NumeroCarte;
	boolean FaceCarte;
	public Carte(int i,String Psymbole) {
		NumeroCarte = Fonctions.NumTranslate(i);
		Symbole = Psymbole;
		FaceCarte = false;
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
	public String AffichageC()
	{
		if (this.GetFaceCarte())
			return this.toString();
		else 
			return "?";
	}
}
