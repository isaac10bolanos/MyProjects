package www.skillstorm.singleton;

public class Evolution {
	
	private static Object mutex = new Object();
	
	private static Evolution instance = null;
	
	private int generation;
	
	private Evolution() {
		this.generation = 10;
	}
	
	private Evolution(int generation) {
		this.generation = generation;
	}
	
	public static Evolution getInstance() {
		synchronized (mutex) {
			if(instance == null) {
				instance = new Evolution();
			}
			return instance;
		}
	}
	
	public static Evolution getInstance(int generation) {
		synchronized (mutex) {
			if(instance == null) {
				instance = new Evolution();
			}
			return instance;
		}
	}

}
