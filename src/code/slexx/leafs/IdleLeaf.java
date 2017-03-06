package code.slexx.leafs;

import code.slexx.data.Settings;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * Created by Mihael on 6.3.2017.
 */
public class IdleLeaf extends LeafTask {

	private Settings settings;

	public IdleLeaf(Settings settings) {
		this.settings = settings;
	}

	@Override
	public void execute() {
		if (!Inventory.containsAllOf(settings.getRequiredItems())) {
			settings.getBot().stop();
		}
	}
}
