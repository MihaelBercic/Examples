package net.slex.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import net.slex.data.BoltEnum;
import net.slex.data.FletcherSettings;

/**
 * Created by Mihael on 18. 03. 2017.
 */
public class TheBranchWeNeed extends BranchTask {

    private FletcherSettings settings; // We create the settings class.
    private FailureTask failureTask; // we create the failure task.

    public TheBranchWeNeed(FletcherSettings settings) {
        this.settings = settings; // initialize settings class
        failureTask = new FailureTask(); // initialize failure task
    }

    @Override
    public boolean validate() {
        BoltEnum selected = settings.getSelectedBolt(); // get the selected from the settings class.
        return selected != null && Inventory.containsAllOf(selected.getRequiredItems()); // if its null it means it has not been selected yet
        // if its not null it will check if the inventory contains all of the items.
    }

    @Override
    public TreeTask successTask() {
        return null; // I did not include here anything since this was just a demonstration.
    }

    @Override
    public TreeTask failureTask() {
        return failureTask;
    }

    class FailureTask extends LeafTask {

        @Override
        public void execute() {
            System.out.println(settings.getSelectedBolt() != null ? "You don't have the items." : "You haven't selected anything.");
        }
    }
}
