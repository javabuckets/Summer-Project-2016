package com.thom.gameengine.world;

/**
 * @author Thomas Boel Micheelsen
 * @since 12-07-2016
 */
public class TilePos 
{
	private int x, y;
	
	public TilePos(int x, int y) 
	{
		this.setX(x);
		this.setY(y);
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}
}