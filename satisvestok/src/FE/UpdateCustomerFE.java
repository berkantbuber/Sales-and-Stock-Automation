package FE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAL.CustomerDAL;
import DAL.EmployeeDAL;
import contract.KategoriContract;
import contract.MusteriContract;
import contract.PersonelContract;
import interfaces.feinterface;
import java.awt.Font;

public class UpdateCustomerFE extends JDialog implements feinterface {

	public UpdateCustomerFE() {
		
		
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Müþteri Düzenleme Alaný"));
		panel.setBackground(Color.white);
		
		getContentPane().add(panel);
		getContentPane().add(panel);
		setTitle("Müþteri Düzenleme");
		pack();
		setLocationRelativeTo(null); 
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
				
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldJPanel = new JPanel(new GridLayout(4, 2));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		
		JLabel updateCustomerName = new JLabel("D\u00FCzenlenecek M\u00FC\u015Fteri :", JLabel.RIGHT);
		updateCustomerName.setForeground(Color.BLACK);
		updateCustomerName.setBackground(Color.WHITE);
		updateCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fieldJPanel.add(updateCustomerName);
		
		JComboBox customerBox = new JComboBox(new CustomerDAL().GetAll().toArray());
		customerBox.setBackground(Color.WHITE);
		customerBox.setForeground(Color.BLACK);
		customerBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fieldJPanel.add(customerBox);
		customerBox.insertItemAt("Kategori Seç", 0);
		customerBox.setSelectedIndex(0);
		
		JLabel adiSoyadiLabel = new JLabel("Adý Soyadý : ", JLabel.RIGHT);
		adiSoyadiLabel.setBackground(Color.WHITE);
		adiSoyadiLabel.setForeground(Color.BLACK);
		adiSoyadiLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fieldJPanel.add(adiSoyadiLabel);
		JTextField adisoyadiField = new JTextField(15);
		adisoyadiField.setForeground(Color.BLACK);
		adisoyadiField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adisoyadiField.setBackground(Color.WHITE);
		fieldJPanel.add(adisoyadiField);
		JLabel numberLabel = new JLabel ("Telefon Numarasý : ", JLabel.RIGHT);
		numberLabel.setForeground(Color.BLACK);
		numberLabel.setBackground(Color.WHITE);
		numberLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fieldJPanel.add(numberLabel);
		JTextField numberField = new JTextField(15);
		numberField.setForeground(Color.BLACK);
		numberField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		numberField.setBackground(Color.WHITE);
		fieldJPanel.add(numberField);
		JLabel cityLabel = new JLabel("Þehir : ", JLabel.RIGHT);
		cityLabel.setBackground(Color.WHITE);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fieldJPanel.add(cityLabel);
		JTextField cityField = new JTextField(15);
		cityField.setForeground(Color.BLACK);
		cityField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cityField.setBackground(Color.WHITE);
		fieldJPanel.add(cityField);
		JTextArea adressArea = new JTextArea(6, 1);
		JScrollPane pane = new JScrollPane(adressArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
		
		JButton kaydetButton = new JButton("Kaydet");
		kaydetButton.setForeground(Color.BLACK);
		kaydetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kaydetButton.setBackground(Color.white);
		buttonPanel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		iptalButton.setForeground(Color.BLACK);
		iptalButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		iptalButton.setBackground(Color.white);
		buttonPanel.add(iptalButton);
		
		panel.add(fieldJPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
			
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusteriContract contract = new MusteriContract();
				MusteriContract casContract = (MusteriContract) customerBox.getSelectedItem();
				
				contract.setId(casContract.getId());
				contract.setAdisoyadi(adisoyadiField.getText());
				contract.setTelefon(numberField.getText());
				contract.setSehir(cityField.getText());
				contract.setAdres(adressArea.getText());
				
				new CustomerDAL().Update(contract);
				JOptionPane.showMessageDialog(null, contract.getAdisoyadi()+" adlý müþteri düzenlenmiþtir.");
				
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