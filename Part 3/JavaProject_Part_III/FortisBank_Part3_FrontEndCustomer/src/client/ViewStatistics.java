package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import bus.Customer;
import bus.SavingAccount;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStatistics extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNumber;
	private JTextField txtFirstName;
	private JTextField txtSin;
	private JTextField txtPhoneNumber;
	private JTextField txtLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatistics frame = new ViewStatistics();
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
	public ViewStatistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Saving Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(68, 52, 850, 80);
		contentPane.add(panel);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNumber.setBounds(113, 29, 110, 25);
		panel.add(lblAccountNumber);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(490, 24, 150, 35);
		panel.add(btnSearch);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(247, 29, 180, 25);
		panel.add(txtAccountNumber);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(650, 24, 150, 35);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Saving Account Statistics");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(377, 11, 225, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(68, 145, 850, 184);
		contentPane.add(panel_1);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(182, 26, 180, 25);
		panel_1.add(txtFirstName);
		
		JLabel lblCustomerName = new JLabel("First Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(62, 26, 110, 25);
		panel_1.add(lblCustomerName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(62, 72, 110, 25);
		panel_1.add(lblPhoneNumber);
		
		JLabel lblSin = new JLabel("SIN");
		lblSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSin.setBounds(62, 115, 110, 25);
		panel_1.add(lblSin);
		
		txtSin = new JTextField();
		txtSin.setColumns(10);
		txtSin.setBounds(182, 115, 180, 25);
		panel_1.add(txtSin);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(182, 72, 180, 25);
		panel_1.add(txtPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(474, 68, 110, 25);
		panel_1.add(lblAddress);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(594, 70, 180, 83);
		panel_1.add(txtAddress);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(474, 26, 110, 25);
		panel_1.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(594, 26, 180, 25);
		panel_1.add(txtLastName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Saving Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(68, 340, 850, 232);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAccountNumber_1 = new JLabel("Saving Account Number");
		lblAccountNumber_1.setBounds(63, 35, 178, 25);
		panel_2.add(lblAccountNumber_1);
		lblAccountNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel txtSavingAccountNumber = new JLabel("00");
		txtSavingAccountNumber.setBounds(251, 35, 110, 25);
		panel_2.add(txtSavingAccountNumber);
		txtSavingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSavingAccountDetailsDate = new JLabel("Date");
		lblSavingAccountDetailsDate.setBounds(476, 35, 110, 25);
		panel_2.add(lblSavingAccountDetailsDate);
		lblSavingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel txtSavingAccountDetailsDate = new JLabel("Date");
		txtSavingAccountDetailsDate.setBounds(604, 35, 110, 25);
		panel_2.add(txtSavingAccountDetailsDate);
		txtSavingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblOpeningBalance = new JLabel("Balance");
		lblOpeningBalance.setBounds(63, 80, 110, 25);
		panel_2.add(lblOpeningBalance);
		lblOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblExtraFee = new JLabel("Extra Fee");
		lblExtraFee.setBounds(476, 80, 110, 25);
		panel_2.add(lblExtraFee);
		lblExtraFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setBounds(63, 134, 110, 25);
		panel_2.add(lblInterestRate);
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAnnualGain = new JLabel("Annual Gain ");
		lblAnnualGain.setBounds(476, 134, 110, 25);
		panel_2.add(lblAnnualGain);
		lblAnnualGain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnViewStatistics = new JButton("View Statistics");
		
		btnViewStatistics.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewStatistics.setBounds(634, 175, 150, 35);
		panel_2.add(btnViewStatistics);
		
		JLabel txtBalance = new JLabel("Balance");
		txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBalance.setBounds(183, 80, 110, 25);
		panel_2.add(txtBalance);
		
		JLabel txtExtraFee = new JLabel("Extra Fee");
		txtExtraFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtExtraFee.setBounds(604, 80, 110, 25);
		panel_2.add(txtExtraFee);
		
		JLabel txtInterestRate = new JLabel("Interest Rate");
		txtInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInterestRate.setBounds(183, 134, 110, 25);
		panel_2.add(txtInterestRate);
		
		JLabel txtAnnualGain = new JLabel("Annual Gain ");
		txtAnnualGain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAnnualGain.setBounds(604, 134, 110, 25);
		panel_2.add(txtAnnualGain);
		
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(txtAccountNumber.getText()).equals("")) {
					try {

						int accNo = Integer.parseInt(txtAccountNumber.getText());
						SavingAccount savAcc = new SavingAccount();

						savAcc = SavingAccount.search(accNo);

						if (!(savAcc == null)) {
							int customerId = savAcc.getIdentificationNumber();

							Customer cust = new Customer();
							cust = Customer.search(customerId);

							txtFirstName.setText(cust.getFirstName());
							txtLastName.setText(cust.getLastName());
							txtPhoneNumber.setText(cust.getPhoneNumber());
							txtSin.setText(Integer.toString(cust.getSin()));
							txtAddress.setText(cust.getAddress());

							txtSavingAccountNumber.setText(Integer.toString(savAcc.getAccountNumber()));
							txtSavingAccountDetailsDate.setText(savAcc.getOpenedDate().toString());
							txtBalance.setText(Double.toString(savAcc.getBalance()));
							txtExtraFee.setText(Double.toString(savAcc.getExtraFee()));
							txtInterestRate.setText(Double.toString(savAcc.getAnnualInterestRate()));
							txtAnnualGain.setText(Double.toString(savAcc.getAnnunalGain()));
						} else {
							JOptionPane.showMessageDialog(null, "Enter a valid saving account number");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Account number must be integer");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Enter an account number");
				}

			}
		});
		
		btnViewStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double principal = Double.parseDouble(txtBalance.getText());
				double rate = Double.parseDouble(txtInterestRate.getText());
				
				double annuallyInterest = ((principal*rate*1)/100);
				double monthlyInterest = annuallyInterest/12;
				
				JOptionPane.showMessageDialog(null,"Annual interest amount = $ "+ annuallyInterest+"\n Monthly interest amount = $ "+ monthlyInterest );
				
			}
		});
		
		
	}
}
