package code.qverkk.tracker;

import com.runemate.game.api.hybrid.local.Skill;

public class Tracker {

	private Skill skill;
	private int expGained;

	public Tracker(Skill skill, int expGained) {
		super();
		this.skill = skill;
		this.expGained = expGained;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public void addExperienceGained(int experience) {
		expGained += experience;
	}
}
