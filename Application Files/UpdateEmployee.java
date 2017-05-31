/** Creating a Package*/
package employee_management;
/** Importing predefined packages*/
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
/** Creating a class and making an IS-A relation and also implementing an Interface ActionListener*/
public class UpdateEmployee extends JFrame implements ActionListener
{
	JLabel lblHeader, lblFooter, lblTitle, lblStaffID, lblFirstName, lblLastName, lblDOB, lblGender, lblMale, lblFemale, lblMaritalStatus, lblMarried, lblUnmarried, lblFathersName, lblPAddress, lblCity, lblState, lblCountry, lblEmailId, lblContactNo;
	JPanel pnlTop, pnlFooter, pnlCenter, pnlGender, pnlHeader, pnlCenterComponents, pnlButtons, pnlMaritalStatus, pnlPAddress, pnlbt, pnlFooterText;
	JTextField txtStaffID, txtFirstName, txtLastName, txtDOB, txtFathersName, txtCity, txtState, txtCountry, txtEmailId, txtContactNo;
	String ProgramCode [] = {"CSE", "COM", "EEE", "EE", "ME"};
	String EnrolmentStatus [] = {"Active", "Passout", "Suspended", "Expelled"};
	JRadioButton rdbMale, rdbFemale, rdbMarried, rdbUnmarried;
	JButton btnSearch, btnUpdate, btnDelete, btnCancel, btnClear;
	JTextArea txtarPAddress;
	JScrollPane scrpScrollBar;
	String StaffID, FirstName, LastName, DateofBirth, Gender, MaritalStatus, FathersName, City, states, Country, EmailID, ContactNo, PermanentAddress;
	ButtonGroup btngrpGender, btngrpMarital;
	ResultSet rs;
	/** Defining the constructor*/
	public UpdateEmployee()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Student Management");
		setLayout(new BorderLayout());
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setBackground(Color.white);
		setLocation(200, 20);
		setSize(1000, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Adventure Subtitles", 0, 40));
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
		txtarPAddress.setWrapStyleWord(true);

		txtState = new JTextField("", 15 );
		txtState.setFont(new Font("Adventure Subtitles", 0, 18));

		txtCountry = new JTextField("", 15);
		txtCountry.setFont(new Font("Adventure Subtitles", 0, 18));

		txtEmailId = new JTextField ("", 15);
		txtEmailId.setFont(new Font("Adventure Subtitles", 0, 18));

		txtContactNo = new JTextField("", 15);
		txtContactNo.setFont(new Font("Adventure Subtitles", 0, 18));

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

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Adventure Subtitles", 0, 18));
		btnSearch.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Adventure Subtitles", 0, 18));
		btnUpdate.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Adventure Subtitles", 0, 18));
		btnCancel.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Adventure Subtitles", 0, 18));
		btnClear.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Adventure Subtitles", 0, 18));
		btnDelete.addActionListener(this);

		
		pnlGender = new JPanel();
		pnlGender.setBackground(Color.white);

		pnlMaritalStatus = new JPanel();
		pnlMaritalStatus.setBackground(Color.white);

		pnlPAddress = new JPanel();
		pnlPAddress.setLayout(new BorderLayout());

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 5, 10, 0));
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
	/** The methods which adds all the components to the frame and makes it visible*/
	public void LaunchFrame()
	{
		pnlHeader.add(lblHeader);
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

		pnlButtons.add(btnSearch);
		pnlButtons.add(btnUpdate);
		pnlButtons.add(btnDelete);
		pnlButtons.add(btnCancel);
		pnlButtons.add(btnClear);

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);

		setVisible(true);
	}
	/** Implementation of predefined method of the interface ActionListener*/
	public void actionPerformed(ActionEvent e)
	{	
		
        if(e.getSource()== btnSearch)
		{   
			if((txtStaffID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null,"First enter the Staff ID to search the details");
			}
			else
			{
				try
				{
					int i = Integer.parseInt(txtStaffID.getText());
					Search(i);
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter the Staff ID in numeric value");
					txtStaffID.requestFocus();
				}
				 
			}
        }
		else if (e.getSource()==btnUpdate)
		{
			if ((txtStaffID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Staff ID, for which you want to update the record");
			}
			else if ((txtFirstName.getText()).equals("") || (txtLastName.getText()).equals("") || (txtDOB.getText()).equals("") || 
				(txtFathersName.getText()).equals("") || (txtCity.getText()).equals("") || (txtarPAddress.getText()).equals("") || (txtState.getText()).equals("") || 
				(txtCountry.getText()).equals("") || (txtEmailId.getText()).equals("") || (txtContactNo.getText()).equals("") )
			{
				JOptionPane.showMessageDialog(null, "Please, enter all the fields");
			}
			else
			{
				StaffID = txtStaffID.getText();
				FirstName = txtFirstName.getText();
				LastName = txtLastName.getText();
				DateofBirth = txtDOB.getText();
				FathersName = txtFathersName.getText();
				PermanentAddress = txtarPAddress.getText();
				City = txtCity.getText();
				states = txtState.getText();
				Country = txtCountry.getText();
				EmailID = txtEmailId.getText();
				ContactNo = txtContactNo.getText();
				if(rdbMale.isSelected())
				{
					Gender = "Male";
				}
				else if(rdbFemale.isSelected())
				{
					Gender = "Female";
				}
				if(rdbMarried.isSelected())
				{
					MaritalStatus="Married";
				}
				else if(rdbUnmarried.isSelected())
				{
					MaritalStatus="Unmarried";
				}

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
					Update();
				}
			}
		}
		else if(e.getSource()== btnDelete)
		{   
			if ((txtStaffID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Student ID, which you want to delete");
			}
		else
			{
				int i = Integer.parseInt(txtStaffID.getText());
				Delete(i); 
				Clear();
			}
        }
		else if(e.getSource()== btnClear)
		{         
            Clear();            
        }
		else if(e.getSource()== btnCancel)
		{         
            Cancel();            
        }
	}
	/** The method which searches the employee on the basis of the received employee Id*/
	boolean Search(int SID)
	{
		boolean flag = false;
        try
        {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "select * from Employee_Management where StaffID ="+ SID +"";
			rs=state.executeQuery(sql);
			if(rs.next())
			{
				txtStaffID.setText(rs.getString("StaffID"));
				txtFirstName.setText(rs.getString("FirstName"));
				txtLastName.setText(rs.getString("LastName"));
				txtDOB.setText(rs.getString("DateofBirth"));
				Gender = rs.getString("Gender");
				MaritalStatus = rs.getString("MaritalStatus");
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
				
				if(MaritalStatus.equals("Married"))
				{
					rdbMarried.setSelected(true);
					rdbUnmarried.setSelected(false);
				}
				else if(MaritalStatus.equals("Unmarried"))
				{
					rdbUnmarried.setSelected(true);
					rdbMarried.setSelected(false);
				}
				txtFathersName.setText(rs.getString("FathersName"));
				txtarPAddress.setText(rs.getString("PermanentAddress"));
				txtCity.setText(rs.getString("City"));
				txtState.setText(rs.getString("States"));
				txtCountry.setText(rs.getString("Country"));
				txtEmailId.setText(rs.getString("EmailID"));
				txtContactNo.setText(rs.getString("ContactNo"));
				flag=true;
			}
			if(txtFirstName.getText().equals("") && (txtLastName.getText()).equals("") && (txtDOB.getText()).equals("") && 
				(txtFathersName.getText()).equals("") && (txtCity.getText()).equals("") && (txtarPAddress.getText()).equals("") && (txtState.getText()).equals("") && 
				(txtCountry.getText()).equals("") && (txtEmailId.getText()).equals("") && (txtContactNo.getText()).equals(""))
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
        catch (Exception e) 
		{
		   System.out.print(e);
        }
		return flag;
	}
	/** Method which updates the records of the employee*/
	void Update()
	{
		try
		{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Drivers loaded successfully");
           Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
		   int i=Integer.parseInt(txtStaffID.getText());
           String sql = "UPDATE Employee_Management set FirstName= '"+FirstName+"', LastName= '"+LastName+"', DateofBirth= '"+DateofBirth+"', Gender= '"+Gender+"',MaritalStatus='"+MaritalStatus+"', FathersName= '"+FathersName+"', PermanentAddress= '"+PermanentAddress+"', City= '"+City+"', States= '"+states+"', Country= '"+Country+"', EmailID= '"+EmailID+"', ContactNo= '"+ContactNo+"' WHERE StaffID= "+i;           
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
	/** The method which deletes the records on the basis of the passed employee ID*/
	void Delete(int SID)
	{ 
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "delete from Employee_Management where StaffID = ("+ SID +")";
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
	/** The method which Clears all the fields of the form*/
	void Clear()
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
	/** The method which disposes the frame*/
	void Cancel()
	{
		dispose();
	}

}