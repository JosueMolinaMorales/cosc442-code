package game;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import ui.Screen;
import ui.StartScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationMain.
 */
public class ApplicationMain extends JFrame implements KeyListener {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1060623638149583738L;
	
	/** The terminal. */
	private AsciiPanel terminal;
	
	/** The screen. */
	private Screen screen;
	
	/**
	 * Instantiates a new application main.
	 */
	public ApplicationMain(){
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}
	
	/**
	 * Repaint.
	 */
	@Override
	public void repaint(){
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	/**
	 * Key pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	/**
	 * Key released.
	 *
	 * @param e the e
	 */
	@Override
	public void keyReleased(KeyEvent e) { }

	/**
	 * Key typed.
	 *
	 * @param e the e
	 */
	@Override
	public void keyTyped(KeyEvent e) { }
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
