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

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CloseAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountNo;
	private JTextField txtFirstName;
	private JTextField txtSin;
	private JTextField txtPhoneNumber;
	private int customerId =0;
	private JTextField txtLastName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloseAccount frame = new CloseAccount();
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
	public CloseAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Account Information");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(359, 11, 256, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(59, 52, 850, 80);
		contentPane.add(panel);
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNo.setBounds(127, 29, 110, 25);
		panel.add(lblAccountNo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(490, 24, 150, 35);
		panel.add(btnSearch);
		
		txtAccountNo = new JTextField();
		txtAccountNo.setColumns(10);
		txtAccountNo.setBounds(247, 29, 180, 25);
		panel.add(txtAccountNo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(59, 138, 850, 266);
		contentPane.add(panel_1);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNumber.setBounds(61, 26, 110, 25);
		panel_1.add(lblAccountNumber);
		
		JLabel txtAccountNumber = new JLabel("00");
		txtAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAccountNumber.setBounds(181, 26, 110, 25);
		panel_1.add(txtAccountNumber);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(61, 200, 110, 25);
		panel_1.add(lblDate);
		
		JLabel txtDate = new JLabel("Date");
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDate.setBounds(181, 200, 110, 25);
		panel_1.add(txtDate);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(181, 68, 180, 25);
		panel_1.add(txtFirstName);
		
		JLabel lblCustomerNumber = new JLabel("First Name");
		lblCustomerNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerNumber.setBounds(61, 68, 110, 25);
		panel_1.add(lblCustomerNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(61, 114, 110, 25);
		panel_1.add(lblPhoneNumber);
		
		JLabel lblSin = new JLabel("SIN");
		lblSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSin.setBounds(61, 157, 110, 25);
		panel_1.add(lblSin);
		
		txtSin = new JTextField();
		txtSin.setColumns(10);
		txtSin.setBounds(181, 157, 180, 25);
		panel_1.add(txtSin);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(181, 114, 180, 25);
		panel_1.add(txtPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(473, 110, 110, 25);
		panel_1.add(lblAddress);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(593, 112, 180, 83);
		panel_1.add(txtAddress);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountType.setBounds(473, 26, 110, 25);
		panel_1.add(lblAccountType);
		
		JLabel txtAccountType = new JLabel("00");
		txtAccountType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAccountType.setBounds(593, 26, 110, 25);
		panel_1.add(txtAccountType);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(473, 68, 110, 25);
		panel_1.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(593, 68, 180, 25);
		panel_1.add(txtLastName);
		
		JButton btnCloseAccount = new JButton("Close Account");
		
		btnCloseAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCloseAccount.setBounds(170, 442, 150, 35);
		contentPane.add(btnCloseAccount);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(420, 442, 150, 35);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(670, 442, 150, 35);
		contentPane.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// search button for searching the account based on account number to delete
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SavingAccount savAcc = new SavingAccount();
				CreditAccount creAcc = new CreditAccount();
				CheckingAccount cheAcc = new CheckingAccount();
				Customer customer = new Customer();
				boolean found = false;
				
				try
				{
					savAcc.setAccountNumber(Integer.parseInt(txtAccountNo.getText()));
					int id = savAcc.getAccountNumber();
					savAcc = SavingAccount.search(id);
					creAcc = CreditAccount.search(id);
					cheAcc = CheckingAccount.search(id);
					if(!(savAcc == null))
					{
						found = true;
						txtAccountNumber.setText(Integer.toString(savAcc.getAccountNumber()));
						txtAccountType.setText((EnumAccountType.SavingAccount).toString());
						txtDate.setText(savAcc.getOpenedDate().toString());
						
						customerId = savAcc.getIdentificationNumber();
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
						
							txtFirstName.setText(customer.getFirstName());
							txtLastName.setText(customer.getLastName());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtSin.setText(Integer.toString(customer.getSin()));
							txtAddress.setText(customer.getAddress());

						}
						else
						{
							JOptionPane.showMessageDialog(null, "Customer not Found");
						}
					
					}
					
					if(!(creAcc == null))
					{
						found = true;
						txtAccountNumber.setText(Integer.toString(creAcc.getAccountNumber()));
						txtAccountType.setText((EnumAccountType.CreditAccount).toString());
						txtDate.setText(creAcc.getOpenedDate().toString());
						
						customerId = creAcc.getIdentificationNumber();
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
						
							txtFirstName.setText(customer.getFirstName());
							txtLastName.setText(customer.getLastName());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtSin.setText(Integer.toString(customer.getSin()));
							txtAddress.setText(customer.getAddress());

						}
						else
						{
							JOptionPane.showMessageDialog(null, "Customer not Found");
						}
					}
					if(!(cheAcc == null))
					{
						found = true;
						txtAccountNumber.setText(Integer.toString(cheAcc.getAccountNumber()));
						txtAccountType.setText((EnumAccountType.CheckingAccount).toString());
						txtDate.setText(cheAcc.getOpenedDate().toString());
						
						customerId = cheAcc.getIdentificationNumber();
						
						customer = Customer.search(customerId);
						
						if(!(customer == null))
						{
						
							txtFirstName.setText(customer.getFirstName());
							txtLastName.setText(customer.getLastName());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtPhoneNumber.setText(customer.getPhoneNumber());
							txtSin.setText(Integer.toString(customer.getSin()));
							txtAddress.setText(customer.getAddress());

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
				catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(null, "Enter Valid Account No.");
				}
			}
		});
		
		// close button for deleting the searched account 
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accNo = Integer.parseInt(txtAccountNumber.getText());
				String accType = txtAccountType.getText();
				if(accType.equals("CheckingAccount"))
				{
					JOptionPane.showMessageDialog(null, "Cannot delete checking account");
				}
				else if(accType.equals("SavingAccount"))
				{
					try {
						SavingAccount.remove(accNo);
						JOptionPane.showMessageDialog(null, "Account Deleted");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RaiseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(accType.equals("CreditAccount"))
				{
					try {
						CreditAccount.remove(accNo);
						JOptionPane.showMessageDialog(null, "Account Deleted");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RaiseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
