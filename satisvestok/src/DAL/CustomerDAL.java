package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contract.KategoriContract;
import contract.MusteriContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class CustomerDAL extends ObjectHelper implements DALInterface<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO musteri (AdiSoyadi, Telefon, Adres, Sehir) " + "VALUES('"
					+ entity.getAdisoyadi() + "' , '" + entity.getTelefon() + "','" + entity.getAdres() + "', '"
					+ entity.getSehir() + "' )");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MusteriContract> GetAll() {

		List<MusteriContract> datacontract = new ArrayList<MusteriContract>();

		Connection connection = getConnection();
		MusteriContract contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Musteri");
			while (resultSet.next()) {
				contract = new MusteriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdisoyadi(resultSet.getString("AdiSoyadi"));
				contract.setAdres(resultSet.getString("Adres"));
				contract.setSehir(resultSet.getString("Sehir"));
				contract.setTelefon(resultSet.getString("Telefon"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;

	}

	@Override
	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(MusteriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("UPDATE Musteri SET AdiSoyadi = '" + entity.getAdisoyadi() + "', " + "  Telefon = '" + entity.getTelefon() + "', " + " Adres = '"
					+ entity.getAdres() + "', " + " Sehir = '" + entity.getSehir() + "' WHERE Id = " + entity.getId() + " ");

			System.out.println(entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
