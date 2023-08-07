package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import complex.contract.StockContractComplex;
import complex.contract.StockContractTotalComplex;
import contract.KategoriContract;
import contract.StokContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class StockDAL extends ObjectHelper implements DALInterface<StokContract> {

	@Override
	public void Insert(StokContract entity) {
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

	 		statement.executeUpdate("INSERT INTO Stock (PersonelId, UrunId, Tarih, Adet) VALUES("+entity.getPersonelId()+"," 
					+ ""+entity.getUrunId()+", '"+entity.getTarih()+"', "+entity.getAdet()+")");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/*
	 SELECT stock.Id, personel.AdiSoyadi, urunler.Adi, Adet, stock.Tarih FROM stock 
	 LEFT JOIN urunler ON stock.UrunId = urunler.Id 
	 LEFT JOIN personel ON stock.PersonelId = personel.Id;
	 */
	
	public List<StockContractComplex> GetAllStock(){
		
		List<StockContractComplex> datacontract = new ArrayList<StockContractComplex>();

		Connection connection = getConnection();
		StockContractComplex contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT stock.Id, personel.AdiSoyadi, urunler.Adi, Adet, stock.Tarih FROM stock"
					+ "	 LEFT JOIN urunler ON stock.UrunId = urunler.Id"
					+ "	 LEFT JOIN personel ON stock.PersonelId = personel.Id ORDER BY stock.Id DESC");
			while (resultSet.next()) {
				contract = new StockContractComplex();
				contract.setId(resultSet.getInt("Id"));
		 		contract.setPersonelAdý(resultSet.getString("personel.AdiSoyadi"));
				contract.setUrunAdý(resultSet.getString("urunler.Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setTarih(resultSet.getString("stock.Tarih"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}
	
public List<StockContractTotalComplex> GetTotalStock(){
		
		List<StockContractTotalComplex> datacontract = new ArrayList<StockContractTotalComplex>();

		Connection connection = getConnection();
		StockContractTotalComplex contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT SUM(Adet) as Toplam, stock.Id, personel.AdiSoyadi, urunler.Adi, Adet, stock.Tarih FROM stock \r\n"
					+ "LEFT JOIN urunler ON stock.UrunId = urunler.Id \r\n"
					+ "LEFT JOIN personel ON stock.PersonelId = personel.Id GROUP BY UrunId;");
			while (resultSet.next()) {
				contract = new StockContractTotalComplex();
				contract.setId(resultSet.getInt("Id"));
		 		contract.setPersonelAdý(resultSet.getString("personel.AdiSoyadi"));
				contract.setUrunAdý(resultSet.getString("urunler.Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setTarih(resultSet.getString("stock.Tarih"));
				contract.setToplam(resultSet.getInt("Toplam"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}
	
	public List<StokContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StokContract Delete(StokContract entity) { 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(StokContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StokContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
