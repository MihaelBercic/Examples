package code.qverkk.user;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author Mihael
 * 
 */

public class Example {

	public Example() {
		String[] file = new String[] { "username,password,393,1,mulename", "username,password,393,1,mulename", "username,password,393,1,mulename", "username,password,393,1,mulename" };
		List<User> users = new ArrayList<>();
		for (String s : file) {
			String[] params = s.split(",");
			String username = params[0];
			String password = params[1];
			int world = Integer.parseInt(params[2]);
			int oreNumber = Integer.parseInt(params[3]);
			String muleName = params[4];
			users.add(new User(username, password, world, oreNumber, muleName));
		}

		for (User user : users) {
			System.out.println("Launch client: " + user.getUsername());
		}

	}
}
