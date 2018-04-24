package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="konusmaci")
public class Konusmaci {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int konusmaciId;
	
	@Column(name="konusmaciAdSoyad")
	private String konusmaciAdSoyad;
	
	@Column(name="konusmaciIcerik")
	private String konusmaciIcerik;
	
	@Column(name="konusmaciTelefon")
	private String konusmaciTelefon;
	
	@Column(name="konusmaciMail")
	private String konusmaciMail;

	@Column(name="konusmaciKulup")
	private String konusmaciKulup;
	
	
	public String getKonusmaciKulup() {
		return konusmaciKulup;
	}

	public void setKonusmaciKulup(String konusmaciKulup) {
		this.konusmaciKulup = konusmaciKulup;
	}

	public int getKonusmaciId() {
		return konusmaciId;
	}

	public void setKonusmaciId(int konusmaciId) {
		this.konusmaciId = konusmaciId;
	}

	public String getKonusmaciAdSoyad() {
		return konusmaciAdSoyad;
	}

	public void setKonusmaciAdSoyad(String konusmaciAdSoyad) {
		this.konusmaciAdSoyad = konusmaciAdSoyad;
	}


	public String getKonusmaciIcerik() {
		return konusmaciIcerik;
	}

	public void setKonusmaciIcerik(String konusmaciIcerik) {
		this.konusmaciIcerik = konusmaciIcerik;
	}

	public String getKonusmaciTelefon() {
		return konusmaciTelefon;
	}

	public void setKonusmaciTelefon(String konusmaciTelefon) {
		this.konusmaciTelefon = konusmaciTelefon;
	}

	public String getKonusmaciMail() {
		return konusmaciMail;
	}

	public void setKonusmaciMail(String konusmaciMail) {
		this.konusmaciMail = konusmaciMail;
	}

	public Konusmaci(String konusmaciAdSoyad, String konusmaciIcerik, String konusmaciTelefon, String konusmaciMail) {
		super();
		this.konusmaciAdSoyad = konusmaciAdSoyad;
		this.konusmaciIcerik = konusmaciIcerik;
		this.konusmaciTelefon = konusmaciTelefon;
		this.konusmaciMail = konusmaciMail;
	}

	public Konusmaci() {
		super();
	}
	
	
	
}
