package www.skillstorm.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MyReader {
	
	
	private final String textFile = "C:\\Users\\isaac\\Documents\\Workspace\\Week8Notes\\src\\www\\skillstorm\\beans\\MyFile.txt";
	private final String textFile2 = "C:\\Users\\isaac\\Documents\\Workspace\\Week8Notes\\src\\www\\skillstorm\\beans\\MyFile2.txt";
	private final String csvFile = "C:\\Users\\isaac\\Documents\\Workspace\\Week8Notes\\src\\www\\skillstorm\\beans\\MyCSVmine.csv";

	public void readFile1() {
		
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(textFile);
			int inByte;
			
			while((inByte = in.read()) != -1) {	
				System.out.print((char)inByte);
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				in.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public void readFile2() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(textFile);
			br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					System.out.println(line.trim());
				}
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	
	public void readFile3() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(textFile))){
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					System.out.println(line.trim());
				}
			}
			
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void writeFile() {
		File file = new File(textFile2);
		
		if(file.exists()) {
			System.out.println("File exists!");
		} else {
			System.out.println("File doesn't exist!");
		}
		
		if(file.isDirectory()) {
			System.out.println("It's in a directory!");
		}else {
			System.out.println("It's not in the directory!");
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(textFile2))){
			
			
			bw.write("This is my new text file");
			bw.newLine();
			bw.write("Wow this is cool!");
			bw.newLine();
			bw.newLine();
			bw.write("What awesome things Java can do!");
			bw.newLine();
			bw.write("la la la");
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<MyPeople> readCSV(){
		List<MyPeople> people = new LinkedList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			String line;
			
			//line = br.readLine();
			while((line = br.readLine()) != null) {
				
				String[] vals = line.split(",");
				
				MyPeople record = new MyPeople(vals[0].trim(),
						Integer.parseInt(vals[1].trim()), vals[2].trim());
				people.add(record);
			}
			
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return people;
		
	}
	
	public void writeCSV(List<MyPeople> people) {
		File file = new File("csvFile2.csv");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			
			for(MyPeople p: people) {
				bw.write(p.getName() + ", " + p.getAge() + ", " + p.getEyeColor());
				bw.newLine();
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
