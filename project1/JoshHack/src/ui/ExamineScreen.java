package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class ExamineScreen.
 */
public class ExamineScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new examine screen.
	 *
	 * @param player the player
	 */
	public ExamineScreen(Creature player) {
		super(player);
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	@Override
	protected String getVerb() {
		return "examine";
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
		String article = "aeiou".contains(player.nameOf(item).subSequence(0, 1)) ? "an " : "a ";
		player.notify("It's " + article + player.nameOf(item) + "." + item.details());
		return null;
	}
}
