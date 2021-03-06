/** Creating a Package*/
package student_management;
/** Importing the predefined packages*/
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;
/** Creating a class and making an iS-A relation also implementing an Interface ActionListener*/
public class UpdateStudent extends JFrame implements ActionListener
{
	JLabel lblTitle, lblStudentID, lblFirstName, lblLastName, lblGender, lblMale, lblFemale, lblJoiningYear, lblProgramCode, lblEnrolmentStatus, lblHeader, lblFooter, lblImage;
	JTextField txtStudentID, txtFirstName, txtLastName, txtJoiningYear;
	JComboBox cmbProgramCode, cmbEnrolmentStatus;
	JRadioButton rdbMale, rdbFemale;
	JButton btnSearch, btnUpdate, btnDelete, btnClear, btnCancel;
	JPanel pnlTop, pnlFooter, pnlCenter, pnlGender, pnlHeader, pnlCenterComponents, pnlButtons, pnlImage, pnlAddCenterComp, pnlbt, pnlFooterText;
	String ProgramCode [] = {"--Select--", "CSE", "COM", "EEE", "EE", "ME"};
	String EnrolmentStatus [] = {"--Select--", "Active", "Passout", "Suspended", "Expelled"};
	ButtonGroup btngrpGender;
	String StudentID, FirstName, LastName, Gender, JoiningYear, Programcode, Enrolmentstatus; 
	Object objProgramCode, objEnrolmentStatus;
	ResultSet rs;
	/** Defining the constructor*/
	public UpdateStudent()
	{
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

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Adventure Subtitles", 0, 18));
		btnSearch.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Adventure Subtitles", 0, 18));
		btnUpdate.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Adventure Subtitles", 0, 18));
		btnDelete.addActionListener(this);

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
		
		lblImage = new JLabel(new ImageIcon("Update Students.jpg"));

		pnlImage = new JPanel();
		pnlImage.setBackground(Color.white);
		
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 5, 10, 0));
		pnlButtons.setBackground(Color.white);
		
		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);
		
		pnlCenter = new JPanel ();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setLayout(new GridLayout(2, 1, 10, 15));
		
		lblFooter = new JLabel("Copyright � Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));

		pnlFooterText = new JPanel();
		pnlFooterText.setLayout(new GridBagLayout());
		pnlFooterText.setBackground(new Color(153, 0, 51));
		
		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridLayout(2, 1, 10, 10));
		pnlFooter.setBackground(Color.white);
	
	}
	/** the method which adds the components to the frame and makes it visible*/
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

		pnlButtons.add(btnSearch);
		pnlButtons.add(btnUpdate);
		pnlButtons.add(btnDelete);
		pnlButtons.add(btnClear);
		pnlButtons.add(btnCancel);
		

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);
		
		setVisible(true);
	}
	/** Implementation of the method of the interface ActionListener*/
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnSearch)
		{
			if((txtStudentID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null,"First enter the Student ID to search the details");
			}
			else
			{
				try
				{
					int i = Integer.parseInt(txtStudentID.getText());
					//Call to Serach function by passing an argument
					Search(i);
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter the Student ID in numeric value");
					txtStudentID.requestFocus();
				}
			}
		}
		else
		if (e.getSource() == btnUpdate)
		{
			if ((txtStudentID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Student ID, for which you want to Update the record");
			}
			else if ((txtFirstName.getText()).equals("") || (txtLastName.getText()).equals("") || (txtJoiningYear.getText()).equals("") || (cmbProgramCode.getSelectedItem()).equals("--Select--") || (cmbEnrolmentStatus.getSelectedItem()).equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null, "Please, enter all the fields");
			}
			else
			{
				StudentID = txtStudentID.getText();
				FirstName = txtFirstName.getText();
				LastName = txtLastName.getText();
				if(rdbMale.isSelected())
				{
					Gender = "Male";
				}
				else if(rdbFemale.isSelected())
				{
					Gender = "Female";
				}
				JoiningYear = txtJoiningYear.getText();
				Programcode = (String)cmbProgramCode.getSelectedItem();
				Enrolmentstatus = (String)cmbEnrolmentStatus.getSelectedItem();

				/** Validating the TextFields*/
				Pattern P1 = Pattern.compile("[1-9,&%$#@!()*^]");
				Pattern P2 = Pattern.compile("[a-z,A-Z,&%$#@!()*^ ]");
				Matcher mtcrFirstName = P1.matcher(FirstName);
				Matcher mtcrLastName = P1.matcher(LastName);
				Matcher mtcrJoiningYear = P2.matcher(JoiningYear);
				if (mtcrFirstName.find())
				{
					JOptionPane.showMessageDialog(null, "First Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrLastName.find())
				{
					JOptionPane.showMessageDialog(null, "Last Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrJoiningYear.find())
				{
					JOptionPane.showMessageDialog(null, "The Joining Year must be the numeric value");
				}
				else
				{
					//Call to the Update method
					Update();
				}
			}
		}
		else if(e.getSource() == btnDelete)
		{  

			if ((txtStudentID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Student ID, which you want to delete");
			}
			else
			{
				int i = Integer.parseInt(txtStudentID.getText());
				//Call to the delete method by passing a value
				Delete(i); 
				Clear();
			}
		}
		else if (e.getSource() == btnClear)
		{
			//Call to clear function
			Clear();
		}
		else if(e.getSource() == btnCancel)
		{
			dispose();
		}
	}
	/** The method which searches the data based upon the received value from the user*/
	void Search(int SID)
	{
		//boolean flag = false;
        try
        {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "select * from Student_Management where StudentID ="+ SID +"";
			rs=state.executeQuery(sql);
			if(rs.next())
			{
				txtStudentID.setText(rs.getString("StudentID"));
				txtFirstName.setText(rs.getString("FirstName"));
				txtLastName.setText(rs.getString("LastName"));
				Gender = rs.getString("Gender");
				if(Gender.equals("Male"))
				{
					rdbMale.setSelected(true);
					rdbFemale.setSelected(false);
				}
				else if(Gender.equals("Female"))
				{
					rdbFemale.setSelected(true);
					rdbMale.setSelected(false);
				}
				txtJoiningYear.setText(rs.getString("JoiningYear"));
				cmbProgramCode.setSelectedItem(rs.getString("ProgramCode"));
				cmbEnrolmentStatus.setSelectedItem(rs.getString("EnrolmentStatus"));

				//flag=true;
			}
			if(txtFirstName.getText().equals("") && (txtLastName.getText()).equals("") && txtJoiningYear.getText().equals("") && cmbProgramCode.getSelectedItem().equals("--Select--") && cmbEnrolmentStatus.getSelectedItem().equals("--Select--"))
			{
					JOptionPane.showMessageDialog(null,"The record does not exist.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Record Found Successfully");
			}
			System.out.println("Statement executed successfully");
			rs.close();
			state.close();
			connect.close();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter the Student ID in numeric value");
			txtStudentID.requestFocus();
		}
        catch (Exception e) 
		{
		   System.out.print(e);
        }
		//return flag;
	}
	/** The method which updates the record of the student when invoked*/
	void Update()
	{
		 try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Drivers loaded successfully");
           Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
		   int i=Integer.parseInt(txtStudentID.getText());
           String sql = "UPDATE Student_Management set FirstName= '"+FirstName+"', LastName= '"+LastName+"', Gender= '"+Gender+"',JoiningYear= '"+JoiningYear+"', ProgramCode= '"+Programcode+"', EnrolmentStatus= '"+Enrolmentstatus+"' WHERE StudentID= "+i;           
		   state.executeUpdate(sql);
		   JOptionPane.showMessageDialog(null, "Record Updated Successfully");
		   System.out.println("Statement executed successfully");
           state.close();
           connect.close();
		}
        catch (Exception e) 
		{
           System.out.print(e);
        }
    }
	/** A function the deletes the record of the student, which student id is passed to it*/ 
	void Delete(int SID)
	{ 
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "delete from Student_Management where StudentID = ("+ SID +")";
			state.execute(sql);
			JOptionPane.showMessageDialog(null, "Record deleted Successfully");
			System.out.println("Statement executed successfully");
			state.close();
			connect.close();
		}
        catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
        }
	}
	/** The method which clear all the fields of the form*/
	void Clear()
	{
		txtStudentID.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtJoiningYear.setText("");
		cmbProgramCode.setSelectedItem("--Select--");
		cmbEnrolmentStatus.setSelectedItem("--Select--");
		btngrpGender.clearSelection();
	}
}