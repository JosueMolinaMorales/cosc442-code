package ui;

import game.Creature;
import game.Spell;

// TODO: Auto-generated Javadoc
/**
 * The Class CastSpellScreen.
 */
public class CastSpellScreen extends TargetBasedScreen {
	
	/** The spell. */
	private Spell spell;
	
	/**
	 * Instantiates a new cast spell screen.
	 *
	 * @param player the player
	 * @param caption the caption
	 * @param sx the sx
	 * @param sy the sy
	 * @param spell the spell
	 */
	public CastSpellScreen(Creature player, String caption, int sx, int sy, Spell spell) {
		super(player, caption, sx, sy);
		this.spell = spell;
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
		player.castSpell(spell, x, y);
	}
}
