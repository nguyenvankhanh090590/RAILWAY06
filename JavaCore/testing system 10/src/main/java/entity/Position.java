package entity;

public class Position {
	@Override
	public String toString() {
		return "Position [id=" + id + ", posiName=" + posiName + "]";
	}

	private int id;
	private String posiName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosiName() {
		return posiName;
	}

	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}

	public Position(int id, String posiName) {
		super();
		this.id = id;
		this.posiName = posiName;
	}

	public Position() {
		id = 0;
		posiName = "Chờ xếp việc";
	}

}
