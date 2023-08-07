package FE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import interfaces.feinterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.AccountDAL;
import DAL.CustomerDAL;
import DAL.ProductDAL;
import DAL.SaleDAL;
import DAL.StockDAL;
import complex.contract.SaleContractComplex;
import complex.contract.StockContractComplex;
import complex.contract.StockContractTotalComplex;
import contract.MusteriContract;
import contract.PersonelContract;
import contract.SatisContract;
import contract.StokContract;
import contract.UrunlerContract;

public class MainDisplay extends JFrame implements feinterface {

	private JPanel contentPane;
	public DefaultTableModel model = null;
	public DefaultTableModel model1 = null;
	public Object[] stockColumn = null;
	public Object[] saleColumn = null;
	private JTable table;
	private JTable table_1;
	private JTextField stockSumField;
	private JTextField saleSumField;
	private Component employeeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay frame = new MainDisplay();
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
	public MainDisplay() {
		initDisplay();
	}

	@Override
	public void initDisplay() {

		JPanel panel = initPanel();
		JMenuBar bar = initBar();

		getContentPane().add(panel);

		getContentPane().add(panel);
		setJMenuBar(bar);

		setTitle("Satýþ ve Stok Programý");
		setFont(new Font("Bell MT", Font.BOLD, 14));
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		// contentPane.setBorder(new EmptyBorder(100, 100, 100, 100));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(100, 100));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tabbedPane.setBackground(Color.WHITE);

		contentPane.add(tabbedPane);

		Panel sale = new Panel();
		sale.setForeground(Color.BLACK);
		sale.setBackground(Color.WHITE);
		sale.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tabbedPane.addTab("Satýþ", null, sale, null);
		sale.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(250, 250);
		scrollPane_1.setBounds(87, 0, 365, 400);
		sale.add(scrollPane_1);

		model1 = new DefaultTableModel();
		Object[] saleColumn = { "Ürün Id", "Müþteri Adý", "Personel Adý", "Ürün Adý", "Ürün Tarihi", "Ürün Adeti" };
		model1.setColumnIdentifiers(saleColumn);

		table_1 = new JTable(model1);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table_1.setForeground(Color.BLACK);
		table_1.setBackground(Color.WHITE);
		scrollPane_1.setColumnHeaderView(table_1);
		scrollPane_1.setViewportView(table_1);
		sale.add(scrollPane_1);

		JPanel rightSalePane = new JPanel();
		sale.add(scrollPane_1, BorderLayout.CENTER);

		JPanel rightSalePanel = new JPanel();
		rightSalePanel.setBorder(
				new TitledBorder(null, "Satýþ Ýþlemleri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rightSalePanel.setForeground(Color.BLACK);
		rightSalePanel.setBackground(Color.WHITE);

		rightSalePanel.setBounds(0, 0, 202, 461);
		sale.add(rightSalePanel, BorderLayout.EAST);
		rightSalePanel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel employeeLabel = new JLabel("Müþteri Adý : ", JLabel.RIGHT);
		employeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		employeeLabel.setForeground(Color.BLACK);
		employeeLabel.setBackground(Color.WHITE);
		rightSalePanel.add(employeeLabel);

		JComboBox customerNameBox = new JComboBox(new CustomerDAL().GetAll().toArray());
		customerNameBox.setForeground(Color.BLACK);
		customerNameBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		customerNameBox.setBackground(Color.WHITE);
		rightSalePanel.add(customerNameBox);

		JLabel saleProudctNameLabel = new JLabel("Ürün Adý: ", JLabel.RIGHT);
		saleProudctNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		saleProudctNameLabel.setBackground(Color.WHITE);
		saleProudctNameLabel.setForeground(Color.BLACK);
		rightSalePanel.add(saleProudctNameLabel);

		JComboBox saleProductNameBox = new JComboBox(new ProductDAL().GetAll().toArray());
		saleProductNameBox.setForeground(Color.BLACK);
		saleProductNameBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		saleProductNameBox.setBackground(Color.WHITE);
		rightSalePanel.add(saleProductNameBox);

		JLabel saleSumLabel = new JLabel("Ürün Adeti: ", SwingConstants.RIGHT);
		saleSumLabel.setForeground(Color.BLACK);
		saleSumLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		saleSumLabel.setBackground(Color.WHITE);
		rightSalePanel.add(saleSumLabel);

		saleSumField = new JTextField();
		saleSumField.setColumns(10);
		rightSalePanel.add(saleSumField);

		JLabel saleDateLabel = new JLabel("Ürün Tarihi: ", JLabel.RIGHT);
		saleDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		saleDateLabel.setBackground(Color.WHITE);
		saleDateLabel.setForeground(Color.BLACK);
		rightSalePanel.add(saleDateLabel);

		JDateChooser saleDate = new JDateChooser();
		rightSalePanel.add(saleDate);

		JButton doSaleButton = new JButton("Satýþ Yap");
		doSaleButton.setForeground(Color.BLACK);
		doSaleButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		doSaleButton.setBackground(Color.WHITE);
		rightSalePanel.add(doSaleButton);

		JButton updateSaleButton = new JButton("Yenile");
		updateSaleButton.setForeground(Color.BLACK);
		updateSaleButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		updateSaleButton.setBackground(Color.WHITE);
		for(SaleContractComplex updatecontract : new SaleDAL().GetAllSale()) {
			
			model1.addRow(updatecontract.getDatas());
			
		}
		rightSalePanel.add(updateSaleButton);

		doSaleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PersonelContract pContract = (PersonelContract) LoginFE.nameBox.getSelectedItem();
			 	UrunlerContract uContract = (UrunlerContract) saleProductNameBox.getSelectedItem();
				MusteriContract mContract = (MusteriContract) customerNameBox.getSelectedItem();
				SatisContract contract = new SatisContract();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(saleDate.getDate());

				contract.setMusteriId(mContract.getId());
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setAdet(Integer.parseInt(saleSumField.getText()));
				contract.setTarih(date);

				new SaleDAL().Insert(contract);
				StokContract stockContract = new StokContract();

				stockContract.setPersonelId(pContract.getId());
				stockContract.setUrunId(uContract.getId());
				stockContract.setAdet(-Integer.parseInt(saleSumField.getText()));
				stockContract.setTarih(date);

				new StockDAL().Insert(stockContract);

				JOptionPane.showMessageDialog(null, mContract.getAdisoyadi() + " adlý müþteriye satýþ yapýlmýþtýr ve "
						+ uContract.getAdi() + " adlý üründen stokta " + contract.getAdet() + " adet eksiltirmiþtir.");
                
				int satir = model1.getRowCount();

				for (int i = 0; i < satir; i++) {

					model1.removeRow(0);

				}
				
				for(SaleContractComplex updatecontract : new SaleDAL().GetAllSale()) {
					
					model1.addRow(updatecontract.getDatas());
					
				}
			}
		});
		
		updateSaleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int satir = model1.getRowCount();

				for (int i = 0; i < satir; i++) {

					model1.removeRow(0);

				}
				
				for(SaleContractComplex contract : new SaleDAL().GetAllSale()) {
					
					model1.addRow(contract.getDatas());
					
				}
				
			}
		});
		
		

		Panel stock = new Panel();
		stock.setForeground(Color.BLACK);
		stock.setBackground(Color.WHITE);
		stock.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tabbedPane.addTab("Stok", null, stock, null);
		stock.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(200, 250);
		scrollPane.setBounds(237, 0, 603, 289);

		model = new DefaultTableModel();
		Object[] stockColumn = { "Ürün Id", "Personel Adý", "Ürün Adý", "Ürün Adeti", "Ürün Tarihi", "Toplam" };
		model.setColumnIdentifiers(stockColumn);

		table = new JTable(model);
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);

		scrollPane.setViewportView(table);
		stock.add(scrollPane, BorderLayout.CENTER);

		JPanel leftStockPanel = new JPanel(new GridLayout(5, 2));
		leftStockPanel.setBorder(
				new TitledBorder(null, "Stok Ýþlemleri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftStockPanel.setForeground(Color.BLACK);
		leftStockPanel.setBackground(Color.WHITE);

		leftStockPanel.setBounds(0, 0, 237, 289);
		stock.add(leftStockPanel, BorderLayout.WEST);

		for (StockContractComplex contractComplex : new StockDAL().GetAllStock()) {

			model.addRow(contractComplex.getDatas());

		}
		JLabel stockProudctNameLabel = new JLabel("Ürün Adý: ", JLabel.RIGHT);
		stockProudctNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		stockProudctNameLabel.setBackground(Color.WHITE);
		stockProudctNameLabel.setForeground(Color.BLACK);
		leftStockPanel.add(stockProudctNameLabel);

		JComboBox stockProductNameBox = new JComboBox(new ProductDAL().GetAll().toArray());
		stockProductNameBox.setForeground(Color.BLACK);
		stockProductNameBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		stockProductNameBox.setBackground(Color.WHITE);
		leftStockPanel.add(stockProductNameBox);

		JLabel stockSumLabel = new JLabel("Ürün Adeti: ", SwingConstants.RIGHT);
		stockSumLabel.setForeground(Color.BLACK);
		stockSumLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		stockSumLabel.setBackground(Color.WHITE);
		leftStockPanel.add(stockSumLabel);

		stockSumField = new JTextField();
		stockSumField.setColumns(10);
		leftStockPanel.add(stockSumField);

		JLabel stockDateLabel = new JLabel("Ürün Tarihi: ", JLabel.RIGHT);
		stockDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		stockDateLabel.setBackground(Color.WHITE);
		stockDateLabel.setForeground(Color.BLACK);
		leftStockPanel.add(stockDateLabel);

		JDateChooser stockDate = new JDateChooser();
		leftStockPanel.add(stockDate);

		JButton addStcokButton = new JButton("Stok Ekle");
		addStcokButton.setBackground(Color.WHITE);
		addStcokButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addStcokButton.setForeground(Color.BLACK);
		leftStockPanel.add(addStcokButton);

		JButton updateStcokButton = new JButton("Stok Yenile");
		updateStcokButton.setBackground(Color.WHITE);
		updateStcokButton.setForeground(Color.BLACK);
		updateStcokButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		leftStockPanel.add(updateStcokButton);

		JButton stocktotaButton = new JButton("Stok Bilgisi");
		stocktotaButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		stocktotaButton.setForeground(Color.BLACK);
		stocktotaButton.setBackground(Color.WHITE);
		leftStockPanel.add(stocktotaButton);

		stocktotaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int satir = model.getRowCount();

				for (int i = 0; i < satir; i++) {

					model.removeRow(0);

				}
				for (StockContractTotalComplex total : new StockDAL().GetTotalStock()) {

					model.addRow(total.getDatas());

				}

			}
		});

		updateStcokButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {

					model.removeRow(0);
				}
				for (StockContractComplex compContract : new StockDAL().GetAllStock()) {

					model.addRow(compContract.getDatas());
				}

			}
		});

		addStcokButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StokContract contract = new StokContract();
				UrunlerContract uContract = (UrunlerContract) stockProductNameBox.getSelectedItem();
				PersonelContract pContract = (PersonelContract) LoginFE.nameBox.getSelectedItem();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(stockDate.getDate());

				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setTarih(date);
				contract.setAdet(Integer.parseInt(stockSumField.getText()));
				new StockDAL().Insert(contract);

				JOptionPane.showMessageDialog(null, uContract.getAdi() + " stoða eklenmiþtir.");

				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {

					model.removeRow(0);
				}
				for (StockContractComplex compContract : new StockDAL().GetAllStock()) {

					model.addRow(compContract.getDatas());

				}

			}
		});

		setSize(861, 398);
		setLocationRelativeTo(null);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel();
		return panel;

	}

	@Override
	public JMenuBar initBar() {

		JMenuBar bar = new JMenuBar();
		bar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bar.setForeground(Color.BLACK);
		bar.setBackground(Color.WHITE);

		JMenu fileMenu = new JMenu("Dosya");
		fileMenu.setForeground(Color.BLACK);
		fileMenu.setBackground(Color.WHITE);
		fileMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bar.add(fileMenu);

		JMenuItem exitItem = new JMenuItem("Çýkýþ");
		exitItem.setBackground(Color.WHITE);
		exitItem.setForeground(Color.BLACK);
		exitItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fileMenu.add(exitItem);
		
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		
		JMenu ProductMenu = new JMenu("Ürünler");
		ProductMenu.setForeground(Color.BLACK);
		ProductMenu.setBackground(Color.WHITE);
		ProductMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bar.add(ProductMenu);

		JMenuItem addProductItem = new JMenuItem("Ürün Ekle");
		addProductItem.setForeground(Color.BLACK);
		addProductItem.setBackground(Color.WHITE);
		addProductItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ProductMenu.add(addProductItem);

		JMenuItem addCategoryItem = new JMenuItem("Kategori Ekle");
		addCategoryItem.setForeground(Color.BLACK);
		addCategoryItem.setBackground(Color.WHITE);
		addCategoryItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ProductMenu.add(addCategoryItem);

		JMenuItem updateProductItem = new JMenuItem("Ürünü Düzenle");
		updateProductItem.setForeground(Color.BLACK);
		updateProductItem.setBackground(Color.WHITE);
		updateProductItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ProductMenu.add(updateProductItem);
		
		updateProductItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new UpdateProductFE();
						
					}
				});
				
			}
		});

		JMenuItem updateCatagoryItem = new JMenuItem("Kategori Düzenle");
		updateCatagoryItem.setBackground(Color.WHITE);
		updateCatagoryItem.setForeground(Color.BLACK);
		updateCatagoryItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ProductMenu.add(updateCatagoryItem);
		
		updateCatagoryItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new UpdateCategoryFE();
						
					}
				});
				
			}
		});

		JMenu EmployeeMenu = new JMenu("Personel Ýþlemleri");
		EmployeeMenu.setForeground(Color.BLACK);
		EmployeeMenu.setBackground(Color.WHITE);
		EmployeeMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bar.add(EmployeeMenu);

		JMenuItem addEmployeeItem = new JMenuItem("Personel Ekle");
		addEmployeeItem.setForeground(Color.BLACK);
		addEmployeeItem.setBackground(Color.WHITE);
		addEmployeeItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		EmployeeMenu.add(addEmployeeItem);

		JMenuItem addAuthorityItem = new JMenuItem("Yetki Ekle");
		addAuthorityItem.setBackground(Color.WHITE);
		addAuthorityItem.setForeground(Color.BLACK);
		addAuthorityItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		EmployeeMenu.add(addAuthorityItem);

		JMenuItem setPasswordItem = new JMenuItem("Þifre Belirleme");
		setPasswordItem.setForeground(Color.BLACK);
		setPasswordItem.setBackground(Color.WHITE);
		setPasswordItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		EmployeeMenu.add(setPasswordItem);

		JMenu customerMenu = new JMenu("Müþteri Ýþlemleri");
		customerMenu.setForeground(Color.BLACK);
		customerMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerMenu.setBackground(Color.WHITE);
		bar.add(customerMenu);

		JMenuItem addCustomerItem = new JMenuItem("Müþteri Ekle");
		addCustomerItem.setForeground(Color.BLACK);
		addCustomerItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addCustomerItem.setBackground(Color.WHITE);
		customerMenu.add(addCustomerItem);

		JMenuItem updateCustomer = new JMenuItem("Müþteri Düzenle");
		updateCustomer.setForeground(Color.BLACK);
		updateCustomer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		updateCustomer.setBackground(Color.WHITE);
		customerMenu.add(updateCustomer);
		
		updateCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new UpdateCustomerFE();
						
					}
				});
				
			}
		});

		PersonelContract contract = (PersonelContract) LoginFE.nameBox.getSelectedItem();

		if (new AccountDAL().GetYetkiId(contract.getId()).getYetkiId() == 4) {

			EmployeeMenu.hide();

		} else if (new AccountDAL().GetYetkiId(contract.getId()).getYetkiId() == 5) {

			EmployeeMenu.hide();
			ProductMenu.hide();
			customerMenu.hide();

		}

		addProductItem.addActionListener((ActionListener) new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new AddProductFE();

					}

				});

			}
		});
		addCategoryItem.addActionListener((ActionListener) new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new AddCategoryFE();

					}

				});

			}
		});

		addEmployeeItem.addActionListener((ActionListener) new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new AddEmployeeFE();

					}

				});
			}

		});

		addAuthorityItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						new addAuthorityItemFE();

					}
				});

			}
		});

		setPasswordItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new PasswordProcessFE();

			}
		});

		addCustomerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						new addCustomerFE();

					}
				});

			}
		});

		return bar;

	}

	@Override
	public JTabbedPane initTabs() {
		return null;
	}

	@Override
	public void initPencere() {
		// TODO Auto-generated method stub

	}
}