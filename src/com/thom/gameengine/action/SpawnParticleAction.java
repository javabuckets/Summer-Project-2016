package com.thom.gameengine.action;

import java.awt.Point;
import java.awt.event.ActionEvent;

import com.thom.gameengine.Game;
import com.thom.gameengine.gameobjects.Particle;
import com.thom.gameengine.rendersystem.Particles;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class SpawnParticleAction extends GameAction
{
	private Game gameInstance;
	private Particle particle;
	private Point position;
	
	public SpawnParticleAction(Game game, Particle particle, Point position) 
	{
		this.gameInstance = game;
		this.particle = particle;
		this.position = position;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Particles particleHandler = new Particles(gameInstance);
		
		particleHandler.spawnParticle(particle, position, 3, true);
		
		gameInstance.updateGUI();
	}
}