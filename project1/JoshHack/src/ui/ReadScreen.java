package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadScreen.
 */
public class ReadScreen extends InventoryBasedScreen {

	/** The sx. */
	private int sx;
	
	/** The sy. */
	private int sy;
	
	/**
	 * Instantiates a new read screen.
	 *
	 * @param player the player
	 * @param sx the sx
	 * @param sy the sy
	 */
	public ReadScreen(Creature player, int sx, int sy) {
		super(player);
		this.sx = sx;
		this.sy = sy;
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	@Override
	protected String getVerb() {
		return "read";
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param item the item
	 * @return true, if is acceptable
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return !item.writtenSpells().isEmpty();
	}

	/**
	 * Use.
	 *
	 * @param item the item
	 * @return the screen
	 */
	@Override
	protected Screen use(Item item) {
		return new ReadSpellScreen(player, sx, sy, item);
	}

}
