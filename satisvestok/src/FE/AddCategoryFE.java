package FE;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAL.CategoryDAL;
import contract.KategoriContract;
import interfaces.feinterface;
import java.awt.Font;

public class AddCategoryFE extends JFrame implements feinterface {

	public AddCategoryFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
	 	JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
		panel.setBackground(Color.white);
		
		getContentPane().add(panel);
		setTitle("Kategori Ekle");
		pack();
		
		setLocationRelativeTo(null); 
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.setForeground(Color.BLACK);
		
		
		
		JLabel adiLabel = new JLabel("Kategori Adý : ", JLabel.RIGHT);
		adiLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiLabel.setForeground(Color.BLACK);
		adiLabel.setBackground(Color.WHITE);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		adiField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiField.setForeground(Color.BLACK);
		adiField.setBackground(Color.WHITE);
		panel.add(adiField);
		
		JButton kaydetButton = new JButton("Kaydet");
		kaydetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kaydetButton.setForeground(Color.BLACK);
		kaydetButton.setBackground(Color.white);
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KategoriContract contract = new KategoriContract();
				
				contract.setAdi(adiField.getText());

				

				new CategoryDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi() +" adlý kategori baþarýlý bir þekilde kaydedilmiþtir.");
			   
			}
		} );
		

		JButton iptalButton = new JButton("Ýptal");
		iptalButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		iptalButton.setForeground(Color.BLACK);
		iptalButton.setBackground(Color.white);
		panel.add(iptalButton);


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
