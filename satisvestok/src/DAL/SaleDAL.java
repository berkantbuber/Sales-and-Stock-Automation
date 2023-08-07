package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import complex.contract.SaleContractComplex;
import complex.contract.StockContractComplex;
import contract.SatisContract;
import contract.StokContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class SaleDAL extends ObjectHelper implements DALInterface<SatisContract> {

	@Override
	public void Insert(SatisContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Sales (UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES("
					+ entity.getUrunId() + "," + "" + entity.getMusteriId() + ",'" + entity.getTarih() + "',"
					+ entity.getAdet() + "," + entity.getPersonelId() + ")");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<SaleContractComplex> GetAllSale() {
		
		List<SaleContractComplex> dataContract = new ArrayList<SaleContractComplex>(); 
		
		Connection conn = getConnection();
		SaleContractComplex contract;
		
		try {
			
			Statement statement = conn.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT sales.Id, personel.AdiSoyadi, musteri.AdiSoyadi, urunler.Adi, Adet, sales.Tarih FROM sales"
		    		+ " LEFT JOIN musteri on sales.MusteriId = musteri.Id "
		    		+ " LEFT JOIN urunler ON sales.UrunId = urunler.Id "
		    		+ " LEFT JOIN personel ON sales.PersonelId = personel.Id ORDER BY sales.Id DESC");
		            
		    while(rs.next()) {
		    	
		    	contract = new SaleContractComplex();
		    	
		    	contract.setId(rs.getInt("sales.Id"));
		    	contract.setMusteriAdi(rs.getString("musteri.AdiSoyadi"));
		    	contract.setPersonelAdi(rs.getString("personel.AdiSoyadi"));
		    	contract.setTarih(rs.getString("sales.Tarih"));
		    	contract.setUrunAdi(rs.getString("urunler.Adi"));
		    	contract.setAdet(rs.getInt("Adet"));
		    	
		    	
		    	dataContract.add(contract);
		    }
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}
	
	@Override
	public List<SatisContract> GetAll() {
		
		return null;
	}

	@Override
	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SatisContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SatisContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
