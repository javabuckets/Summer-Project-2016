package com.thom.gameengine.animation;

/**
 * @author Thomas Boel Micheelsen
 * @since 11-07-2016
 * 
 * The front and back enums are exclusive to BIRDVIEW. 
 * left and right are used in both BIRDVIEW and SIDEVIEW.
 */
public enum AnimationState 
{
	front,
	back,
	left,
	right,
	
	/**
	 * @since 13-04-2017
	 */
	idle,
	jumping,
	falling, 
	dancing,
	crouching,
	talking,
	playing;
	
	// Add further states if needed
}
