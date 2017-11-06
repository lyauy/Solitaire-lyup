package soliter;

public class Main {

	public static void main(String[] args) {

		boolean GG = false ;
		
		PlateauDeJeu A = new PlateauDeJeu();	
		while(!GG)
		{
			A.Dessin();
			A.Menu();
		}
	}
}
