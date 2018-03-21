package payroll.com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import payroll.com.service.impl.AdminServiceDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class GeneratePaySlipFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratePaySlipFrame frame = new GeneratePaySlipFrame("125");
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
	public GeneratePaySlipFrame(String userId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Icon.png"));
		setTitle("GENERATE PAYSLIP\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(135, 155, 172, 20);
		contentPane.add(dateChooser);
		
		JLabel lblSelectDateFor = new JLabel("SELECT DATE FOR SALARY GENERATION");
		lblSelectDateFor.setBounds(61, 47, 317, 40);
		lblSelectDateFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSelectDateFor);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame adminFrame=new AdminFrame(userId);
				adminFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(9, 46, 42, 23);
		btnBack.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\Back.png"));
		contentPane.add(btnBack);
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date=dateChooser.getDate();
				AdminServiceDaoImpl adminServiceDaoImpl=new AdminServiceDaoImpl();
				adminServiceDaoImpl.generatePaySlip(date);
				JOptionPane.showMessageDialog(contentPane, "salary distributed successfully");
				AdminFrame adminFrame=new AdminFrame(userId);
				adminFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnGenerate.setBounds(151, 212, 116, 23);
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnGenerate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\elliot program\\java_pgm\\payrollSystem\\images\\GeneratePayslip.jpg"));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
