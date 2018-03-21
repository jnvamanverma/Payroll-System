package payroll.com.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ForgotPasswordFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordNewPassword;
	private JPasswordField passwordConfirmPassword;
	private JButton btnSubmit;
	private JButton btnReset;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordFrame frame = new ForgotPasswordFrame();
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
	public ForgotPasswordFrame() {
		setTitle("FORGOT PASSWORD");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResetPassword = new JLabel("RESET PASSWORD");
		lblResetPassword.setBounds(199, 11, 180, 32);
		lblResetPassword.setForeground(new Color(0, 0, 255));
		lblResetPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblResetPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(191, 55, 169, 32);
		lblNewPassword.setForeground(new Color(220, 20, 60));
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(176, 86, 169, 32);
		lblConfirmPassword.setForeground(new Color(255, 0, 0));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblConfirmPassword);

		passwordNewPassword = new JPasswordField();
		passwordNewPassword.setBounds(342, 64, 235, 20);
		passwordNewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordNewPassword.getPassword().length < 8)
					JOptionPane.showMessageDialog(contentPane, "Password too short");
				passwordNewPassword.setText(null);
			}
		});
		contentPane.add(passwordNewPassword);

		passwordConfirmPassword = new JPasswordField();
		passwordConfirmPassword.setBounds(342, 95, 235, 20);
		passwordConfirmPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordConfirmPassword.getPassword().length < 8)
					JOptionPane.showMessageDialog(contentPane, "Password too short");
				passwordConfirmPassword.setText(null);
			}
		});
		contentPane.add(passwordConfirmPassword);

		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(45, 338, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (!(passwordNewPassword.getText().length() > 7)
						&& !(passwordConfirmPassword.getText().length() > 7)) {
					JOptionPane.showMessageDialog(contentPane, "password too short or not matched");
					passwordNewPassword.setText(null);
					passwordConfirmPassword.setText(null);
					
				}
				else
					if (passwordNewPassword.getText().toString().equals(passwordConfirmPassword.getText().toString())) {
						LoginFrame frame = new LoginFrame();
						frame.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(contentPane, "PASSWORD MISMATCH");
						passwordNewPassword.setText(null);
						passwordConfirmPassword.setText(null);
					}

			}
		});
		btnSubmit.setForeground(new Color(255, 0, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSubmit);

		btnReset = new JButton("RESET");
		btnReset.setBounds(271, 338, 89, 23);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordNewPassword.setText(null);
				passwordConfirmPassword.setText(null);
			}
		});
		btnReset.setForeground(new Color(255, 0, 255));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame loginFrame=new LoginFrame();
				loginFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		btnBack.setBounds(33, 4, 42, 23);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setBounds(22, 0, 577, 372);
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\ForgotPasswordFrame.jpg"));
		contentPane.add(label);
		

	}
}
