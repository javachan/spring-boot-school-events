package app.domain;

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

	@ManyToOne
	@JoinColumn(name="baskan",unique=true)
	private Baskan baskan;

	
	
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
	
	public Baskan getBaskan() {
		return baskan;
	}
	public void setBaskan(Baskan baskan) {
		this.baskan = baskan;
	}
	
	public Kulup(String kulupAd, String kulupIcerik, String kulupLogo, Baskan baskan) {
		super();
		this.kulupAd = kulupAd;
		this.kulupIcerik = kulupIcerik;
		this.kulupLogo = kulupLogo;
		this.baskan = baskan;
	}
	public Kulup() {
		super();
	}
	
	
	
	
}
