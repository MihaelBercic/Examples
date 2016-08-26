package java.com.qverkk.user;

/*
 * @Author Mihael
 * 
 */

public class User {
	String username, password, mulename;
	int world, oreNumber;

	public User(String username, String password, int world, int oreNumber, String mulename) {
		super();
		this.username = username;
		this.password = password;
		this.mulename = mulename;
		this.world = world;
		this.oreNumber = oreNumber;
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

	public String getMulename() {
		return mulename;
	}

	public void setMulename(String mulename) {
		this.mulename = mulename;
	}

	public int getWorld() {
		return world;
	}

	public void setWorld(int world) {
		this.world = world;
	}

	public int getOreNumber() {
		return oreNumber;
	}

	public void setOreNumber(int oreNumber) {
		this.oreNumber = oreNumber;
	}

}
