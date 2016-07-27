package com.thom.gameengine;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.keybinding.KeyStrokeList;
import com.thom.gameengine.world.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 02-07-2016
 */
@SuppressWarnings("serial")
public abstract class Game extends JFrame
{
	protected GamePanel gamePanel = new GamePanel();
	protected World world = new World();
	
	protected Dimension screenSize;
	
	public Game(Dimension par1Dimension, boolean windowed)
	{
		this.setScreenSize(par1Dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(!windowed);
		setFocusable(true);	
		setVisible(true);
		add(gamePanel);
	}
	
	private void setScreenSize(Dimension par1Dimension) 
	{
		setSize(par1Dimension);
		screenSize = par1Dimension;
	}

	/**
	 * Make sure the initialize() function is called in the END of the constructor.
	 */
	public void initialize()
	{
		repaint();
		new KeyStrokeList();
		handleKeyBinds();
	}

	public abstract GameType getGameType();

	public abstract void handleKeyBinds();
	
	public void addComponent(JComponent component, int priority)
	{
		gamePanel.add(component, priority, 0);
	}
}