package com.thom.gameengine.test;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import com.thom.gameengine.action.GameAction;
import com.thom.gameengine.gameobjects.GameObject;

@SuppressWarnings("serial")
public class MoveAction extends GameAction
{
	GameObject obj1, obj2;

	public MoveAction(GameObject obj1, GameObject obj2) 
	{
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (!intersects(obj1, obj2))
		{
			obj1.setLocation(obj1.getLocation().x + 1, obj1.getLocation().y);
			obj2.setLocation(obj2.getLocation().x - 1, obj2.getLocation().y);
		}
	}

	public boolean intersects(GameObject obj1, GameObject obj2)
	{
		Rectangle obj2Rect = obj2.getBounds();

		Rectangle result = SwingUtilities.computeIntersection(obj1.getX(), obj1.getY(), obj1.getWidth(), obj1.getHeight(), obj2Rect);

		return (result.getWidth() > 0 && result.getHeight() > 0);
	}
}