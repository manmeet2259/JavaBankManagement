package client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import bus.Customer;
import bus.RaiseException;
import bus.SavingAccount;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OpenSavingAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomerId;
	private JTextField txtFirstName;
	private JTextField txtSin;
	private JTextField txtPhoneNumber;
	private JTextField txtExtraFee;
	private JTextField txtOpeningBalance;
	private JTextField txtInterestRate;
	private JTextField txtAnnualGain;
	private JTextField txtLastName;
	private JTextArea txtAddress;
	private JPanel panelSavingAcc;
	private JLabel txtSavingAccountNumber;
	int savingAccountNo = 0;
	int customerId = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenSavingAccount frame = new OpenSavingAccount();
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
	public OpenSavingAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Customer Information");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(364, 11, 264, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Saving Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(64, 52, 850, 80);
		contentPane.add(panel);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerId.setBounds(127, 29, 110, 25);
		panel.add(lblCustomerId);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(490, 24, 150, 35);
		panel.add(btnSearch);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(247, 29, 180, 25);
		panel.add(txtCustomerId);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(650, 24, 150, 35);
		panel.add(btnCancel);
		
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 138, 850, 184);
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
		
		txtAddress = new JTextArea();
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
		
		panelSavingAcc = new JPanel();
		panelSavingAcc.setLayout(null);
		panelSavingAcc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Saving Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSavingAcc.setBounds(64, 333, 850, 267);
		panelSavingAcc.setVisible(false);
		contentPane.add(panelSavingAcc);
		
		JLabel lblSavingAccountNumber = new JLabel("Account Number");
		lblSavingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSavingAccountNumber.setBounds(61, 34, 110, 25);
		panelSavingAcc.add(lblSavingAccountNumber);
		
		txtSavingAccountNumber = new JLabel("00");
		txtSavingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSavingAccountNumber.setBounds(181, 34, 110, 25);
		panelSavingAcc.add(txtSavingAccountNumber);
		
		JLabel lblSavingAccountDetailsDate = new JLabel("Date");
		lblSavingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSavingAccountDetailsDate.setBounds(474, 34, 110, 25);
		panelSavingAcc.add(lblSavingAccountDetailsDate);
		
		JLabel txtDate = new JLabel(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDate.setBounds(594, 34, 110, 25);
		panelSavingAcc.add(txtDate);
		
		JLabel lblExtraFee = new JLabel("Extra Fee");
		lblExtraFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtraFee.setBounds(474, 81, 110, 25);
		panelSavingAcc.add(lblExtraFee);
		
		txtExtraFee = new JTextField();
		txtExtraFee.setColumns(10);
		txtExtraFee.setBounds(594, 81, 180, 25);
		panelSavingAcc.add(txtExtraFee);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(241, 197, 150, 35);
		panelSavingAcc.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(491, 197, 150, 35);
		panelSavingAcc.add(btnReset);
		
		JLabel lblOpeningBalance = new JLabel("Opening Balance");
		lblOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOpeningBalance.setBounds(61, 81, 110, 25);
		panelSavingAcc.add(lblOpeningBalance);
		
		txtOpeningBalance = new JTextField();
		txtOpeningBalance.setColumns(10);
		txtOpeningBalance.setBounds(181, 81, 180, 25);
		panelSavingAcc.add(txtOpeningBalance);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInterestRate.setBounds(61, 133, 110, 25);
		panelSavingAcc.add(lblInterestRate);
		
		txtInterestRate = new JTextField();
		txtInterestRate.setColumns(10);
		txtInterestRate.setBounds(181, 133, 180, 25);
		panelSavingAcc.add(txtInterestRate);
		
		JLabel lblAnnualGain = new JLabel("Annual Gain ");
		lblAnnualGain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnnualGain.setBounds(474, 133, 110, 25);
		panelSavingAcc.add(lblAnnualGain);
		
		txtAnnualGain = new JTextField();
		txtAnnualGain.setColumns(10);
		txtAnnualGain.setBounds(594, 133, 180, 25);
		panelSavingAcc.add(txtAnnualGain);
		
		// button search is looking for the existing customer as this is the prerequisite to open  a saving account
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer customer = new Customer();
				
				try
				{
					customer.setIdentificationNumber(Integer.parseInt(txtCustomerId.getText()));
					int id = customer.getIdentificationNumber();
					customer = Customer.search(id);
					
					if(!(customer == null))
					{
						customerId = customer.getIdentificationNumber();
						txtFirstName.setText(customer.getFirstName());
						txtLastName.setText(customer.getLastName());
						txtPhoneNumber.setText(customer.getPhoneNumber());
						txtPhoneNumber.setText(customer.getPhoneNumber());
						txtSin.setText(Integer.toString(customer.getSin()));
						txtAddress.setText(customer.getAddress());
						
						panelSavingAcc.setVisible(true);
						savingAccountNo = SavingAccount.getAccountNo();
						txtSavingAccountNumber.setText(Integer.toString(savingAccountNo));
						txtDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid User Id");
						txtCustomerId.setText("");
					}
				
				}
				catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(null, "Enter Valid Customer Id" + e1.getMessage());
				}

			}
		});
		
		// button save is responcible to save the account details in table
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = false;
				SavingAccount savAcc = new SavingAccount();
				try {
					Date date = new Date();
					java.sql.Date currDate = new java.sql.Date(date.getTime());
					savAcc.setAccountNumber(savingAccountNo);
					savAcc.setIdentificationNumber(customerId);
					savAcc.setBalance(Double.parseDouble(txtOpeningBalance.getText()));
					savAcc.setOpenedDate(currDate);
					savAcc.setExtraFee(Double.parseDouble(txtExtraFee.getText()));
					savAcc.setAnnualInterestRate(Double.parseDouble(txtInterestRate.getText()));
					savAcc.setAnnunalGain(Double.parseDouble(txtAnnualGain.getText()));
					
					status = true;
					
				} catch (RaiseException e1) {
					JOptionPane.showMessageDialog(null, "Error : "+ e1.getMessage());
				}
				catch (NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(null, "Error : Empty Field");
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, "Error : "+ e3.getMessage());
				}

				if(status)
				{
					try {
						if(SavingAccount.add(savAcc) == 1)
						{
							JOptionPane.showMessageDialog(null, "Account Created Successfully");
							reset();
						}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Something went wrong");
						} catch (RaiseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				
				
			}
		});
		
		// button reset is used to clear all the controls
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reset();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RaiseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	private void reset()
			throws SQLException, RaiseException {
		txtCustomerId.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtPhoneNumber.setText("");
		txtSin.setText("");
		txtAddress.setText("");
		txtOpeningBalance.setText("");
		txtExtraFee.setText("");
		txtInterestRate.setText("");
		txtAnnualGain.setText("");
		txtSavingAccountNumber.setText("");
		panelSavingAcc.setVisible(false);
		
}
}















