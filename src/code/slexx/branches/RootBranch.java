package code.slexx.branches;

import code.slexx.data.Settings;
import code.slexx.leafs.IdleLeaf;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.rs3.local.hud.interfaces.MakeXInterface;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * Created by Mihael on 6.3.2017.
 */
public class RootBranch extends BranchTask {

	private Settings settings;
	private IdleLeaf idleLeaf;
	private MakeBranch makeBranch;

	public RootBranch(Settings settings) {
		this.settings = settings;
		this.idleLeaf = new IdleLeaf(settings);
		makeBranch = new MakeBranch(settings);
	}

	@Override
	public boolean validate() {
		Player me = Players.getLocal();
		return !MakeXInterface.isOpen() && me != null && me.getAnimationId() == -1;
	}

	@Override
	public TreeTask successTask() {
		return makeBranch;
	}

	@Override
	public TreeTask failureTask() {
		return idleLeaf;
	}
}
