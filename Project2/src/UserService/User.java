package UserService;

public class User {

	// Variables
	private int UserID;
	private String username;
	private String password;
	private boolean loggedIn;

	// Constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
		UserID = 0;
	}

	// Getters and setters
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
