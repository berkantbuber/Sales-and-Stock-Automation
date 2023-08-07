package FE;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAL.EmployeeDAL;
import contract.PersonelContract;
import interfaces.feinterface;
import java.awt.Font;

public class AddEmployeeFE extends JDialog implements feinterface {

	public AddEmployeeFE() {
		
		
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Personel Kayýt Alaný"));
		panel.setBackground(Color.white);
		
		getContentPane().add(panel);
		setTitle("Personel Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true); 
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));
		
		JLabel adiSoyadiLabel = new JLabel("Adý Soyadý : ", JLabel.RIGHT);
		adiSoyadiLabel.setBackground(Color.WHITE);
		adiSoyadiLabel.setForeground(Color.BLACK);
		adiSoyadiLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(adiSoyadiLabel);
		JTextField adisoyadiField = new JTextField(15);
		adisoyadiField.setForeground(Color.BLACK);
		adisoyadiField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adisoyadiField.setBackground(Color.WHITE);
		panel.add(adisoyadiField);
		JLabel emailLabel = new JLabel ("E-mail Adresi : ", JLabel.RIGHT);
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(emailLabel);
		JTextField emailField = new JTextField(15);
		emailField.setForeground(Color.BLACK);
		emailField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		emailField.setBackground(Color.WHITE);
		panel.add(emailField);
		
		
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
				PersonelContract contract = new PersonelContract();
				contract.setAdisoyadi(adisoyadiField.getText());
				contract.setEmail(emailField.getText());
				
				
				new EmployeeDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdisoyadi()+" adlý personel eklenmiþtir.");
				
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
