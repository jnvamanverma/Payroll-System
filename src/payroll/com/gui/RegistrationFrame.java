package payroll.com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.Salary;
import payroll.com.service.impl.AdminServiceDaoImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class RegistrationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmployeeName;
	private JTextField textFieldMobileNo;
	private JTextField textFieldDepartment;
	private JTextField textFieldDesignation;
	private JTextField textFieldLastName;
	private JTextField textBasicSalary;
	private JTextField textAllowance;
	private JTextField textBonus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationFrame frame = new RegistrationFrame("125", null);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegistrationFrame(String userId, String empUserId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("REGISTRATION");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 666);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(32, 101, 118, 17);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFirstName);

		textFieldEmployeeName = new JTextField();
		textFieldEmployeeName.setBounds(160, 101, 197, 20);
		textFieldEmployeeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEmployeeName.getText();
			}
		});
		getContentPane().add(textFieldEmployeeName);
		textFieldEmployeeName.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Designation");
		lblNewLabel_20.setBounds(396, 462, 67, -9);
		getContentPane().add(lblNewLabel_20);

		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setBounds(294, 11, 228, 49);
		lblEmployeeDetails.setForeground(Color.BLUE);
		lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblEmployeeDetails);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(32, 151, 81, 14);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblMobileNo);

		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setBounds(160, 150, 197, 20);
		textFieldMobileNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMobileNo.getText();
			}
		});
		getContentPane().add(textFieldMobileNo);
		textFieldMobileNo.setColumns(10);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(59, 322, 91, 17);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDepartment);

		textFieldDepartment = new JTextField();
		textFieldDepartment.setBounds(160, 322, 197, 20);
		textFieldDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDepartment.getText();
			}
		});
		getContentPane().add(textFieldDepartment);
		textFieldDepartment.setColumns(10);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(395, 322, 91, 17);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDesignation);

		textFieldDesignation = new JTextField();
		textFieldDesignation.setBounds(557, 322, 197, 20);
		textFieldDesignation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDesignation.getText();
			}
		});
		getContentPane().add(textFieldDesignation);
		textFieldDesignation.setColumns(10);

		JLabel lblWorkType = new JLabel("WorkType");
		lblWorkType.setBounds(396, 153, 90, 17);
		lblWorkType.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblWorkType);

		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(395, 103, 91, 14);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(534, 101, 153, 20);
		getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);

		JLabel lblDepartmentHeader = new JLabel("DEPARTMENT");
		lblDepartmentHeader.setBounds(278, 220, 185, 49);
		lblDepartmentHeader.setForeground(Color.BLUE);
		lblDepartmentHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblDepartmentHeader);

		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setBounds(59, 439, 115, 14);
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblBasicSalary);

		textBasicSalary = new JTextField();
		textBasicSalary.setBounds(160, 438, 150, 20);
		getContentPane().add(textBasicSalary);
		textBasicSalary.setColumns(10);

		JLabel lblSalary = new JLabel("SALARY");
		lblSalary.setBounds(311, 384, 91, 41);
		lblSalary.setForeground(Color.BLUE);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 19));
		getContentPane().add(lblSalary);

		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(396, 439, 46, 14);
		lblBonus.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblBonus);

		JLabel lblAllowance = new JLabel("Allowance");
		lblAllowance.setBounds(59, 482, 84, 14);
		lblAllowance.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblAllowance);

		textAllowance = new JTextField();
		textAllowance.setBounds(160, 481, 150, 20);
		getContentPane().add(textAllowance);
		textAllowance.setColumns(10);

		textBonus = new JTextField();
		textBonus.setBounds(557, 438, 153, 20);
		getContentPane().add(textBonus);
		textBonus.setColumns(10);

		JComboBox comboBoxWorkType = new JComboBox();
		comboBoxWorkType.setBounds(534, 150, 81, 20);
		comboBoxWorkType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxWorkType.setModel(new DefaultComboBoxModel(new String[] { "select", "full-time", "part-time" }));
		getContentPane().add(comboBoxWorkType);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(313, 523, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Employee employee = new Employee();
				Salary salary = new Salary();

				AdminServiceDaoImpl adminServiceDaoImpl = new AdminServiceDaoImpl();

				employee.setFirstName(textFieldEmployeeName.getText());
				employee.setLastName(textFieldLastName.getText());
				employee.setMobileNumber(textFieldMobileNo.getText());
				employee.setWorkType(comboBoxWorkType.getSelectedItem().toString());
				employee.setDepartment(textFieldDepartment.getText());
				employee.setDesignation(textFieldDesignation.getText());
				

				salary.setBasicSalary(Double.parseDouble(textBasicSalary.getText()));
				salary.setBonus(Double.parseDouble(textBonus.getText()));
				salary.setAllowance(Double.parseDouble(textAllowance.getText()));

				boolean response;
				if (empUserId == null)
					response = adminServiceDaoImpl.hireEmployee(employee, salary);
				else {
                       employee.setUserId(empUserId);
                       salary.setUserId(empUserId);
					response = adminServiceDaoImpl.editDetailsAdmin(employee, salary);
				}

				if (response == true) {
					JOptionPane.showMessageDialog(getContentPane(), "result submitted successfully");
					AdminFrame admin = new AdminFrame(userId);
					admin.setVisible(true);
                     setVisible(false);
				} else
					JOptionPane.showMessageDialog(getContentPane(), "error in submitting results");

			}
		});
		btnSubmit.setForeground(new Color(255, 0, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame adminFrame=new AdminFrame(userId);
				adminFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 11, 42, 23);
		btnNewButton.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		getContentPane().add(btnNewButton);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogOut.setBounds(694, 11, 53, 39);
		getContentPane().add(btnLogOut);

		if (!(empUserId == null)) {

			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			SalaryDaoImpl salaryDaoImpl = new SalaryDaoImpl();
			Employee employee = employeeDaoImpl.searchEmployee(empUserId);
			Salary salary = salaryDaoImpl.searchSalary(empUserId);

			textFieldEmployeeName.setText(employee.getFirstName());
			textFieldLastName.setText(employee.getLastName());
			textFieldMobileNo.setText(employee.getMobileNumber());
			// employee.setWorkType(comboBoxWorkType.getSelectedItem().toString());
			comboBoxWorkType.setSelectedItem(employee.getWorkType());
			textFieldDepartment.setText(employee.getDepartment());
			textFieldDesignation.setText(employee.getDesignation());

			textBasicSalary.setText(Double.toString(salary.getBasicSalary()));
			textBonus.setText(Double.toString(salary.getBonus()));
			textAllowance.setText(Double.toString(salary.getAllowance()));
		}
	}

}
