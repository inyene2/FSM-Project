/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.command;

/**
 * Command class constructs and handles Command objects
 * @author inyene2
 *
 */
public class Command {
	
	/** Fixed String */
	public static final String R_FIXED =  "Fixed";
	/** Duplicate String */
	public static final String R_DUPLICATE =  "Duplicate";
	/** Wont fix String */
	public static final String R_WONTFIX =  "WontFix";
	/** Works for me String */
	public static final String R_WORKSFORME =  "WorksForMe";
	
	/** Command owner id */
	private String ownerId;
	/** Command note */
	private String note;
	/** Instructions of Command */
	private CommandValue command;
	/** Command resolution  */
	private Resolution resolution;
	
	/**
	 * Constructs Command objects with params for all fields
	 * @param x CommandValue of Command
	 * @param id ownerId of Command
	 * @param z Resolution of Command
	 * @param n Command note
	 */
	public Command(CommandValue x, String id, Resolution z, String n) {
		if (x == null) {
			throw new IllegalArgumentException("Invalid information.");
		}
		else if (x == CommandValue.ASSIGN && (id == null || id.length() == 0)) {
			throw new IllegalArgumentException("Invalid information.");
		}
		else if (x == CommandValue.RESOLVE && z == null) {
			throw new IllegalArgumentException("Invalid information.");
		}
		else if (n == null || n.length() == 0) {
			throw new IllegalArgumentException("Invalid information.");
		}
		else {
			command = x;
			ownerId = id;
			resolution = z;
			note = n;
		}
	}
	/**
	 * Returns Command
	 * @return command
	 */
	public CommandValue getCommand() {
		return command;
	}
	/**
	 * Returns Command Ownerid
	 * @return Owner id
	 */
	public String getOwnerId() {
		return ownerId;
	}
	/**
	 * Return Command resolution
	 * @return Commanf Resolution
	 */
	public Resolution getResolution() {
		return resolution;
	}
	/**
	 * Return Command note
	 * @return Command note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * Keeps static values for CommandValues
	 * @author inyene2
	 *
	 */
	public enum CommandValue {
		/** Assign CommandValue */
		ASSIGN, 
		/** Confirm CommandValue */
		CONFIRM, 
		/** Resolve CommandValue */
		RESOLVE, 
		/** Verify CommandValue */
		VERIFY, 
		/** Reopen CommandValue */
		REOPEN;
			
		}
	/**
	 * Keeps static values for Resolutions
	 * @author inyene2
	 *
	 */
	public enum Resolution {
		/** Fixed Resolution*/
		FIXED,
		/** Duplicate Resolution */
		DUPLICATE,
		/** WontFix Resolution */
		WONTFIX, 
		/** WorksForMe Resolution */
		WORKSFORME;
	}
}
