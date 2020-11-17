import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DatabaseGUI {

	private JButton moreInfor;
	private JComboBox sortLists;
	private ArrayList<University> schools;
	JFrame frame;
	JPanel panel;

	public static void main(String[] args) throws IOException {
		File test = new File("collegeList.csv");
		int check = Database.addUniversity(test);
		if (check == 1)
			System.out.println("Not enough input");
		new DatabaseGUI();
	}

	public DatabaseGUI() {
		panel = new JPanel();
		frame = new JFrame();
		panel.setLayout(null);
		frame.add(panel);
		createComponents(Database.universities);
	}
	
	public DatabaseGUI(ArrayList<University> list) {
		panel = new JPanel();
		frame = new JFrame();
		panel.setLayout(null);
		frame.add(panel);
		createComponents(list);
	}
	
	public void createComponents(ArrayList<University> list) {
		schools = list;
		panel.removeAll();
		
		frame.setSize(1020, 60 + 115 * schools.size());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel nameLabel = new JLabel("University Name");
		nameLabel.setBounds(10, 42, 180, 40);
		panel.add(nameLabel);

		JLabel gpaLabel = new JLabel("Average GPA");
		gpaLabel.setBounds(210, 42, 180, 40);
		panel.add(gpaLabel);

		JLabel numLabel = new JLabel("Number Of Students");
		numLabel.setBounds(410, 42, 180, 40);
		panel.add(numLabel);

		JLabel rateLabel = new JLabel("Admission Rate");
		rateLabel.setBounds(610, 42, 180, 40);
		panel.add(rateLabel);
		
		JButton back = new JButton("Remove Search Filters");
		back.setBounds(40, 10, 370, 40);
		back.addActionListener(e -> {
			createComponents(Database.universities);
		});
		panel.add(back);
		
		JButton search = new JButton("Search");
		search.setBounds(430, 10, 120, 40);
		search.addActionListener(e -> {
			new SearchGUI(schools, this);
		});
		panel.add(search);
		
		String[] sortStrings = { "Sort by name", "Sort by highest GPA to lowest",  "Sort by lowest GPA to highest", "Sort by highest number of student to lowest",
				"Sort by lowest number of student to highest", "Sort by highest admission rate to lowest", "Sort by lowest admission rate to highest", "sortMajor" };
		sortLists = new JComboBox(sortStrings);
		sortLists.setSelectedIndex(0);
		
		// This is currently not compatible with searching, needs to use 
		// ArrayList instead of Database
		sortLists.addActionListener(e -> {
			String tmp = (String) sortLists.getSelectedItem();
			Database lists = new Database();

			switch (tmp) {
			case "Sort by name":
				universitySort.sortName(lists, "L");
				break;
			case "Sort by highest GPA to lowest":
				universitySort.sortGpa(lists, "H");
				break;
			case "Sort by lowest GPA to highest":
				universitySort.sortGpa(lists, "L");
				break;
			case "Sort by highest number of student to lowest":
				universitySort.sortNum(lists, "H");
				break;
			case "Sort by lowest number of student to highest":
				universitySort.sortNum(lists, "L");
				break;
			case "Sort by highest admission rate to lowest":
				universitySort.sortRate(lists, "H");
				break;
			case "Sort by lowest admission rate to highest":
				universitySort.sortRate(lists, "L");
				break;
			}

			new DatabaseGUI();
		});
		sortLists.setBounds(610, 10, 380, 40);
		panel.add(sortLists);

		int size = schools.size();
		for (int i = 0; i < size; i++) {
			int currentIndex = i;
			
			JButton nameButton = new JButton(schools.get(i).getName());
			nameButton.setBounds(10, 70 + i * 100, 180, 80);
			panel.add(nameButton);

			JButton gpaButton = new JButton(schools.get(i).getAverageGPA() + "");
			gpaButton.setBounds(210, 70 + i * 100, 180, 80);
			panel.add(gpaButton);

			JButton numButton = new JButton(schools.get(i).getNumStudents() + "");
			numButton.setBounds(410, 70 + i * 100, 180, 80);
			panel.add(numButton);

			JButton rateButton = new JButton(schools.get(i).getAdmissionRate() + "");
			rateButton.setBounds(610, 70 + i * 100, 180, 80);
			panel.add(rateButton);

			moreInfor = new JButton("More Information");
			moreInfor.setBounds(810, 70 + i * 100, 180, 80);
			moreInfor.addActionListener(e -> {
				JPanel sPanel = new JPanel();
				JFrame sFrame = new JFrame();
				sFrame.setSize(600, 400);
				sFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				sFrame.add(sPanel);
				
				JLabel major = new JLabel(schools.get(currentIndex).getMajors() + "");
				major.setBounds(10, 100, 180, 80);
				sPanel.add(major);
				
				sFrame.setVisible(true);
			});
			panel.add(moreInfor);

		}

		frame.setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
	
}