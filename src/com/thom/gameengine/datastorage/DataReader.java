package com.thom.gameengine.datastorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DataReader 
{
	public boolean doesFileExist(File file)
	{
		if (file.exists() && !file.isDirectory())
			return true;
		else 
			return false;
	}
	
	public List<String> getDataFileContents(File file) throws IOException
	{
		return Files.readAllLines(file.toPath());
	}
	
	public String readLine(File file, int line) throws IOException
	{
		return getDataFileContents(file).get(line-1);
	}
	
	public ArrayList<Integer> getDigitsFromLine(File file, int line) throws IOException
	{
		List<String> lines = getDataFileContents(file);
		
		String lineContents = lines.get(line-1);
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		for (int i = 0; i < lineContents.length(); i++)
		{
			if (Character.isDigit(lineContents.charAt(i)))
			{
				digits.add(Integer.valueOf(String.valueOf(lineContents.charAt(i))));
			}
		}
		return digits;
	}
	
	public int getValueFromArrayList(ArrayList<Integer> arrayList)
	{
		String line = arrayList.toString().replace('[', ' ').replace(']', ' ').replace(',', ' ').replaceAll("\\s", "");
		
		if (line.isEmpty()) 	return 0; // The program crashes otherwise if getDigitsFromLine() is called on with an empty line as a parameter.
		else 					return Integer.valueOf(line); 
	}
	
	public int getLines(File file) throws IOException 
	{
		return getDataFileContents(file).size();
	}
}