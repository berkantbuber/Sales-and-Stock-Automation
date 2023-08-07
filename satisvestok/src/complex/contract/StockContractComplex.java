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

	public String getUrunAdư() {
		return urunAdi;
	}

	public void setUrunAdư(String urunAdư) {
		this.urunAdi = urunAdư;
	}

	public String getPersonelAdư() {
		return personelAdi;
	}

	public void setPersonelAdư(String personelAdư) {
		this.personelAdi = personelAdư;
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
