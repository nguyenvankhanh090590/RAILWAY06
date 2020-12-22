package entity;


public class PrimaryStudent extends Student {
	private String clasz;
	private static int countPrim = 0;
	

	

	public static int getCountPrim() {
		return countPrim;
	}

	public static void setCountPrim(int countPrim) {
		PrimaryStudent.countPrim = countPrim;
	}

	public String getClasz() {
		return clasz;
	}

	public void setClasz(String clasz) {
		this.clasz = clasz;
	}

	public PrimaryStudent(int id, String name, String clasz) throws Exception  {
		super(id, name);
		this.clasz = clasz;
		PrimaryStudent.countPrim ++;
	}
	
	

	

	
	
}
