package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contract.KategoriContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class CategoryDAL extends ObjectHelper implements DALInterface<KategoriContract> {

	@Override
	public void Insert(KategoriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Kategori (Adi,ParentId) VALUES('" + entity.getAdi() + "',"
					+ entity.getParentId() + ")");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetAll() {

		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	public List<KategoriContract> GetAllParentId() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0 ");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public KategoriContract Delete(KategoriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(KategoriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("UPDATE Kategori SET Adi = '" + entity.getAdi() + "', " + " ParentId = "
					+ entity.getParentId() + " WHERE Id = " + entity.getId() + " ");
			
			System.out.println(entity.getId());
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<KategoriContract> GetBySearchCategory(String kategoriAdi) {

		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM Kategori WHERE Adi LIKE '" + "%" + kategoriAdi + "%" + "'");
 
			while (rs.next()) {

				KategoriContract contract = new KategoriContract();

				contract.setAdi(rs.getString("Adi"));
				contract.setParentId(rs.getInt("ParentId"));

				datacontract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;

	}

}
