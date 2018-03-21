package payroll.com.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import payroll.com.dao.impl.AttendanceSheetDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PaySlipDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PaySlip;
import payroll.com.extra.service.classes.CountAttendance;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AttendanceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component Absent = null;
	protected static final ButtonModel Present = null;
	protected static final Icon Apsent = null;
	private JPanel contentPane;
	private JTextField textFieldUserId;
	private JTextField textFieldFirstName;
	protected AbstractButton comboBox;
	protected Object testcon;
	protected Object sql;
	protected int total;
	protected Object stmnt;
	private JTextField textFieldLastName;
	private JTextField textFieldNoOfWorkingDays;
	private JTextField textFieldCL;
	private JTextField textFieldEL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceFrame frame = new AttendanceFrame("128");
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
	public AttendanceFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("Attendance\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(96, 40, 86, 20);
		contentPane.add(textFieldUserId);
		textFieldUserId.setColumns(10);
		textFieldUserId.setEditable(false);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(96, 95, 86, 20);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setEditable(false);
		
		JLabel lblUserId = new JLabel("User id");
		lblUserId.setBounds(10, 43, 76, 14);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblUserId);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 98, 63, 14);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 145, 125, 14);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(96, 143, 86, 20);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		textFieldLastName.setEditable(false);
		
		JLabel lblNoOfWorking = new JLabel("no of working days");
		lblNoOfWorking.setBounds(10, 197, 125, 14);
		lblNoOfWorking.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNoOfWorking);
		
		textFieldNoOfWorkingDays = new JTextField();
		textFieldNoOfWorkingDays.setBounds(159, 195, 86, 20);
		contentPane.add(textFieldNoOfWorkingDays);
		textFieldNoOfWorkingDays.setColumns(10);
		textFieldNoOfWorkingDays.setEditable(false);
		
		JButton btnLogOut = new JButton("");
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
		btnLogOut.setBounds(169, 344, 53, 39);
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogOut.setForeground(new Color(255, 0, 0));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnLogOut);
		
		JLabel label = new JLabel("");
		label.setBounds(271, 43, 335, 273);
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\AttendanceFrame.jpg"));
		contentPane.add(label);
		
		JButton buttonBack = new JButton("");
		buttonBack.setBounds(0, 0, 42, 23);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportFrame reportFrame=new ReportFrame(userId);
				reportFrame.setVisible(true);
				setVisible(false);
			}
		});
		buttonBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		contentPane.add(buttonBack);
		
		JLabel lblCl = new JLabel("CL");
		lblCl.setBounds(27, 241, 46, 14);
		lblCl.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblCl);
		
		JLabel lblEl = new JLabel("EL");
		lblEl.setBounds(30, 272, 46, 14);
		lblEl.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEl);
		
		textFieldCL = new JTextField();
		textFieldCL.setBounds(83, 239, 86, 20);
		contentPane.add(textFieldCL);
		textFieldCL.setColumns(10);
		textFieldCL.setEditable(false);
		
		textFieldEL = new JTextField();
		textFieldEL.setBounds(83, 270, 86, 20);
		contentPane.add(textFieldEL);
		textFieldEL.setColumns(10);
		textFieldEL.setEditable(false);
		
		
		if(!(userId==null)){
			PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
			EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
			AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
			Employee employee=employeeDaoImpl.searchEmployee(userId);
			String paySlipId=employee.getPaySlipId();
			PaySlip paySlip=paySlipDaoImpl.searchPaySlip(paySlipId);
			Date date1=paySlip.getPaidDate();
			Date date2=new Date();
			CountAttendance countAttendance=attendanceSheetDaoImpl.countAttendanceSheet(employee.getUserId(), date1, date2);
			
			textFieldFirstName.setText(employee.getFirstName());
			textFieldLastName.setText(employee.getLastName());
			textFieldUserId.setText(userId);
			textFieldNoOfWorkingDays.setText(Integer.toString(countAttendance.getWorkingDays()));
			textFieldCL.setText(Integer.toString(countAttendance.getCl()));
			textFieldEL.setText(Integer.toString(countAttendance.getEl()));
		}

	}
}
