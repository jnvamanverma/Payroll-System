package payroll.com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import payroll.com.dao.impl.AddressDaoImpl;
import payroll.com.dao.impl.DepartmentDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.entity.Address;
import payroll.com.entity.Department;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.Salary;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ProfileFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldFirstName;
	private JTextField textFieldEmployeeId;
	private JTextField textFieldEmailId;
	private JTextField textFieldMobileNo;
	private JTextField textFieldDepartment;
	private JTextField textFieldDesignation;
	private JTextField textFieldAccountNo;
	private JTextField textFieldDepartmentNo;
	private JTextField textFieldLastName;
	private JTextField textFieldGender;
	private JTextField textFieldUserType;
	private JTextField textFieldWorkType;
	private JTextField textFieldDateOfBirth;
	private JTextField textStreet;
	private JTextField textDistrict;
	private JTextField textState;
	private JTextField textCity;
	private JTextField textPin;
	private JTextField textBasicSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame frame = new ProfileFrame("125");
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

	public ProfileFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("PROFILE");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 721);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(32, 84, 118, 17);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFirstName);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(32, 122, 101, 17);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEmployeeId);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(160, 84, 197, 20);
		getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		if (!(userId == null))
			textFieldFirstName.setEditable(false);

		textFieldEmployeeId = new JTextField();
		textFieldEmployeeId.setBounds(160, 122, 197, 20);
			textFieldEmployeeId.setEditable(false);
		getContentPane().add(textFieldEmployeeId);
		textFieldEmployeeId.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Designation");
		lblNewLabel_20.setBounds(396, 462, 67, -9);
		getContentPane().add(lblNewLabel_20);

		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setBounds(286, 0, 228, 49);
		lblEmployeeDetails.setForeground(Color.BLUE);
		lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblEmployeeDetails);

		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(32, 214, 70, 17);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEmailId);

		textFieldEmailId = new JTextField();
		textFieldEmailId.setBounds(160, 214, 197, 20);
		getContentPane().add(textFieldEmailId);
		textFieldEmailId.setColumns(10);
		if (!(userId == null))
			textFieldEmailId.setEditable(false);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(32, 265, 81, 14);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblMobileNo);

		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setBounds(160, 265, 197, 20);
		if (!(userId == null))
			textFieldMobileNo.setEditable(false);
		getContentPane().add(textFieldMobileNo);
		textFieldMobileNo.setColumns(10);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(42, 404, 91, 17);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDepartment);

		textFieldDepartment = new JTextField();
		textFieldDepartment.setBounds(160, 404, 197, 20);
		if (!(userId == null))
			textFieldDepartment.setEditable(false);
		getContentPane().add(textFieldDepartment);
		textFieldDepartment.setColumns(10);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(42, 450, 91, 17);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDesignation);

		textFieldDesignation = new JTextField();
		textFieldDesignation.setBounds(160, 450, 197, 20);
		if (!(userId == null))
			textFieldDesignation.setEditable(false);
		getContentPane().add(textFieldDesignation);
		textFieldDesignation.setColumns(10);

		JLabel lblUserType = new JLabel("Usertype");
		lblUserType.setBounds(407, 122, 91, 17);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblUserType);

		JLabel lblWorkType = new JLabel("WorkType");
		lblWorkType.setBounds(408, 167, 90, 17);
		lblWorkType.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblWorkType);

		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setBounds(413, 264, 109, 17);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblAccountNo);

		textFieldAccountNo = new JTextField();
		textFieldAccountNo.setBounds(532, 264, 153, 20);
		if (!(userId == null))
			textFieldAccountNo.setEditable(false);
		getContentPane().add(textFieldAccountNo);
		textFieldAccountNo.setColumns(10);

		JLabel lblDepartmentNo = new JLabel("Department No.");
		lblDepartmentNo.setBounds(404, 404, 118, 17);
		lblDepartmentNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDepartmentNo);

		textFieldDepartmentNo = new JTextField();
		textFieldDepartmentNo.setBounds(532, 404, 153, 20);
			textFieldDepartmentNo.setEditable(false);
		getContentPane().add(textFieldDepartmentNo);
		textFieldDepartmentNo.setColumns(10);

		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(407, 87, 91, 14);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(534, 84, 153, 20);
		getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);
		if (!(userId == null))
			textFieldLastName.setEditable(false);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setBounds(407, 215, 115, 14);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(32, 168, 101, 14);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblGender);

		textFieldGender = new JTextField();
		textFieldGender.setBounds(166, 167, 86, 20);
		getContentPane().add(textFieldGender);
		textFieldGender.setColumns(10);
		if (!(userId == null))
			textFieldGender.setEditable(false);

		textFieldUserType = new JTextField();
		textFieldUserType.setBounds(534, 122, 153, 20);
		getContentPane().add(textFieldUserType);
		textFieldUserType.setColumns(10);
		if (!(userId == null))
			textFieldUserType.setEditable(false);

		textFieldWorkType = new JTextField();
		textFieldWorkType.setBounds(534, 167, 86, 20);
		getContentPane().add(textFieldWorkType);
		textFieldWorkType.setColumns(10);
		if (!(userId == null))
			textFieldWorkType.setEditable(false);

		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setBounds(534, 214, 86, 20);
		getContentPane().add(textFieldDateOfBirth);
		textFieldDateOfBirth.setColumns(10);
			textFieldDateOfBirth.setEditable(false);

		JLabel lblDepartmentHeader = new JLabel("DEPARTMENT");
		lblDepartmentHeader.setBounds(278, 322, 185, 49);
		lblDepartmentHeader.setForeground(Color.BLUE);
		lblDepartmentHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblDepartmentHeader);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(286, 481, 125, 38);
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblAddress);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(32, 521, 67, 25);
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblStreet);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(408, 526, 46, 14);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblCity);

		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setBounds(32, 572, 66, 14);
		lblDistrict.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDistrict);

		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(413, 572, 46, 14);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPin);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(32, 614, 46, 14);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblState);

		textStreet = new JTextField();
		textStreet.setBounds(160, 525, 153, 20);
		getContentPane().add(textStreet);
		textStreet.setColumns(10);
		if (!(userId == null))
			textStreet.setEditable(false);

		textDistrict = new JTextField();
		textDistrict.setBounds(160, 571, 153, 20);
		getContentPane().add(textDistrict);
		textDistrict.setColumns(10);
		if (!(userId == null))
			textDistrict.setEditable(false);

		textState = new JTextField();
		textState.setBounds(160, 613, 153, 20);
		getContentPane().add(textState);
		textState.setColumns(10);
		if (!(userId == null))
			textState.setEditable(false);

		textCity = new JTextField();
		textCity.setBounds(532, 525, 153, 20);
		getContentPane().add(textCity);
		textCity.setColumns(10);
		if (!(userId == null))
			textCity.setEditable(false);

		textPin = new JTextField();
		textPin.setBounds(534, 571, 151, 20);
		getContentPane().add(textPin);
		textPin.setColumns(10);
		if (!(userId == null))
			textPin.setEditable(false);

		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setBounds(406, 451, 115, 14);
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblBasicSalary);

		textBasicSalary = new JTextField();
		textBasicSalary.setBounds(532, 450, 150, 20);
		getContentPane().add(textBasicSalary);
		textBasicSalary.setColumns(10);
			textBasicSalary.setEditable(false);
			
			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EmployeeFrame employeeFrame=new EmployeeFrame(userId);
					employeeFrame.setVisible(true);
					setVisible(false);
				}
			});
			button.setBounds(10, 11, 42, 23);
			button.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
			getContentPane().add(button);
			
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
			btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
			btnLogOut.setBounds(621, 17, 53, 39);
			getContentPane().add(btnLogOut);
			
		//	if (!(textFieldUserType.getText().equals("admin")))
			//	btnMoreOptions.setVisible(false);
		//}
		/*else
		{
			JButton btnSearch = new JButton("SEARCH EMPlOYEE");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					Employee employee=new Employee();
					employee.setFirstName(textFieldFirstName.getText());
					employee.setLastName(textFieldLastName.getText());
					employee.setWorkType(textFieldWorkType.getText());
					employee.setMobileNumber(textFieldMobileNo.getText());
					employee.setDesignation(textFieldDesignation.getText());
					employee.setDepartment(textFieldDepartment.getText());
					
					LoginData loginData = new LoginData();
					loginData.setUserType(textFieldUserType.getText());


						Address address = new Address();
						address.setStreet(textStreet.getText());
						address.setCity(textCity.getText());
						address.setPin(Integer.parseInt(textPin.getText()));
						address.setDistrict(textDistrict.getText());
						address.setState(textState.getText());
						
						String str=null;
					
				}
			});
			btnSearch.setForeground(Color.MAGENTA);
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSearch.setBounds(265, 644, 89, 23);
			getContentPane().add(btnSearch);
		}*/

		if (!(userId == null)) {
			EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();
			Employee employee = daoImpl.searchEmployee(userId);
			textFieldFirstName.setText(employee.getFirstName());
			textFieldLastName.setText(employee.getLastName());
			textFieldWorkType.setText(employee.getWorkType());
			textFieldMobileNo.setText(employee.getMobileNumber());
			textFieldDesignation.setText(employee.getDesignation());
			textFieldDepartment.setText(employee.getDepartment());

			DepartmentDaoImpl daoImpl2 = new DepartmentDaoImpl();
			Department department = daoImpl2.searchDepartment(employee.getDepartment());
			textFieldDepartmentNo.setText(department.getDepId());

			LoginDataDaoImpl daoImpl4 = new LoginDataDaoImpl();
			LoginData loginData = daoImpl4.searchLoginData(userId);
			textFieldUserType.setText(loginData.getUserType());
			textFieldEmployeeId.setText(userId);

			SalaryDaoImpl daoImpl5 = new SalaryDaoImpl();
			Salary salary = daoImpl5.searchSalary(userId);
			textBasicSalary.setText(Double.toString(salary.getBasicSalary()));
            System.out.println(employee.getAccountNumber());
			if (!(employee.getAccountNumber() == null)) {
				textFieldDateOfBirth.setText(employee.getDob().toString());
				textFieldGender.setText(employee.getGender());
				textFieldEmailId.setText(employee.getEmailId());
				textFieldAccountNo.setText(employee.getAccountNumber());

				AddressDaoImpl daoImpl3 = new AddressDaoImpl();
				Address address = daoImpl3.searchAddress(userId);
				textStreet.setText(address.getStreet());
				textCity.setText(address.getCity());
				textPin.setText(Integer.toString(address.getPin()));
				textDistrict.setText(address.getDistrict());
				textState.setText(address.getState());
			}
		}

	}
}
