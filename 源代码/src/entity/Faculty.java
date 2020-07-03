package entity;

public class Faculty {
	private int id;
	private String department;
	private String name;
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Faculty(int id, String department, String name, String pwd) {
		this.id = id;
		this.department = department;
		this.name = name;
		this.pwd = pwd;
	}

	public Faculty() {
	}
}
