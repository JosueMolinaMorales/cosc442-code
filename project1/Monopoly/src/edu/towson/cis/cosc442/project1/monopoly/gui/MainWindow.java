package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
public class MainWindow extends JFrame implements MonopolyGUI{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The east panel. */
	JPanel eastPanel = new JPanel();
	
	/** The gui cells. */
	ArrayList<GUICell> guiCells = new ArrayList<GUICell>();

	/** The north panel. */
	JPanel northPanel = new JPanel();
	
	/** The player panels. */
	PlayerPanel[] playerPanels;
	
	/** The south panel. */
	JPanel southPanel = new JPanel();
	
	/** The west panel. */
	JPanel westPanel = new JPanel();

	/**
	 * Instantiates a new main window.
	 */
	public MainWindow() {
		northPanel.setBorder(new LineBorder(Color.BLACK));
		southPanel.setBorder(new LineBorder(Color.BLACK));
		westPanel.setBorder(new LineBorder(Color.BLACK));
		eastPanel.setBorder(new LineBorder(Color.BLACK));
		
		Container c = getContentPane();
		//setSize(800, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d);
		c.add(northPanel, BorderLayout.NORTH);
		c.add(southPanel, BorderLayout.SOUTH);
		c.add(eastPanel, BorderLayout.EAST);
		c.add(westPanel, BorderLayout.WEST);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Adds the cells.
	 *
	 * @param panel the panel
	 * @param cells the cells
	 */
	private void addCells(JPanel panel, List<?> cells) {
		for(int x=0; x<cells.size(); x++) {
			GUICell cell = new GUICell((Cell)cells.get(x));
			panel.add(cell);
			guiCells.add(cell);
		}
	}
	
	/**
	 * Builds the player panels.
	 */
	private void buildPlayerPanels() {
		GameMaster master = GameMaster.instance();
		JPanel infoPanel = new JPanel();
        int players = master.getNumberOfPlayers();
        infoPanel.setLayout(new GridLayout(2, (players+1)/2));
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		playerPanels = new PlayerPanel[master.getNumberOfPlayers()];
		for (int i = 0; i< master.getNumberOfPlayers(); i++){
			playerPanels[i] = new PlayerPanel(master.getPlayer(i));
			infoPanel.add(playerPanels[i]);
			playerPanels[i].displayInfo();
		}
	}

	/**
	 * Enable end turn btn.
	 *
	 * @param playerIndex the player index
	 */
	public void enableEndTurnBtn(int playerIndex) {
		playerPanels[playerIndex].setEndTurnEnabled(true);
	}
	
	/**
	 * Enable player turn.
	 *
	 * @param playerIndex the player index
	 */
	public void enablePlayerTurn(int playerIndex) {
		playerPanels[playerIndex].setRollDiceEnabled(true);
		
	}

	/**
	 * Enable purchase btn.
	 *
	 * @param playerIndex the player index
	 */
	public void enablePurchaseBtn(int playerIndex) {
		playerPanels[playerIndex].setPurchasePropertyEnabled(true);
	}

	/**
	 * Gets the dice roll.
	 *
	 * @return the dice roll
	 */
	@SuppressWarnings("deprecation")
	public int[] getDiceRoll() {
		TestDiceRollDialog dialog = new TestDiceRollDialog(this);
		dialog.show();
		return dialog.getDiceRoll();
	}

    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isDrawCardButtonEnabled();
    }

    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isEndTurnButtonEnabled();
    }

	/**
	 * Checks if is gets the out of jail button enabled.
	 *
	 * @return true, if is gets the out of jail button enabled
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
		return playerPanels[currentPlayerIndex].isGetOutOfJailButtonEnabled();
	}

    /**
     * Checks if is trade button enabled.
     *
     * @param i the i
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled(int i) {
        return playerPanels[i].isTradeButtonEnabled();
    }
	
	/**
	 * Move player.
	 *
	 * @param index the index
	 * @param from the from
	 * @param to the to
	 */
	public void movePlayer(int index, int from, int to) {
		GUICell fromCell = queryCell(from);
		GUICell toCell = queryCell(to);
		fromCell.removePlayer(index);
		toCell.addPlayer(index);
	}

    /**
     * Open respond dialog.
     *
     * @param deal the deal
     * @return the respond dialog
     */
    @SuppressWarnings("deprecation")
	public RespondDialog openRespondDialog(TradeDeal deal) {
        GUIRespondDialog dialog = new GUIRespondDialog();
        dialog.setDeal(deal);
        dialog.show();
        return dialog;
    }

    /**
     * Open trade dialog.
     *
     * @return the trade dialog
     */
    @SuppressWarnings("deprecation")
	public TradeDialog openTradeDialog() {
        GUITradeDialog dialog = new GUITradeDialog(this);
        dialog.show();
        return dialog;
    }
	
	/**
	 * Query cell.
	 *
	 * @param index the index
	 * @return the GUI cell
	 */
	private GUICell queryCell(int index) {
		IOwnable cell = GameMaster.instance().getGameBoard().getCell(index);
		for(int x = 0; x < guiCells.size(); x++) {
			GUICell guiCell = (GUICell)guiCells.get(x);
			if(guiCell.getCell() == cell) return guiCell;
		}
		return null;
	}

    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setBuyHouseEnabled(b);
    }

    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setDrawCardEnabled(b);
    }

    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setEndTurnEnabled(enabled);
    }

    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setGetOutOfJailEnabled(b);
    }

    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setPurchasePropertyEnabled(enabled);
    }

    /**
     * Sets the roll dice enabled.
     *
     * @param b the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setRollDiceEnabled(b);
    }

    /**
     * Sets the trade enabled.
     *
     * @param index the index
     * @param b the b
     */
    public void setTradeEnabled(int index, boolean b) {
        playerPanels[index].setTradeEnabled(b);
    }
	
	/**
	 * Sets the up game board.
	 *
	 * @param board the new up game board
	 */
	public void setupGameBoard(GameBoard board) {
		Dimension dimension = GameBoardUtil.calculateDimension(board.getCellNumber());
		northPanel.setLayout(new GridLayout(1, dimension.width + 2));
		southPanel.setLayout(new GridLayout(1, dimension.width + 2));
		westPanel.setLayout(new GridLayout(dimension.height, 1));
		eastPanel.setLayout(new GridLayout(dimension.height, 1));
		addCells(northPanel, GameBoardUtil.getNorthCells(board));
		addCells(southPanel, GameBoardUtil.getSouthCells(board));
		addCells(eastPanel, GameBoardUtil.getEastCells(board));
		addCells(westPanel, GameBoardUtil.getWestCells(board));
		buildPlayerPanels();
	}

    /**
     * Show buy house dialog.
     *
     * @param currentPlayer the current player
     */
    @SuppressWarnings("deprecation")
	public void showBuyHouseDialog(Player currentPlayer) {
        BuyHouseDialog dialog = new BuyHouseDialog(currentPlayer);
        dialog.show();
    }

    /**
     * Show message.
     *
     * @param msg the msg
     */
    public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
    }

	/**
	 * Show util dice roll.
	 *
	 * @return the int
	 */
	public int showUtilDiceRoll() {
		return UtilDiceRoll.showDialog();
	}

	/**
	 * Start game.
	 */
	public void startGame() {
		int numberOfPlayers = GameMaster.instance().getNumberOfPlayers();
		for(int i = 0; i < numberOfPlayers; i++) {
			movePlayer(i, 0, 0);
		}
	}

	/**
	 * Update.
	 */
	public void update() {
		for(int i = 0; i < playerPanels.length; i++) {
			playerPanels[i].displayInfo();
		}
		for(int j = 0; j < guiCells.size(); j++ ) {
			GUICell cell = (GUICell)guiCells.get(j);
			cell.displayInfo();
		}
	}
}
