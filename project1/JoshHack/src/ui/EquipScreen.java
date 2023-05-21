package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class EquipScreen.
 */
public class EquipScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new equip screen.
	 *
	 * @param player the player
	 */
	public EquipScreen(Creature player) {
		super(player);
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	protected String getVerb() {
		return "wear or wield";
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param item the item
	 * @return true, if is acceptable
	 */
	protected boolean isAcceptable(Item item) {
		return item.attackValue() > 0 || item.defenseValue() > 0;
	}

	/**
	 * Use.
	 *
	 * @param item the item
	 * @return the screen
	 */
	protected Screen use(Item item) {
		player.equip(item);
		return null;
	}
}
