package school;

public class Student {
	
	private int id;
	private String fname;
	private String lname;
	private int aclass;
	
	public Student(int id, String fname, String lname, int aclass) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.aclass = aclass;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public int getAclass() {
		return aclass;
	}
	
	public void setAclass(int aclass) {
		this.aclass = aclass;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", aclass=" + aclass + "]";
	}
}