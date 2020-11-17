import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpGUI extends JFrame{


	private String helpText = "";
	private File helpFile = new File("help.txt");
	JPanel cards;
	JTextArea area;
	
	public static void main (String[] args) throws FileNotFoundException {
		HelpGUI hlp = new HelpGUI();
	}
	
	public HelpGUI() throws FileNotFoundException {
		createComponents();
	}

	public void createComponents() throws FileNotFoundException {
		cards = new JPanel();
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
        
		area = new JTextArea(9, 45);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		Scanner scan = new Scanner(helpFile);
		while (scan.hasNextLine()) {
			helpText += scan.nextLine();
		}
		area.setText(helpText);
		cards.add(area);
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}