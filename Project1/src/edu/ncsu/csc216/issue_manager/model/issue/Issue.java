/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;

/**
 * Issue class constructs and handles Issue objects
 * @author inyene2
 *
 */
public class Issue {
	/** Enhancement String */
	public static final String I_ENHANCEMENT = "Enhancement";
	/** Bug String */
	public static final String I_BUG = "Bug";
	/** New String */
	public static final String NEW_NAME = "New";
	/** Working String */
	public static final String WORKING_NAME = "Working";
	/** Confirmed String */
	public static final String CONFIRMED_NAME = "Confirmed";
	/** Verifying String */
	public static final String VERIFYING_NAME = "Verifying";
	/** Closed String */
	public static final String CLOSED_NAME = "Closed";
	/** Issue Id */
	private int issueId;
	/** Issue summary */
	private String summary;
	/** Issue owner */
	private String owner;
	/** Issue confirmed status */
	private boolean confirmed;
	/** Issue notes */
	private ArrayList<String> notes;
	/** Issue type */
	private IssueType issueType;
	/** Issue resolution */
	private Resolution resolution;
	/** Issue NewState */
	private IssueState newState;
	/** Issue ConfirmedState */
	private IssueState confirmedState;
	/** Issue ClosedState */
	private IssueState closedState;
	/** Issue current state */
	private IssueState state;
	/** Issue VerifyingState */
	private IssueState verifyingState;
	/** Issue WorkingState */
	private IssueState workingState;
	
	/**
	 * Issue constructor
	 * @param i id
	 * @param issue type
	 * @param x owner
	 * @param y note
	 */
	public Issue (int i, IssueType issue, String x, String y) {
		
	}
	/**
	 * Issue constructor with parameters for all fields
	 * @param a id
	 * @param b name
	 * @param c title
	 * @param d section
	 * @param e command
	 * @param f confirmed status
	 * @param g owner
	 * @param h notes
	 */
	public Issue (int a, String b, String c, String d, String e, boolean f, String g, ArrayList<String> h) {
		
	}
	/**
	 * Sets Issue id
	 * @param i id
	 */
	private void setIssueId(int i) {
		
	}
	/**
	 * Sets Issue state
	 * @param x state
	 */
	private void setState(String x) {
		
	}
	/**
	 * Sets Issue type
	 * @param x type
	 */
	private void setIssueType(String x) {
		
	}
	/**
	 * Sets Issue summary
	 * @param x summary
	 */
	private void setSummary(String x) {
		
	}
	/**
	 * Sets Issue owner
	 * @param x owner
	 */
	private void setOwner(String x) {
		
	}
	/**
	 * Sets Issue confirmed status
	 * @param x confirmed boolean
	 */
	private void setConfirmed(boolean x) {
		
	}
	/**
	 * Sets Issue Resolution
	 * @param x resolution
	 */
	private void setResolution(String x) {
		
	}
	/**
	 * Sets Issue notes
	 * @param x notes
	 */
	private void setNotes(ArrayList<String> x) {
		
	}
	/**
	 * Gets Issue id
	 * @return id
	 */
	public int getIssueId() {
		return 0;
	}
	/**
	 * Gets Issue state name
	 * @return state name
	 */
	public String getStateName() {
		return null;
	}
	/**
	 * Gets Issue type
	 * @return type
	 */
	public String getIssueType() {
		return null;
	}
	/**
	 * Gets Issue resolution
	 * @return resolution
	 */
	public String getResolution() {
		return null;
	}
	/**
	 * Returns Issue owner
	 * @return owner
	 */
	public String getOwner() {
		return null;
	}
	/**
	 * Gets Issue summary
	 * @return summary
	 */
	public String getSummary() {
		return null;
	}
	/**
	 * Gets Issue notes
	 * @return notes
	 */
	public ArrayList<String> getNotes() {
		return null;
	}
	/**
	 * Gets Issue notes as string
	 * @return notes
	 */
	public String getNotesString() {
		return null;
	}
	/**
	 * Returns Issue confirmed status
	 * @return confirmed status
	 */
	public boolean isConfirmed () {
		return false;
	}
	/**
	 * Returns Issue as string
	 * @return Issue as string
	 */
	public String toString() {
		return null;
	}
	/**
	 * Adds note to Issue
	 * @param x note
	 */
	private void addNote(String x) {
		
	}
	/**
	 * Updates Issue with Command
	 * @param x command
	 */
	public void update(Command x) {
		
	}
	/**
	 * Holds static Issue types
	 * @author inyene2
	 *
	 */
	public enum IssueType {
		/** Enhancement IssueType */
		ENHANCEMENT, 
		/** Bug IssueType */
		BUG;
	}
	/**
	 * ClosedState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class ClosedState implements IssueState {

		@Override
		public void updateState(Command x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	/**
	 * WorkingState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class WorkingState implements IssueState {

		@Override
		public void updateState(Command x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	/**
	 * NewState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class NewState implements IssueState {

		@Override
		public void updateState(Command x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	/**
	 * ConfirmedState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class ConfirmedState implements IssueState {

		@Override
		public void updateState(Command x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	/**
	 * VerifyingState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class VerifyingState implements IssueState {

		@Override
		public void updateState(Command x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
}


