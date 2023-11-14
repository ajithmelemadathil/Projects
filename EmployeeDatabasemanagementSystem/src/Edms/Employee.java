package Edms;

public class Employee {
	private int slno;
	private String id;
	private String name;
	private int age;
	private double sal;
	private String designation;
	static int count;

	public Employee(int slno, String name, int age, double sal, String designation) {
		super();
		this.slno = slno;
		this.name = name;
		this.age = age;
		this.sal = sal;
		this.designation = designation;
		this.id = "EMP" + (count++);
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [slno=" + slno + ", id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal
				+ ", designation=" + designation + "]";
	}

}
