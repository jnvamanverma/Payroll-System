package payroll.com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.service.impl.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserServiceImpl userServiceImpl=new UserServiceImpl();
	private JPanel contentPane;
	private JTextField txtUserId;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnForgotPassword;
	private JLabel label;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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

	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setBounds(87, 181, 75, 17);
		lblUserId.setForeground(new Color(0, 0, 255));
		lblUserId.setBackground(new Color(128, 128, 128));
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblUserId);

		txtUserId = new JTextField();
		txtUserId.setBounds(210, 181, 236, 20);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(68, 228, 75, 14);
		lblPassword.setForeground(new Color(0, 0, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(68, 293, 89, 23);
		btnLogin.setForeground(new Color(255, 0, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String userId = txtUserId.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				System.out.println(userId + " - " + password);
				
				LoginData loginData=new LoginData();
				loginData.setPassword(password);
				loginData.setUserId(userId);

				boolean response = userServiceImpl.login(loginData);
				if (response) {
                   EmployeeFrame employeeFrame=new EmployeeFrame(userId);
                   employeeFrame.setVisible(true);
                   setVisible(false);
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"UserId Or Password Incorrect");
				}

			}
		});
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 227, 236, 20);
		contentPane.add(passwordField);
		
		btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(355, 293, 147, 23);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1=JOptionPane.showInputDialog("enter your user id");
				String str2=JOptionPane.showInputDialog("Enter your aadhar number");
				Employee emp=new Employee();
				emp.setAadharnumber(str2);
				emp.setUserId(str1);
				if(userServiceImpl.aadharVerification(emp)==true)
				{ForgotPasswordFrame forgotPassword=new ForgotPasswordFrame();
				forgotPassword.setVisible(true);
				setVisible(false);
				}
				else JOptionPane.showMessageDialog(contentPane, " user id or Aadhar number not matched");
			}
		});
		btnForgotPassword.setForeground(new Color(255, 0, 255));
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnForgotPassword);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeFrame homeFrame=new HomeFrame();
				homeFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		btnBack.setBounds(10, 11, 42, 23);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setBounds(0, 0, 576, 339);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\LoginFrame.jpg"));
		contentPane.add(label);
		
		
	}
}
