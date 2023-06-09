package ui;

import game.Creature;
import game.Line;
import game.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class FireWeaponScreen.
 */
public class FireWeaponScreen extends TargetBasedScreen {

	/**
	 * Instantiates a new fire weapon screen.
	 *
	 * @param player the player
	 * @param sx the sx
	 * @param sy the sy
	 */
	public FireWeaponScreen(Creature player, int sx, int sy) {
		super(player, "Fire " + player.nameOf(player.weapon()) + " at?", sx, sy);
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
		Creature other = player.creature(x, y, player.z);
		
		if (other == null)
			player.notify("There's no one there to fire at.");
		else
			player.rangedWeaponAttack(other);
	}
}
