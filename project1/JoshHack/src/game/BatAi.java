package game;

// TODO: Auto-generated Javadoc
/**
 * The Class BatAi.
 */
public class BatAi extends CreatureAi {

	/**
	 * Instantiates a new bat ai.
	 *
	 * @param creature the creature
	 */
	public BatAi(Creature creature) {
		super(creature);
	}

	/**
	 * On update.
	 */
	public void onUpdate(){
		wander();
		wander();
	}
}
