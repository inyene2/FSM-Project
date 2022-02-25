/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.command;

/**
 * @author inyene2
 *
 */
public class Command {
	
	/** Fixed String */
	public static final String R_FIXED =  "Fixed";
	public static final String R_DUPLICATE =  "Fixed";
	public static final String R_WONTFIX =  "Fixed";
	public static final String R_WORKSFORME =  "Fixed";
	
	/** Command owner id */
	private String ownerId;
	/** Command note */
	private String note;
	/** Instructions of Command */
	private Command c;
	/** Command resolution  */
	private Resolution resolution;
	
	/**
	 * Constructs Command objects with params for all fields
	 * @param x CommandValue of Command
	 * @param ownerId ownerId of Command
	 * @param z Resolution of Command
	 * @param note Command note
	 */
	public Command(CommandValue x, String ownerId, Resolution z, String note) {
		
	}
	/**
	 * Returns Command
	 * @return command
	 */
	public CommandValue getCommand() {
		return null;
	}
	/**
	 * Returns Command Ownerid
	 * @return Owner id
	 */
	public String getOwnerId() {
		return null;
	}
	/**
	 * Return Command resolution
	 * @return Commanf Resolution
	 */
	public Resolution getResolution() {
		return null;
	}
	/**
	 * Return Command note
	 * @return Command note
	 */
	public String getNote() {
		return null;
	}
	/**
	 * Keeps static values for CommandValues
	 * @author inyene2
	 *
	 */
	public enum CommandValue {
		ASSIGN, CONFIRM, RESOLVE, VERIFY, REOPEN;
			
		}
	/**
	 * Keeps static values for Resolutions
	 * @author inyene2
	 *
	 */
	public enum Resolution {
		FIXED, DUPLICATE, WONTFIX, WORKSFORME;
	}
}
