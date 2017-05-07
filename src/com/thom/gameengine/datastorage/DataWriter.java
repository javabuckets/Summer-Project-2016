package com.thom.gameengine.datastorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DataWriter 
{
	DataReader dr = new DataReader();
	
	public void generateDataFile(File file)
	{
		try 
		{
			FileWriter fw = new FileWriter(file.getName());
			writeLine(file, "@data file\n");
			fw.close();
		} 
		catch (IOException e) 
		{
			System.out.println("There was an error whilst trying to generate the data file: " + file.getName()); 
			e.printStackTrace();		
		}
	}
	
	public void writeLine(File file, String text) throws IOException
	{
		List<String> lines = dr.getDataFileContents(file);
		
		lines.add(text);
		
		Files.write(file.toPath(), lines);
	}
	
	/**
	 * Sets the contents of a specified line in a DataFile to be parameter 'text'.
	 */
	public void replaceLine(File file, int line, String text) throws IOException
	{
		List<String> lines = dr.getDataFileContents(file);
		
		lines.set(line-1, text);
		
		Files.write(file.toPath(), lines);
	}
}