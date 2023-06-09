package ui;

import game.Creature;
import game.Item;
import game.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class LookScreen.
 */
public class LookScreen extends TargetBasedScreen {

	/**
	 * Instantiates a new look screen.
	 *
	 * @param player the player
	 * @param caption the caption
	 * @param sx the sx
	 * @param sy the sy
	 */
	public LookScreen(Creature player, String caption, int sx, int sy) {
		super(player, caption, sx, sy);
	}

	/**
	 * Enter world coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 * @param screenX the screen X
	 * @param screenY the screen Y
	 */
	public void enterWorldCoordinate(int x, int y, int screenX, int screenY) {
		Creature creature = player.creature(x, y, player.z);
		if (creature != null){
			caption = creature.glyph() + " "  + creature.name() + creature.details();
			return;
		}
		
		Item item = player.item(x, y, player.z);
		if (item != null){
			caption = item.glyph() + " "  + player.nameOf(item) + item.details();
			return;
		}
		
		Tile tile = player.tile(x, y, player.z);
		caption = tile.glyph() + " " + tile.details();
	}
}
