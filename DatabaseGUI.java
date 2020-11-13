import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatabaseGUI implements ActionListener {

	private JButton moreInfor;
	private JComboBox sortLists;

	public static void main(String[] args) throws IOException {
		File test = new File("c:/Users/proph/Desktop/CSE201/test.csv");
		int check = Database.addUniversity(test);
		if (check == 1)
			System.out.println("Not enough input");
		new DatabaseGUI();
	}

	public DatabaseGUI() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1020, 60 + 115 * Database.universities.size());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		frame.add(panel);

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
		
		JTextField searchBox = new JTextField();
		searchBox.setBounds(40, 10, 370, 40);
		panel.add(searchBox);
		
		JButton search = new JButton("Search");
		search.setBounds(430, 10, 120, 40);
		panel.add(search);
		
		String[] sortStrings = { "Sort by name", "Sort by highest GPA to lowest",  "Sort by lowest GPA to highest", "Sort by highest number of student to lowest",
				"Sort by lowest number of student to highest", "Sort by highest admission rate to lowest", "Sort by lowest admission rate to highest", "sortMajor" };
		sortLists = new JComboBox(sortStrings);
		sortLists.setSelectedIndex(0);
		sortLists.addActionListener(this);
		sortLists.setBounds(610, 10, 380, 40);
		panel.add(sortLists);

		int size = Database.universities.size();
		for (int i = 0; i < size; i++) {
			JButton nameButton = new JButton(Database.universities.get(i).getName());
			nameButton.setBounds(10, 70 + i * 100, 180, 80);
			panel.add(nameButton);

			JButton gpaButton = new JButton(Database.universities.get(i).getAverageGPA() + "");
			gpaButton.setBounds(210, 70 + i * 100, 180, 80);
			panel.add(gpaButton);

			JButton numButton = new JButton(Database.universities.get(i).getNumStudents() + "");
			numButton.setBounds(410, 70 + i * 100, 180, 80);
			panel.add(numButton);

			JButton rateButton = new JButton(Database.universities.get(i).getAdmissionRate() + "");
			rateButton.setBounds(610, 70 + i * 100, 180, 80);
			panel.add(rateButton);

			moreInfor = new JButton("More Information");
			moreInfor.setBounds(810, 70 + i * 100, 180, 80);
			moreInfor.addActionListener(this);
			panel.add(moreInfor);

		}

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == moreInfor) {
			JPanel sPanel = new JPanel();
			JFrame sFrame = new JFrame();
			sFrame.setSize(600, 400);
			sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			sFrame.add(sPanel);

			JLabel major = new JLabel(Database.universities.get(0).getMajors() + "");
			major.setBounds(10, 100, 180, 80);
			sPanel.add(major);

			sFrame.setVisible(true);
		} else {
			String tmp = (String) sortLists.getSelectedItem();
			Database list = new Database();

			switch (tmp) {
			case "Sort by name":
				universitySort.sortName(list, "L");
				break;
			case "Sort by highest GPA to lowest":
				universitySort.sortGpa(list, "H");
				break;
			case "Sort by lowest GPA to highest":
				universitySort.sortGpa(list, "L");
				break;
			case "Sort by highest number of student to lowest":
				universitySort.sortNum(list, "H");
				break;
			case "Sort by lowest number of student to highest":
				universitySort.sortNum(list, "L");
				break;
			case "Sort by highest admission rate to lowest":
				universitySort.sortRate(list, "H");
				break;
			case "Sort by lowest admission rate to highest":
				universitySort.sortRate(list, "L");
				break;
			}

			new DatabaseGUI();

		}

	}

}
