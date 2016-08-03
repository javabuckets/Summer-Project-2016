package com.thom.gameengine;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.thom.gameengine.gametype.GameType;
import com.thom.gameengine.keybinding.KeyStrokeList;
import com.thom.gameengine.world.World;

/**
 * @author Thomas Boel Micheelsen
 * @since 31-07-2016
 */
@SuppressWarnings("serial")
public abstract class Game2D extends JFrame
{
	protected JPanel gamePanel = new JPanel(null);
	protected Dimension screenSize;
	
	protected World world = new World();
	
	public Timer timer;
	public Map<String, Point> pressedKeys = new HashMap<String, Point>();
	
	public Game2D(Dimension size)
	{
		super("Made using Game Engine 2D by Thomas Boel Micheelsen");
		this.setScreenSize(size);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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