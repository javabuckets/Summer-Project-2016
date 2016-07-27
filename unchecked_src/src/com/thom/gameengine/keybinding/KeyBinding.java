package com.thom.gameengine.keybinding;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.thom.gameengine.action.GameAction;

/**
 * @author Thomas Boel Micheelsen
 * @since 08-07-2016
 */
public class KeyBinding 
{
	public static void addKeyBind(JComponent gameComponent, String keybind, GameAction action)
	{
		gameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keybind), action.toString() + "_BIND:" + keybind);
		gameComponent.getActionMap().put(action.toString() + "_BIND:" + keybind, action);
	}
	
	public static void addKeyBind(JComponent gameComponent, KeyBind keybind, GameAction action)
	{
		gameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(getKeyStrokeFromKey(keybind), action.toString() + "_BIND:" + keybind);
		gameComponent.getActionMap().put(action.toString() + "_BIND:" + keybind, action);
	}
	
	public static KeyStroke getKeyStrokeFromKey(KeyBind keyBind)
	{
		return KeyStrokeList.keyBindMap.get(keyBind);
	}
}