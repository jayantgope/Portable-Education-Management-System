/** Creating a Package*/
package subject_management;
/** Importing the packages*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**Creating a class by making an IS-A relation and implementing the Interface ActionListener*/
public class ViewSubject extends JFrame implements ActionListener
{
	JLabel lblSubjectId, lblSubjectName, lblSemester, lblHeader, lblImage, lblFooter;
	JPanel pnlHeader, pnlFooter, pnlImage, pnlSubjectPanel, pnlSubject, pnlCenter, pnlButtons, pnlbt, pnlFooterText;
	JTextField txtSubjectID, txtSubjectName;
	JComboBox cmbSemester;
	Object Semester [] = {"--Select--",1, 2, 3, 4, 5, 6, 7, 8};
	JButton btnFirst, btnPrevious, btnNext, btnLast;
	String SubjectName;
	int SubjectID;
	Object objSemester;
	public Connection conn;
	public Statement stmt,s1,st;
	public ResultSet rs,r1;
	/**Defining Constructor*/
    public ViewSubject() 
	{
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.white);
		setLayout(new BorderLayout());
		setLocation(320, 0);
		setSize(700, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(153, 0, 51));

		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Times New Roman", 0, 40));
		lblHeader.setForeground(new Color(255, 255, 255));
		
		pnlImage = new JPanel();
		pnlImage.setBackground(new Color(255, 255, 255));

		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("View Subjects.jpg"));

		pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.white);
		pnlCenter.setLayout(new GridLayout(2, 1, 10, 15));

		pnlSubjectPanel = new JPanel();
		pnlSubjectPanel.setBackground(new Color(255, 255, 255));

		pnlSubject = new JPanel();
		pnlSubject.setBackground(new Color(255, 255, 255));
		pnlSubject.setLayout(new GridLayout(3, 2, 10, 15));

		pnlFooter = new JPanel();
		pnlFooter.setBackground(new Color(153, 0, 51));

		lblFooter = new JLabel("Copyright © Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));
		
		lblSubjectId = new JLabel ("Subject Id");
		lblSubjectId.setFont(new Font("Adventure Subtitles", 0, 18));
		lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setFont(new Font("Adventure Subtitles", 0, 18));
		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Adventure Subtitles", 0, 18));
		
		txtSubjectID = new JTextField("", 15);
		txtSubjectID.setFont(new Font("Adventure Subtitles", 0, 18));
		txtSubjectName = new JTextField ("", 15);
		txtSubjectName.setFont(new Font("Adventure Subtitles", 0, 18));
		cmbSemester = new JComboBox(Semester);
		cmbSemester.setFont(new Font("Adventure Subtitles", 0, 18));

		btnFirst = new JButton("First");
		btnFirst.setFont(new Font("Adventure Subtitles", 0, 18));
		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Adventure Subtitles", 0, 18));
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Adventure Subtitles", 0, 18));
		btnLast = new JButton("Last");
		btnLast.setFont(new Font("Adventure Subtitles", 0, 18));
		
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 4, 10, 0));
		pnlButtons.setBackground(Color.white);
		
		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);	
		
		lblFooter = new JLabel("Copyright © Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));

		pnlFooterText = new JPanel();
		pnlFooterText.setLayout(new GridBagLayout());
		pnlFooterText.setBackground(new Color(153, 0, 51));

		pnlFooter = new JPanel();
		pnlFooter.setLayout(new GridLayout(2, 1, 10, 10));
		pnlFooter.setBackground(Color.white);

		connect();
		DisabledFields(false);
    }
	/** The method which add all the instantiated components to the frame and makes the frame visible*/
	public void LaunchFrame()
	{
		add(pnlHeader, BorderLayout.NORTH);
		pnlHeader.add(lblHeader, new GridBagConstraints());
		
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.add(pnlImage);
		pnlImage.add(lblImage, new GridBagConstraints());
		pnlCenter.add(pnlSubjectPanel);

		pnlSubject.add(lblSubjectId);
		pnlSubject.add(txtSubjectID);
		pnlSubject.add(lblSubjectName);
		pnlSubject.add(txtSubjectName);
		pnlSubject.add(lblSemester);
		pnlSubject.add(cmbSemester);

		pnlSubjectPanel.add(pnlSubject);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(lblFooter, new GridBagConstraints());

		btnFirst.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
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
	/** The method, which disables the fields, which are not required to be enabled*/
	private void DisabledFields(boolean b)
	{
		txtSubjectName.setEnabled(b);
		cmbSemester.setEnabled(b);
		btnFirst.setEnabled(!b);
		btnPrevious.setEnabled(!b);
		btnNext.setEnabled(!b);
		btnLast.setEnabled(!b);	
	}
	/** Implementing the method of the interface ActionListener*/
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
				{	
					rs.beforeFirst();
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
	/** A method which displays the records on the frame to its associated fields*/
	private void Display(ResultSet rs) throws SQLException
	{
		txtSubjectID.setText(rs.getString("SubjectID"));
		txtSubjectName.setText(rs.getString("SubjectName"));
		cmbSemester.setSelectedItem(rs.getString("Semester"));
		txtSubjectID.requestFocus();
	 }
	 /** A method which, initiates the connection*/
	public void connect()
	{	
		try
		{
			rs=StudConnection.executeQuery("select * from Subject_Management");
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
/** Creating a class that connects the frame with the database */
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
