package game;

import ui.InventoryBasedScreen;
import ui.Screen;

// TODO: Auto-generated Javadoc
/**
 * The Class EatScreen.
 */
public class EatScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new eat screen.
	 *
	 * @param player the player
	 */
	public EatScreen(Creature player) {
		super(player);
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	@Override
	protected String getVerb() {
		return "eat";
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param item the item
	 * @return true, if is acceptable
	 */
	@Override
	protected boolean isAcceptable(Item item) {
		return item.foodValue() != 0;
	}

	/**
	 * Use.
	 *
	 * @param item the item
	 * @return the screen
	 */
	@Override
	protected Screen use(Item item) {
		player.eat(item);
		return null;
	}
}
