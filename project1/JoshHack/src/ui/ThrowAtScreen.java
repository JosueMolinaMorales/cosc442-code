package ui;

import game.Creature;
import game.Item;
import game.Line;
import game.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class ThrowAtScreen.
 */
public class ThrowAtScreen extends TargetBasedScreen {
	
	/** The item. */
	private Item item;
	
	/**
	 * Instantiates a new throw at screen.
	 *
	 * @param player the player
	 * @param sx the sx
	 * @param sy the sy
	 * @param item the item
	 */
	public ThrowAtScreen(Creature player, int sx, int sy, Item item) {
		super(player, "Throw " + player.nameOf(item) + " at?", sx, sy);
		this.item = item;
	}

	/**
	 * Checks if is acceptable.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if is acceptable
	 */
	public boolean isAcceptable(int x, int y) {
		if (!player.canSee(x, y, player.z))
			return false;
		
		for (Point p : new Line(player.x, player.y, x, y)){
			if (!player.realTile(p.x, p.y, player.z).isGround())
				return false;
		}
		
		return true;
	}

	/**
	 * Select world coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 * @param screenX the screen X
	 * @param screenY the screen Y
	 */
	public void selectWorldCoordinate(int x, int y, int screenX, int screenY){
		player.throwItem(item, x, y, player.z);
	}
}
