package entity;

public class Project {
	private int id;
	private int teamSize;
	private int idManager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	public Project(int id, int teamSize, int idManager) {
		super();
		this.id = id;
		this.teamSize = teamSize;
		this.idManager = idManager;
	}
	public Project() {
		super();
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", teamSize=" + teamSize + ", idManager=" + idManager + "]";
	}
	
	
}
