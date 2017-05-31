/** Creation of a package*/
package report;
/** Importing predefined packages, in order to use predefined methods and constructors*/
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
/** Creating a class NewReport by making an IS-A relation*/
public class NewReport extends JFrame
{
	/** Declaring Variables*/
	JLabel lblHeader, lblFooter;
	JPanel pnlFooter, pnlHeader, pnlCenter, pnlScrollPane;
	Vector columnNames;
	Vector data ;
	JTable table;
	JButton button;
	String sql;
	JScrollPane scrollPane;
	/** Defining Constructor*/
	public NewReport()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Reports");
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setBackground(Color.white);
		setLocation(0, 0);
		setSize(1365, 720);
		pnlScrollPane = new JPanel(new BorderLayout());

		
		setExtendedState(Frame.MAXIMIZED_BOTH);

		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Verdana", 0, 40));
		lblHeader.setForeground(new Color(255, 255, 255));
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(153, 0, 51));
		pnlHeader.add(lblHeader);
		add(pnlHeader, BorderLayout.NORTH);

		pnlCenter = new JPanel ();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setLayout(new GridBagLayout());
		add(pnlCenter, BorderLayout.CENTER);
		
		lblFooter = new JLabel("Copyright © Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));
		

		pnlFooter = new JPanel();
		pnlFooter.setBackground(new Color(153, 0, 51));
		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(lblFooter);

		/** Making the frame visible*/
		setVisible(true);
	}
	/** This method generates the report and displays it on the JTable*/
	public void Display(int x)
	{
		columnNames = new Vector();
		data = new Vector();
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:EMS";
	        Connection connection = DriverManager.getConnection(url);
			System.out.println("Connection established successfully");
			if(x == 1)
			{
				sql = "Select * from Employee_Management";
			}
			else if(x == 2)
			{
				sql = "Select * from Student_Management where JoiningYear = '2013'";
			}
			else if(x == 3)
			{
				sql = "Select * from Student_Management where JoiningYear = '2012'";
			}
			else if(x == 4)
			{
				sql = "Select * from Student_Management where JoiningYear = '2011'";
			}
			else if(x == 5)
			{
				sql = "Select * from Student_Management where JoiningYear = '2010'";
			}
			else if(x == 6)
			{
				sql = "Select * from Student_Management where ProgramCode = 'CSE'";
			}
			else if(x == 7)
			{
				sql = "Select * from Student_Management where ProgramCode = 'COM'";
			}
			else if(x == 8)
			{
				sql = "Select * from Student_Management where ProgramCode = 'EEE'";
			}
			else if(x == 9)
			{
				sql = "Select * from Student_Management where ProgramCode = 'EE'";
			}
			else if(x == 10)
			{
				sql = "Select * from Student_Management where ProgramCode = 'ME'";
			}
			else if(x == 11)
			{
				sql = "Select * from Student_Management where EnrolmentStatus = 'Active'";
			}
			else if(x == 12)
			{
				sql = "Select * from Student_Management where EnrolmentStatus = 'Passout'";
			}
			else if(x == 13)
			{
				sql = "Select * from Student_Management where EnrolmentStatus = 'Suspended'";
			}
			else if(x == 14)
			{
				sql = "Select * from Student_Management where EnrolmentStatus = 'Expelled'";
			}
			else if(x == 15)
			{
				sql = "Select * from Subject_Management where Semester = '1'";
			}
			else if(x == 16)
			{
				sql = "Select * from Subject_Management where Semester = '2'";
			}
			else if(x == 17)
			{
				sql = "Select * from Subject_Management where Semester = '3'";
			}
			else if(x == 18)
			{
				sql = "Select * from Subject_Management where Semester = '4'";
			}
			else if(x == 19)
			{
				sql = "Select * from Subject_Management where Semester = '5'";
			}
			else if(x == 20)
			{
				sql = "Select * from Subject_Management where Semester = '6'";
			}
			else if(x == 21)
			{
				sql = "Select * from Subject_Management where Semester = '7'";
			}
			else if(x == 22)
			{
				sql = "Select * from Subject_Management where Semester = '8'";
			}
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) 
			{
				columnNames.addElement( md.getColumnName(i) );
			}
			while (rs.next()) 
			{
				Vector row = new Vector(columns);
				for (int i = 1; i <= columns; i++)
				{
					row.addElement( rs.getObject(i) );
				}
				data.addElement( row );
			}
			rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		/** Instantiating the JTable*/
		table = new JTable(data, columnNames);
		TableColumn col;
		for (int i = 0; i < table.getColumnCount(); i++) 
		{
			col = table.getColumnModel().getColumn(i);
			col.setMinWidth(100);
			col.setMaxWidth(200);
			
			table.setRowHeight(20);
			table.setFont(new Font("Times New Roman", 0, 18));
			table.setForeground(new Color(153, 0, 51));
			scrollPane = new JScrollPane(table);
			pnlScrollPane.add( scrollPane );
			pnlCenter.add(pnlScrollPane);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			table.setFillsViewportHeight(false);
		}
	}
}