package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contract.AccountsContract;
import core.ObjectHelper;
import interfaces.DALInterface;

public class AccountDAL extends ObjectHelper implements DALInterface<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Accounts (personelId,yetkiId,sifre) VALUES(" + entity.getPersonelId()
					+ "," + entity.getYetkiId() + ", '" + entity.getSifre() + "')");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public AccountsContract GetEmployeeIdAndPassword(int PersonelId, String Sifre) {

		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * FROM accounts WHERE PersonelId = "+PersonelId+" AND Sifre = '"+Sifre.trim()+"'");

			while (rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setSifre(rs.getString("Sifre"));
				contract.setYetkiId(rs.getInt("YetkiId"));
				
			}

			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {

			System.out.println(e);

		}

		return contract;
	}
	
	public AccountsContract GetYetkiId(int personelId) {

		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * FROM accounts WHERE PersonelId = "+personelId+" ");

			while (rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setYetkiId(rs.getInt("YetkiId"));
				
			}

			sorgu.close();
			baglanti.close();
		} catch (SQLException e) {

			System.out.println(e);

		}

		return contract;
	}

	@Override
	public List<AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
