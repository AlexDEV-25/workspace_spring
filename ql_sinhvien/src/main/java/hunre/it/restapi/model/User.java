package hunre.it.restapi.model;

public class User {
	private int masv;
	private String tensv;
	private String monhoc;
	private float diem;

	public User(int masv, String tensv, String monhoc, float diem) {
		this.masv = masv;
		this.tensv = tensv;
		this.monhoc = monhoc;
		this.diem = diem;
	}

	public User() {
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

}
