package www.skillstorm.general;

import java.util.List;

public class MyProgram {
	
	public static void main(String[] args) {
		
		MyReader reader = new MyReader();
		//reader.readFile1();
		//reader.readFile2();
		//reader.readFile3();
		//reader.writeFile();
		List<MyPeople> people = reader.readCSV();
		//System.out.println(people);
		reader.writeCSV(people);
	}

}
