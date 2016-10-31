package code.qverkk.tracker;

import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.script.framework.core.LoopingThread;
import com.runemate.game.api.script.framework.listeners.SkillListener;
import com.runemate.game.api.script.framework.listeners.events.SkillEvent;

public class Script implements SkillListener {

	private TrackerList list = new TrackerList();

	private void onStart() {
		new LoopingThread(() -> {
			// update UI here
		}, 100).start();
	}

	@Override
	public void onExperienceGained(SkillEvent arg0) {
		SkillListener.super.onExperienceGained(arg0);
		Skill e = arg0.getSkill();
		list.getTracker(e).addExperienceGained(arg0.getChange());
	}

}
