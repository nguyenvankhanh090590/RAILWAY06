/**
 * 
 */
package entity.Ex1;

public class Student {

	private int id;
	private String name;
	private String hometown;
	private float score;

	public Student(String name, String hometown) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		String xeploai = "";
		if (this.score < 4) {
			xeploai = "Yếu";
		} else if (this.score >= 4 && this.score < 6) {
			xeploai = "Trung bình";
		} else if (this.score < 8) {
			xeploai = "Khá";
		} else {
			xeploai = "Giỏi";
		}
		return "Student [id=" + id + ", name=" + name + ", hometown=" + hometown + ", score=" + score + ", xeploai="
				+ xeploai + "]";
	}

	public void plusScore(float score1) {
		this.score = this.score + score1;
	}
}
