package client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import bus.CheckingAccount;
import bus.CreditAccount;
import bus.Customer;
import bus.EnumAccountType;
import bus.RaiseException;
import bus.SavingAccount;
import bus.Transaction;
import data.CheckingAccountDB;
import data.CreditAccountDB;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNumber;
	private JTextField txtAmount;
	int customerId = 0;
	Double balance = 0.0;
	int accountNo=0;
	String tableName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Deposit Money");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(212, 11, 154, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(40, 52, 497, 80);
		contentPane.add(panel);
		
		JLabel lblCustomerId = new JLabel("Account No");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerId.setBounds(10, 27, 110, 25);
		panel.add(lblCustomerId);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(331, 22, 150, 35);
		panel.add(btnSearch);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(130, 27, 180, 25);
		panel.add(txtAccountNumber);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(40, 143, 490, 280);
		contentPane.add(panel_1);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNumber.setBounds(61, 26, 135, 25);
		panel_1.add(lblAccountNumber);
		
		JLabel txtAccountNo = new JLabel("00");
		txtAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAccountNo.setBounds(206, 26, 110, 25);
		panel_1.add(txtAccountNo);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(61, 115, 110, 25);
		panel_1.add(lblCustomerName);
		
		JLabel lblPhoneNumber = new JLabel("Amount");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(61, 161, 110, 25);
		panel_1.add(lblPhoneNumber);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(206, 161, 180, 25);
		panel_1.add(txtAmount);
		
		JLabel txtCustomerName = new JLabel("Customer Name");
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setBounds(208, 115, 178, 25);
		panel_1.add(txtCustomerName);
		
		JButton btnDeposit = new JButton("Deposit");
		
		btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeposit.setBounds(206, 210, 180, 35);
		panel_1.add(btnDeposit);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalance.setBounds(61, 68, 110, 25);
		panel_1.add(lblBalance);
		
		JLabel txtBalance = new JLabel("00");
		txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBalance.setBounds(206, 68, 178, 25);
		panel_1.add(txtBalance);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(387, 433, 150, 35);
		contentPane.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// Button search is user to search the account based on account number to perform deposite
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					accountNo =Integer.parseInt(txtAccountNumber.getText());
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
				
				
				
				SavingAccount savAcc = new SavingAccount();
				CreditAccount creAcc = new CreditAccount();
				CheckingAccount cheAcc = new CheckingAccount();
				Customer customer = new Customer();
				boolean found = false;
				
				
				
				try
				{
					savAcc.setAccountNumber(accountNo);
					int id = savAcc.getAccountNumber();
					savAcc = SavingAccount.search(id);
					creAcc = CreditAccount.search(id);
					cheAcc = CheckingAccount.search(id);
					
					
					if(!(savAcc == null))
					{
						found = true;
						tableName = (EnumAccountType.SavingAccount).toString();
						txtAccountNo.setText(Integer.toString(savAcc.getAccountNumber()));
						
						customerId = savAcc.getIdentificationNumber();
						balance = savAcc.getBalance();
						txtBalance.setText(Double.toString(balance));
						
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
							txtCustomerName.setText(customer.getFirstName() +" "+ customer.getLastName());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Customer not Found");
						}
					
					}
					
					if(!(creAcc == null))
					{
						found = true;
						tableName = (EnumAccountType.CreditAccount).toString();
						txtAccountNo.setText(Integer.toString(creAcc.getAccountNumber()));
						
						customerId = creAcc.getIdentificationNumber();
						balance = (creAcc.getBalance());
						txtBalance.setText(Double.toString(balance));
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
							txtCustomerName.setText(customer.getFirstName() +" "+ customer.getLastName());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Customer not Found");
						}
					}
					if(!(cheAcc == null))
					{
						found = true;
						tableName = (EnumAccountType.CheckingAccount).toString();
						txtAccountNo.setText(Integer.toString(cheAcc.getAccountNumber()));
						
						customerId = cheAcc.getIdentificationNumber();
						balance = cheAcc.getBalance();
						txtBalance.setText(Double.toString(balance));
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
							txtCustomerName.setText(customer.getFirstName() +" "+ customer.getLastName());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Customer not Found");
						}
					}
					
					if(!found)
					{
						JOptionPane.showMessageDialog(null, "Account not found");
						
					}
				
				}
				
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, "Error : "+ e3.getMessage());
				}
			}
		});
		
		// update the balance of the searched account
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount=0.0;
				
				try
				{
					amount = Double.parseDouble(txtAmount.getText());
					balance = balance+amount;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid amount");
				}
				
				try {
					boolean status = false;
					if(tableName.equals("CheckingAccount"))
					{
						CheckingAccountDB.deposit(accountNo, balance);
						status = true;
					}
					if(tableName.equals("CreditAccount"))
					{
						CreditAccountDB.deposit(accountNo, balance);
						status = true;
					}
					if(tableName.equals("SavingAccount"))
					{
						CreditAccountDB.deposit(accountNo, balance);
						status = true;
					}
					
					if(status)
					{
						
						
						Transaction trans = null;
						trans = new Transaction();
						
						trans.setTransactionNumber(Transaction.getTransactionNo());
						trans.setAccountNo(accountNo);
						trans.setTransactionType("Credit");
						trans.setTranactionAmount(amount);
						trans.setDescription("Deposit by Self");
						trans.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
						trans.setOldBal(balance-amount);
						trans.setNewBal(balance);
						
						Transaction.add(trans);
						
						JOptionPane.showMessageDialog(null, "Transaction Complete");
						
						txtAccountNumber.setText("");
						txtAccountNo.setText("00");
						txtBalance.setText("00");
						txtCustomerName.setText("Undefined");
						txtAmount.setText("");
					}
				} catch (SQLException | RaiseException e1) 
				{
					JOptionPane.showMessageDialog(null, "Something Went Wrong.");
				}
			}
		});
	}
}
