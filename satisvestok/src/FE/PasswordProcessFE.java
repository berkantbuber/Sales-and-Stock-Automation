package FE;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import DAL.AccountDAL;
import DAL.EmployeeDAL;
import DAL.YetkilerDAL;
import contract.AccountsContract;
import contract.PersonelContract;
import contract.YetkilerContract;
import interfaces.feinterface;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PasswordProcessFE extends JDialog implements feinterface {

	public PasswordProcessFE() {
		
		initPencere();
		
	}
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder(" "));
		panel.setBackground(Color.white);
		
		getContentPane().add(panel);
		setTitle("Þifre Belirleme Ekraný");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE); 
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		
		JLabel employeeLabel = new JLabel("Personel Seç : ", SwingConstants.RIGHT);
		employeeLabel.setForeground(Color.BLACK);
		employeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		employeeLabel.setBackground(Color.WHITE);
		panel.add(employeeLabel);
		JComboBox employeeBox = new JComboBox(new EmployeeDAL().GetAll().toArray());
		employeeBox.setForeground(Color.BLACK);
		employeeBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		employeeBox.setBackground(Color.white);
		panel.add(employeeBox);
		employeeBox.insertItemAt("Kiþi Seçiniz", 0);
		employeeBox.setSelectedIndex(0);
		JLabel authorityLabel = new JLabel("Yetki Seç : ", JLabel.RIGHT);
		authorityLabel.setForeground(Color.BLACK);
		authorityLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		authorityLabel.setBackground(Color.WHITE);
		panel.add(authorityLabel);
		JComboBox authorityBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		authorityBox.setForeground(Color.BLACK);
		authorityBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		authorityBox.setBackground(Color.white);
		
		panel.add(authorityBox);
		authorityBox.insertItemAt("Yetki Seçiniz", 0);
		authorityBox.setSelectedIndex(0);
		JLabel passwordLabel = new JLabel("Þifre Belirle : ", JLabel.RIGHT);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setBackground(Color.WHITE);
		panel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setBackground(Color.WHITE);
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(passwordField);	
		JLabel passwordtekrarlabel = new JLabel("Þifre Tekrar : ", JLabel.RIGHT);
		passwordtekrarlabel.setForeground(Color.BLACK);
		passwordtekrarlabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		passwordtekrarlabel.setBackground(Color.WHITE);
		panel.add(passwordtekrarlabel);
		JPasswordField passwordtekrarfield = new JPasswordField(10);
		passwordtekrarfield.setForeground(Color.BLACK);
		passwordtekrarfield.setFont(new Font("Times New Roman", Font.BOLD, 12));
		passwordtekrarfield.setBackground(Color.WHITE);
		panel.add(passwordtekrarfield);
		
		
		JButton kaydetButton = new JButton("Kaydet");
		kaydetButton.setForeground(Color.BLACK);
		kaydetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kaydetButton.setBackground(Color.white);
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		iptalButton.setForeground(Color.BLACK);
		iptalButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		iptalButton.setBackground(Color.white);
		panel.add(iptalButton);
		
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AccountsContract contract = new AccountsContract();
				PersonelContract pcontract = (PersonelContract) employeeBox.getSelectedItem();
				YetkilerContract ycontract = (YetkilerContract) authorityBox.getSelectedItem();
				
				if(passwordField.getText().equals(passwordtekrarfield.getText())) {
						
					contract.setPersonelId(pcontract.getId());
					contract.setYetkiId(ycontract.getId());
					contract.setSifre(passwordField.getText());

					new AccountDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, pcontract.getAdisoyadi() + " adlý kiþiye" 
					+ ycontract.getAdi() + " yetkisi baþarýlý bir þekilde eklenmiþtir.");
	
				}else 
					JOptionPane.showMessageDialog(null, "Þifreyi kontrol ediniz.");
					
				
				
			}
		});
		

		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initDisplay() {
		// TODO Auto-generated method stub
		
	}
	
	

}

