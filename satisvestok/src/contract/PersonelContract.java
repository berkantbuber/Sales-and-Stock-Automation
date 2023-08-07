package contract;

public class PersonelContract {

	private int id;
	private String adisoyadi;
	private String email;


	public int getId() {
 		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdisoyadi() {
		return adisoyadi;
	}

	public void setAdisoyadi(String adisoyadi) { 
		this.adisoyadi = adisoyadi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
	 	return adisoyadi ;
 	}

}
