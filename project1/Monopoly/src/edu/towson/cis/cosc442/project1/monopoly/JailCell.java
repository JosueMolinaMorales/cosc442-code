package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class JailCell.
 */
public class JailCell extends Cell {
	
	/** The bail. */
	public static int BAIL = 50;
	
	/**
	 * Instantiates a new jail cell.
	 */
	public JailCell() {
		setName("Jail");
	}
	
	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public boolean playAction(String msg) {
		return true;
	}
}
