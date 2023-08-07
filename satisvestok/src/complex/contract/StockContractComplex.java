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

	public String getUrunAdý() {
		return urunAdi;
	}

	public void setUrunAdý(String urunAdý) {
		this.urunAdi = urunAdý;
	}

	public String getPersonelAdý() {
		return personelAdi;
	}

	public void setPersonelAdý(String personelAdý) {
		this.personelAdi = personelAdý;
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
