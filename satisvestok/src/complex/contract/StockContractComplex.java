package complex.contract;

import java.sql.Date;

public class StockContractComplex {

	private int id;
	private String urunAdi;
	private String personelAdi;
	private String tarih;
	private int adet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrunAd�() {
		return urunAdi;
	}

	public void setUrunAd�(String urunAd�) {
		this.urunAdi = urunAd�;
	}

	public String getPersonelAd�() {
		return personelAdi;
	}

	public void setPersonelAd�(String personelAd�) {
		this.personelAdi = personelAd�;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}
 
	public Object[] getDatas() {

		Object[] datas = {id, personelAdi, urunAdi, adet, tarih,};

		return datas;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return personelAdi + " " + urunAdi;

	}

}
