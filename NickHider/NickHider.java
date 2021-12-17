/*
Make sure that you dont render the mod. i have dont it by simply changing getWidth() and getHeight() to 0
*/

package eclipse.client.module.impl;

import eclipse.client.module.Module;

public class NickHider extends Module{

	public NickHider() {
		super("Nick Hider", "Hides the player's name", 0,0);
	}
	
	@Override
	public int getWidth() {
		return 0;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}
	
	public String getPlayerName() {
		return "You";
	}
}
