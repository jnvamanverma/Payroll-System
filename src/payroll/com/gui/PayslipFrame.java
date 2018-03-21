package payroll.com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;

import payroll.com.dao.impl.AttendanceSheetDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.dao.impl.PaySlipDaoImpl;
import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.dao.impl.TaxDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;
import payroll.com.entity.PaySlip;
import payroll.com.entity.Salary;
import payroll.com.entity.Tax;
import payroll.com.extra.service.classes.CountAttendance;
import payroll.com.service.impl.UserServiceImpl;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PayslipFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtEmployeeId;
	private JTextField txtDepartment;
	private JTextField txtDaysWorked;
	private JTextField txtBankAccount;
	private JTextField txtCasualLeave;
	private JTextField txtName;
	private JTextField txtDesignation;
	private JTextField txtPfaccount;
	private JTextField txtPaySlipNo;
	private JTextField txtBasicPay;
	private JTextField txtAllowance;
	private JTextField txtBonus;
	private JTextField txtTotalEarnings;
	private JTextField txtTotalDeductions;
	private JTextField txtNetSalary;
	private JTextField textFieldIncomeTax;
	private JTextField textFieldServiceTax;
	private JTextField textFieldEmergencyLeave;
	private JTextField textFieldPfDeduction;

	/**
	 * Launch the application.
	 */

	
	
	
	private EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	private SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
	private AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
	private PFDaoImpl pfDaoImpl=new PFDaoImpl();
	private PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
	private TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
	
public static void main(String[] args) {
	PayslipFrame payslipFrame=new PayslipFrame("125");
	payslipFrame.setVisible(true);
}
	 

	/**
	 * Create the frame.
	 */
	public PayslipFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("PAY SLIP");
		setForeground(Color.RED);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setSize(1650,1080);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPayrollSystem = new JLabel("PAYROLL SYSTEM");
		lblPayrollSystem.setBounds(151, 23, 156, 14);
		lblPayrollSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblPayrollSystem);

		JLabel lblPayslipMonth = new JLabel("Payslip for the month of January 2017");
		lblPayslipMonth.setBounds(90, 48, 277, 14);
		lblPayslipMonth.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPayslipMonth);

		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setBounds(23, 99, 87, 14);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEmployeeId);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(23, 143, 87, 14);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDepartment);

		JLabel lblDaysWorked = new JLabel("Days Worked");
		lblDaysWorked.setBounds(23, 218, 87, 14);
		lblDaysWorked.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDaysWorked);

		JLabel lblBankAccount = new JLabel("Bank Account");
		lblBankAccount.setBounds(23, 180, 87, 14);
		lblBankAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBankAccount);

		JLabel lblCasualLeave = new JLabel("Casual Leave");
		lblCasualLeave.setBounds(23, 255, 87, 14);
		lblCasualLeave.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblCasualLeave);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setBounds(138, 96, 113, 20);
		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtEmployeeId);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setEditable(false);

		txtDepartment = new JTextField();
		txtDepartment.setBounds(138, 140, 113, 20);
		txtDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtDepartment);
		txtDepartment.setColumns(10);
		txtDepartment.setEditable(false);

		txtDaysWorked = new JTextField();
		txtDaysWorked.setBounds(138, 215, 113, 20);
		txtDaysWorked.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtDaysWorked);
		txtDaysWorked.setColumns(10);
		txtDaysWorked.setEditable(false);

		txtBankAccount = new JTextField();
		txtBankAccount.setBounds(138, 177, 113, 20);
		txtBankAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtBankAccount);
		txtBankAccount.setColumns(10);
		txtBankAccount.setEditable(false);

		txtCasualLeave = new JTextField();
		txtCasualLeave.setBounds(138, 253, 113, 20);
		contentPane.add(txtCasualLeave);
		txtCasualLeave.setColumns(10);
		txtCasualLeave.setEditable(false);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(261, 100, 86, 14);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblName);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(261, 144, 86, 14);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDesignation);

		JLabel lblPfaccount = new JLabel("P.F.Account");
		lblPfaccount.setBounds(261, 181, 86, 14);
		lblPfaccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPfaccount);

		JLabel lblPaySlipNo = new JLabel("Pay Slip No.");
		lblPaySlipNo.setBounds(261, 219, 86, 14);
		lblPaySlipNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPaySlipNo);

		txtName = new JTextField();
		txtName.setBounds(377, 97, 132, 20);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setEditable(false);

		txtDesignation = new JTextField();
		txtDesignation.setBounds(377, 141, 132, 20);
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtDesignation);
		txtDesignation.setColumns(10);
		txtDesignation.setEditable(false);

		txtPfaccount = new JTextField();
		txtPfaccount.setBounds(377, 178, 132, 20);
		txtPfaccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtPfaccount);
		txtPfaccount.setColumns(10);
		txtPfaccount.setEditable(false);

		txtPaySlipNo = new JTextField();
		txtPaySlipNo.setBounds(377, 216, 132, 20);
		txtPaySlipNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtPaySlipNo);
		txtPaySlipNo.setColumns(10);
		txtPaySlipNo.setEditable(false);

		JLabel lblDeductionsAmount = new JLabel("Deductions                         Amount");
		lblDeductionsAmount.setBounds(261, 307, 234, 14);
		lblDeductionsAmount.setBackground(new Color(0, 191, 255));
		lblDeductionsAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDeductionsAmount);

		txtBasicPay = new JTextField();
		txtBasicPay.setBounds(107, 353, 86, 20);
		txtBasicPay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtBasicPay);
		txtBasicPay.setColumns(10);
		txtBasicPay.setEditable(false);

		txtAllowance = new JTextField();
		txtAllowance.setBounds(107, 393, 86, 20);
		txtAllowance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtAllowance);
		txtAllowance.setColumns(10);
		txtAllowance.setEditable(false);

		txtBonus = new JTextField();
		txtBonus.setBounds(107, 439, 86, 20);
		txtBonus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtBonus);
		txtBonus.setColumns(10);
		txtBonus.setEditable(false);

		JPanel panel = new JPanel();
		panel.setBounds(10, 295, 241, 35);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEarningsAmount = new JLabel("Earnings              Amount");
		lblEarningsAmount.setBounds(33, 11, 158, 15);
		panel.add(lblEarningsAmount);
		lblEarningsAmount.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(248, 295, 261, 35);
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 330, 241, 143);
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblBasicPay = new JLabel("Basic Pay");
		lblBasicPay.setBounds(21, 24, 87, 14);
		panel_2.add(lblBasicPay);
		lblBasicPay.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblAllowance = new JLabel("Allowance");
		lblAllowance.setBounds(21, 61, 87, 14);
		panel_2.add(lblAllowance);
		lblAllowance.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(21, 104, 87, 14);
		panel_2.add(lblBonus);
		lblBonus.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(248, 330, 261, 143);
		panel_3.setBackground(new Color(0, 191, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblIncomeTax = new JLabel("Income Tax");
		lblIncomeTax.setBounds(20, 21, 106, 14);
		lblIncomeTax.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblIncomeTax);
		
		textFieldIncomeTax = new JTextField();
		textFieldIncomeTax.setBounds(153, 19, 86, 20);
		panel_3.add(textFieldIncomeTax);
		textFieldIncomeTax.setColumns(10);
		textFieldIncomeTax.setEditable(false);
		
		JLabel lblServiceTax = new JLabel("Service Tax");
		lblServiceTax.setBounds(20, 59, 106, 14);
		lblServiceTax.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblServiceTax);
		
		textFieldServiceTax = new JTextField();
		textFieldServiceTax.setBounds(153, 57, 86, 20);
		panel_3.add(textFieldServiceTax);
		textFieldServiceTax.setColumns(10);
		textFieldServiceTax.setEditable(false);
		
		JLabel lblPfDeduction = new JLabel("PF Deduction");
		lblPfDeduction.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPfDeduction.setBounds(20, 104, 106, 14);
		panel_3.add(lblPfDeduction);
		
		textFieldPfDeduction = new JTextField();
		textFieldPfDeduction.setBounds(153, 102, 86, 20);
		panel_3.add(textFieldPfDeduction);
		textFieldPfDeduction.setColumns(10);
		textFieldPfDeduction.setEditable(false);

		JLabel lblTotalEarnings = new JLabel("Total Earnings");
		lblTotalEarnings.setBounds(23, 491, 105, 14);
		lblTotalEarnings.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblTotalEarnings);

		txtTotalEarnings = new JTextField();
		txtTotalEarnings.setBounds(138, 484, 86, 20);
		txtTotalEarnings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtTotalEarnings);
		txtTotalEarnings.setColumns(10);
		txtTotalEarnings.setEditable(false);

		JLabel lblTotalDeductions = new JLabel("Total Deductions");
		lblTotalDeductions.setBounds(261, 492, 106, 14);
		lblTotalDeductions.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblTotalDeductions);

		txtTotalDeductions = new JTextField();
		txtTotalDeductions.setBounds(409, 489, 86, 20);
		txtTotalDeductions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtTotalDeductions);
		txtTotalDeductions.setColumns(10);
		txtTotalDeductions.setEditable(false);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 470, 241, 49);
		panel_4.setBackground(new Color(0, 191, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(248, 470, 261, 49);
		panel_5.setBackground(new Color(0, 191, 255));
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_5);

		JLabel lblNetSalary = new JLabel("Net Salary");
		lblNetSalary.setBounds(90, 530, 103, 14);
		lblNetSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNetSalary);

		txtNetSalary = new JTextField();
		txtNetSalary.setBounds(324, 530, 86, 20);
		txtNetSalary.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtNetSalary);
		txtNetSalary.setColumns(10);
		txtNetSalary.setEditable(false);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 516, 499, 40);
		panel_6.setBackground(new Color(0, 191, 255));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_6);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setBounds(442, 14, 53, 39);
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
					JOptionPane.showMessageDialog(contentPane, "sorry there is some error in logged you out");
			}
		});
		btnLogOut.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\log-out.jpg"));
		btnLogOut.setForeground(new Color(255, 0, 0));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnLogOut);
		
		JLabel lblEmergencyLeave = new JLabel("Emergency Leave");
		lblEmergencyLeave.setBounds(261, 255, 129, 14);
		lblEmergencyLeave.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEmergencyLeave);
		
		textFieldEmergencyLeave = new JTextField();
		textFieldEmergencyLeave.setBounds(377, 253, 132, 20);
		contentPane.add(textFieldEmergencyLeave);
		textFieldEmergencyLeave.setColumns(10);
		textFieldEmergencyLeave.setEditable(false);
		
		JButton buttonBack = new JButton("");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportFrame reportFrame=new ReportFrame(userId);
				reportFrame.setVisible(true);
				setVisible(false);
			}
		});
		buttonBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		buttonBack.setBounds(23, 14, 42, 23);
		contentPane.add(buttonBack);
		
		if(!(userId==null)){
			
			PF pf=pfDaoImpl.searchPF(userId);
			Employee employee=employeeDaoImpl.searchEmployee(userId);
			Salary salary=salaryDaoImpl.searchSalary(userId);
			Date date2=new Date();
			String paySlipId=employee.getPaySlipId();
			PaySlip paySlip=paySlipDaoImpl.searchPaySlip(paySlipId);
			Date date1=paySlip.getPaidDate();
			CountAttendance countAttendance=attendanceSheetDaoImpl.countAttendanceSheet(employee.getUserId(), date1, date2);
			Tax tax=taxDaoImpl.searchTax(userId);
			
			txtEmployeeId.setText(employee.getUserId());
			txtName.setText(employee.getFirstName()+" "+employee.getLastName());
			txtDepartment.setText(employee.getDepartment());
			txtDesignation.setText(employee.getDepartment());
			txtPfaccount.setText(pf.getPfAccountNumber());
			txtBankAccount.setText(employee.getAccountNumber());
			txtBonus.setText(Double.toString(salary.getBonus()));
			txtAllowance.setText(Double.toString(salary.getAllowance()));
			txtBasicPay.setText(Double.toString(salary.getBasicSalary()));
			txtDaysWorked.setText(Integer.toString(countAttendance.getWorkingDays()));
			textFieldEmergencyLeave.setText(Integer.toString(countAttendance.getEl()));
			txtCasualLeave.setText(Integer.toString(countAttendance.getCl()));
			textFieldIncomeTax.setText(Double.toString(tax.getIncomeTax()));
			textFieldServiceTax.setText(Double.toString(tax.getServiceTax()));
			textFieldPfDeduction.setText(Double.toString(tax.getPfDeduction()));
			txtTotalEarnings.setText(Double.toString(tax.getTotalEarning()));
			txtTotalDeductions.setText(Double.toString(tax.getTotalDeduction()));
			txtPaySlipNo.setText(employee.getPaySlipId());
			txtNetSalary.setText(Double.toString(tax.getNetSalary()));
			
			
			
			
		}

	}
}
