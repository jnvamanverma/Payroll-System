package payroll.com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EmployeeTableFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton buttonLogOut;
	private JButton buttonBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeTableFrame frame = new EmployeeTableFrame("125");
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
	public EmployeeTableFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setFont(new Font("Dialog", Font.BOLD, 17));
		setTitle("DISPLAY EMPLOYEE DATA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBounds(173, 11, 495, 31);
		table = new JTable();

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(new String[] { "UseId", "FirstName", "LastName" });

		table.setModel(model);

		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ArrayList<UserProfile> list = new ArrayList<UserProfile>();
				ArrayList<Employee> list = daoImpl.getAll();

				DefaultTableModel model1 = new DefaultTableModel();
				model1.setColumnIdentifiers(new String[] { "userId", "Firstname", "Lastname", "DateOfBirth", "EmailId",
						"Gender", "MobileNo", "AadharNo", "WorkType", "AccountNo", "Designation", "Department" });
				for (Employee employee : list) {

					model1.addRow(new Object[] { employee.getUserId(), employee.getFirstName(), employee.getLastName(),
							employee.getDob(), employee.getEmailId(), employee.getGender(), employee.getMobileNumber(),
							employee.getAadharnumber(), employee.getWorkType(), employee.getAccountNumber(),
							employee.getDesignation(), employee.getDepartment() });

				}
				table.setModel(model1);
			}
		});
		contentPane.setLayout(null);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnDisplay);

		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(173, 429, 471, 31);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginData loginData=new LoginData();
				loginData.setUserId(userId);
				loginData.setLoginStatus(0);
				LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
				System.out.println(loginDataDaoImpl.editLoginData(loginData));
				System.exit(0);

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnExit);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 933, 168);
		contentPane.add(scrollPane);

		// table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 223, 933, 206);
		lblNewLabel.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\EmployeeTableFrame.jpg"));
		contentPane.add(lblNewLabel);
		
		buttonLogOut = new JButton("");
		buttonLogOut.setBounds(814, 11, 53, 39);
		buttonLogOut.addActionListener(new ActionListener() {
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
		buttonLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		contentPane.add(buttonLogOut);
		
		buttonBack = new JButton("");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame adminFrame=new AdminFrame(userId);
				adminFrame.setVisible(true);
				setVisible(false);
			}
		});
		buttonBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		buttonBack.setBounds(10, 11, 42, 23);
		contentPane.add(buttonBack);
	}
}
