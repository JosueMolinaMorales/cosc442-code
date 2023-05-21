package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class QuaffScreen.
 */
public class QuaffScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new quaff screen.
	 *
	 * @param player the player
	 */
	public QuaffScreen(Creature player) {
		super(player);
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	@Override
	protected String getVerb() {
		return "quaff";
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param item the item
	 * @return true, if is acceptable
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return item.quaffEffect() != null;
	}

	/**
	 * Use.
	 *
	 * @param item the item
	 * @return the screen
	 */
	@Override
	protected Screen use(Item item) {
		player.quaff(item);
		return null;
	}

}
