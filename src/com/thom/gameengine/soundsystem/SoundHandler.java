package com.thom.gameengine.soundsystem;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Thomas Boel Micheelsen
 * @since 23-04-2017
 */
public class SoundHandler 
{
	public static ArrayList<Clip> clips = new ArrayList<Clip>();
	public static ArrayList<TrackList> tracklists = new ArrayList<TrackList>();
	
	public static void playSound(String soundPath)
	{
		try 
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clips.add(clip);
		} 
		catch (Exception e) 
		{
			System.err.println("Couldn't play sound at: " + soundPath);
			e.printStackTrace();
		}
	}
	
	public static void stopSound(Clip clip)
	{
		for (Clip c : clips)
		{
			if (clip.equals(c))
			{
				c.stop();
			}
		}
	}
	
	public static void stopAllSounds()
	{
		for (Clip c : clips)
		{
			c.stop();
		}
	}
	
	public static void playTrackList(TrackList tracklist)
	{
		
	}
	
	public static void addTrackList(TrackList tracklist)
	{
		tracklists.add(tracklist);
	}
	
	public static void addToTrackList(TrackList tracklist, String trackName)
	{
		tracklist.addTrack(trackName);
	}
}