/**Package Declaration*/
package employee_management;
/** Importing pre-defined packages in order to use the predefined methods and classes*/
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
/** Creating a class by making IS-A relation and implementing the ActionListener interface*/
public class EmployeeManagement extends JFrame implements ActionListener
{
	/** Declaring the variables*/
	JLabel lblHeader, lblFooter, lblTitle, lblStaffID, lblFirstName, lblLastName, lblDOB, lblGender, lblMale, lblFemale, lblMaritalStatus, lblMarried, lblUnmarried, lblFathersName, lblPAddress, lblCity, lblState, lblCountry, lblEmailId, lblContactNo;
	JPanel pnlTop, pnlFooter, pnlCenter, pnlGender, pnlHeader, pnlCenterComponents, pnlButtons, pnlMaritalStatus, pnlPAddress, pnlbt, pnlFooterText;
	JTextField txtStaffID, txtFirstName, txtLastName, txtDOB, txtFathersName, txtCity, txtState, txtCountry, txtEmailId, txtContactNo;
	/** Declaring as well as initializing an array of String type*/
	String ProgramCode [] = {"CSE", "COM", "EEE", "EE", "ME"};
	String EnrolmentStatus [] = {"Active", "Passout", "Suspended", "Expelled"};
	/** Declaring radio buttons variables*/
	JRadioButton rdbMale, rdbFemale, rdbMarried, rdbUnmarried;
	JButton btnAdd, btnClear, btnDelete;
	JTextArea txtarPAddress;
	JScrollPane scrpScrollBar;
	String FirstName, LastName, DateofBirth, Gender, MaritalStatus, FathersName, City, states, Country, EmailID, ContactNo, PermanentAddress;
	int StaffID;
	ButtonGroup btngrpGender, btngrpMarital;
	/** Constructor declaration*/
	public EmployeeManagement()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Employee Management");
		setLayout(new BorderLayout());
		/** Setting the icon image for the frame*/
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setBackground(Color.white);
		setLocation(200, 20);
		setSize(1000, 700);
		/** Making the frame maximized*/
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		/**Object Creation*/
		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Verdana", 0, 40));
		lblHeader.setForeground(new Color(255, 255, 255));
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(153, 0, 51));
		
		pnlCenter = new JPanel ();
		pnlCenter.setBackground(Color.white);

		pnlCenterComponents = new JPanel ();
		pnlCenterComponents.setBackground(Color.white);
		pnlCenterComponents.setLayout(new GridLayout(13, 2, 10, 8));
		
		lblStaffID = new JLabel("Staff ID : ");
		lblStaffID.setFont(new Font("Adventure Subtitles", 0, 18));

		lblFirstName = new JLabel("First Name : ");
		lblFirstName.setFont(new Font("Adventure Subtitles", 0, 18));

		lblLastName = new JLabel("Last Name : ");
		lblLastName.setFont(new Font("Adventure Subtitles", 0, 18));

		lblDOB = new JLabel("Date of Birth : ");
		lblDOB.setFont(new Font("Adventure Subtitles", 0, 18));

		lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Adventure Subtitles", 0, 18));

		lblMale = new JLabel("Male");
		lblMale.setFont(new Font("Adventure Subtitles", 0, 18));

		lblFemale = new JLabel("Female");
		lblFemale.setFont(new Font("Adventure Subtitles", 0, 18));

		lblMaritalStatus = new JLabel("Marital Status : ");
		lblMaritalStatus.setFont(new Font("Adventure Subtitles", 0, 18));

		lblMarried = new JLabel("Married");
		lblMarried.setFont(new Font("Adventure Subtitles", 0, 18));

		lblUnmarried = new JLabel("Unmarried");
		lblUnmarried.setFont(new Font("Adventure Subtitles", 0, 18));

		lblFathersName = new JLabel("Father's Name : ");
		lblFathersName.setFont(new Font("Adventure Subtitles", 0, 18));

		lblPAddress = new JLabel("Permanent Address : ");
		lblPAddress.setFont(new Font("Adventure Subtitles", 0, 18));

		lblCity = new JLabel("City : ");
		lblCity.setFont(new Font("Adventure Subtitles", 0, 18));

		lblState = new JLabel("State : ");
		lblState.setFont(new Font("Adventure Subtitles", 0, 18));

		lblCountry = new JLabel("Country : ");
		lblCountry.setFont(new Font("Adventure Subtitles", 0, 18));

		lblEmailId = new JLabel ("Email Id : ");
		lblEmailId.setFont(new Font("Adventure Subtitles", 0, 18));

		lblContactNo = new JLabel ("Contact No. : ");
		lblContactNo.setFont(new Font("Adventure Subtitles", 0, 18));

		txtStaffID = new JTextField("", 15);
		txtStaffID.setFont(new Font("Adventure Subtitles", 0, 18));

		txtFirstName = new JTextField("", 15);
		txtFirstName.setFont(new Font("Adventure Subtitles", 0, 18));

		txtLastName = new JTextField("", 15);
		txtLastName.setFont(new Font("Adventure Subtitles", 0, 18));

		txtDOB = new JTextField("", 15);
		txtDOB.setFont(new Font("Adventure Subtitles", 0, 18));

		txtFathersName = new JTextField("", 15);
		txtFathersName.setFont(new Font("Adventure Subtitles", 0, 18));

		txtCity = new JTextField("", 15);
		txtCity.setFont(new Font("Adventure Subtitles", 0, 18));

		txtarPAddress = new JTextArea();
		txtarPAddress.setFont(new Font("Adventure Subtitles", 0, 18));
		scrpScrollBar = new JScrollPane(txtarPAddress, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		txtarPAddress.setLineWrap(true);

		txtState = new JTextField("", 15 );
		txtState.setFont(new Font("Adventure Subtitles", 0, 18));

		txtCountry = new JTextField("", 15);
		txtCountry.setFont(new Font("Adventure Subtitles", 0, 18));

		txtEmailId = new JTextField ("", 15);
		txtEmailId.setFont(new Font("Adventure Subtitles", 0, 18));

		txtContactNo = new JTextField("", 15);
		txtContactNo.setFont(new Font("Adventure Subtitles", 0, 18));
		txtContactNo.setColumns(10);

		rdbMale = new JRadioButton ("Male");
		rdbMale.setBackground(Color.white);
		rdbMale.setFont(new Font("Adventure Subtitles", 0, 18));

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setBackground(Color.white);
		rdbFemale.setFont(new Font("Adventure Subtitles", 0, 18));

		rdbMarried = new JRadioButton ("Married");
		rdbMarried.setBackground(Color.white);
		rdbMarried.setFont(new Font("Adventure Subtitles", 0, 18));

		rdbUnmarried = new JRadioButton ("Unmarried");
		rdbUnmarried.setBackground(Color.white);
		rdbUnmarried.setFont(new Font("Adventure Subtitles", 0, 18));

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Adventure Subtitles", 0, 18));
		btnAdd.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Adventure Subtitles", 0, 18));
		btnClear.addActionListener(this);

		btnDelete = new JButton("Cancel");
		btnDelete.setFont(new Font("Adventure Subtitles", 0, 18));
		btnDelete.addActionListener(this);

		pnlGender = new JPanel();
		pnlGender.setBackground(Color.white);

		pnlMaritalStatus = new JPanel();
		pnlMaritalStatus.setBackground(Color.white);

		pnlPAddress = new JPanel();
		pnlPAddress.setLayout(new BorderLayout());

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 3, 10, 0));
		pnlButtons.setBackground(Color.white);

		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);
		
		lblFooter = new JLabel("Copyright © Jayant Gope 2018, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));

		pnlFooterText = new JPanel();
		pnlFooterText.setLayout(new GridBagLayout());
		pnlFooterText.setBackground(new Color(153, 0, 51));
		
		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridLayout(2, 1, 10, 10));
		pnlFooter.setBackground(Color.white);

		btngrpGender = new ButtonGroup();
		btngrpMarital = new ButtonGroup();
	}
	/** Defining the method LaunchFrame*/
	public void LaunchFrame()
	{
		pnlHeader.add(lblHeader);
		/** Setting the layout of the panel to BorderLayout*/
		add(pnlHeader, BorderLayout.NORTH);

		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.add(pnlCenterComponents);

		pnlCenterComponents.add(lblStaffID);
		pnlCenterComponents.add(txtStaffID);
		pnlCenterComponents.add(lblFirstName);
		pnlCenterComponents.add(txtFirstName);
		pnlCenterComponents.add(lblLastName);
		pnlCenterComponents.add(txtLastName);
		pnlCenterComponents.add(lblDOB);
		pnlCenterComponents.add(txtDOB);

		pnlCenterComponents.add(lblGender);
		pnlCenterComponents.add(pnlGender);
	
		pnlCenterComponents.add(lblMaritalStatus);
		pnlCenterComponents.add(pnlMaritalStatus);
		
		pnlCenterComponents.add(lblFathersName);
		pnlCenterComponents.add(txtFathersName);
		pnlCenterComponents.add(lblPAddress);
		pnlCenterComponents.add(pnlPAddress);
		pnlPAddress.add(scrpScrollBar);
		pnlCenterComponents.add(lblCity);
		pnlCenterComponents.add(txtCity);
		pnlCenterComponents.add(lblState);
		pnlCenterComponents.add(txtState);
		pnlCenterComponents.add(lblCountry);
		pnlCenterComponents.add(txtCountry);
		pnlCenterComponents.add(lblEmailId);
		pnlCenterComponents.add(txtEmailId);
		pnlCenterComponents.add(lblContactNo);
		pnlCenterComponents.add(txtContactNo);

		pnlGender.add(rdbMale);
		pnlGender.add(rdbFemale);
		btngrpGender.add(rdbMale);
		btngrpGender.add(rdbFemale);
		btngrpMarital.add(rdbMarried);
		btngrpMarital.add(rdbUnmarried);

		pnlMaritalStatus.add(rdbMarried);
		pnlMaritalStatus.add(rdbUnmarried);

		pnlButtons.add(btnAdd);
		pnlButtons.add(btnClear);
		pnlButtons.add(btnDelete);

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);

		/** Making the Frame visible*/
		setVisible(true);
	}
	/** Providing the implementation of the method of the Interface*/
	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton)e.getSource();
		String name = b.getLabel();
		if (name.equals("Clear"))
		{
			txtStaffID.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtDOB.setText("");
			txtFathersName.setText("");
			txtCity.setText("");
			txtState.setText("");
			txtCountry.setText("");
			txtEmailId.setText("");
			txtContactNo.setText("");
			txtarPAddress.setText("");
			btngrpGender.clearSelection();
			btngrpMarital.clearSelection();
		}
		else
		if (name.equals("Add"))
		{
			if((txtStaffID.getText()).equals("") || (txtFirstName.getText()).equals("") || (txtLastName.getText()).equals("") || (txtDOB.getText()).equals("") || 
				(txtFathersName.getText()).equals("") || (txtCity.getText()).equals("") || (txtarPAddress.getText()).equals("") || (txtState.getText()).equals("") || 
				(txtCountry.getText()).equals("") || (txtEmailId.getText()).equals("") || (txtContactNo.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter all the fields first");
			}
			else
			{
				FirstName = txtFirstName.getText();
				LastName = txtLastName.getText();
				DateofBirth = txtDOB.getText();
				FathersName = txtFathersName.getText();
				City = txtCity.getText();
				states = txtState.getText();
				Country = txtCountry.getText();
				EmailID = txtEmailId.getText();
				ContactNo = txtContactNo.getText();
				PermanentAddress = txtarPAddress.getText();
	
				Pattern p = Pattern.compile("[1-9,&%$#@!()*^]");
				Pattern P2 = Pattern.compile("[a-z,A-Z,&%$#@!()*^ ]");
				Matcher mtcrFirstName = p.matcher(FirstName);
				Matcher mtcrLastName = p.matcher(LastName);
				Matcher mtcrFathersName = p.matcher(FathersName);
				Matcher mtcrContactNo = P2.matcher(ContactNo);
				if (mtcrFirstName.find())
				{
					JOptionPane.showMessageDialog(null, "First Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrLastName.find())
				{
					JOptionPane.showMessageDialog(null, "Last Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrFathersName.find())
				{
					JOptionPane.showMessageDialog(null, "Father's Name must not contain Numeric Values and Special Symbols");
				}
				else if(mtcrContactNo.find())
				{
					JOptionPane.showMessageDialog(null, "The Contact Number must be the numeric value");
				}
				else
				{
					/** Invoking AddtoDatabase Method*/
					AddtoDatabase();
				}
			}
		}
		else if(name.equals("Cancel"))
		{
			dispose();
		}
	}
	void AddtoDatabase ()
	{
		try
		{
			/** Written in try block, in order to catch the NumberFormatException*/
			StaffID = Integer.parseInt(txtStaffID.getText()); 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "insert into Employee_Management (StaffID,FirstName,LastName,DateofBirth,Gender,MaritalStatus,FathersName,PermanentAddress,City,states,Country,EmailID,ContactNo ) values (" + StaffID + ",'" + FirstName + "','" + LastName + "','" + DateofBirth + "','" + Gender + "','" + MaritalStatus + "','" + FathersName + "','" + PermanentAddress + "','" + City + "','" + states + "','" + Country + "','" + EmailID + "','" + ContactNo + "')";
			state.execute(sql);
			JOptionPane.showMessageDialog(null, "Record added Successfully");
			System.out.println("Statement executed successfully");
			state.close();
			connect.close();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter the Staff ID in numeric value");
			txtStaffID.requestFocus();
		}
		catch (SQLException e) 
		{
           JOptionPane.showMessageDialog(null, "Either the Staff ID already exists or you haven't entered the Date of Birth in correct format (DD/MM/YYYY)");
        }
        catch (Exception e) 
		{
           JOptionPane.showMessageDialog(null, e);
		   System.out.println(e);
        }
	}

}