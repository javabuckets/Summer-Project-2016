package com.thom.gameengine.action;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import com.thom.gameengine.Game;
import com.thom.gameengine.gameobjects.Particle;
import com.thom.gameengine.rendersystem.Particles;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class SpawnRandomParticleAction extends GameAction
{
	private Game gameInstance;
	private ArrayList<Particle> particles;
	private Point position;
	
	private Random rand;
	
	public SpawnRandomParticleAction(Game game, ArrayList<Particle> particles, Point position) 
	{
		rand = new Random();
		
		this.gameInstance = game;
		this.particles = particles;
		this.position = position;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Particles particleHandler = new Particles(gameInstance);
	
		Particle particle = particles.get(rand.nextInt(particles.size()));
		
		Point pos = new Point(position.x, position.y);
		pos.x += rand.nextInt(40);
		pos.y += rand.nextInt(40);
		
		particleHandler.spawnParticle(particle, pos, 3, true);
		
		gameInstance.updateGUI();
	}
}