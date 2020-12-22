package entity;


public class SecondaryStudent extends Student {
	private String clasz;
	private String task;
	private static int countSecn = 0;
	public String getClasz() {
		return clasz;
	}
	public void setClasz(String clasz) {
		this.clasz = clasz;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public static int getCountSecn() {
		return countSecn;
	}
	public static void setCountSecn(int countSecn) {
		SecondaryStudent.countSecn = countSecn;
	}
	public SecondaryStudent(int id, String name, String clasz, String task) throws Exception  {
		super(id, name);
		this.clasz = clasz;
		this.task = task;
		SecondaryStudent.countSecn ++;
	}
	
	
	
	
	
	
	
}
