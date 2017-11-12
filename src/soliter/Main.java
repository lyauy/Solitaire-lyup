package soliter;

public class Main {

	public static void main(String[] args) {

		PlateauDeJeu A = new PlateauDeJeu();	
		
		while(!A.ConditionPourWin())
		{
			A.Dessin();
			A.Menu();
			A.AutoWin();
		}
	}
}
