/**
 * 
 */
package info.sokobot.sokobot;

import info.sokobot.sokobot.resources.User;

/**
 * @author jonah
 * 
 */
public class Sokobot {

	protected String Token;
	protected static String token;
	
	public Sokobot(String token) {
		this.Token=token;
	}
	
	
	public User getUser(String userId) {
		return new RequestUtil().getUser(userId);
	}
	protected static String getToken() {
		return token;
	}
	
	
	
}
