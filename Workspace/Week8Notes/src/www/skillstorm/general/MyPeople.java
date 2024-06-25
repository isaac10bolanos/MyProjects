package www.skillstorm.general;

public class MyPeople {
	
	private String name;
	private int age;
	private String eyeColor;
	
	public MyPeople(String name, int age, String eyeColor) {
		this.name = name;
		this.age = age;
		this.eyeColor = eyeColor;
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

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %d, Eye Color: %s", this.name, this.age, this.eyeColor);
	}

}
