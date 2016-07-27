package com.thom.gameengine.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Thomas Boel Micheelsen
 * @since 08-07-2016
 */
@SuppressWarnings("serial")
public abstract class GameAction extends AbstractAction
{	
	public abstract void actionPerformed(ActionEvent e);
}