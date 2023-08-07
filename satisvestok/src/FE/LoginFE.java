package FE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.AccountDAL;
import DAL.EmployeeDAL;
import contract.PersonelContract;
import interfaces.feinterface;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class LoginFE extends JFrame {

	public static JComboBox nameBox = null;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFE frame = new LoginFE();
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
	public LoginFE() {
		
		setTitle("Giriþ Ekraný");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Adý Soyadý : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setForeground(Color.BLACK);
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(22, 44, 101, 25);
		contentPane.add(lblName);
		
		JLabel lblpassword = new JLabel("Þifre : ");
		lblpassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpassword.setForeground(Color.BLACK);
		lblpassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblpassword.setBackground(Color.WHITE);
		lblpassword.setBounds(36, 108, 87, 25);
		contentPane.add(lblpassword);
		
		JButton loginButton = new JButton("Giriþ Yap");
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		loginButton.setBackground(Color.WHITE);
		loginButton.setForeground(Color.BLACK);
		loginButton.setBounds(148, 164, 170, 34);
		contentPane.add(loginButton);
		
		nameBox = new JComboBox(new EmployeeDAL().GetAll().toArray());
		nameBox.setBackground(Color.WHITE); 
		nameBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
	 	nameBox.setForeground(Color.BLACK);
		nameBox.setBounds(148, 41, 246, 34);
		nameBox.insertItemAt("Kiþi Seçiniz", 0);
		nameBox.setSelectedIndex(0);
		contentPane.add(nameBox);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passwordField.setBounds(148, 103, 246, 39);
		contentPane.add(passwordField);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = (PersonelContract) nameBox.getSelectedItem();
				
				if(new AccountDAL().GetEmployeeIdAndPassword(contract.getId(), passwordField.getText()).getId()!=0) {
					
					new MainDisplay();
					
					dispose();
		 			
				}else {
					
					JOptionPane.showMessageDialog(null, "Giriþ Baþarýsýz");
					
				}
				// TODO Auto-generated method stub			
			}
		});
		
   }
}
