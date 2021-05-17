package mijnRestau.models;

public class Adres {
	private String straat;
	private String postCode;
	private String stad;
	private int huisnummer;

public Adres( String postCode,String straat, int huisnummer, String stad) {
	
	this.straat = straat;
	this.postCode = postCode;
	this.stad =stad;
	this.huisnummer = huisnummer;
}

public String getStraat() {
	return straat;
}

public void setStraat(String straat) {
	this.straat = straat;
}

public String getPostCode() {
	return postCode;
}

public void setPostCode(String postCode) {
	this.postCode = postCode;
}

public String getStad() {
	return stad;
}

public void setStad(String stad) {
	this.stad = stad;
}

public int getHuisnummer() {
	return huisnummer;
}

public void setHuisnummer(int huisnummer) {
	this.huisnummer = huisnummer;
}
}
