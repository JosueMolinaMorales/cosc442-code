package game;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerAi.
 */
public class PlayerAi extends CreatureAi {

	/** The messages. */
	private List<String> messages;
	
	/** The fov. */
	private FieldOfView fov;
	
	/**
	 * Instantiates a new player ai.
	 *
	 * @param creature the creature
	 * @param messages the messages
	 * @param fov the fov
	 */
	public PlayerAi(Creature creature, List<String> messages, FieldOfView fov) {
		super(creature);
		this.messages = messages;
		this.fov = fov;
	}

	/**
	 * On enter.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param tile the tile
	 */
	public void onEnter(int x, int y, int z, Tile tile){
		if (tile.isGround()){
			creature.x = x;
			creature.y = y;
			creature.z = z;
			
			Item item = creature.item(creature.x, creature.y, creature.z);
			if (item != null)
				creature.notify("There's a " + creature.nameOf(item) + " here.");
			
		} else if (tile.isDiggable()) {
			creature.dig(x, y, z);
		}
	}
	
	/**
	 * On notify.
	 *
	 * @param message the message
	 */
	public void onNotify(String message){
		messages.add(message);
	}
	
	/**
	 * Can see.
	 *
	 * @param wx the wx
	 * @param wy the wy
	 * @param wz the wz
	 * @return true, if successful
	 */
	public boolean canSee(int wx, int wy, int wz) {
		return fov.isVisible(wx, wy, wz);
	}
	
	/**
	 * On gain level.
	 */
	public void onGainLevel(){
	}

	/**
	 * Remembered tile.
	 *
	 * @param wx the wx
	 * @param wy the wy
	 * @param wz the wz
	 * @return the tile
	 */
	public Tile rememberedTile(int wx, int wy, int wz) {
		return fov.tile(wx, wy, wz);
	}
}
