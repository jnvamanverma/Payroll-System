package payroll.com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.service.impl.EmployeeServiceDaoImpl;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame("125");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.setBounds(10, 96, 89, 23);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfileFrame profileFrame=new ProfileFrame(userId);
				profileFrame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnProfile);
		
		JButton btnResign = new JButton("RESIGN");
		btnResign.setBounds(10, 172, 89, 23);
		btnResign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "Do you really want to resign ?", "Resign", JOptionPane.YES_NO_OPTION);

				if (res == 0)
				{ 
					EmployeeServiceDaoImpl serviceDaoImpl=new EmployeeServiceDaoImpl();
					if(serviceDaoImpl.getResign(userId)==false)
					{
						JOptionPane.showMessageDialog(null,"error in resignation process");
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(),"your resignation is accepted");
						HomeFrame home=new HomeFrame();
						home.setVisible(true);
						setVisible(false);
					}
				} else 
				{
					JOptionPane.showMessageDialog(getContentPane(),"Your reisgnation has been cancelled..");
				}
			}
		});
		btnResign.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnResign);
		
		JButton btnEditDetails = new JButton("EDIT PROFILE");
		btnEditDetails.setBounds(10, 251, 130, 23);
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditProfileFrame editProfileFrame=new EditProfileFrame(userId);
				editProfileFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnEditDetails);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.setBounds(10, 305, 89, 23);
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportFrame reportFrame=new ReportFrame(userId);
				reportFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnReport);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(10, 11, 42, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame loginFrame=new LoginFrame();
				loginFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setBounds(371, 11, 53, 39);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginData loginData=new LoginData();
				loginData.setUserId(userId);
				loginData.setLoginStatus(0);
				LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
				System.out.println(loginDataDaoImpl.editLoginData(loginData));
				LoginFrame loginFrame=new LoginFrame();
				loginFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		contentPane.add(btnLogOut);
		
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=employeeDaoImpl.searchEmployee(userId);
		String heading="welcome    "+employee.getFirstName()+"   "+employee.getLastName();;
		JLabel lblWelcome = new JLabel(heading);
		lblWelcome.setBounds(88, 11, 277, 39);
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblWelcome);
		
		
		JButton btnMoreOptions = new JButton("MORE OPTIONS");
		btnMoreOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame admin = new AdminFrame(userId);
				admin.setVisible(true);
				setVisible(false);
			}
		});
		btnMoreOptions.setForeground(Color.RED);
		btnMoreOptions.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMoreOptions.setBounds(347, 61, 149, 23);
		contentPane.add(btnMoreOptions);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 506, 339);
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\employeeFrame.png"));
		contentPane.add(label);
		
       LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
       LoginData loginData=loginDataDaoImpl.searchLoginData(userId);
       if(!(loginData.getUserType().equals("admin")))
    	   btnMoreOptions.setVisible(false);
		

	}
}
