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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import payroll.com.dao.impl.AddressDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.entity.Address;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;
import payroll.com.service.impl.EmployeeServiceDaoImpl;
import payroll.com.service.impl.UserServiceImpl;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EditProfileFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldEmployeeName;
	private JTextField textFieldEmailId;
	private JTextField textFieldMobileNo;
	private JTextField textFieldAccountNo;
	private JTextField textFieldLastName;
	private JTextField textStreet;
	private JTextField textDistrict;
	private JTextField textState;
	private JTextField textCity;
	private JTextField textPin;
	private JTextField textPFAccount;
	private JTextField textPFPercentage;
	private JTextField textAadharNo;
	private JTextField textFieldEmployeeId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfileFrame frame = new EditProfileFrame("125");
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
	public EditProfileFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("EDIT PROFILE");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 664);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(32, 84, 118, 17);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFirstName);

		textFieldEmployeeName = new JTextField();
		textFieldEmployeeName.setBounds(160, 84, 197, 20);
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

		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(32, 228, 70, 17);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEmailId);

		textFieldEmailId = new JTextField();
		textFieldEmailId.setBounds(160, 228, 197, 20);
		textFieldEmailId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEmailId.getText();
			}
		});
		getContentPane().add(textFieldEmailId);
		textFieldEmailId.setColumns(10);

		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(32, 182, 81, 14);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblMobileNo);

		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setBounds(160, 181, 197, 20);
		textFieldMobileNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMobileNo.getText();
			}
		});
		getContentPane().add(textFieldMobileNo);
		textFieldMobileNo.setColumns(10);

		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setBounds(407, 181, 109, 17);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblAccountNo);

		textFieldAccountNo = new JTextField();
		textFieldAccountNo.setBounds(534, 181, 153, 20);
		textFieldAccountNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAccountNo.getText();
			}
		});
		getContentPane().add(textFieldAccountNo);
		textFieldAccountNo.setColumns(10);

		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(407, 87, 91, 14);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(534, 84, 153, 20);
		getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setBounds(407, 229, 115, 14);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(33, 272, 101, 14);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(294, 305, 125, 38);
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblAddress);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(35, 361, 67, 25);
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblStreet);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(386, 366, 46, 14);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblCity);

		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setBounds(36, 408, 66, 14);
		lblDistrict.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDistrict);

		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(386, 408, 46, 14);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPin);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(36, 446, 46, 14);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblState);

		textStreet = new JTextField();
		textStreet.setBounds(160, 365, 136, 20);
		getContentPane().add(textStreet);
		textStreet.setColumns(10);

		textDistrict = new JTextField();
		textDistrict.setBounds(160, 407, 136, 20);
		getContentPane().add(textDistrict);
		textDistrict.setColumns(10);

		textState = new JTextField();
		textState.setBounds(160, 445, 136, 20);
		getContentPane().add(textState);
		textState.setColumns(10);

		textCity = new JTextField();
		textCity.setBounds(514, 365, 136, 20);
		getContentPane().add(textCity);
		textCity.setColumns(10);

		textPin = new JTextField();
		textPin.setBounds(514, 407, 136, 20);
		getContentPane().add(textPin);
		textPin.setColumns(10);

		JLabel lblPf = new JLabel("P F Details ");
		lblPf.setBounds(294, 497, 153, 30);
		lblPf.setForeground(Color.BLUE);
		lblPf.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblPf);

		JLabel lblPFAccount = new JLabel("P F Account");
		lblPFAccount.setBounds(51, 553, 83, 14);
		lblPFAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPFAccount);

		textPFAccount = new JTextField();
		textPFAccount.setBounds(160, 552, 146, 20);
		getContentPane().add(textPFAccount);
		textPFAccount.setColumns(10);

		JLabel lblPFPercentage = new JLabel("P F Percentage");
		lblPFPercentage.setBounds(386, 553, 112, 14);
		lblPFPercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPFPercentage);

		textPFPercentage = new JTextField();
		textPFPercentage.setBounds(514, 552, 136, 20);
		getContentPane().add(textPFPercentage);
		textPFPercentage.setColumns(10);

		JLabel lblAadharNo = new JLabel("Aadhar No.");
		lblAadharNo.setBounds(407, 136, 91, 14);
		lblAadharNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblAadharNo);

		textAadharNo = new JTextField();
		textAadharNo.setBounds(534, 135, 153, 20);
		getContentPane().add(textAadharNo);
		textAadharNo.setColumns(10);

		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setBounds(160, 270, 101, 20);
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] { "male", "female", "others" }));
		getContentPane().add(comboBoxGender);

		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setBounds(32, 136, 102, 14);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEmployeeId);

		textFieldEmployeeId = new JTextField();
		textFieldEmployeeId.setBounds(160, 135, 197, 20);
		getContentPane().add(textFieldEmployeeId);
		textFieldEmployeeId.setColumns(10);
		textFieldEmployeeId.setEditable(false);

		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setBounds(407, 274, 130, 14);
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblChangePassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(534, 271, 153, 20);
		getContentPane().add(passwordField);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(534, 228, 153, 20);
		getContentPane().add(dateChooser);
		

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(294, 594, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				EmployeeServiceDaoImpl daoImpl=new EmployeeServiceDaoImpl();
				
				LoginData loginData=new LoginData();
				Employee employee=new Employee();
				Address address=new Address();
				PF pf=new PF();
				
				employee.setFirstName(textFieldEmployeeName.getText());
				employee.setLastName(textFieldLastName.getText());
				employee.setUserId(textFieldEmployeeId.getText());
				employee.setAadharnumber(textAadharNo.getText());
				employee.setMobileNumber(textFieldMobileNo.getText());
				employee.setAccountNumber(textFieldAccountNo.getText());
				employee.setEmailId(textFieldEmailId.getText());
				employee.setDob(dateChooser.getDate());
				employee.setGender(comboBoxGender.getSelectedItem().toString());
				
				loginData.setPassword(passwordField.getText());
				loginData.setUserId(textFieldEmployeeId.getText());
				
				address.setUserId(textFieldEmployeeId.getText());
				address.setStreet(textStreet.getText());
				address.setCity(textCity.getText());
				address.setDistrict(textDistrict.getText());
				address.setPin((Integer.parseInt(textPin.getText())));
				address.setState(textState.getText());
				
				pf.setUserId(textFieldEmployeeId.getText());
				pf.setPfAccountNumber(textPFAccount.getText());
				pf.setPfPercentage(Double.parseDouble(textPFPercentage.getText()));
				
				
				
				if(daoImpl.editdetails(loginData, employee, address, pf)==true)
				{
					JOptionPane.showMessageDialog(getContentPane(),"resource successfully submitted ");
					ProfileFrame profile=new ProfileFrame(userId);
					profile.setVisible(true);
					setVisible(false);
				}else
				{
					JOptionPane.showMessageDialog(getContentPane(),"Sorry!!!  Error in submitting resources ");
				}
				
			}
		});
		btnSubmit.setForeground(new Color(0, 0, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(btnSubmit);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setBounds(561, 28, 53, 39);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserServiceImpl impl = new UserServiceImpl();
				boolean res = impl.logOut(userId);
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
					JOptionPane.showMessageDialog(getContentPane(), "sorry there is some error in logged you out");
			}
			
		});
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogOut.setForeground(new Color(255, 0, 0));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(btnLogOut);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfileFrame profileFrame=new ProfileFrame(userId);
				profileFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		btnBack.setBounds(10, 11, 42, 23);
		getContentPane().add(btnBack);

		if (!(userId == null)) {
			EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();
			Employee employee = daoImpl.searchEmployee(userId);
			textFieldEmployeeName.setText(employee.getFirstName());
			textFieldLastName.setText(employee.getLastName());
			textFieldMobileNo.setText(employee.getMobileNumber());
			LoginDataDaoImpl daoImpl2 = new LoginDataDaoImpl();
			LoginData loginData = daoImpl2.searchLoginData(userId);
			textFieldEmployeeId.setText(loginData.getUserId());
			passwordField.setText(loginData.getPassword());

			if (!(employee.getAccountNumber() == null)) {
				textAadharNo.setText(employee.getAadharnumber());
				textFieldAccountNo.setText(employee.getAccountNumber());
				textFieldEmailId.setText(employee.getEmailId());
				dateChooser.setDate(employee.getDob());
				if (employee.getGender().equals("male"))
					comboBoxGender.setSelectedIndex(0);
				else if (employee.getGender().equals("female"))
					comboBoxGender.setSelectedIndex(1);
				else
					comboBoxGender.setSelectedItem(2);

				AddressDaoImpl daoImpl3 = new AddressDaoImpl();
				Address address = daoImpl3.searchAddress(userId);
				textStreet.setText(address.getStreet());
				textCity.setText(address.getCity());
				textDistrict.setText(address.getDistrict());
				textPin.setText(Integer.toString(address.getPin()));
				textState.setText(address.getState());

				PFDaoImpl daoImpl4 = new PFDaoImpl();
				PF pf = daoImpl4.searchPF(userId);
				textPFAccount.setText(pf.getPfAccountNumber());
				textPFPercentage.setText(Double.toString(pf.getPfPercentage()));
			}

		}

	}
}
