package vn.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "hoten")
	private String hoten;
	@Column(name = "ten")
	private String ten;
	@Column(name = "email")
	private String enail;

	public Employee(long id, String hoten, String ten, String enail) {
		this.id = id;
		this.hoten = hoten;
		this.ten = ten;
		this.enail = enail;
	}

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEnail() {
		return enail;
	}

	public void setEnail(String enail) {
		this.enail = enail;
	}

}
