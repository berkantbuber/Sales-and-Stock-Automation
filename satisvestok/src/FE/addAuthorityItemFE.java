package FE;

import java.awt.Color;
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

import DAL.YetkilerDAL;
import contract.YetkilerContract;
import interfaces.feinterface;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class addAuthorityItemFE extends JDialog implements feinterface {
	
	public addAuthorityItemFE() {

		initPencere();
		
	}
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBackground(Color.white);
		
		getContentPane().add(panel);
		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		 
	} 

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(Color.BLACK);
		JLabel adiLabel = new JLabel("Yetki Adý : ", JLabel.RIGHT);
		adiLabel.setForeground(Color.BLACK);
		adiLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiLabel.setBackground(Color.WHITE);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		adiField.setForeground(Color.BLACK);
		adiField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiField.setBackground(Color.WHITE);
		panel.add(adiField);
		
		
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
				
				YetkilerContract contract = new YetkilerContract();
				
				contract.setAdi(adiField.getText());
				new YetkilerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+" yetkisi baþarýyla eklendi.");
				
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
