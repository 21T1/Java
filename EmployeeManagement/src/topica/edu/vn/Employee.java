package topica.edu.vn;

public class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
	
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

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee() {
		super();
	}

	@Override
	public int compareTo(Employee o) {
		// return this.name.compareToIgnoreCase(o.getName());
		int comp = this.name.compareToIgnoreCase(o.getName());
		if (comp == 0) {
			if (this.id == o.id) {
				return 0;
			}
			if (this.id > o.id) {
				return -1;
			}
			return 1;
		}
		return comp;
	}

}
