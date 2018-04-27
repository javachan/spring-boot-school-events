package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role="USER";
	
	@Column(name="baskanAdSoyad")
	private String baskanAdSoyad;
	
	public String getBaskanAdSoyad() {
		return baskanAdSoyad;
	}
	public void setBaskanAdSoyad(String baskanAdSoyad) {
		this.baskanAdSoyad = baskanAdSoyad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Login(String username, String password, String role, String baskanAdSoyad) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.baskanAdSoyad = baskanAdSoyad;
	}
	public Login() {
		super();
	}

	
}
