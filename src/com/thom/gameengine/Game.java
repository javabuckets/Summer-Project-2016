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
	
	protected String assetsPath;
	
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
	 * @since 23-04-2017
	 */
	public void setAssetsPath(String assetsPath) 
	{
		this.assetsPath = assetsPath;
	}
	
	/**
	 * @since 23-04-2017
	 */
	public String getAssetsPath() 
	{
		return assetsPath;
	}

	/**
	 * Make sure the initialize() function is called at the END of the constructor and ONLY once.
	 */
	public void initialize()
	{
		updateGUI();
		new KeyStrokeList();
		handleKeyBinds();
	}
	
	/**
	 * @since 23-04-2017
	 */
	public void updateGUI()
	{
		repaint();
	}

	public abstract GameType getGameType();

	public abstract void handleKeyBinds();
	
	public void addComponent(JComponent component, int priority)
	{
		gamePanel.add(component, priority, 0);
	}
	
	/**
	 * @since 23-04-2017
	 */
	public void removeComponent(JComponent component)
	{
		gamePanel.remove(component);
	}
}