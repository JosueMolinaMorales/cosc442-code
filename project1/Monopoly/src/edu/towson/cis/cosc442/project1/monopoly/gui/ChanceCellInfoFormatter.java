package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

// TODO: Auto-generated Javadoc
/**
 * The Class ChanceCellInfoFormatter.
 */
public class ChanceCellInfoFormatter implements CellInfoFormatter {
    
    /** The Constant CHANCE_CELL_LABEL. */
    public static final String CHANCE_CELL_LABEL = "<html><font color='teal'><b>Chance</b></font></html>";
    
    /**
     * Format.
     *
     * @param cell the cell
     * @return the string
     */
    public String format(Cell cell) {
        return CHANCE_CELL_LABEL;
    }
}
