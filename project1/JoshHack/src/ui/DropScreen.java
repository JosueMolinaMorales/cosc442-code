package ui;

import game.Creature;
import game.Item;

// TODO: Auto-generated Javadoc
/**
 * The Class DropScreen.
 */
public class DropScreen extends InventoryBasedScreen {

	/**
	 * Instantiates a new drop screen.
	 *
	 * @param player the player
	 */
	public DropScreen(Creature player) {
		super(player);
	}

	/**
	 * Gets the verb.
	 *
	 * @return the verb
	 */
	@Override
	protected String getVerb() { 
		return "drop"; 
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
		player.drop(item); 
		return null;
	}
}
