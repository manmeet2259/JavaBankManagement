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
import bus.SavingAccount;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAccountInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomerId;
	private JTextField txtExtraFee;
	private JTextField txtOpeningBalance;
	private JTextField txtInterestRate;
	private JTextField txtAnnualGain;
	private JTextField txtCreditLimit;
	private JTextField txtBalance;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccountInformation frame = new ViewAccountInformation();
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
	public ViewAccountInformation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
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
		
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(658, 24, 150, 35);
		panel.add(btnCancel);
		
		JPanel panelSavAcc = new JPanel();
		panelSavAcc.setLayout(null);
		panelSavAcc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Saving Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSavAcc.setBounds(64, 254, 850, 183);
		panelSavAcc.setVisible(false);
		contentPane.add(panelSavAcc);
		
		JLabel lblAccountNumber = new JLabel("Saving Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNumber.setBounds(61, 34, 178, 25);
		panelSavAcc.add(lblAccountNumber);
		
		JLabel txtSavingAccountNumber = new JLabel("00");
		txtSavingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSavingAccountNumber.setBounds(249, 34, 110, 25);
		panelSavAcc.add(txtSavingAccountNumber);
		
		JLabel lblSavingAccountDetailsDate = new JLabel("Date");
		lblSavingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSavingAccountDetailsDate.setBounds(474, 34, 110, 25);
		panelSavAcc.add(lblSavingAccountDetailsDate);
		
		JLabel txtSavingAccountDetailsDate = new JLabel("Date");
		txtSavingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSavingAccountDetailsDate.setBounds(602, 34, 110, 25);
		panelSavAcc.add(txtSavingAccountDetailsDate);
		
		JLabel lblExtraFee = new JLabel("Extra Fee");
		lblExtraFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtraFee.setBounds(474, 81, 110, 25);
		panelSavAcc.add(lblExtraFee);
		
		txtExtraFee = new JTextField();
		txtExtraFee.setColumns(10);
		txtExtraFee.setBounds(602, 81, 180, 25);
		panelSavAcc.add(txtExtraFee);
		
		JLabel lblOpeningBalance = new JLabel("Opening Balance");
		lblOpeningBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOpeningBalance.setBounds(61, 81, 110, 25);
		panelSavAcc.add(lblOpeningBalance);
		
		txtOpeningBalance = new JTextField();
		txtOpeningBalance.setColumns(10);
		txtOpeningBalance.setBounds(181, 81, 180, 25);
		panelSavAcc.add(txtOpeningBalance);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInterestRate.setBounds(61, 133, 110, 25);
		panelSavAcc.add(lblInterestRate);
		
		txtInterestRate = new JTextField();
		txtInterestRate.setColumns(10);
		txtInterestRate.setBounds(181, 133, 180, 25);
		panelSavAcc.add(txtInterestRate);
		
		JLabel lblAnnualGain = new JLabel("Annual Gain ");
		lblAnnualGain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnnualGain.setBounds(474, 133, 110, 25);
		panelSavAcc.add(lblAnnualGain);
		
		txtAnnualGain = new JTextField();
		txtAnnualGain.setColumns(10);
		txtAnnualGain.setBounds(602, 133, 180, 25);
		panelSavAcc.add(txtAnnualGain);
		
		JPanel panelCreditAcc = new JPanel();
		panelCreditAcc.setLayout(null);
		panelCreditAcc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Credit Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCreditAcc.setBounds(64, 448, 850, 102);
		panelCreditAcc.setVisible(false);
		contentPane.add(panelCreditAcc);
		
		JLabel lblCreditAccountDetailsDate = new JLabel("Date");
		lblCreditAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditAccountDetailsDate.setBounds(472, 23, 110, 25);
		panelCreditAcc.add(lblCreditAccountDetailsDate);
		
		JLabel txtCreditAccountDetailsDate = new JLabel("Date");
		txtCreditAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCreditAccountDetailsDate.setBounds(602, 23, 110, 25);
		panelCreditAcc.add(txtCreditAccountDetailsDate);
		
		JLabel lblCreditLimit = new JLabel("Credit Limit");
		lblCreditLimit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditLimit.setBounds(59, 59, 110, 25);
		panelCreditAcc.add(lblCreditLimit);
		
		txtCreditLimit = new JTextField();
		txtCreditLimit.setColumns(10);
		txtCreditLimit.setBounds(179, 59, 180, 25);
		panelCreditAcc.add(txtCreditLimit);
		
		JLabel lblCreditAccountNumber = new JLabel("Credit Account Number");
		lblCreditAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditAccountNumber.setBounds(59, 23, 180, 25);
		panelCreditAcc.add(lblCreditAccountNumber);
		
		JLabel txtCreditAccountNumber = new JLabel("00");
		txtCreditAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCreditAccountNumber.setBounds(249, 23, 110, 25);
		panelCreditAcc.add(txtCreditAccountNumber);
		
		JLabel lblBorrowedAmount = new JLabel("Borrowed Amount");
		lblBorrowedAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBorrowedAmount.setBounds(472, 59, 124, 25);
		panelCreditAcc.add(lblBorrowedAmount);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(602, 59, 180, 25);
		panelCreditAcc.add(textField);
		
		JPanel panelChkAcc = new JPanel();
		panelChkAcc.setLayout(null);
		panelChkAcc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Checking Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChkAcc.setBounds(64, 141, 850, 102);
		panelChkAcc.setVisible(false);
		contentPane.add(panelChkAcc);
		
		JLabel lblCheckingAccountDetailsDate = new JLabel("Date");
		lblCheckingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckingAccountDetailsDate.setBounds(472, 23, 110, 25);
		panelChkAcc.add(lblCheckingAccountDetailsDate);
		
		JLabel txtCheckingAccountDetailsDate = new JLabel("Date");
		txtCheckingAccountDetailsDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCheckingAccountDetailsDate.setBounds(602, 23, 110, 25);
		panelChkAcc.add(txtCheckingAccountDetailsDate);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBalance.setBounds(59, 59, 110, 25);
		panelChkAcc.add(lblBalance);
		
		txtBalance = new JTextField();
		txtBalance.setColumns(10);
		txtBalance.setBounds(179, 59, 180, 25);
		panelChkAcc.add(txtBalance);
		
		JLabel lblCheckingAccountNumber = new JLabel("Checking Account Number");
		lblCheckingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckingAccountNumber.setBounds(59, 23, 180, 25);
		panelChkAcc.add(lblCheckingAccountNumber);
		
		JLabel txtCheckingAccountNumber = new JLabel("00");
		txtCheckingAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCheckingAccountNumber.setBounds(249, 23, 110, 25);
		panelChkAcc.add(txtCheckingAccountNumber);
		
		JLabel txtCustomerName = new JLabel("Welcome");
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setBounds(679, 30, 235, 25);
		contentPane.add(txtCustomerName);
		
		// button search is searching all the accounts of the user based on customer id
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reset(panelSavAcc, panelCreditAcc, panelChkAcc);
				SavingAccount savAcc = new SavingAccount();
				CheckingAccount chkAcc = new CheckingAccount();
				CreditAccount creAcc = new CreditAccount();
				Customer customer = new Customer();
				String msg = "Welcome";
				
				
				
				try
				{
					reset(panelSavAcc, panelCreditAcc, panelChkAcc);
					customer.setIdentificationNumber(Integer.parseInt(txtCustomerId.getText()));
					int id = customer.getIdentificationNumber();
					customer = Customer.search(id);
					
					if(!(customer == null))
					{
						txtCustomerName.setText("");
						txtCustomerName.setText(msg +" : "+customer.getFirstName());
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid User Id");
						txtCustomerId.setText("");
					}
					
					chkAcc = CheckingAccount.searchByCustomerId(id);
					if(!(chkAcc == null))
					{
						panelChkAcc.setVisible(true);
						txtCheckingAccountNumber.setText(Integer.toString(chkAcc.getAccountNumber()));
						txtCheckingAccountDetailsDate.setText(chkAcc.getOpenedDate().toString());
						txtBalance.setText(Double.toString(chkAcc.getBalance()));
					}
					
					savAcc = SavingAccount.searchByCustomerId(id);
					if(!(savAcc == null))
					{
						panelSavAcc.setVisible(true);
						txtSavingAccountNumber.setText(Integer.toString(savAcc.getAccountNumber()));
						txtSavingAccountDetailsDate.setText(savAcc.getOpenedDate().toString());
						txtOpeningBalance.setText(Double.toString(savAcc.getBalance()));
						txtExtraFee.setText(Double.toString(savAcc.getExtraFee()));
						txtInterestRate.setText(Double.toString(savAcc.getAnnualInterestRate()));
						txtAnnualGain.setText(Double.toString(savAcc.getAnnunalGain()));
					}
					creAcc = CreditAccount.searchByCustomer(id);
					if(!(creAcc == null))
					{
						panelCreditAcc.setVisible(true);
						txtCreditAccountNumber.setText(Integer.toString(creAcc.getAccountNumber()));
						txtCreditAccountDetailsDate.setText(creAcc.getOpenedDate().toString());
						txtCreditLimit.setText(Double.toString(creAcc.getCreditLimit()));
						
						
					}
					
					
				
				}
				catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(null, "Enter Valid Customer Id");
				}
			}

			private void reset(JPanel panelSavAcc, JPanel panelCreditAcc, JPanel panelChkAcc) {
				panelChkAcc.setVisible(false);
				panelCreditAcc.setVisible(false);
				panelSavAcc.setVisible(false);
			}
		});
		// button cancel is used to close the form
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
