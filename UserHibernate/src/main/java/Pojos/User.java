package Pojos;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 30,nullable = true)
	private String password;
	@Transient
	private String confirmPass;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role role;
	@Column(name="regAmt")
	private Double regAmt;
	@Column(name="regDate")
	private LocalDate regDate;
	@Lob
	private byte[] image;
	
	public User()
	{
		System.out.println(getClass());
	}

	public User(String name, String email, String password, String confirmPass, Double regAmt, Role role,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPass = confirmPass;
		this.regAmt = regAmt;
		this.role = role;
		this.regDate = regDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public Double getregAmt() {
		return regAmt;
	}

	public void setregAmt(Double regAmt) {
		this.regAmt = regAmt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getregDate() {
		return regDate;
	}

	public void setregDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + ", confirmPass="
				+ confirmPass + ", regAmt=" + regAmt + ", role=" + role + ", regDate=" + regDate +  "]\n";
	}
	
	
}
