import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SuggestGUI extends JFrame {
	
	public static Database collegeList;
	public static User currentUser;
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JTextField gpa;
	JTextField major;
	private String[] sizes = {"S","M","L"};
	JComboBox size = new JComboBox(sizes);
	//JTextField addPreferredSchool;
	//JTextField removePreferredSchool;
	JButton search;
	//JButton back;
	//JToolBar cardb;
	JPanel cards;
	JPanel card2;
	JPanel im;
	ImageIcon imag;
	

	/*
	 * Initializes the database and user upon successful login.
	 */
	public static void main(String[] args) throws IOException {
		
		
		JFrame frame = new SuggestGUI();
		//frame.setTitle("uniSEARCHity");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
	
	public SuggestGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		//cardb = new JToolBar();
		cards = new JPanel();
		card2 = new JPanel();
//		cardb.setLayout(new BorderLayout());
//		cardb.setPreferredSize(new Dimension(500,50));
//		cardb.setMaximumSize(new Dimension(10000, 50));
		cards.setLayout(new GridLayout(0, 2, 0, 10));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
		label1 = new JLabel("GPA: ");
		label2 = new JLabel("Major: ");
		label3 = new JLabel("Size: ");
		
		gpa = new JTextField(25);
		
		major = new JTextField(25);
		
		
		
		//addPreferredSchool = new JTextField(25);
		//removePreferredSchool = new JTextField(25);
		search = new JButton("Suggest Schools");
		search.addActionListener(e -> {
		});
//		back = new JButton("Back");
//		back.addActionListener(e -> {
//		});
		
		//cardb.add(back);
		cards.add(label1);
		cards.add(gpa);
		cards.add(label2);
		cards.add(major);
		cards.add(label3);
		cards.add(size);
		card2.add(search);
		
		//cardb.setBackground(Color.WHITE);
		cards.setBackground(Color.WHITE);
		card2.setBackground(Color.WHITE);
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		//frame.add(cardb, BorderLayout.NORTH);
		frame.add(cards,BorderLayout.NORTH);
		frame.add(card2, BorderLayout.CENTER);
		//frame.add(fileUp, BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}