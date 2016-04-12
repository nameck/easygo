package zzia;

public class Student {
	String name;
	static int courses = 8;
	int age = 20;
	public Student(String name) {
		super();
		this.name = name;	
	}
	public void show(){
		age++;
		courses++;
		System.out.println(this.name+"-->" +this.age + "-->" +this.courses);
	}
}
