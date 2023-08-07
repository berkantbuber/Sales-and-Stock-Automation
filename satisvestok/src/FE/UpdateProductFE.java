package FE;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.SwingConstants;

public class UpdateProductFE extends JDialog implements feinterface {
	public UpdateProductFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		setTitle("Ürün Düzenleme Ekraný");
		panel.setBackground(Color.white);

		getContentPane().add(panel);
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(6, 2));
		panel.setForeground(Color.BLACK);

		JLabel adiLabel1 = new JLabel("\u00DCr\u00FCn Ad\u0131 : ", SwingConstants.RIGHT);
		adiLabel1.setForeground(Color.BLACK);
		adiLabel1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		adiLabel1.setBackground(Color.WHITE);
		panel.add(adiLabel1);

		JComboBox nameBox = new JComboBox(new ProductDAL().GetAll().toArray());
		panel.add(nameBox);
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

		JButton iptalButton = new JButton("Ýptal");
		iptalButton.setForeground(Color.BLACK);
		iptalButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		iptalButton.setBackground(Color.white);
		panel.add(iptalButton);

		JButton kaydetButton = new JButton("Kaydet");
		kaydetButton.setForeground(Color.BLACK);
		kaydetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kaydetButton.setBackground(Color.white);
		panel.add(kaydetButton);
		
		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				UrunlerContract proContract = (UrunlerContract) nameBox.getSelectedItem();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							
				String date = format.format(tarihDate.getDate());				
				contract.setKategoriId(casContract.getId());
				contract.setId(proContract.getId());
				contract.setAdi(adiField.getText());
				contract.setTarih(date);
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));
				new ProductDAL().Update(contract);
				JOptionPane.showMessageDialog(null,
						contract.getAdi() + " adlý ürün baþarýlý bir þekilde düzenlenmiþtir.");

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
