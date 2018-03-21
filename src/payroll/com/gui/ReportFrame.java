package payroll.com.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ReportFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPFAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportFrame frame = new ReportFrame("128");
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
	public ReportFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("PAYROLL SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReport = new JLabel("REPORT");
		lblReport.setBounds(223, 11, 81, 36);
		lblReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblReport);
		
		JButton btnPaySlip = new JButton("PAY SLIP");
		btnPaySlip.setBounds(269, 338, 122, 23);
		btnPaySlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PayslipFrame payslip=new PayslipFrame(userId);
				payslip.setVisible(true);
				setVisible(false);
			
			}
		});
		btnPaySlip.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnPaySlip);
		
		JButton btnAttendance = new JButton("ATTENDANCE");
		btnAttendance.setBounds(68, 338, 142, 23);
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttendanceFrame attendanceFrame=new AttendanceFrame(userId);
				attendanceFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnAttendance);
		
		JLabel lblPFAmount = new JLabel("P F Amount");
		lblPFAmount.setBounds(68, 303, 122, 14);
		lblPFAmount.setBackground(Color.WHITE);
		lblPFAmount.setForeground(Color.BLACK);
		lblPFAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblPFAmount);
		
		textPFAmount = new JTextField();
		textPFAmount.setBounds(269, 301, 122, 23);
		contentPane.add(textPFAmount);
		textPFAmount.setColumns(10);
		textPFAmount.setEditable(false);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 58, 528, 222);
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\ReportFrame.jpg"));
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 0, 42, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfileFrame profileFrame=new ProfileFrame(userId);
				profileFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("");
		btnLogout.addActionListener(new ActionListener() {
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
		btnLogout.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogout.setBounds(429, 11, 53, 39);
		contentPane.add(btnLogout);
		
		if(!(userId==null)){
			PFDaoImpl daoImpl=new PFDaoImpl();
			PF pf=daoImpl.searchPF(userId);
			textPFAmount.setText(Double.toString(pf.getPfAmount()));
		}
	}
}
