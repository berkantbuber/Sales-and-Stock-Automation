package FE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DAL.CategoryDAL;
import contract.KategoriContract;
import interfaces.feinterface;
import javax.swing.SwingConstants;

public class UpdateCategoryFE extends JDialog implements feinterface {

	public UpdateCategoryFE() {

		initPencere();

	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		setTitle("Kategori Düzenleme Ekraný");
		panel.setBackground(Color.white);

		getContentPane().add(panel);
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);

		panel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));
		panel.setLayout(null);
		panel.setLayout(null);
		JLabel categoryNameLabel = new JLabel("Kategori  Adý : ", JLabel.LEFT);
		categoryNameLabel.setBounds(6, 16, 113, 35);
		categoryNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		categoryNameLabel.setForeground(Color.BLACK);
		categoryNameLabel.setBackground(Color.WHITE);
		panel.add(categoryNameLabel);

		JTextField categoryNameField = new JTextField(10);
		categoryNameField.setBounds(108, 16, 164, 35);
		categoryNameField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		categoryNameField.setForeground(Color.BLACK);
		categoryNameField.setBackground(Color.WHITE);
		panel.add(categoryNameField);

		JLabel selectCategory = new JLabel("Kategori  Seç  : ", SwingConstants.LEFT);
		selectCategory.setBounds(6, 63, 113, 35);
		selectCategory.setForeground(Color.BLACK);
		selectCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		selectCategory.setBackground(Color.WHITE);
		panel.add(selectCategory);

		JComboBox kategoriBox = new JComboBox(new CategoryDAL().GetAll().toArray());
		kategoriBox.setBounds(108, 63, 164, 35);
		kategoriBox.setForeground(Color.BLACK);
		kategoriBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kategoriBox.setBackground(Color.WHITE);
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("Kategori Seç", 0);
		kategoriBox.setSelectedIndex(0);

		JButton kaydetButton = new JButton("Kaydet");
		kaydetButton.setBounds(144, 109, 128, 35);
		kaydetButton.setForeground(Color.BLACK);
		kaydetButton.setBackground(Color.WHITE);
		kaydetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(kaydetButton);

		JButton iptalButton = new JButton("\u0130ptal");
		iptalButton.setBounds(6, 109, 128, 35);
		iptalButton.setForeground(Color.BLACK);
		iptalButton.setBackground(Color.WHITE);
		iptalButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(iptalButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KategoriContract contract = new KategoriContract();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();

				contract.setId(casContract.getId());
				contract.setAdi(categoryNameField.getText());
				new CategoryDAL().Update(contract);
				JOptionPane.showMessageDialog(null,
						contract.getAdi() + " adlý kategori baþarýlý bir þekilde düzenlenmiþtir.");

			}
		});

		iptalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		JLabel label = new JLabel("");
		label.setBounds(6, 86, 113, 35);
		panel.add(label);

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
