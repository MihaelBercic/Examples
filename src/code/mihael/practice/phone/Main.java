package code.mihael.practice.phone;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

	public static void main(String... args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(() -> new Phone());
	}

}
