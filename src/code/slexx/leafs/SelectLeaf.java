package code.slexx.leafs;

import code.slexx.data.Settings;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.rs3.local.hud.interfaces.MakeXInterface;
import com.runemate.game.api.rs3.local.hud.interfaces.eoc.ActionBar;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * Created by Mihael on 6.3.2017.
 */
public class SelectLeaf extends LeafTask {

	private Settings settings;

	public SelectLeaf(Settings settings) {
		this.settings = settings;
	}

	@Override
	public void execute() {
		ActionBar.Slot slot = ActionBar.newQuery().names(settings.getRequiredItems()).results().first();
		if (slot != null) {
			if (!ActionBar.isExpanded()) {
				ActionBar.toggleExpansion();
			} else {
				if (slot.activate(false)) {
					Execution.delayUntil(() -> MakeXInterface.isOpen(), Random.nextInt(1000, 2000));
				}
			}
		} else {
			SpriteItem item = Inventory.newQuery().names(settings.getRequiredItems()).results().random();
			if (item != null) {
				if (item.click()) {
					Execution.delayUntil(() -> MakeXInterface.isOpen(), Random.nextInt(1000, 2000));
				}
			}
		}
	}
}
