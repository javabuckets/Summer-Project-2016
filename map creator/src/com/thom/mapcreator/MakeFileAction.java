package com.thom.mapcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

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
			try 
			{
				FileWriter fw = new FileWriter(new File("C:\\Users\\Thomas\\Desktop\\worldData.txt"));
				PrintWriter pw = new PrintWriter(fw);
				
				for (int i = 0; i < world.getTileList().size(); i++)
				{
					pw.println();
				}
				
				pw.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		
		else if (action == "read")
		{
			try 
			{
				FileReader fr = new FileReader(new File("C:\\Users\\Thomas\\Desktop\\worldData.txt"));
				BufferedReader br = new BufferedReader(fr);
				ArrayList<Tile> tileList = new ArrayList<Tile>();
				
				for (int i = 0; i < world.getTileList().size(); i++)
				{
					tileList.add(br.readLine());
				}
				
				br.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}