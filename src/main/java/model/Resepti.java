package model;

public class Resepti {

	private int id;
	private String nimi;
	private String kuvaus;
	private String ainekset;
	private String valmistusaika;
	private String ohjeet;
	
	
	
	//konstruktorit 
	public Resepti() {
	}


	//reseptin luonti id:llä ja ilman
	public Resepti(int id, String nimi, String kuvaus, String ainekset, String valmistusaika, String ohjeet) {
		super();
		this.id = id;
		this.nimi = nimi;		
		this.kuvaus = kuvaus;
		this.ainekset = ainekset;
		this.valmistusaika = valmistusaika;
		this.ohjeet = ohjeet;
	}
	public Resepti(String nimi, String kuvaus, String ainekset, String valmistusaika, String ohjeet) {
		super();
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.ainekset = ainekset;
		this.valmistusaika = valmistusaika;
		this.ohjeet = ohjeet;
	}



	public String getNimi() {
		return nimi;
	}



	public void setNimi(String nimi) {
		this.nimi = nimi;
	}



	public String getValmistusaika() {
		return valmistusaika;
	}





	public int getId() {
		return id;
	}



	public String getKuvaus() {
		return kuvaus;
	}



	public String getAinekset() {
		return ainekset;
	}



	public String getOhjeet() {
		return ohjeet;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}



	public void setAinekset(String ainekset) {
		this.ainekset = ainekset;
	}
	

	public void setValmistusaika(String valmistusaika) {
		
		String trimmattuValmistusaika = valmistusaika.replace(" ", "");
		this.valmistusaika = trimmattuValmistusaika;
	}



	public void setOhjeet(String ohjeet) {
		this.ohjeet = ohjeet;
	}



	@Override
	public String toString() {
		return "Resepti [id=" + id + "nimi=" + nimi + ", kuvaus=" + kuvaus + ", ainekset=" + ainekset + ", valmistusaika=" + valmistusaika
				+ ", ohjeet=" + ohjeet + "]";
	}
	
	
}
