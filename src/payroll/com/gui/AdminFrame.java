package payroll.com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.entity.LoginData;
import payroll.com.service.impl.AdminServiceDaoImpl;
import payroll.com.service.impl.UserServiceImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    AdminServiceDaoImpl adminServiceDaoImpl=new AdminServiceDaoImpl();
	UserServiceImpl userServiceImpl = new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame("125");
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
	public AdminFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 557, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//setSize(1650,1080);

		JButton btnHireEmployee = new JButton("HIRE EMPLOYEE");
		btnHireEmployee.setBounds(10, 71, 171, 38);
		btnHireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RegistrationFrame registrationForm = new RegistrationFrame(userId, null);
				registrationForm.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		btnHireEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnHireEmployee);

		JButton btnFireEmployee = new JButton("FIRE EMPLOYEE");
		btnFireEmployee.setBounds(25, 180, 147, 38);
		btnFireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userid1 = JOptionPane.showInputDialog("enter user id of employee");

				boolean response = adminServiceDaoImpl.fireEmployee(userid1);
				if (response == false) {
					JOptionPane.showMessageDialog(contentPane, "error in deletion or user id not found");
				} else
					JOptionPane.showMessageDialog(contentPane, "employee removed successfully");
			}
		});
		btnFireEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnFireEmployee);

		JButton btnEditDetails = new JButton("EDIT DETAILS");
		btnEditDetails.setBounds(10, 120, 171, 38);
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String empUserId = JOptionPane.showInputDialog("enter user id of employee");
				RegistrationFrame form = new RegistrationFrame(userId, empUserId);
				form.setVisible(true);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnEditDetails);

		JButton btnMakeAdmin = new JButton("Make Admin");
		btnMakeAdmin.setBounds(25, 236, 147, 38);
		btnMakeAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog("enter employee id");
				//AdminServiceDaoImpl adminServiceDaoImpl=new AdminServiceDaoImpl();
				boolean res=adminServiceDaoImpl.makeAdmin(str);
				if(res==true)
					JOptionPane.showMessageDialog(contentPane, "type of user is changes to admin successfully");
				else 
					JOptionPane.showMessageDialog(contentPane, "Sorry!!! error in making admin");
			}
		});
		btnMakeAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnMakeAdmin);

		JLabel lblAdministrator = new JLabel("ADMINISTRATOR");
		lblAdministrator.setBounds(7, 21, 204, 49);
		lblAdministrator.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAdministrator);

		JButton btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogOut.setBounds(459, 314, 53, 39);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//UserServiceImpl userServiceImpl = new UserServiceImpl();
				boolean res = userServiceImpl.logOut(userId);
				if (res == true) {
					LoginData loginData=new LoginData();
					loginData.setUserId(userId);
					loginData.setLoginStatus(0);
					LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
					System.out.println(loginDataDaoImpl.editLoginData(loginData));
					LoginFrame loginFrame=new LoginFrame();
					loginFrame.setVisible(true);
					setVisible(false);
				} else
					JOptionPane.showMessageDialog(contentPane, "sorry there is some error in logged you out");
			}
		});
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnLogOut);
		
		JButton btnDisplayAllEmployees = new JButton("DISPLAY ALL EMPLOYEES");
		btnDisplayAllEmployees.setBounds(10, 285, 222, 23);
		btnDisplayAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeTableFrame employeeTableFrame=new EmployeeTableFrame(userId);
			       employeeTableFrame.setVisible(true);
			       setVisible(false);
			}
		});
		btnDisplayAllEmployees.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnDisplayAllEmployees);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(221, 22, 320, 342);
		lblNewLabel.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\AdminFrame.jpg"));
		contentPane.add(lblNewLabel);
		
		JButton btnGeneratePaySlip = new JButton("Generate Pay slip");
		btnGeneratePaySlip.setBounds(10, 319, 204, 23);
		btnGeneratePaySlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GeneratePaySlipFrame generatePaySlipFrame=new GeneratePaySlipFrame(userId);
				generatePaySlipFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnGeneratePaySlip.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnGeneratePaySlip);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeFrame employeeFrame=new EmployeeFrame(userId);
				employeeFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		btnBack.setBounds(7, 0, 42, 23);
		contentPane.add(btnBack);

	}
}
