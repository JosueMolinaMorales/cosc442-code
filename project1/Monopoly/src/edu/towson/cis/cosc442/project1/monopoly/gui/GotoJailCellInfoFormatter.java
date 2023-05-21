package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

// TODO: Auto-generated Javadoc
/**
 * The Class GotoJailCellInfoFormatter.
 */
public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    /** The Constant GOTO_JAIL_LABEL. */
    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    /**
     * Format.
     *
     * @param cell the cell
     * @return the string
     */
    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
	}
}
