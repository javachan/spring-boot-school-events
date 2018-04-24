package app.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="etkinlik")
public class Etkinlik {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@Column(name="ad")
	private String ad;
	
	@Column(name="tarih")
	@Temporal(TemporalType.DATE)
	private Date tarih;
	
	@Column(name="adres",columnDefinition="TEXT")
	private String adres;
	
	@Column(name="icerik",columnDefinition="TEXT")
	private String icerik;
	
	
	@Column(name="durum")
	private Boolean durum;
	
	@Column(name="kulupAd")
	private String kulupAd;
	
	@ElementCollection
	@Column(name="konusmaci")
	private List<String> konusmaci = new ArrayList<String>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public Boolean getDurum() {
		return durum;
	}

	public void setDurum(Boolean durum) {
		this.durum = durum;
	}

	public String getKulupAd() {
		return kulupAd;
	}

	public void setKulupAd(String kulupAd) {
		this.kulupAd = kulupAd;
	}

	public List<String> getKonusmaci() {
		return konusmaci;
	}

	public void setKonusmaci(List<String> konusmaci) {
		this.konusmaci = konusmaci;
	}

	public Etkinlik(String ad, Date tarih, String adres, String icerik, Boolean durum) {
		super();
		this.ad = ad;
		this.tarih = tarih;
		this.adres = adres;
		this.icerik = icerik;
		this.durum = durum;
		
		
	}

	public Etkinlik() {
		super();
	}
	
	
	
}
