package contract;

public class MusteriContract {

	private int id;
	private String adisoyadi;
	private String telefon;
	private String adres;
	private String sehir;

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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adisoyadi ;
	}

}
