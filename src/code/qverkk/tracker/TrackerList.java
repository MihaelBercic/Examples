package code.qverkk.tracker;

import java.util.ArrayList;

import com.runemate.game.api.hybrid.local.Skill;

public class TrackerList extends ArrayList<Tracker> {

	public Tracker getTracker(Skill skill) {
		return stream().filter(a -> a.getSkill().equals(skill)).findFirst().get();
	}

}
