package code.slexx.data;

import com.runemate.game.api.script.framework.tree.TreeBot;

/**
 * Created by Mihael on 6.3.2017.
 */
public class Settings {

	private String[] requiredItems = new String[] { "Your items here" };
	private TreeBot bot;

	public Settings(TreeBot bot) {
		this.bot = bot;
	}

	public String[] getRequiredItems() {
		return requiredItems;
	}

	public TreeBot getBot() {
		return bot;
	}
}
