package com.thom.gameengine.keybinding;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.KeyStroke;

/**
 * @author Thomas Boel Micheelsen
 * @since 10-07-2016
 */
public class KeyStrokeList 
{
	public static ArrayList<KeyStroke> keyStrokes = new ArrayList<KeyStroke>();
	public static HashMap<KeyBind, KeyStroke> keyBindMap = new HashMap<KeyBind, KeyStroke>();
	
	// Initialization
	public KeyStrokeList() 
	{
		// Keyboard Letters
		for (int i = 0; i < 26; i++)
		{
			addKeyStroke(KeyBind.values()[i].toString());
			keyBindMap.put(KeyBind.values()[i], keyStrokes.get(i));
		}
		// Keyboard Numbers
		for (int i = 0; i < 10; i++)
		{
			addKeyStroke(""+(i));
			keyBindMap.put(KeyBind.values()[26+i], keyStrokes.get(26+i));
		}
		
		// DOES NOT WORK
		keyBindMap.put(KeyBind.LCTRL, KeyStroke.getKeyStroke(InputEvent.CTRL_DOWN_MASK, InputEvent.CTRL_MASK));
	}
	
	public void addKeyStroke(String key)
	{
		keyStrokes.add(KeyStroke.getKeyStroke(key));
	}
	
	public void addKeyStroke(char keyCode)
	{
		keyStrokes.add(KeyStroke.getKeyStroke(keyCode));
	}
}