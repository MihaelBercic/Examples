package code.letmebot;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPathBuilder;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Random;
import com.runemate.game.api.script.framework.LoopingBot;

public class BasicScript extends LoopingBot {

	private Coordinate safeSpot = new Coordinate(0, 0, 0);

	@Override
	public void onLoop() {
	   if(RuneScape.isLoggedIn()){
		Player player = Players.getLocal();
		if (player.getPosition().equals(safeSpot)) {
			if (isReadyToAttack(player)) {
				Npc target = Npcs.newQuery().names("Moss giant").results().nearest();
				if (target != null) {
					if (target.isVisible()) {
						if (target.interact("Attack")) {
							System.out.println("Interaction with target: successful");
						}
					} else {
						Camera.turnTo(target.getPosition().randomize(Random.nextInt(0, 10), Random.nextInt(0, 10)));
					}
				}
			}
		} else {
			// Bresenham
			Path pathToSpot = BresenhamPath.buildTo(safeSpot);

			// Web
			pathToSpot = Traversal.getDefaultWeb().getPathBuilder().buildTo(safeSpot);

			// Region
			pathToSpot = RegionPath.buildTo(safeSpot);
		}
	    }
	}

	private boolean isReadyToAttack(Player player) {
		return player != null && player.getTarget() == null;
	}

}
