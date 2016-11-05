package code.mihael.practice.phone;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Phone extends JFrame {

	private JLabel label = new JLabel("Test");
	private JPanel panel = new JPanel();
	private Map<String, char[]> buttonFields = new LinkedHashMap<String, char[]>() {
		{
			put("1", new char[] {});
			put("2", new char[] { 'a', 'b', 'c', 'A', 'B', 'C', '2' });
			put("3", new char[] { 'd', 'e', 'f', 'D', 'E', 'F', '3' });
			put("4", new char[] { 'g', 'h', 'i', 'G', 'H', 'I', '4' });
			put("5", new char[] { 'j', 'k', 'l', 'J', 'K', 'L', '5' });
			put("6", new char[] { 'm', 'n', 'o', 'M', 'N', 'O', '6' });
			put("7", new char[] { 'p', 'r', 's', 'P', 'R', 'S', 'Q', '7' });
			put("8", new char[] { 't', 'u', 'v', 'T', 'U', 'V', '8' });
			put("9", new char[] { 'w', 'x', 'y', 'z', 'W', 'X', 'Y', 'Z', '9' });
			put("0", new char[] { ' ' });

		}
	};
	private int i = 0, x = 10, y = 40, press = 0;
	private int btnWidth = 50, btnHeight = 50;
	private int lastPressed = 0;
	private char currentCharacter;
	private String text = "";

	public Phone() {
		initialize();

		Timer timer = new Timer();
		timer.setExpire(TimeUnit.SECONDS, 3);
		timer.addActionListener(MethodEvent.RESTART, () -> label.setText(text + currentCharacter));
		timer.start();

		buttonFields.entrySet().forEach(e -> {
			String btn = e.getKey();
			char[] val = e.getValue();
			String type = "";
			if (val.length > 0) {
				for (int i = 0; i < (val.length >= 3 ? 3 : val.length); i++) {
					System.out.println(btn);
					type = type.concat("" + val[i]);
				}
			}

			JButton key = new JButton("<html><center>" + btn + "<br>" + type + "</center></html>");
			key.setName("" + btn);
			key.setFont(new Font("Arial", 0, 10));
			key.setFocusable(false);
			key.setBounds(x, y, btnWidth, btnHeight);

			key.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int pressedKey = Integer.parseInt(key.getName());
					if (lastPressed != pressedKey || !timer.isRunning()) {
						press = 0;
						lastPressed = pressedKey;
						timer.restart();
						text = label.getText();
					}
					if (timer.isRunning()) {
						int size = val.length;
						if (press >= size) {
							press = 0;
						}
						if (size == 0) {
							currentCharacter = (char) pressedKey;
						} else {
							currentCharacter = val[press];
							press++;
						}
						timer.restart();
					} else {
						press = 0;
					}
				}
			});

			panel.add(key);
			i++;
			if (i % 3 == 0) {
				y += btnHeight + 5;
				x = 10;
				if (i % 9 == 0) {
					x = 15 + btnWidth;
				}
			} else {
				x += btnWidth + 5;
			}
		});

	}

	private void initialize() {
		setTitle("Mobile phone test");
		setSize(200, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		panel.setLayout(null);

		panel.add(label);
		label.setBounds(10, 10, 100, 30);
	}

}
