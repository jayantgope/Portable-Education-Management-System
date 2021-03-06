/** Creating a package*/
package subject_management;
/** Importing predefined packages*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/** A class is created by making an IS-A relation also an interface is implemented*/
public class UpdateSubject extends JFrame implements ActionListener
{
	JLabel lblSubjectId, lblSubjectName, lblSemester, lblHeader, lblImage, lblFooter;
	JPanel pnlHeader, pnlFooter, pnlImage, pnlSubjectPanel, pnlSubject, pnlCenter, pnlButtons, pnlbt, pnlFooterText;
	JTextField txtSubjectID, txtSubjectName;
	JComboBox cmbSemester;
	Object Semester [] = {"--Select--",1, 2, 3, 4, 5, 6, 7, 8};
	JButton btnSearch, btnUpdate, btnDelete, btnClear, btnCancel;
	String SubjectName;
	int SubjectID;
	Object objSemester;
	ResultSet rs;
	/** Defining the constructor*/
    public UpdateSubject() 
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
		lblImage.setIcon(new ImageIcon("Update Subjects.jpg"));

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

		lblFooter = new JLabel("Copyright � Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));
		
		lblSubjectId = new JLabel ("Subject Id");
		lblSubjectId.setFont(new Font("Adventure Subtitles", 0, 18));
		lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setFont(new Font("Adventure Subtitles", 0, 18));
		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Adventure Subtitles", 0, 18));
		
		txtSubjectID = new JTextField("", 10);
		txtSubjectID.setFont(new Font("Adventure Subtitles", 0, 18));
		txtSubjectName = new JTextField ("", 10);
		txtSubjectName.setFont(new Font("Adventure Subtitles", 0, 18));
		cmbSemester = new JComboBox(Semester);
		cmbSemester.setFont(new Font("Adventure Subtitles", 0, 18));

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

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 5, 10, 0));
		pnlButtons.setBackground(Color.white);
		
		pnlbt = new JPanel();
		pnlbt.setLayout(new GridBagLayout());
		pnlbt.setBackground(Color.white);	
		
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
	/** The method which adds all the instantiated components to the frame and makes it visible*/
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
	/** Implementing the method of the interface ActionListener*/
	public void actionPerformed( ActionEvent e)
	{
		if (e.getSource() == btnSearch)
		{
			if((txtSubjectID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null,"First enter the Subject ID to search the details");
			}
			else
			{
				//Handling the NumberFormatException
				try
				{
					int i = Integer.parseInt(txtSubjectID.getText());
					//Call to Search method
					Search(i);
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter the Subject ID in numeric value");
					txtSubjectID.requestFocus();
				}
			}
		}
		else if (e.getSource() == btnUpdate)
		{
			if ((txtSubjectID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Subject ID, for which you want to Update the record");
			}
			else if ((txtSubjectName.getText()).equals("") || cmbSemester.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null, "Please, enter all the fields");
			}
			else
			{
				SubjectID = Integer.parseInt(txtSubjectID.getText());
				SubjectName = txtSubjectName.getText();
				objSemester = cmbSemester.getSelectedItem();
				// Call to update method
				Update();
			}
		}
		else if(e.getSource() == btnDelete)
		{  

			if ((txtSubjectID.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please, enter the Subject ID, which you want to delete");
			}
			else
			{
				int i = Integer.parseInt(txtSubjectID.getText());
				//Call to delete function
				Delete(i); 
				Clear();
			}
		}
		else if(e.getSource() == btnClear)
		{
			//Call to clear function
			Clear();
		}
		else if(e.getSource() == btnCancel)
		{			
			dispose();
		}

	}
	/** The method which received an argument and searches for the record on the basis of the argument received*/
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
			String sql = "select * from Subject_Management where SubjectID ="+ SID +"";
			rs=state.executeQuery(sql);
			if(rs.next())
			{
				txtSubjectID.setText(rs.getString("SubjectID"));
				txtSubjectName.setText(rs.getString("SubjectName"));
				cmbSemester.setSelectedItem(rs.getInt("Semester"));
				flag=true;
			}
			if(txtSubjectName.getText().equals("") && cmbSemester.getSelectedItem().equals("--Select--"))
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
	/** The method, which updates the redords of the subject*/
	void Update()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Drivers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			int i=Integer.parseInt(txtSubjectID.getText());
			String sql = "UPDATE Subject_Management set SubjectName= '"+SubjectName+"',Semester= "+objSemester+" WHERE SubjectID= "+i;           
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
	/** The method used to delete the record*/
	void Delete(int SID)
	{ 
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Divers loaded successfully");
			Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
			System.out.println("Connection established successfully");
			Statement state = connect.createStatement();
			String sql = "delete from Subject_Management where SubjectID = ("+ SID +")";
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
	/** The method which clears all the fields of the form*/
	void Clear()
	{
		txtSubjectID.setText("");
		txtSubjectName.setText("");				
		cmbSemester.setSelectedItem("--Select--");
	}
}
