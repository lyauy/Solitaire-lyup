package soliter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Solitaire {
	JTextField text = new JTextField();
	JLabel label = new JLabel();
	
	private JPanel getMainPanel(ArrayList<Object> Paquet)
	{
		//contenue
		JPanel panel = new JPanel();
		panel.add(new JLabel("Liste cartes : "));
		for (int i = 0; i < 52; i++)
			panel.add(new JLabel(Paquet.get(i).toString()));
		return panel;
	}
	public Solitaire(ArrayList<Object> Paquet)
	{
		System.out.println("Création de la fenêtre ...");
		JFrame frame = new JFrame();
		frame.setTitle("Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getMainPanel(Paquet));
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setAlwaysOnTop(true);
	}
}
