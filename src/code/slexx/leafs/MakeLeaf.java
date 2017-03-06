package code.slexx.leafs;

import com.runemate.game.api.rs3.local.hud.interfaces.MakeXInterface;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class MakeLeaf extends LeafTask {

	@Override
	public void execute() {
		MakeXInterface.confirm();
	}

}