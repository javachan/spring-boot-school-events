package app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import app.json.JsonDateSerializer;

@Entity
@Table(name="kulup")
public class Kulup {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="kulupId")
	private int kulupId;
	
	@Column(name="kulupAd")
	private String kulupAd;
	
	@Column(name="kulupIcerik",columnDefinition = "TEXT")
	private String kulupIcerik;
	
	@Column(name="kulupLogo")
	private String kulupLogo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="kulupTarih")
	private Date kulupTarih;
	
	
	@Column(name="kulupDurum")
	private Boolean kulupDurum;
	
	@Column(name="baskanAdSoyad")
	private String baskanAdSoyad;

	
	public String getBaskanAdSoyad() {
		return baskanAdSoyad;
	}
	public void setBaskanAdSoyad(String baskanAdSoyad) {
		this.baskanAdSoyad = baskanAdSoyad;
	}
	
	
	public int getKulupId() {
		return kulupId;
	}
	
	public void setKulupId(int kulupId) {
		this.kulupId = kulupId;
	}
	public String getKulupAd() {
		return kulupAd;
	}
	public void setKulupAd(String kulupAd) {
		this.kulupAd = kulupAd;
	}
	public String getKulupIcerik() {
		return kulupIcerik;
	}
	public void setKulupIcerik(String kulupIcerik) {
		this.kulupIcerik = kulupIcerik;
	}
	public String getKulupLogo() {
		return kulupLogo;
	}
	public void setKulupLogo(String kulupLogo) {
		this.kulupLogo = kulupLogo;
	}	

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getKulupTarih() {
		return kulupTarih;
	}
	public void setKulupTarih(Date kulupTarih) {
		this.kulupTarih = kulupTarih;
	}
	
	public Boolean getKulupDurum() {
		return kulupDurum;
	}
	public void setKulupDurum(Boolean kulupDurum) {
		this.kulupDurum = kulupDurum;
	}
	
	public Kulup(String kulupAd, String kulupIcerik, String kulupLogo, Date kulupTarih, Boolean kulupDurum) {
		super();
		this.kulupAd = kulupAd;
		this.kulupIcerik = kulupIcerik;
		this.kulupLogo = kulupLogo;
		this.kulupTarih = kulupTarih;
		this.kulupDurum = kulupDurum;
	}
	public Kulup() {
		super();
	}
	
	
	
	
}
