package client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import bus.CreditAccount;
import bus.Customer;
import bus.RaiseException;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OpenCreditAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomerId;
	private JTextField txtFirstName;
	private JTextField txtSin;
	private JTextField txtPhoneNumber;
	private JTextField txtCreditLimit;
	private JTextField txtLastName;
	private JTextArea txtAddress;
	private JLabel txtCreditAccountNumber;
	private JPanel panelCreditAccount;
	int customerId = 0;
	int creditAccounNumber = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenCreditAccount frame = new OpenCreditAccount();
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
	public OpenCreditAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Enter Customer Information");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(366, 11, 269, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Credit Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(66, 52, 850, 80);
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
		panel_1.setBounds(66, 138, 850, 176);
		contentPane.add(panel_1);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(180, 26, 180, 25);
		panel_1.add(txtFirstName);
		
		JLabel lblCustomerName = new JLabel("First Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(60, 26, 110, 25);
		panel_1.add(lblCustomerName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(60, 72, 110, 25);
		panel_1.add(lblPhoneNumber);
		
		JLabel lblSin = new JLabel("SIN");
		lblSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSin.setBounds(60, 115, 110, 25);
		panel_1.add(lblSin);
		
		txtSin = new JTextField();
		txtSin.setColumns(10);
		txtSin.setBounds(180, 115, 180, 25);
		panel_1.add(txtSin);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(180, 72, 180, 25);
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
		
		panelCreditAccount = new JPanel();
		panelCreditAccount.setLayout(null);
		panelCreditAccount.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Credit Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCreditAccount.setBounds(66, 325, 850, 221);
		panelCreditAccount.setVisible(false);
		contentPane.add(panelCreditAccount);
		
		JLabel lblCreditAccountDetailsDate = new JLabel("Date");
		lblCreditAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditAccountDetailsDate.setBounds(474, 34, 110, 25);
		panelCreditAccount.add(lblCreditAccountDetailsDate);
		
		JLabel txtDate = new JLabel("Date");
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDate.setBounds(594, 34, 110, 25);
		panelCreditAccount.add(txtDate);
		
		JLabel lblCreditLimit = new JLabel("Credit Limit");
		lblCreditLimit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditLimit.setBounds(61, 82, 110, 25);
		panelCreditAccount.add(lblCreditLimit);
		
		txtCreditLimit = new JTextField();
		txtCreditLimit.setColumns(10);
		txtCreditLimit.setBounds(181, 82, 180, 25);
		panelCreditAccount.add(txtCreditLimit);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(228, 155, 150, 35);
		panelCreditAccount.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(478, 155, 150, 35);
		panelCreditAccount.add(btnReset);
		
		JLabel lblCreditAccountNumber = new JLabel("Credit Account Number");
		lblCreditAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditAccountNumber.setBounds(61, 34, 180, 25);
		panelCreditAccount.add(lblCreditAccountNumber);
		
		txtCreditAccountNumber = new JLabel("00");
		txtCreditAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCreditAccountNumber.setBounds(251, 34, 110, 25);
		panelCreditAccount.add(txtCreditAccountNumber);
		
		
		// button search is used to search the user from the database as account is not opened if the user is not exist in system
		
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
						
						panelCreditAccount.setVisible(true);
						creditAccounNumber = CreditAccount.getAccountNo();
						txtCreditAccountNumber.setText(Integer.toString(creditAccounNumber));
						txtDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid User Id");
						txtCustomerId.setText("");
					}
				
				}
				catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(null, "Enter Valid Customer Id");
				}

				
			}
		});
		
		// button save is responsible to save the details of credit account 
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = false;
				CreditAccount creAcc = new CreditAccount();
				try {
					
					Date date = new Date();
					java.sql.Date currDate = new java.sql.Date(date.getTime());
					creAcc.setAccountNumber(creditAccounNumber);
					creAcc.setIdentificationNumber(customerId);
					creAcc.setCreditLimit(Double.parseDouble(txtCreditLimit.getText()));
					creAcc.setBalance(Double.parseDouble(txtCreditLimit.getText()));
					creAcc.setOpenedDate(currDate);
					status = true;

				} catch (RaiseException e1) {
					JOptionPane.showMessageDialog(null, "Error : "+ e1.getMessage());
				}
				catch (NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(null, "Error : Invalid Input");
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, "Error : "+ e3.getMessage());
				}

				if(status)
				{
					try {
						if(CreditAccount.add(creAcc) == 1)
						{
							JOptionPane.showMessageDialog(null, "Account Created Successfully");
							reset();
						}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Something went wrong");
						}
						catch (RaiseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}
					
				
				
			}
		});
		
		// button reset is used to clear all the fields
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
		txtCreditAccountNumber.setText("");
		txtCreditLimit.setText("");
		panelCreditAccount.setVisible(false);
		
	

		
	}

}
