package ui;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class WinScreen.
 */
public class WinScreen implements Screen {

	/**
	 * Display output.
	 *
	 * @param terminal the terminal
	 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("You won.", 1, 1);
		terminal.writeCenter("-- press [enter] to restart --", 22);
	}

	/**
	 * Respond to user input.
	 *
	 * @param key the key
	 * @return the screen
	 */
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
