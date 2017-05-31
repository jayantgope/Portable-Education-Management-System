/**Creating a package*/
package student_management;
/** Importing the pre-defined packages, in order to pre defined methods and classes*/
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;
/**Creating a class by making an IS-A relation*/
public class Student extends JFrame implements ActionListener
{
	/**Variable Declarations*/
	JLabel lblTitle, lblStudentID, lblFirstName, lblLastName, lblGender, lblMale, lblFemale, lblJoiningYear, lblProgramCode, lblEnrolmentStatus, lblHeader, lblFooter, lblImage;
	JTextField txtStudentID, txtFirstName, txtLastName, txtJoiningYear;
	JComboBox cmbProgramCode, cmbEnrolmentStatus;
	JRadioButton rdbMale, rdbFemale;
	JButton btnAdd, btnClear, btnCancel;
	JPanel pnlTop, pnlFooter, pnlCenter, pnlGender, pnlHeader, pnlCenterComponents, pnlButtons, pnlImage, pnlAddCenterComp, pnlbt, pnlFooterText;
	/** Array of strings are declared as well as instantiated*/
	String ProgramCode [] = {"--Select--", "CSE", "COM", "EEE", "EE", "ME"};
	String EnrolmentStatus [] = {"--Select--", "Active", "Passout", "Suspended", "Expelled"};
	ButtonGroup btngrpGender;
	String FirstName, LastName, Gender ;
	Object objProgramCode, objEnrolmentStatus;
	int StudentID, JoiningYear;
	/** Defining the constructor*/
	public Student()
	{
		setSize(500, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Student Management");
		setLayout(new BorderLayout());
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setBackground(Color.white);
		setLocation(200, 0);
		setSize(1000, 740);
		setExtendedState(JFrame.MAXIMIZED_BOTH);


		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Adventure Subtitles", 0, 40));
		lblHeader.setForeground(new Color(255, 255, 255));
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(153, 0, 51));
		
		lblTitle = new JLabel ("STUDENT MANAGEMENT");

		lblStudentID = new JLabel("Student ID : ");
		lblStudentID.setFont(new Font("Adventure Subtitles", 0, 18));

		lblFirstName = new JLabel("First Name : ");
		lblFirstName.setFont(new Font("Adventure Subtitles", 0, 18));

		lblLastName = new JLabel("Last Name : ");
		lblLastName.setFont(new Font("Adventure Subtitles", 0, 18));

		lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Adventure Subtitles", 0, 18));

		lblJoiningYear = new JLabel("Joining Year : ");
		lblJoiningYear.setFont(new Font("Adventure Subtitles", 0, 18));

		lblProgramCode = new JLabel("Program Code : ");
		lblProgramCode.setFont(new Font("Adventure Subtitles", 0, 18));

		lblEnrolmentStatus = new JLabel("Enrolment Status : ");
		lblEnrolmentStatus.setFont(new Font("Adventure Subtitles", 0, 18));

		txtStudentID = new JTextField("", 15);
		txtStudentID.setFont(new Font("Adventure Subtitles", 0, 18));

		txtFirstName = new JTextField("", 15);
		txtFirstName.setFont(new Font("Adventure Subtitles", 0, 18));

		txtLastName = new JTextField("", 15);
		txtLastName.setFont(new Font("Adventure Subtitles", 0, 18));

		txtJoiningYear = new JTextField("", 15);
		txtJoiningYear.setFont(new Font("Adventure Subtitles", 0, 18));

		cmbProgramCode = new JComboBox(ProgramCode);
		cmbProgramCode.setFont(new Font("Adventure Subtitles", 0, 18));

		cmbEnrolmentStatus = new JComboBox(EnrolmentStatus);
		cmbEnrolmentStatus.setFont(new Font("Adventure Subtitles", 0, 18));

		btngrpGender = new ButtonGroup();

		rdbMale = new JRadioButton ("Male");
		rdbMale.setFont(new Font("Adventure Subtitles", 0, 18));
		rdbMale.setBackground(Color.white);

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setFont(new Font("Adventure Subtitles", 0, 18));
		rdbFemale.setBackground(Color.white);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Adventure Subtitles", 0, 18));
		btnAdd.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Adventure Subtitles", 0, 18));
		btnClear.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Adventure Subtitles", 0, 18));
		btnCancel.addActionListener(this);

		pnlGender = new JPanel();

		pnlAddCenterComp = new JPanel();
		pnlAddCenterComp.setLayout(new GridLayout(8, 2, 10, 8));
		pnlAddCenterComp.setBackground(Color.white);

		pnlCenterComponents = new JPanel();
		pnlCenterComponents.setBackground(Color.white);
		pnlCenterComponents.setLayout(new GridBagLayout());
		
		lblImage = new JLabel(new ImageIcon("Add Students.jpg"));

		pnlImage = new JPanel();
		pnlImage.setBackground(Color.white);
		
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 3, 10, 0));
		pnlButtons.setBackground(Color.white);
		
		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);
		
		pnlCenter = new JPanel ();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setLayout(new GridLayout(2, 1, 10, 15));
		
		lblFooter = new JLabel("Copyright © Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));

		pnlFooterText = new JPanel();
		pnlFooterText.setLayout(new GridBagLayout());
		pnlFooterText.setBackground(new Color(153, 0, 51));
		
		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridLayout(2, 1, 10, 10));
		pnlFooter.setBackground(Color.white);
	
	}
	/** The method which add all the components to the frame and makes the frame visible*/
	public void LaunchFrame()
	{
		pnlHeader.add(lblHeader);
		add(pnlHeader, BorderLayout.NORTH);

		pnlImage.add(lblImage);

		pnlAddCenterComp.add(lblStudentID);
		pnlAddCenterComp.add(txtStudentID);
		pnlAddCenterComp.add(lblFirstName);
		pnlAddCenterComp.add(txtFirstName);
		pnlAddCenterComp.add(lblLastName);
		pnlAddCenterComp.add(txtLastName);
		pnlAddCenterComp.add(lblGender);
		pnlAddCenterComp.add(pnlGender);

		pnlGender.setBackground(Color.white);
		
		pnlGender.add(rdbMale);
		pnlGender.add(rdbFemale);
		btngrpGender.add(rdbMale);
		btngrpGender.add(rdbFemale);

		pnlAddCenterComp.add(lblJoiningYear);
		pnlAddCenterComp.add(txtJoiningYear);
		pnlAddCenterComp.add(lblProgramCode);
		pnlAddCenterComp.add(cmbProgramCode);
		pnlAddCenterComp.add(lblEnrolmentStatus);
		pnlAddCenterComp.add(cmbEnrolmentStatus);

		pnlCenterComponents.add(pnlAddCenterComp);

		add(pnlCenter, BorderLayout.CENTER);

		pnlCenter.add(pnlImage);
		pnlCenter.add(pnlCenterComponents);

		pnlButtons.add(btnAdd);
		pnlButtons.add(btnClear);
		pnlButtons.add(btnCancel);

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);
		
		setVisible(true);
		
	}
	/** Implementation of the method of interface actionListener*/
	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton)e.getSource();
		String name = b.getLabel();
		if (name.equals("Clear"))
		{
			txtStudentID.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtJoiningYear.setText("");
			cmbProgramCode.setSelectedItem("--Select--");
			cmbEnrolmentStatus.setSelectedItem("--Select--");
			btngrpGender.clearSelection();
		}
		else
		if (name.equals("Add"))
		{
			if((txtStudentID.getText()).equals("") || (txtFirstName.getText()).equals("") || (txtLastName.getText()).equals("") || (txtJoiningYear.getText()).equals("") || 
				(cmbProgramCode.getSelectedItem()).equals("--Select--") || (cmbEnrolmentStatus.getSelectedItem()).equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null, "Please enter all the fields first");
			}
			else
			{
				FirstName = txtFirstName.getText();
				LastName = txtLastName.getText();
				if(rdbMale.isSelected())
				{
					Gender = rdbMale.getText();
				}
				else if(rdbFemale.isSelected())
				{
					Gender = rdbMale.getText();
				}
				objProgramCode = cmbProgramCode.getSelectedItem();
				objEnrolmentStatus = cmbEnrolmentStatus.getSelectedItem();

				Pattern P1 = Pattern.compile("[1-9,&%$#@!()*^]");
				Pattern P2 = Pattern.compile("[a-z,A-Z,&%$#@!()*^ ]");
				Matcher mtcrFirstName = P1.matcher(FirstName);
				Matcher mtcrLastName = P1.matcher(LastName);
				if (mtcrFirstName.find())
				{
					JOptionPane.showMessageDialog(null, "First Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrLastName.find())
				{
					JOptionPane.showMessageDialog(null, "Last Name must not contain Numeric Values and Special Symbols");
				}
				else
				{
					AddtoDatabase();
				}
			}

		}
		else if(name.equals("Cancel"))
		{
				dispose();
		}
	}
	/** The methods that adds the data to the database*/
	public void AddtoDatabase ()
	{
		try
		{
			JoiningYear = Integer.parseInt(txtJoiningYear.getText());
			StudentID = Integer.parseInt(txtStudentID.getText()); 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "insert into Student_Management (StudentID,FirstName,LastName,Gender,JoiningYear,ProgramCode,EnrolmentStatus) values (" + StudentID + ",'" + FirstName + "','" + LastName + "','" + Gender + "'," + JoiningYear + ",'" + objProgramCode + "','" + objEnrolmentStatus + "')";
			state.execute(sql);
			JOptionPane.showMessageDialog(null, "Record added Successfully");
			System.out.println("Statement executed successfully");
			state.close();
			connect.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Student ID already exists");
			txtStudentID.requestFocus();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "The Student ID or the Joining Year is not Valid");
			txtStudentID.requestFocus();
		}
        catch (Exception e) 
		{
           JOptionPane.showMessageDialog(null, e);
        }
	}
}