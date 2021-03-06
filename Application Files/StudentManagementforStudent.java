/** Creating a package*/
package student_management;
/** Importing the predefined packages, in order the use predefined classes and methods*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/** Creating a class and making an IS-A relation also implementing an Interface ActionListener*/
public class StudentManagementforStudent extends JFrame implements ActionListener
{
	/** Declaring the Variables*/
	JLabel lblTitle, lblStudentID, lblFirstName, lblLastName, lblGender, lblMale, lblFemale, lblJoiningYear, lblProgramCode, lblEnrolmentStatus, lblHeader, lblFooter, lblImage;
	JTextField txtStudentID, txtFirstName, txtLastName, txtJoiningYear;
	JComboBox cmbProgramCode, cmbEnrolmentStatus;
	JRadioButton rdbMale, rdbFemale;
	JButton btnFirst, btnPrevious, btnNext, btnLast;
	JPanel pnlTop, pnlFooter, pnlCenter, pnlGender, pnlHeader, pnlCenterComponents, pnlButtons, pnlImage, pnlAddCenterComp, pnlbt, pnlFooterText;
	String ProgramCode [] = {"--Select--", "CSE", "COM", "EEE", "EE", "ME"};
	String EnrolmentStatus [] = {"--Select--", "Active", "Passout", "Suspended", "Expelled"};
	String StudentID, FirstName, LastName, Gender, JoiningYear, Program_Code, Enrolment_Status;
	ButtonGroup btngrpGender;
	public Connection conn;
	public Statement stmt,s1,st;
	public ResultSet rs,r1;
	/** Defining the constructor*/
	public StudentManagementforStudent()
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
		lblHeader.setFont(new Font("Verdana", 0, 40));
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

		lblMale = new JLabel("Male");
		lblMale.setFont(new Font("Adventure Subtitles", 0, 18));

		lblFemale = new JLabel("Female");
		lblFemale.setFont(new Font("Adventure Subtitles", 0, 18));

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

		rdbMale = new JRadioButton ("Male");
		rdbMale.setBackground(Color.white);
		rdbMale.setFont(new Font("Adventure Subtitles", 0, 18));

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setBackground(Color.white);
		rdbFemale.setFont(new Font("Adventure Subtitles", 0, 18));

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

		pnlAddCenterComp = new JPanel();
		pnlAddCenterComp.setLayout(new GridLayout(8, 2, 10, 8));
		pnlAddCenterComp.setBackground(Color.white);

		pnlCenterComponents = new JPanel();
		pnlCenterComponents.setBackground(Color.white);
		pnlCenterComponents.setLayout(new GridBagLayout());
		

		lblImage = new JLabel(new ImageIcon("Student.jpg"));

		pnlImage = new JPanel();
		pnlImage.setBackground(Color.white);
		

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 4, 10, 0));
		pnlButtons.setBackground(Color.white);
		

		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);
		

		pnlCenter = new JPanel ();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setLayout(new GridLayout(2, 1, 10, 15));
		
		
		btngrpGender = new ButtonGroup();
		
		lblFooter = new JLabel("Copyright � Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));

		pnlFooterText = new JPanel();
		pnlFooterText.setLayout(new GridBagLayout());
		pnlFooterText.setBackground(new Color(153, 0, 51));
		
		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridLayout(2, 1, 10, 10));
		pnlFooter.setBackground(Color.white);

		/** Call to the method Connect and DisabledFields*/
		connect();
		DisabledFields(false);
	
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

		pnlButtons.add(btnFirst);
		pnlButtons.add(btnPrevious);
		pnlButtons.add(btnNext);
		pnlButtons.add(btnLast);

		pnlbt.add(pnlButtons);
		
		pnlFooterText.add(lblFooter);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(pnlbt);
		pnlFooter.add(pnlFooterText);
		
		setVisible(true);
	}
	/** The method which disables the fields, which are of use at the moment*/
	private void DisabledFields(boolean b)
	{
		txtFirstName.setEnabled(b);
		txtLastName.setEnabled(b);
		txtJoiningYear.setEnabled(b);
		rdbMale.setEnabled(b);
		rdbFemale.setEnabled(b);
		cmbProgramCode.setEnabled(b);
		cmbEnrolmentStatus.setEnabled(b);
		btnFirst.setEnabled(!b);
		btnPrevious.setEnabled(!b);
		btnNext.setEnabled(!b);
		btnLast.setEnabled(!b);	
	}
	/** Implementing the method of the Interface ActionListener*/
	public void actionPerformed(ActionEvent e)
	{      
		StudentID=txtStudentID.getText();
		FirstName=txtFirstName.getText();
		LastName=txtLastName.getText();
		JoiningYear=txtJoiningYear.getText();
		Program_Code = (String) cmbProgramCode.getSelectedItem();
		Enrolment_Status = (String) cmbEnrolmentStatus.getSelectedItem();
		if(rdbMale.isSelected())
		{
			Gender="Male";
		}
		else if(rdbFemale.isSelected())
		{
			Gender="Female";
		}
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
						Display(rs);
					}	
				}
				else if(e.getSource()==btnPrevious)
				{
				
					if(rs.isFirst())
					{	rs.beforeFirst();
					
					 JOptionPane.showMessageDialog(null, "First Record");
					}
					if(rs.previous())
					{	
					 	Display(rs);
					}		
				}
			}
		catch(SQLException e1) 
		{
		}
	}
	/** The method that displays the records of the students on the associated fields by retrieving from the database*/
	private void Display(ResultSet rs) throws SQLException
	{
		txtStudentID.setText(rs.getString("StudentID"));
		txtFirstName.setText(rs.getString("FirstName"));
		txtLastName.setText(rs.getString("LastName"));
		Gender=rs.getString("Gender");
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
		txtStudentID.requestFocus();
	 }
	public void connect()
	{	
		try
		{
			rs=StudConnection.executeQuery("select * from Student_Management");
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
}
/** Creating a class in which the database is being connected*/
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