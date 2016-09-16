package code.cloud;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.TimerTask;

public class CheckURL extends TimerTask {

	private String urString, response = "";
	private TrayIcon icon;

	public CheckURL(String urString, TrayIcon icon) {
		this.urString = urString;
		this.icon = icon;
	}

	@Override
	public void run() {
		if (findChange()) {
			icon.displayMessage("Change detected", "There is a change in the URL response.", MessageType.INFO);
		}
	}

	private boolean findChange() {
		try {
			URL url = new URL(urString);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String currentResponse = "";
			while ((line = reader.readLine()) != null) {
				currentResponse = currentResponse.concat(line);
			}
			reader.close();
			if (!response.isEmpty() && !response.equals(currentResponse)) {
				System.out.println("Response: " + response.length());
				System.out.println("CurrentResponse: " + currentResponse.length());
				return true;
			} else if (response.isEmpty()) {
				response = currentResponse;
				System.out.println("Set reponse");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
