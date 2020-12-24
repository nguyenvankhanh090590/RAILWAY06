package entity;

public class Employee extends User{
	private int project_id;
	private String proSkill;
	
	@Override
	public String toString() {
		return "Employee [project_id=" + project_id + ", proSkill=" + proSkill + ", getId()=" + getId()
				+ ", getFullName()=" + getFullName() + ", getEmail()=" + getEmail() + "]";
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProSkill() {
		return proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
	public Employee(int id, String fullName, String email, String password, int project_id, String proSkill) {
		super(id, fullName, email, password);
		this.project_id = project_id;
		this.proSkill = proSkill;
	}
	
	
	
	
}
