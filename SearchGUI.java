import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SearchGUI {

	JFrame frame;
	ArrayList<University> list;
	
	JPanel top;
	JButton nameButton;
	JButton gpaButton;
	JButton numButton;
	JButton rateButton;
	JButton majorButton;
	
	JPanel bottom;
	JLabel label1;
	JLabel label2;
	JTextField field1;
	JTextField field2;
	JButton search;
	
	// main is only for testing
	public static void main(String[] args) throws IOException {
		File test = new File("collegeList.csv");
		Database.addUniversity(test);
		new SearchGUI(Database.universities);
	}
	
	public SearchGUI(ArrayList<University> list) {
		this.list = list;
		createComponents();
	}
	
	private void createComponents() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
		JButton nameButton = new JButton("University Name");
		nameButton.addActionListener(e -> {
			createComponentsName();
		});
		JButton gpaButton = new JButton("Average GPA");
		gpaButton.addActionListener(e -> {
			createComponentsGPA();
		});
		JButton numButton = new JButton("Number Of Students");
		numButton.addActionListener(e -> {
			createComponentsNum();
		});
		JButton rateButton = new JButton("Admission Rate");
		rateButton.addActionListener(e -> {
			createComponentsRate();
		});
		JButton majorButton = new JButton("Majors");
		majorButton.addActionListener(e -> {
			createComponentsMajor();
		});
		
		top = new JPanel();
		top.setLayout(new GridLayout(5,0));
		top.setBorder(new TitledBorder(new EtchedBorder(), "Choose a Search Filter"));
		top.add(nameButton);
		top.add(gpaButton);
		top.add(numButton);
		top.add(rateButton);
		top.add(majorButton);
		
		bottom = new JPanel();
		bottom.setBorder(new TitledBorder(new EtchedBorder(), "Specify Conditions"));
		
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void createComponentsName() {
		bottom.removeAll();
		label1 = new JLabel("Name: ");
		field1 = new JTextField(25);
		search = new JButton("Search");
		search.addActionListener(e -> {
			ArrayList<University> result = 
					Search.searchName(list, field1.getText());
			if (result.isEmpty()) {
				field1.setText("No Schools Found");
			} else {
				new DatabaseGUI(result);
			}
		});
		
		bottom.setLayout(new FlowLayout());
		bottom.add(label1);
		bottom.add(field1);
		bottom.add(search);
		bottom.revalidate();
		bottom.repaint();
	}
	
	public void createComponentsGPA() {
		bottom.removeAll();
		label1 = new JLabel("Minimum GPA: ");
		field1 = new JTextField(25);
		label2 = new JLabel("Maximum GPA: ");
		field2 = new JTextField(25);
		search = new JButton("Search");
		search.addActionListener(e -> {
			try {
				ArrayList<University> result = 
						Search.searchGPA(list, Double.parseDouble(field1.getText()), Double.parseDouble(field2.getText()));
				if (result.isEmpty()) {
					field1.setText("No Schools Found");
					field2.setText("No Schools Found");
				} else {
					new DatabaseGUI(result);
				}
			} catch (Exception e1) {
				field1.setText("Must be a number");
				field2.setText("Must be a number");
			}
		});
		
		bottom.setLayout(new FlowLayout());
		bottom.add(label1);
		bottom.add(field1);
		bottom.add(label2);
		bottom.add(field2);
		bottom.add(search);
		bottom.revalidate();
		bottom.repaint();
	}
	
	public void createComponentsNum() {
		bottom.removeAll();
		label1 = new JLabel("Minimum Number of Students: ");
		field1 = new JTextField(15);
		label2 = new JLabel("Maximum Number of Students: ");
		field2 = new JTextField(15);
		search = new JButton("Search");
		search.addActionListener(e -> {
			try {
				ArrayList<University> result = 
						Search.searchNum(list, Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText()));
				if (result.isEmpty()) {
					field1.setText("No Schools Found");
					field2.setText("No Schools Found");
				} else {
					new DatabaseGUI(result);
				}
			} catch (Exception e1) {
				field1.setText("Must be an integer");
				field2.setText("Must be an integer");
			}
		});
		
		bottom.setLayout(new FlowLayout());
		bottom.add(label1);
		bottom.add(field1);
		bottom.add(label2);
		bottom.add(field2);
		bottom.add(search);
		bottom.revalidate();
		bottom.repaint();
	}
	
	public void createComponentsRate() {
		bottom.removeAll();
		label1 = new JLabel("Minimum Admission Rate: ");
		field1 = new JTextField(20);
		label2 = new JLabel("Maximum Admission Rate: ");
		field2 = new JTextField(20);
		search = new JButton("Search");
		search.addActionListener(e -> {
			try {
				ArrayList<University> result = 
						Search.searchRate(list, Double.parseDouble(field1.getText()), Double.parseDouble(field2.getText()));
				if (result.isEmpty()) {
					field1.setText("No Schools Found");
					field2.setText("No Schools Found");
				} else {
					new DatabaseGUI(result);
				}
			} catch (Exception e1) {
				field1.setText("Must be a number");
				field2.setText("Must be a number");
			}
		});
		
		bottom.setLayout(new FlowLayout());
		bottom.add(label1);
		bottom.add(field1);
		bottom.add(label2);
		bottom.add(field2);
		bottom.add(search);
		bottom.revalidate();
		bottom.repaint();
	}
	
	public void createComponentsMajor() {
		bottom.removeAll();
		label1 = new JLabel("Major: ");
		field1 = new JTextField(25);
		search = new JButton("Search");
		search.addActionListener(e -> {
			ArrayList<University> result = 
					Search.searchMajor(list, field1.getText());
			if (result.isEmpty()) {
				field1.setText("No Schools Found");
			} else {
				new DatabaseGUI(result);
			}
		});
		
		bottom.setLayout(new FlowLayout());
		bottom.add(label1);
		bottom.add(field1);
		bottom.add(search);
		bottom.revalidate();
		bottom.repaint();
	}
}