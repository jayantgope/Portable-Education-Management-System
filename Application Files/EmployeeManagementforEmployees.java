/**Package Declaration*/
package employee_management;
/** Importing pre-defined packages in order to use the predefined methods and classes*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/** Declaring a class by making IS-A relation and implementing the ActionListener interface*/
public class EmployeeManagementforEmployees extends JFrame implements ActionListener
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
	JButton btnFirst, btnPrevious, btnNext, btnLast;
	JTextArea txtarPAddress;
	JScrollPane scrpScrollBar;
	String StaffID, FirstName, LastName, DateofBirth, Gender, MaritalStatus, FathersName, City, states, Country, EmailID, ContactNo, PermanentAddress;
	ButtonGroup btngrpGender, btngrpMarital;
	public Connection conn;
	public Statement stmt,s1,st;
	public ResultSet rs,r1;
	/** Constructor declaration*/
	public EmployeeManagementforEmployees()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Student Management");
		setLayout(new BorderLayout());
		/** Setting the icon image for the frame*/
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setBackground(Color.white);
		setLocation(200, 0);
		setSize(1000, 750);
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

		txtarPAddress = new JTextArea(1, 15);
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

		btnFirst = new JButton("First");
		btnFirst.setFont(new Font("Adventure Subtitles", 0, 18));
		btnFirst.addActionListener(this);

		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Adventure Subtitles", 0, 18));
		btnPrevious.addActionListener(this);

		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Adventure Subtitles", 0, 18));
		btnNext.addActionListener(this);

		btnLast = new JButton("Last");
		btnLast.setFont(new Font("Adventure Subtitles", 0, 18));
		btnLast.addActionListener(this);

		
		pnlGender = new JPanel();
		pnlGender.setBackground(Color.white);

		pnlMaritalStatus = new JPanel();
		pnlMaritalStatus.setBackground(Color.white);

		pnlPAddress = new JPanel();
		pnlPAddress.setLayout(new BorderLayout());

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 4, 10, 0));
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

		connect();
		DisabledFields(false);
	}
	/** Defining the method LaunchFrame*/
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

		pnlButtons.add(btnFirst);
		pnlButtons.add(btnPrevious);
		pnlButtons.add(btnNext);
		pnlButtons.add(btnLast);

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);

		/** Making the Frame visible*/
		setVisible(true);
	}
	/** Defining the method DisabledFields
	* This method disables the text fields and other fields which are no longer needed to enabled
	*/
	private void DisabledFields(boolean b)
	{
		txtFirstName.setEnabled(b);
		txtLastName.setEnabled(b);
		txtDOB.setEnabled(b);
		rdbMale.setEnabled(b);
		rdbFemale.setEnabled(b);
		rdbMarried.setEnabled(b);
		rdbUnmarried.setEnabled(b);
		txtFathersName.setEnabled(b);
		txtCity.setEnabled(b);
		txtState.setEnabled(b);
		txtCountry.setEnabled(b);
		txtEmailId.setEnabled(b);
		txtContactNo.setEnabled(b);
		txtarPAddress.setEnabled(b);
		btnFirst.setEnabled(!b);
		btnPrevious.setEnabled(!b);
		btnNext.setEnabled(!b);
		btnLast.setEnabled(!b);	
	}
	/** Providing the implementation of the method of the Interface*/
	public void actionPerformed(ActionEvent e)
	{      
		try
		{	
			if(e.getSource()==btnFirst)
			{
				if(rs.isFirst())
				{	
					rs.beforeFirst();
					JOptionPane.showMessageDialog(null, "First Record");			
				}
				if(rs.first())
				{
					//Calling Display method
					Display(rs);
				}	
			}
			else if(e.getSource()==btnLast)
			{
				if(rs.isLast())
				{	
					rs.afterLast();
					JOptionPane.showMessageDialog(null, "Last Record");	
				}
				if(rs.last())
				{
					//Calling Display method
					Display(rs);
				}	
			}
			else if(e.getSource()==btnNext)
			{
				if(rs.isLast())
				{	
					rs.afterLast();
					JOptionPane.showMessageDialog(null, "Last Record");		
				}
				if(rs.next())
				{
					//Calling Display method
					Display(rs);
				}	
			}
			else if(e.getSource()==btnPrevious)
			{
				if(rs.isFirst())
				{	
					rs.beforeFirst();
					JOptionPane.showMessageDialog(null, "First Record");
				}
				if(rs.previous())
				{	
					//Calling Display method
				 	Display(rs);
				}		
			}
		}
		catch(SQLException e1) 
		{
			
		}
	}
	/** Defining Display method
	* This method receives the passed value and searches for the associated record*/
	private void Display(ResultSet rs) throws SQLException
	{
		txtStaffID.setText(rs.getString("StaffID"));
		txtFirstName.setText(rs.getString("FirstName"));
		txtLastName.setText(rs.getString("LastName"));
		txtDOB.setText(rs.getString("DateofBirth"));
		String Gender=rs.getString("Gender");
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
		String MaritalStatus=rs.getString("MaritalStatus");
		if(MaritalStatus.equals("Married"))
		{
			rdbMarried.setSelected(true);
			rdbUnmarried.setSelected(false);
		}
		else if(Gender.equals("Female"))
		{
			rdbMarried.setSelected(true);
			rdbUnmarried.setSelected(false);
		}
		txtFathersName.setText(rs.getString("FathersName"));
		txtarPAddress.setText(rs.getString("PermanentAddress"));
		txtCity.setText(rs.getString("City"));
		txtState.setText(rs.getString("States"));
		txtCountry.setText(rs.getString("Country"));
		txtEmailId.setText(rs.getString("EmailID"));
		txtContactNo.setText(rs.getString("ContactNo"));
		txtStaffID.requestFocus();
	 }
	 /** difinition of connect method*/
	public void connect()
	{	
		try
		{
			rs=StudConnection.executeQuery("select * from Employee_Management");
			if(rs.next())		
			Display(rs);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(java.lang.Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
	/** Main Method*/
	public static void main(String args[])
	{
		/** Making the object of the class EmployeeManagementforEmployees with the object reference S*/
		EmployeeManagementforEmployees S = new EmployeeManagementforEmployees();
		/** Calling the LaunchFrame method*/
		S.LaunchFrame();
	}
}
/** Creating a class name StudConnection*/
class StudConnection
{	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:EMS","","");	
		}
		catch(java.lang.Exception e)
		{
			System.out.println(e);
		}
		return con;
	}	
	public static ResultSet executeQuery(String stSQL) throws Exception
	{
		Connection cn = getConnection();
		Statement  st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery(stSQL);
		return rs;		
	}
}
