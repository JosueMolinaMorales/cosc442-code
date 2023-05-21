package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class ThrowScreen.
 */
public class ThrowScreen extends InventoryBasedScreen {
	
	/** The sx. */
	private int sx;
	
	/** The sy. */
	private int sy;
	
	/**
	 * Instantiates a new throw screen.
	 *
	 * @param player the player
	 * @param sx the sx
	 * @param sy the sy
	 */
	public ThrowScreen(Creature player, int sx, int sy) {
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
		return "throw";
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param item the item
	 * @return true, if is acceptable
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return true;
	}

	/**
	 * Use.
	 *
	 * @param item the item
	 * @return the screen
	 */
	@Override
	protected Screen use(Item item) {
		return new ThrowAtScreen(player, sx, sy, item);
	}
}
