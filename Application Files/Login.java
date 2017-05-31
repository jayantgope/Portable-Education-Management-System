/**Creating Package*/
package login;
/** Importing pre-defined packages in order to use the predefined methods and classes*/
import menubar.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** Creating a class by making IS-A relation and implementing the interface ActionListener */
public class Login extends JFrame implements ActionListener
{
	/** JLabel Variables*/
	JLabel lblUsername, lblPassword, lblLoginAs, lblHeader, lblImage, lblFooter;
	JPanel pnlHeader, pnlFooter, pnlImage, pnlLoginPanel, pnlLogin, pnlCenter;
	JTextField txtUsername;
	JPasswordField txtPassword;
	JComboBox cmbLoginAs;
	/** An array of String type*/
	String LoginAs [] = {"--Select--", "Administrator", "Employee", "Student"};
	JButton btnSubmit, btnClear;
	public static int Disabler;
    /** Creates new form Login */
    public Login() 
	{
		/** Setting the icon image for the frame*/
		setIconImage(getToolkit().getImage("EMS.svg.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		setLayout(new BorderLayout());
		setLocation(200, 20);
		setSize(1000, 700);
		/** Making the frame maximized*/
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(153, 0, 51));
	
		lblHeader = new JLabel("Portable Education Management System");
		lblHeader.setFont(new Font("Verdana", 0, 46));
		lblHeader.setForeground(new Color(255, 255, 255));
		
		
		pnlImage = new JPanel();
		pnlImage.setBackground(new Color(255, 255, 255));

		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("LoginImage-1.jpg"));

		pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.white);
		pnlCenter.setLayout(new GridLayout(2, 1, 10, 15));

		pnlLoginPanel = new JPanel();
		pnlLoginPanel.setBackground(new Color(255, 255, 255));
		pnlLoginPanel.setLayout(new GridBagLayout());

		pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(255, 255, 255));
		pnlLogin.setLayout(new GridLayout(4, 2, 10, 15));

		pnlFooter = new JPanel();
		pnlFooter.setBackground(new Color(153, 0, 51));

		lblFooter = new JLabel("Copyright © Jayant Gope 2014, All Rights Reserved");
		lblFooter.setFont(new Font("Times New Roman", 0, 20));
		lblFooter.setForeground(new Color(255, 255, 255));
		
		lblUsername = new JLabel ("Username");
		lblUsername.setFont(new Font("Adventure Subtitles", 0, 18));
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Adventure Subtitles", 0, 18));
		lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Adventure Subtitles", 0, 18));
		
		txtUsername = new JTextField("", 10);
		txtUsername.setFont(new Font("Adventure Subtitles", 0, 18));
		txtPassword = new JPasswordField ("", 10);
		cmbLoginAs = new JComboBox(LoginAs);
		cmbLoginAs.setFont(new Font("Adventure Subtitles", 0, 18));
		btnSubmit = new JButton("Submit");

		btnSubmit.setFont(new Font("Adventure Subtitles", 0, 18));
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Adventure Subtitles", 0, 18));
    }
	/** Defining the method LaunchFrame*/
	public void LaunchFrame()
	{
		add(pnlHeader, BorderLayout.NORTH);
		pnlHeader.add(lblHeader, new GridBagConstraints());
		
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.add(pnlImage);
		pnlImage.add(lblImage, new GridBagConstraints());
		pnlCenter.add(pnlLoginPanel);

		pnlLogin.add(lblUsername);
		pnlLogin.add(txtUsername);
		pnlLogin.add(lblPassword);
		pnlLogin.add(txtPassword);
		pnlLogin.add(lblLoginAs);
		pnlLogin.add(cmbLoginAs);
		pnlLogin.add(btnSubmit);
		pnlLogin.add(btnClear);
		pnlLoginPanel.add(pnlLogin);

		add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.add(lblFooter, new GridBagConstraints());

		btnSubmit.addActionListener(this);
		btnClear.addActionListener(this);

		setVisible(true);
	}
	/** Providing the implementation of the method of the Interface*/
	public void actionPerformed( ActionEvent e)
	  {
			JButton B = (JButton)e.getSource();
			String name = B.getLabel();
			if(name.equals("Clear"))
			{
				txtUsername.setText("");
				txtPassword.setText("");
				cmbLoginAs.setSelectedItem("--Select--");
			}
			else
			{
				if((txtUsername.getText()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Username");
					txtUsername.requestFocus();
				}
				else
				{
					if((txtPassword.getText()).equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter Password");
						txtPassword.requestFocus();
					}
					else
					{
						if((cmbLoginAs.getSelectedItem()).equals("--Select--"))
						{
							JOptionPane.showMessageDialog(null, "Please Select your Post");
						}
						else 
						{
							if(txtUsername.getText().equals("h") && txtPassword.getText().equals("w"))
							{
								if((cmbLoginAs.getSelectedItem()).equals("Administrator"))
								{
									JOptionPane.showMessageDialog(null,"Your Login Successful ");
									setVisible(false);
									Menubar m = new Menubar();
								}
								if((cmbLoginAs.getSelectedItem()).equals("Employee"))
								{
									JOptionPane.showMessageDialog(null,"Your Login Successful ");
									setVisible(false);
									Disabler = 1;
									Menubar m = new Menubar();
									m.LoginAs(Disabler);
								}
								if((cmbLoginAs.getSelectedItem()).equals("Student"))
								{
									JOptionPane.showMessageDialog(null,"Your Login Successful ");

									setVisible(false);
									Disabler = 2;
									Menubar m = new Menubar();
									m.LoginAs(Disabler);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Sorry, Incorrect Username or Password");
							}
						}
					}
				}
			}
	}
	/** Main Method*/
	public static void main(String args[])
	{
		Login N = new Login();
		N.LaunchFrame();
	}
}
