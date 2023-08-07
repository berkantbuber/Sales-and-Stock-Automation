package FE;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import DAL.CategoryDAL;
import DAL.ProductDAL;
import contract.KategoriContract;
import contract.UrunlerContract;
import interfaces.feinterface;
import java.awt.Font;

public class AddProductFE extends JDialog implements feinterface {

	public AddProductFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();		
		panel.setBorder(BorderFactory.createTitledBorder("Ürün Ekleyin"));
		panel.setBackground(Color.white);

		getContentPane().add(panel);
		setTitle("Ürün Kayýt Alaný");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
 
	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		panel.setForeground(Color.BLACK);
		JLabel adiLabel = new JLabel("Ürün Adý : ", JLabel.RIGHT);
		adiLabel.setForeground(Color.BLACK);
		adiLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiLabel.setBackground(Color.WHITE);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		adiField.setForeground(Color.BLACK);
		adiField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiField.setBackground(Color.WHITE);
		panel.add(adiField);

		JLabel kategoriLabel = new JLabel("Kategori : ", JLabel.RIGHT);
		kategoriLabel.setForeground(Color.BLACK);
		kategoriLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		kategoriLabel.setBackground(Color.WHITE);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new CategoryDAL().GetAll().toArray());
		kategoriBox.setForeground(Color.BLACK);
		kategoriBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		kategoriBox.setBackground(Color.white);
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("Kategori Seç", 0);
		kategoriBox.setSelectedIndex(0);

		JLabel tarihLabel = new JLabel("Tarih : ", JLabel.RIGHT);
		tarihLabel.setForeground(Color.BLACK);
		tarihLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tarihLabel.setBackground(Color.WHITE);
		panel.add(tarihLabel);
		JDateChooser tarihDate = new JDateChooser();		
		panel.add(tarihDate);

		JLabel fiyatLabel = new JLabel("Fiyat : ", JLabel.RIGHT);
		fiyatLabel.setBackground(Color.WHITE);
		fiyatLabel.setForeground(Color.BLACK);
		fiyatLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(fiyatLabel);
		JTextField fiyatField = new JTextField(10);
		fiyatField.setForeground(Color.BLACK);
		fiyatField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		fiyatField.setBackground(Color.WHITE);
		panel.add(fiyatField);

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
			UrunlerContract contract = new UrunlerContract();
			KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			String date = format.format(tarihDate.getDate());
			contract.setAdi(adiField.getText());
			contract.setKategoriId(casContract.getId());
			contract.setTarih(date);
			contract.setFiyat(Float.parseFloat(fiyatField.getText()));
			new ProductDAL().Insert(contract);
			JOptionPane.showMessageDialog(null, contract.getAdi()+" adlý ürün baþarýlý þekilde kaydedilmiþtir.");
				
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
