/**Creating Package*/
package menubar;
/** Importing pre-defined packages in order to use the predefined methods and classes*/
import student_management.*;
import employee_management.*;
import report.*;
import subject_management.*;
import login.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Creating a class by making IS-A relation and implementing the interface ActionListener*/
public class Menubar extends JMenuBar implements ActionListener,MouseListener 
{
	/** Declaring the JFrame variable F*/
	JFrame F;
	JMenuBar M;
	JMenu jmnuAdministrator, jmnuEmployee, jmnuStudent, jmnuReports, jmnuLogout, jmnuAdministratorEmployee, jmnuAdministratorStudent, jmnuAdministratorSubject, jmnuStudentReport, jmnuitmAs_Joining, jmnuitmAs_Stream, jmnuitmAs_Enrolment,jmnuEmployeeReport, jmnuSubjectReport;
	JMenuItem a1, a2, a3, a4, a5, a6, b1, b2, c1, e1, jmnuitmFirst_Year, jmnuitmSecond_Year, jmnuitmThird_Year, jmnuitmFinal_Year, jmnuitmCSE, jmnuitmCOM, jmnuitmEEE, jmnuitmEE, jmnuitmME, jmnuitmActive, jmnuitmPassout, jmnuitmSuspended, jmnuitmExpelled, jmnuitmAllEmployees, jmnuitm1stSemester, jmnuitm2ndSemester, jmnuitm3rdSemester, jmnuitm4thSemester, jmnuitm5thSemester, jmnuitm6thSemester, jmnuitm7thSemester, jmnuitm8thSemester, jmnuitmPopUp ;
	JPanel pnlMenu, pnlAfterMenu, pnlImage;
	JLabel lblImage;
	JPopupMenu PopMenu;
	public static int ReportValue;
	/** Constructor Creation */
	public Menubar ()
	{
		/**Creating n instance of JFrame*/
		F = new JFrame ("Menubar");
		F.setLocation(170, 0);
		F.setSize(1000, 700);
		F.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		F.setBackground(new Color(153, 0, 51));
		F.setExtendedState(JFrame.MAXIMIZED_BOTH);
		F.setUndecorated(true);
		M = new JMenuBar();
		M.setBackground(new Color(153, 0, 51));
		
		/**Creating an instance of JPopupMenu*/
		PopMenu = new JPopupMenu();

		jmnuAdministrator = new JMenu("Administrator  |");
		jmnuAdministrator.setForeground(Color.white);
		jmnuAdministrator.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuAdministrator.setMnemonic('A');

		jmnuEmployee = new JMenu("Employee  |");
		jmnuEmployee.setForeground(Color.white);
		jmnuEmployee.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuEmployee.setMnemonic('E');

		jmnuStudent = new JMenu("Student  |");
		jmnuStudent.setForeground(Color.white);
		jmnuStudent.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuStudent.setMnemonic('S');

		jmnuReports = new JMenu("Reports  |");
		jmnuReports.setForeground(Color.white);
		jmnuReports.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuReports.setMnemonic('R');

		jmnuLogout = new JMenu("Logout");
		jmnuLogout.setForeground(Color.white);
		jmnuLogout.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuLogout.setMnemonic('L');

		jmnuAdministratorEmployee = new JMenu("Employee Management");
		jmnuAdministratorEmployee.setForeground(new Color(153, 0, 51));
		jmnuAdministratorEmployee.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuAdministratorEmployee.setIcon(new ImageIcon(ClassLoader.getSystemResource("Profile (1).png")));
		
		jmnuAdministratorStudent = new JMenu("Student Management");
		jmnuAdministratorStudent.setForeground(new Color(153, 0, 51));
		jmnuAdministratorStudent.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuAdministratorStudent.setIcon(new ImageIcon(ClassLoader.getSystemResource("Graduate-male-24.png")));

		jmnuAdministratorSubject = new JMenu("Subject Management");
		jmnuAdministratorSubject.setForeground(new Color(153, 0, 51));
		jmnuAdministratorSubject.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuAdministratorSubject.setIcon(new ImageIcon(ClassLoader.getSystemResource("7186-24x24x32.png")));

		jmnuEmployeeReport = new JMenu("Employees");
		jmnuEmployeeReport.setForeground(new Color(153, 0, 51));
		jmnuEmployeeReport.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuEmployeeReport.setIcon(new ImageIcon(ClassLoader.getSystemResource("Profile (1).png")));

		jmnuStudentReport = new JMenu("Students");
		jmnuStudentReport.setForeground(new Color(153, 0, 51));
		jmnuStudentReport.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuStudentReport.setIcon(new ImageIcon(ClassLoader.getSystemResource("Graduate-male-24.png")));

		jmnuSubjectReport = new JMenu("Subjects");
		jmnuSubjectReport.setForeground(new Color(153, 0, 51));
		jmnuSubjectReport.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuSubjectReport.setIcon(new ImageIcon(ClassLoader.getSystemResource("7186-24x24x32.png")));


		jmnuitmAs_Joining = new JMenu("As Per Joining");
		jmnuitmAs_Joining.setForeground(new Color(153, 0, 51));
		jmnuitmAs_Joining.setFont(new Font("Adventure Subtitles", 0, 20));

		jmnuitmAs_Stream = new JMenu("As Per Stream");
		jmnuitmAs_Stream.setForeground(new Color(153, 0, 51));
		jmnuitmAs_Stream.setFont(new Font("Adventure Subtitles", 0, 20));

		jmnuitmAs_Enrolment = new JMenu("As Per Enrolment Status");
		jmnuitmAs_Enrolment.setForeground(new Color(153, 0, 51));
		jmnuitmAs_Enrolment.setFont(new Font("Adventure Subtitles", 0, 20));

		a1 = new JMenuItem("Add Employee");
		a1.setFont(new Font("Adventure Subtitles", 0, 20));
		a1.setBackground(Color.white);
		a1.setForeground(new Color(153, 0, 51));
		a1.addActionListener(this);

		a2 = new JMenuItem("Update Employee");
		a2.setFont(new Font("Adventure Subtitles", 0, 20));
		a2.setBackground(Color.white);
		a2.setForeground(new Color(153, 0, 51));
		a2.addActionListener(this);

		a3 = new JMenuItem("Add Student");
		a3.setFont(new Font("Adventure Subtitles", 0, 20));
		a3.setBackground(Color.white);
		a3.setForeground(new Color(153, 0, 51));
		a3.addActionListener(this);

		a4 = new JMenuItem("Update Student");
		a4.setFont(new Font("Adventure Subtitles", 0, 20));
		a4.setBackground(Color.white);
		a4.setForeground(new Color(153, 0, 51));
		a4.addActionListener(this);

		a5 = new JMenuItem("Add Subject");
		a5.setFont(new Font("Adventure Subtitles", 0, 20));
		a5.setBackground(Color.white);
		a5.setForeground(new Color(153, 0, 51));
		a5.addActionListener(this);

		a6 = new JMenuItem("Update Subject");
		a6.setFont(new Font("Adventure Subtitles", 0, 20));
		a6.setBackground(Color.white);
		a6.setForeground(new Color(153, 0, 51));
		a6.addActionListener(this);

		b1 = new JMenuItem("View Employees");
		b1.setFont(new Font("Adventure Subtitles", 0, 20));
		b1.setBackground(Color.white);
		b1.setForeground(new Color(153, 0, 51));
		b1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Profile (1).png")));
		b1.addActionListener(this);

		b2 = new JMenuItem("View Subject");
		b2.setFont(new Font("Adventure Subtitles", 0, 20));
		b2.setBackground(Color.white);
		b2.setForeground(new Color(153, 0, 51));
		b2.setIcon(new ImageIcon(ClassLoader.getSystemResource("7186-24x24x32.png")));
		b2.addActionListener(this);

		c1 = new JMenuItem("View Students");
		c1.setFont(new Font("Adventure Subtitles", 0, 20));
		c1.setBackground(Color.white);
		c1.setForeground(new Color(153, 0, 51));
		c1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Graduate-male-24.png")));
		c1.addActionListener(this);

		e1 = new JMenuItem("Logout");
		e1.setFont(new Font("Adventure Subtitles", 0, 20));
		e1.setBackground(Color.white);
		e1.setForeground(new Color(153, 0, 51));
		
		e1.addActionListener(this);

		jmnuitmFirst_Year = new JMenuItem("1st Year");
		jmnuitmFirst_Year.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmFirst_Year.setBackground(Color.white);
		jmnuitmFirst_Year.setForeground(new Color(153, 0, 51));
		jmnuitmFirst_Year.addActionListener(this);

		jmnuitmSecond_Year = new JMenuItem("2nd Year");
		jmnuitmSecond_Year.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmSecond_Year.setBackground(Color.white);
		jmnuitmSecond_Year.setForeground(new Color(153, 0, 51));
		jmnuitmSecond_Year.addActionListener(this);

		jmnuitmThird_Year = new JMenuItem("3rd Year");
		jmnuitmThird_Year.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmThird_Year.setBackground(Color.white);
		jmnuitmThird_Year.setForeground(new Color(153, 0, 51));
		jmnuitmThird_Year.addActionListener(this);

		jmnuitmFinal_Year = new JMenuItem("Final Year");
		jmnuitmFinal_Year.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmFinal_Year.setBackground(Color.white);
		jmnuitmFinal_Year.setForeground(new Color(153, 0, 51));
		jmnuitmFinal_Year.addActionListener(this);

		jmnuitmCSE = new JMenuItem("CSE");
		jmnuitmCSE.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmCSE.setBackground(Color.white);
		jmnuitmCSE.setForeground(new Color(153, 0, 51));
		jmnuitmCSE.addActionListener(this);

		jmnuitmCOM = new JMenuItem("COM");
		jmnuitmCOM.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmCOM.setBackground(Color.white);
		jmnuitmCOM.setForeground(new Color(153, 0, 51));
		jmnuitmCOM.addActionListener(this);

		jmnuitmEEE = new JMenuItem("EEE");
		jmnuitmEEE.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmEEE.setBackground(Color.white);
		jmnuitmEEE.setForeground(new Color(153, 0, 51));
		jmnuitmEEE.addActionListener(this);

		jmnuitmEE = new JMenuItem("EE");
		jmnuitmEE.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmEE.setBackground(Color.white);
		jmnuitmEE.setForeground(new Color(153, 0, 51));
		jmnuitmEE.addActionListener(this);

		jmnuitmME = new JMenuItem("ME");
		jmnuitmME.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmME.setBackground(Color.white);
		jmnuitmME.setForeground(new Color(153, 0, 51));
		jmnuitmME.addActionListener(this);

		jmnuitmActive = new JMenuItem("Active");
		jmnuitmActive.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmActive.setBackground(Color.white);
		jmnuitmActive.setForeground(new Color(153, 0, 51));
		jmnuitmActive.addActionListener(this);

		jmnuitmPassout = new JMenuItem("Passout");
		jmnuitmPassout.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmPassout.setBackground(Color.white);
		jmnuitmPassout.setForeground(new Color(153, 0, 51));
		jmnuitmPassout.addActionListener(this);

		jmnuitmSuspended = new JMenuItem("Suspended");
		jmnuitmSuspended.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmSuspended.setBackground(Color.white);
		jmnuitmSuspended.setForeground(new Color(153, 0, 51));
		jmnuitmSuspended.addActionListener(this);

		jmnuitmExpelled = new JMenuItem("Expelled");
		jmnuitmExpelled.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmExpelled.setBackground(Color.white);
		jmnuitmExpelled.setForeground(new Color(153, 0, 51));
		jmnuitmExpelled.addActionListener(this);

		
		jmnuitmAllEmployees = new JMenuItem("All Employees");
		jmnuitmAllEmployees.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmAllEmployees.setBackground(Color.white);
		jmnuitmAllEmployees.setForeground(new Color(153, 0, 51));
		jmnuitmAllEmployees.addActionListener(this);

		
		jmnuitm1stSemester = new JMenuItem("1st Semester");
		jmnuitm1stSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm1stSemester.setBackground(Color.white);
		jmnuitm1stSemester.setForeground(new Color(153, 0, 51));
		jmnuitm1stSemester.addActionListener(this);
			
		
		jmnuitm2ndSemester = new JMenuItem("2nd Semester");
		jmnuitm2ndSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm2ndSemester.setBackground(Color.white);
		jmnuitm2ndSemester.setForeground(new Color(153, 0, 51));
		jmnuitm2ndSemester.addActionListener(this);
			
		jmnuitm3rdSemester = new JMenuItem("3rd Semester");
		jmnuitm3rdSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm3rdSemester.setBackground(Color.white);
		jmnuitm3rdSemester.setForeground(new Color(153, 0, 51));
		jmnuitm3rdSemester.addActionListener(this);

		jmnuitm4thSemester = new JMenuItem("4th Semester");
		jmnuitm4thSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm4thSemester.setBackground(Color.white);
		jmnuitm4thSemester.setForeground(new Color(153, 0, 51));
		jmnuitm4thSemester.addActionListener(this);

		jmnuitm5thSemester = new JMenuItem("5th Semester");
		jmnuitm5thSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm5thSemester.setBackground(Color.white);
		jmnuitm5thSemester.setForeground(new Color(153, 0, 51));
		jmnuitm5thSemester.addActionListener(this);
	
		jmnuitm6thSemester = new JMenuItem("6th Semester");
		jmnuitm6thSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm6thSemester.setBackground(Color.white);
		jmnuitm6thSemester.setForeground(new Color(153, 0, 51));
		jmnuitm6thSemester.addActionListener(this);

		jmnuitm7thSemester = new JMenuItem("7th Semester");
		jmnuitm7thSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm7thSemester.setBackground(Color.white);
		jmnuitm7thSemester.setForeground(new Color(153, 0, 51));
		jmnuitm7thSemester.addActionListener(this);

		jmnuitm8thSemester = new JMenuItem("8th Semester");
		jmnuitm8thSemester.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitm8thSemester.setBackground(Color.white);
		jmnuitm8thSemester.setForeground(new Color(153, 0, 51));
		jmnuitm8thSemester.addActionListener(this);

		jmnuitmPopUp = new JMenuItem("Exit Full Screen");
		jmnuitmPopUp.setFont(new Font("Adventure Subtitles", 0, 20));
		jmnuitmPopUp.setBackground(Color.white);
		jmnuitmPopUp.setForeground(new Color(153, 0, 51));
		jmnuitmPopUp.addActionListener(this);

		PopMenu.add(jmnuitmPopUp);
		F.addMouseListener(this);

		lblImage = new JLabel(new ImageIcon("Main-Page-Background.jpg"));
		pnlImage = new JPanel();
		pnlImage.setLayout(new BorderLayout());
		JSeparator north = new JSeparator(JSeparator.HORIZONTAL);
		pnlImage.setBackground(Color.white/*new Color(153, 0, 51)*/);

		//////////////////////////////////////////////////////////////////////////////////

		F.setJMenuBar(M);

		M.add(jmnuAdministrator);

		M.add(jmnuEmployee);

		M.add(jmnuStudent);

		M.add(jmnuReports);

		M.add(jmnuLogout);

		jmnuAdministrator.add(jmnuAdministratorEmployee);
		jmnuAdministrator.add(jmnuAdministratorStudent);
		jmnuAdministrator.add(jmnuAdministratorSubject);
		jmnuAdministratorEmployee.add(a1);
		jmnuAdministratorEmployee.add(a2);
		jmnuAdministratorStudent.add(a3);
		jmnuAdministratorStudent.add(a4);
		jmnuAdministratorSubject.add(a5);
		jmnuAdministratorSubject.add(a6);
		jmnuEmployee.add(b1);
		jmnuEmployee.add(b2);
		
		jmnuStudent.add(c1);

		jmnuReports.add(jmnuEmployeeReport);
		jmnuReports.add(jmnuStudentReport);
		jmnuReports.add(jmnuSubjectReport);
		
		jmnuEmployeeReport.add(jmnuitmAllEmployees);

		jmnuStudentReport.add(jmnuitmAs_Joining);
		jmnuStudentReport.add(jmnuitmAs_Stream);
		jmnuStudentReport.add(jmnuitmAs_Enrolment);

		jmnuitmAs_Joining.add(jmnuitmFirst_Year);
		jmnuitmAs_Joining.add(jmnuitmSecond_Year);
		jmnuitmAs_Joining.add(jmnuitmThird_Year);
		jmnuitmAs_Joining.add(jmnuitmFinal_Year);

		jmnuitmAs_Stream.add(jmnuitmCSE);
		jmnuitmAs_Stream.add(jmnuitmCOM);
		jmnuitmAs_Stream.add(jmnuitmEEE);
		jmnuitmAs_Stream.add(jmnuitmEE);
		jmnuitmAs_Stream.add(jmnuitmME);

		jmnuitmAs_Enrolment.add(jmnuitmActive);
		jmnuitmAs_Enrolment.add(jmnuitmPassout);
		jmnuitmAs_Enrolment.add(jmnuitmSuspended);
		jmnuitmAs_Enrolment.add(jmnuitmExpelled);

		jmnuSubjectReport.add(jmnuitm1stSemester);
		jmnuSubjectReport.add(jmnuitm2ndSemester);
		jmnuSubjectReport.add(jmnuitm3rdSemester);
		jmnuSubjectReport.add(jmnuitm4thSemester);
		jmnuSubjectReport.add(jmnuitm5thSemester);
		jmnuSubjectReport.add(jmnuitm6thSemester);
		jmnuSubjectReport.add(jmnuitm7thSemester);	
		jmnuSubjectReport.add(jmnuitm8thSemester);

		jmnuLogout.add(e1);

		F.add(pnlImage);
		pnlImage.add(lblImage);

		/**Making the Frame visible*/
		F.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		JMenuItem B = (JMenuItem)e.getSource();
		String S = B.getText();
		/** Methods are called on the basis of the click of the menu item */
		if(S.equals("Add Employee"))
		{
			EmployeeManagement E = new EmployeeManagement();
			E.LaunchFrame();
		}
		else if(S.equals("Update Employee"))
		{
			UpdateEmployee E = new UpdateEmployee();
			E.LaunchFrame();
		}
		else if(S.equals("Add Student"))
		{
			Student E = new Student();
			E.LaunchFrame();
		}
		else if(S.equals("Update Student"))
		{
			UpdateStudent E = new UpdateStudent();
			E.LaunchFrame();
		}
		else if(S.equals("Add Subject"))
		{
			SubjectManagement E = new SubjectManagement();
			E.LaunchFrame();		
		}
		else if(S.equals("Update Subject"))
		{
			UpdateSubject E = new UpdateSubject();
			E.LaunchFrame();
		}
		else if(S.equals("View Employees"))
		{
			EmployeeManagementforEmployees E = new EmployeeManagementforEmployees();
			E.LaunchFrame();
		}
		else if(S.equals("View Subject"))
		{
			ViewSubject E = new ViewSubject();
			E.LaunchFrame();
		}
		else if(S.equals("View Students"))
		{
			StudentManagementforStudent E = new StudentManagementforStudent();
			E.LaunchFrame();
		}
		else if(S.equals("All Employees"))
		{
			NewReport E = new NewReport();
			E.Display(1);
		}
		else if(S.equals("1st Year"))
		{
			NewReport E = new NewReport();
			E.Display(2);
		}
		else if(S.equals("2nd Year"))
		{
			NewReport E = new NewReport();
			E.Display(3);
		}
		else if(S.equals("3rd Year"))
		{
			NewReport E = new NewReport();
			E.Display(4);
		}
		else if(S.equals("Final Year"))
		{
			NewReport E = new NewReport();
			E.Display(5);
		}
		else if(S.equals("CSE"))
		{
			NewReport E = new NewReport();
			E.Display(6);
		}
		else if(S.equals("COM"))
		{
			NewReport E = new NewReport();
			E.Display(7);
		}
		else if(S.equals("EEE"))
		{
			NewReport E = new NewReport();
			E.Display(8);
		}
		else if(S.equals("EE"))
		{
			NewReport E = new NewReport();
			E.Display(9);
		}
		else if(S.equals("ME"))
		{
			NewReport E = new NewReport();
			E.Display(10);
		}
		else if(S.equals("Active"))
		{
			NewReport E = new NewReport();
			E.Display(11);
		}
		else if(S.equals("Passout"))
		{
			NewReport E = new NewReport();
			E.Display(12);
		}
		else if(S.equals("Suspended"))
		{
			NewReport E = new NewReport();
			E.Display(13);
		}
		else if(S.equals("Expelled"))
		{
			NewReport E = new NewReport();
			E.Display(14);
		}
		else if(S.equals("1st Semester"))
		{
			NewReport E = new NewReport();
			E.Display(15);
		}
		else if(S.equals("2nd Semester"))
		{
			NewReport E = new NewReport();
			E.Display(16);
		}
		else if(S.equals("3rd Semester"))
		{
			NewReport E = new NewReport();
			E.Display(17);
		}
		else if(S.equals("4th Semester"))
		{
			NewReport E = new NewReport();
			E.Display(18);
		}
		else if(S.equals("5th Semester"))
		{
			NewReport E = new NewReport();
			E.Display(19);
		}
		else if(S.equals("6th Semester"))
		{
			NewReport E = new NewReport();
			E.Display(20);
		}
		else if(S.equals("7th Semester"))
		{
			NewReport E = new NewReport();
			E.Display(21);
		}
		else if(S.equals("8th Semester"))
		{
			NewReport E = new NewReport();
			E.Display(22);
		}
		else if(S.equals("Logout"))
		{
			Login E = new Login();
			E.LaunchFrame();
			F.dispose();
		}
		else if (S.equals("Exit Full Screen"))
		{
			F.setExtendedState(JFrame.NORMAL);
			//F.ICONIFIED();
			//F.setSize(1000, 700);
			F.setUndecorated(false);		
		}
	}
	/** Method which makes the menu enable or disable on the basis of the login details */
	public void LoginAs(int i)
	{
		
		if(i == 1)
		{
			jmnuAdministrator.setEnabled(false);
			jmnuReports.setEnabled(false);

		}
		if(i == 2)
		{
			jmnuAdministrator.setEnabled(false);
			jmnuEmployee.setEnabled(false);
			jmnuReports.setEnabled(false);
		}

		
	}
	/** Implemention of the methods of the interface mouseListener*/
	public void mouseReleased(MouseEvent Me)
	{
		if(Me.isPopupTrigger())
		{
			PopMenu.show(Me.getComponent(), Me.getX(), Me.getY());
		}
	}
  
	 public void mouseClicked(MouseEvent me)
	{
	 }

     public void mouseExited(MouseEvent me){
     }
  
     public void mouseEntered(MouseEvent me){
     }
  
     public void mousePressed(MouseEvent me){
     }
}