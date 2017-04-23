package com.thom.gameengine.soundsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class TrackList 
{
	public List<Clip> tracks = new ArrayList<Clip>();
	
	public String soundFolder;
	
	public TrackList(String soundFolder)
	{
		this.soundFolder = soundFolder;
	}
	
	public TrackList() 
	{
		this(null);
	}
	
	public void addTrack(String trackName)
	{
		if (soundFolder != null)
		{
			try 
			{
				AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundFolder + trackName + ".wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				tracks.add(clip);
			} 
			catch (Exception e) 
			{
				System.err.println("Error with adding track to tracklist");
				e.printStackTrace();
			}
		}
	}
	
	public Clip getTrackAt(int index)
	{
		return tracks.get(index);
	}
	
	public void replaceTrackAt(int index, Clip clip)
	{
		tracks.set(index, clip);
	}
	
	public void removeTrackAt(int index)
	{
		tracks.remove(index);
	}
}