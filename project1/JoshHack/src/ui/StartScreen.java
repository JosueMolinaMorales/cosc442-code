package ui;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class StartScreen.
 */
public class StartScreen implements Screen {

	/**
	 * Display output.
	 *
	 * @param terminal the terminal
	 */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("COSC 442 Rougelike Game", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 22);
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
