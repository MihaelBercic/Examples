package code.slexx;

import code.slexx.branches.RootBranch;
import code.slexx.data.Settings;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * Created by Mihael on 6.3.2017.
 */
public class BotName extends TreeBot {

	private Settings settings = new Settings(this);
	private RootBranch rootBranch = new RootBranch(settings);

	@Override
	public TreeTask createRootTask() {
		return rootBranch;
	}
}
