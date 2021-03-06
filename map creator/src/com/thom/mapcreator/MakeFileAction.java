package com.thom.mapcreator;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thom.mapcreator.util.CustomImageIcon;
import com.thom.mapcreator.util.TileTextureUtil;
import com.thom.mapcreator.worldobjects.Tile;
import com.thom.mapcreator.worldobjects.World;

public class MakeFileAction implements ActionListener 
{
	String action;
	World world;

	public MakeFileAction(String action, World world) 
	{
		this.action = action;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (action == "write")
		{
			writeFile();
		}
		
		else if (action == "read")
		{
			readFile();
		}
	}
	
	/**
	 * Saves/Overrides the world file.
	 */
	private void writeFile()
	{
		try 
		{
			FileWriter fw = new FileWriter(new File("C:\\Users\\Thomas\\Desktop\\worldData.txt"));
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				pw.println(world.getTileList().get(i).getName() + " ~ " + "Texture: " + world.getTileList().get(i).getImageIcon().getLocalPath() + ";");
			}
			
			pw.close();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	/**
	 * Loads the world file to the program.
	 */
	private ArrayList<CustomImageIcon> texturesLoaded = new ArrayList<CustomImageIcon>();
	
	private void readFile()
	{
		try 
		{
			FileReader fr = new FileReader(new File("C:\\Users\\Thomas\\Desktop\\worldData.txt"));
			BufferedReader br = new BufferedReader(fr);
			ArrayList<Tile> tileList = new ArrayList<Tile>();
			
			for (int i = 0; i < world.getTileList().size(); i++)
			{
				String currLine = br.readLine();
				
				Point tilePos = getTilePos(currLine);
				String texturePos = getTexturePos(currLine);
				String spritesheet = getSpriteSheet(currLine);
				
				Tile tile = new Tile(tilePos);
				tile.attachTexture(texturePos, TileTextureUtil.getSpriteFromSpritesheet(spritesheet, texturePos));
				
				tileList.add(tile);
			}
			
			world.setTileList(tileList);
			
			/*for (int i = 0; i < world.getTileList().size(); i++)
			{
				world.getTileList().get(i).setIcon(tileList.get(i).getIcon());
			}*/
			
			br.close();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	private Point getTilePos(String line)
	{
		String s = line.substring(0, line.indexOf("; ~"));
		String s1 = s.substring(1);
		
		String sX = s1.substring(0, s1.indexOf(','));
		int x = Integer.valueOf(sX);
		
		String sy1 = s1.substring(s1.indexOf(','), s1.length()).substring(1);
		String sY = sy1.substring(0, sy1.indexOf(','));
		int y = Integer.valueOf(sY);
		
		return new Point(x, y);
	}
	
	private String getTexturePos(String line)
	{
		String s = line.substring(0, line.indexOf("; ~"));
		String s1 = s.substring(s.indexOf(','));
		String s2 = s1.substring(1);
		String s3 = s2.substring(s2.indexOf(',')).substring(1);
		return s3;
	}
	
	private String getSpriteSheet(String line)
	{
		String s = line.substring(line.indexOf("Texture: "), line.lastIndexOf(';')).substring(9);
		return s;
	}
}