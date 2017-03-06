package code.mihael.practice.phone;

import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import code.mihael.practice.phone.data.MethodEvent;

public class Main {

	public static void main(String... args) throws Exception {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// SwingUtilities.invokeLater(() -> new Phone());

		Timer timer = new Timer();
		timer.addActionListener(MethodEvent.STOP, () -> System.out.println("ROBINPC IS A NEWB"));
		timer.start();
		Thread.sleep(5000);
		System.out.println(timer.getTimeAsString());
	}

}
