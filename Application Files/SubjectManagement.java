/** Creating a package*/
package subject_management;
/** Importing the predefined packages*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/** Creating a class and making an IS-A relation also an Interface is Implemented*/
public class SubjectManagement extends JFrame implements ActionListener
{
	JLabel lblSubjectId, lblSubjectName, lblSemester, lblHeader, lblImage, lblFooter;
	JPanel pnlHeader, pnlFooter, pnlImage, pnlSubjectPanel, pnlSubject, pnlCenter, pnlButtons, pnlbt, pnlFooterText;
	JTextField txtSubjectID, txtSubjectName;
	JComboBox cmbSemester;
	Object Semester [] = {"--Select--",1, 2, 3, 4, 5, 6, 7, 8};
	JButton btnAdd, btnClear, btnCancel;
	String SubjectName;
	int SubjectID;
	Object objSemester;
	/** Defining the constructor*/
    public SubjectManagement() 
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
		lblImage.setIcon(new ImageIcon("Subjects.jpg"));

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
		
		txtSubjectID = new JTextField("", 10);
		txtSubjectID.setFont(new Font("Adventure Subtitles", 0, 18));
		txtSubjectName = new JTextField ("", 10);
		txtSubjectName.setFont(new Font("Adventure Subtitles", 0, 18));
		cmbSemester = new JComboBox(Semester);
		cmbSemester.setFont(new Font("Adventure Subtitles", 0, 18));

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Adventure Subtitles", 0, 18));
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Adventure Subtitles", 0, 18));
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Adventure Subtitles", 0, 18));

		
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(1, 3, 10, 0));
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
    }
	/** The method which add the components to the frame and makes the frame visible*/
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

		/** Adding actionListener to the buttons*/
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnCancel.addActionListener(this);
		
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
	/** Providing the implementation of the method of the interface ActionListener*/
	public void actionPerformed( ActionEvent e)
	  {
			if(e.getSource() == btnAdd)
			{
				if((txtSubjectID.getText()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Subject Id");
					txtSubjectID.requestFocus();
				}
				else if((txtSubjectName.getText()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Subject Name");
					txtSubjectName.requestFocus();
				}
				else if((cmbSemester.getSelectedItem()).equals("--Select--"))
				{
					JOptionPane.showMessageDialog(null, "Please Select the Semester");
				}
				else 
				{
					SubjectName = txtSubjectName.getText();
					objSemester = cmbSemester.getSelectedItem();
					AddtoDatabase();
				}
			}
			else if(e.getSource() == btnClear)
			{
				txtSubjectID.setText("");
				txtSubjectName.setText("");
				cmbSemester.setSelectedItem("--Select--");
			}
			else if(e.getSource() == btnCancel)
			{
				dispose();
			}

		}
		/** The methods which adds the data to the database*/
		void AddtoDatabase ()
		{
			try
			{
				// Written in try block, in order to catch the NumberFormatException
				SubjectID = Integer.parseInt(txtSubjectID.getText());
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Divers loaded successfully");
				Connection connect = DriverManager.getConnection("jdbc:odbc:EMS");
				System.out.println("Connection established successfully");
				Statement state = connect.createStatement();
				String sql = "insert into Subject_Management (SubjectID,SubjectName,Semester) values (" + SubjectID + ",'" + SubjectName + "'," + objSemester + ")";
				state.execute(sql);
				JOptionPane.showMessageDialog(null, "Record added Successfully");
				System.out.println("Statement executed successfully");
				state.close();
				connect.close();
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "The Subject ID already exist");
				txtSubjectID.requestFocus();
			}
			catch (NumberFormatException e)
			{
			    JOptionPane.showMessageDialog(null, "Please enter the Subject ID in numeric values");
				txtSubjectID.requestFocus();
			}
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
