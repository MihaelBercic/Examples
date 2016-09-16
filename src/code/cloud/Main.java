package code.cloud;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.util.Timer;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		String url = "";
		long milliseconds = 1000;
		// set it up

		try {
			Image image = new ImageIcon("").getImage();
			TrayIcon trayIcon = new TrayIcon(image, "");
			if (SystemTray.isSupported()) {
				SystemTray tray = SystemTray.getSystemTray();
				tray.add(trayIcon);
				Timer timer = new Timer();
				CheckURL urlCheck = new CheckURL(url, trayIcon);
				timer.schedule(urlCheck, 0, milliseconds);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
