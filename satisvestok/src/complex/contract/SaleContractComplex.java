package complex.contract;

import java.sql.Date;

public class SaleContractComplex {

	private int id;
	private String musteriAdi;
	private String personelAdi;
	private String urunAdi;
	private String tarih;
	private int adet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
	public Object[] getDatas() {

		Object[] datas = {id, musteriAdi, personelAdi, urunAdi, tarih, adet};

		return datas;
	
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  musteriAdi + " " + personelAdi + " " + urunAdi;
	}

}
