package code.mihael.notification;

import com.notification.Notification;
import com.notification.NotificationList;

public class Main {

	public static void main(String... args) {
		NotificationList list = new NotificationList();
		Notification n = new Notification("Notification title", "Notification text", list).backgroundColor("white").textColor("black").borderRadius(0).width(300);
		n.showNotification(500);

	}

}
