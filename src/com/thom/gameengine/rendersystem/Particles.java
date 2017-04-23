package com.thom.gameengine.rendersystem;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import com.thom.gameengine.Game;
import com.thom.gameengine.gameobjects.Particle;
import com.thom.gameengine.gui.ComponentHandler;
import com.thom.gameengine.utility.TimeUtil;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class Particles 
{
	public Game gameInstance;
	
	public Particles(Game game) 
	{
		this.gameInstance = game;
	}
	
	public void spawnParticle(Particle particle, Point pos, int duration, boolean movement)
	{
		Particle part = ComponentHandler.addParticle(particle, pos);
		gameInstance.addComponent(part, 1);
		
		Timer particleLifeTime = new Timer();
		particleLifeTime.schedule(new TimerTask() 
		{
			public void run() 
			{
				part.setAlive(false);
				gameInstance.removeComponent(part);
				gameInstance.updateGUI();
			}
		}, TimeUtil.getMilliseconds(0, duration));
	}
}