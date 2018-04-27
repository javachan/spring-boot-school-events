package app.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="basvuru")
public class Basvuru {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="bId")
	private int bId;
	
	@Column(name="bAdSoyad")
	private String bAdSoyad;
	
	@Column(name="bTelefon")
	private String bTelefon;
	
	@Column(name="bMail")
	private String bMail;
	
	@Column(name="bKulupAd")
	private String bKulupAd;
	
	@Column(name="bKulupIcerik")
	private String bKulupIcerik;
	
	@Column(name="bKulupLogo")
	private String bKulupLogo;
	
	@Column(name="bKulupTarih")
	private Date bKulupTarih;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbAdSoyad() {
		return bAdSoyad;
	}

	public void setbAdSoyad(String bAdSoyad) {
		this.bAdSoyad = bAdSoyad;
	}

	public String getbTelefon() {
		return bTelefon;
	}

	public void setbTelefon(String bTelefon) {
		this.bTelefon = bTelefon;
	}

	public String getbMail() {
		return bMail;
	}

	public void setbMail(String bMail) {
		this.bMail = bMail;
	}

	public String getbKulupAd() {
		return bKulupAd;
	}

	public void setbKulupAd(String bKulupAd) {
		this.bKulupAd = bKulupAd;
	}

	public String getbKulupIcerik() {
		return bKulupIcerik;
	}

	public void setbKulupIcerik(String bKulupIcerik) {
		this.bKulupIcerik = bKulupIcerik;
	}

	public String getbKulupLogo() {
		return bKulupLogo;
	}

	public void setbKulupLogo(String bKulupLogo) {
		this.bKulupLogo = bKulupLogo;
	}

	public Date getbKulupTarih() {
		return bKulupTarih;
	}

	public void setbKulupTarih(Date bKulupTarih) {
		this.bKulupTarih = bKulupTarih;
	}

	public Basvuru(String bAdSoyad, String bTelefon, String bMail, String bKulupAd, String bKulupIcerik,
			String bKulupLogo, Date bKulupTarih) {
		super();
		this.bAdSoyad = bAdSoyad;
		this.bTelefon = bTelefon;
		this.bMail = bMail;
		this.bKulupAd = bKulupAd;
		this.bKulupIcerik = bKulupIcerik;
		this.bKulupLogo = bKulupLogo;
		this.bKulupTarih = bKulupTarih;
	}

	public Basvuru() {
		super();
	}
	
	
	
	
}
