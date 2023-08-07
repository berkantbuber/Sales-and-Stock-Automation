package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contract.KategoriContract;
import contract.UrunlerContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class ProductDAL extends ObjectHelper implements DALInterface<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {

		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO Urunler (Adi, KategoriId, Tarih, Fiyat) " + "VALUES('" + entity.getAdi() + "', "
							+ entity.getKategoriId() + " , '" + entity.getTarih() + "' , " + entity.getFiyat() + ")");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetAll() {

		List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();

		Connection connection = getConnection();
		UrunlerContract contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
			while (resultSet.next()) {
				contract = new UrunlerContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));

				datacontract.add(contract);

				System.out.println(resultSet.getString("Adi"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(UrunlerContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("UPDATE Urunler SET Adi = '" + entity.getAdi() + "', " + " KategoriId = "
					+ entity.getKategoriId() + ", " + " Tarih = '" + entity.getTarih() + "', " + " Fiyat = "
					+ entity.getFiyat() + " WHERE Id = " + entity.getId() + " ");
			
			System.out.println(entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
