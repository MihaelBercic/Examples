package code.slexx.branches;

import code.slexx.data.Settings;
import code.slexx.leafs.MakeLeaf;
import code.slexx.leafs.SelectLeaf;
import com.runemate.game.api.rs3.local.hud.interfaces.MakeXInterface;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class MakeBranch extends BranchTask {

	private Settings settings;

	private MakeLeaf makeLeaf = new MakeLeaf();
	private SelectLeaf selectLeaf;

	public MakeBranch(Settings settings) {
		this.settings = settings;
		selectLeaf = new SelectLeaf(settings);
	}

	@Override
	public boolean validate() {
		return MakeXInterface.isOpen();
	}

	@Override
	public TreeTask successTask() {
		return makeLeaf;
	}

	@Override
	public TreeTask failureTask() {
		return selectLeaf;
	}
}