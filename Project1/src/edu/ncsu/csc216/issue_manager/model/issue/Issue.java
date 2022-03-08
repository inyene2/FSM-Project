/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
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
	private final IssueState newState = new NewState();
	/** Issue ConfirmedState */
	private final IssueState confirmedState = new ConfirmedState();
	/** Issue ClosedState */
	private final IssueState closedState = new ClosedState();
	/** Issue current state */
	private IssueState state;
	/** Issue VerifyingState */
	private final IssueState verifyingState = new VerifyingState();
	/** Issue WorkingState */
	private final IssueState workingState = new WorkingState();
	
	/**
	 * Issue constructor
	 * @param id Issue id
	 * @param type Issue type
	 * @param sum Issue summary
	 * @param note Issue notes
	 */
	public Issue (int id, IssueType type, String sum, String note) {
		if (type == null || sum == null || sum.length() == 0 || note == null || note.length() == 0 || id < 1) {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		else {
			issueId = id;
			summary = sum;
			owner = "";
			confirmed = false;
			issueType = type;
			resolution = null;
			state = newState;
			
			notes = new ArrayList<String>();
			addNote(note);
		}
	}
	/**
	 * Issue constructor with parameters for all fields
	 * @param id Issue id
	 * @param state Issue state
	 * @param type Issue type
	 * @param sum Issue summary
	 * @param owner1 Issue owner
	 * @param confirmed1 Issue confirmed status
	 * @param resolution1 Issue resolution
	 * @param notes1 Issue notes
	 */
	public Issue (int id, String state, String type, String sum, String owner1, boolean confirmed1, String resolution1, ArrayList<String> notes1) {
		if (type == null || sum == null || sum.length() == 0 || notes1 == null || notes1.size() == 0 || id < 1 || owner1 == null || resolution1 == null) {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		else {
			setIssueId(id);
			setSummary(sum);
			setOwner(owner1);
			setConfirmed(confirmed1);
			setIssueType(type);
			setResolution(resolution1);
			setState(state);
			setNotes(notes1);
		}
	}
	/**
	 * Sets Issue id
	 * @param i id
	 */
	private void setIssueId(int i) {
		issueId = i;
	}
	/**
	 * Sets Issue state
	 * @param x state
	 */
	private void setState(String x) {
		if (x.charAt(1) == 'l' || x.charAt(0) == 'L') {
			state = closedState;
		}
		else if (x.charAt(0) == 'w' || x.charAt(0) == 'W') {
			state = workingState;
		}
		else if (x.charAt(0) == 'n' || x.charAt(0) == 'N') {
			state = newState;
		}
		else if (x.charAt(0) == 'c' || x.charAt(0) == 'C') {
			state = confirmedState;
		}
		else if (x.charAt(0) == 'v' || x.charAt(0) == 'V') {
			state = verifyingState;
		}
		else {
			state = null;
		}
	}
	/**
	 * Sets Issue type
	 * @param x type
	 */
	private void setIssueType(String x) {
		if (x.charAt(0) == 'b' || x.charAt(0) == 'B') {
			issueType = IssueType.BUG;
		}
		else if (x.charAt(0) == 'e' || x.charAt(0) == 'E') {
			issueType = IssueType.ENHANCEMENT;
		}
		//else
	}
	/**
	 * Sets Issue summary
	 * @param x summary
	 */
	private void setSummary(String x) {
		summary = x;
	}
	/**
	 * Sets Issue owner
	 * @param x owner
	 */
	private void setOwner(String x) {
		owner = x;
	}
	/**
	 * Sets Issue confirmed status
	 * @param x confirmed boolean
	 */
	private void setConfirmed(boolean x) {
		confirmed = x;
	}
	/**
	 * Sets Issue Resolution
	 * @param x resolution
	 */
	private void setResolution(String x) {
		if (x.length() == 0) {
			resolution = null;
		}
		else if (x.charAt(0) == 'f' || x.charAt(0) == 'F') {
			resolution = Resolution.FIXED;
		}
		else if (x.charAt(0) == 'd' || x.charAt(0) == 'D') {
			resolution = Resolution.DUPLICATE;
		} 
		else if (x.charAt(2) == 'n' || x.charAt(0) == 'N') {
			resolution = Resolution.WONTFIX;
		} 
		else if (x.charAt(2) == 'r' || x.charAt(0) == 'R') {
			resolution = Resolution.WORKSFORME;
		} 
	}
	/**
	 * Sets Issue notes
	 * @param x notes
	 */
	private void setNotes(ArrayList<String> x) {
		notes = x;
	}
	/**
	 * Gets Issue id
	 * @return id
	 */
	public int getIssueId() {
		return issueId;
	}
	/**
	 * Gets Issue state name
	 * @return state name
	 */
	public String getStateName() {
		return state.getStateName();
	}
	/**
	 * Gets Issue type
	 * @return type
	 */
	public String getIssueType() {
		if (issueType == IssueType.BUG) {
			return I_BUG;
		}
		else
			return I_ENHANCEMENT;
	}
	/**
	 * Gets Issue resolution
	 * @return resolution
	 */
	public String getResolution() {
		if (resolution == Resolution.DUPLICATE)
			return "Duplicate";
		else if (resolution == Resolution.FIXED)
			return "Fixed";
		else if (resolution == Resolution.WONTFIX)
			return "Duplicate";
		else if (resolution == Resolution.WORKSFORME)
			return "WorksForMe";
		else
			return "";
	}
	/**
	 * Returns Issue owner
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Gets Issue summary
	 * @return summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * Gets Issue notes
	 * @return notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	/**
	 * Gets Issue notes as string
	 * @return notes
	 */
	public String getNotesString() {
		String listOfNotes = "";
		for (int i = 0; i < notes.size(); i++) {
			listOfNotes = listOfNotes + "-" + "[" + getIssueType() + "] " + notes.get(i) + "\n";
		}
		return listOfNotes;
	}
	/**
	 * Returns Issue confirmed status
	 * @return confirmed status
	 */
	public boolean isConfirmed () {
		return confirmed;
	}
	/**
	 * Returns Issue as string
	 * @return Issue as string
	 */
	public String toString() {
		return "*" + getIssueId() + "," + getStateName() + "," + getIssueType() + "," + getSummary() + "," + getOwner() + "," + isConfirmed() + "," + getResolution() + "\n" + getNotesString();
	}
	/**
	 * Adds note to Issue
	 * @param x note
	 */
	private void addNote(String x) {
		if (x == null || x.length() == 0) {
			throw new IllegalArgumentException();
		}
		notes.add("[" + getStateName() + "] " + x);
	}
	/**
	 * Updates Issue with Command
	 * @param x command
	 */
	public void update(Command x) throws UnsupportedOperationException{
		if (state == newState) {
			newState.updateState(x);
		}
		else if (state == confirmedState) {
			confirmedState.updateState(x);
		}
		else if (state == closedState) {
			closedState.updateState(x);
		}
		else if (state == verifyingState) {
			verifyingState.updateState(x);
		}
		else if (state == workingState) {
			workingState.updateState(x);
		}
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
	 * Interface for states in the Issue State Pattern.  All 
	 * concrete issue states must implement the IssueState interface.
	 * The IssueState interface should be a private interface of the 
	 * Issue class.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface IssueState {
		
		/**
		 * Update the Issue based on the given Command.
		 * An UnsupportedOperationException is throw if the Command
		 * is not a valid action for the given state.  
		 * @param command Command describing the action that will update the Issue's
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command command);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();

	}
	
	/**
	 * ClosedState implementation of IssueState
	 * @author inyene2
	 *
	 */
	public class ClosedState implements IssueState {

		@Override
		public void updateState(Command x) {
			if (x.getCommand() == CommandValue.REOPEN) {
				if (getIssueType() == I_ENHANCEMENT && (owner != null || owner.length() != 0)) {
					state = workingState;
					addNote(x.getNote());
				}
				else if (getIssueType() == I_ENHANCEMENT && (owner == null || owner.length() == 0)) {
					state = newState;
					addNote(x.getNote());
				}
				else if (getIssueType() == I_BUG && isConfirmed() && (owner != null || owner.length() != 0)) {
					state = workingState;
					addNote(x.getNote());
				}
				else if (getIssueType() == I_BUG && isConfirmed() && (owner == null || owner.length() == 0)) {
					state = confirmedState;
					addNote(x.getNote());
				}
				else if ((getIssueType() == I_BUG  && isConfirmed()) || getIssueType() == I_ENHANCEMENT && (owner == null || owner.length() == 0)){
					state = newState;
					addNote(x.getNote());
				}
			}
			else {
				throw new UnsupportedOperationException("Invalid information.");
			}
		}

		@Override
		public String getStateName() {
			return CLOSED_NAME;
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
			if (x.getCommand() == CommandValue.RESOLVE) {
				if (x.getResolution() == Resolution.FIXED) {
					state = verifyingState;
					addNote(x.getNote());
				}
				else {
					addNote(x.getNote());
					state = closedState;
				}
			}
			else {
				throw new UnsupportedOperationException("Invalid information.");
			}
			
		}

		@Override
		public String getStateName() {
			return WORKING_NAME;
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
			if (getIssueType() == I_ENHANCEMENT && x.getCommand() == CommandValue.ASSIGN) {
				state = workingState;
				owner = x.getOwnerId();
				addNote(x.getNote());
			}
			else if (getIssueType() == I_BUG && x.getCommand() == CommandValue.CONFIRM) {
				state = confirmedState;
				addNote(x.getNote());
			}
			else if (x.getCommand() == CommandValue.RESOLVE) {
				resolution = x.getResolution();
				state = closedState;
				addNote(x.getNote());
			}
			else {
				throw new UnsupportedOperationException("Invalid information.");
			}
			
		}

		@Override
		public String getStateName() {
			return NEW_NAME;
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
			if (getIssueType() == I_BUG) {
				if (x.getCommand() == CommandValue.ASSIGN) {
					state = workingState;
					owner = x.getOwnerId();
					addNote(x.getNote());
				}
				else if (x.getCommand() == CommandValue.RESOLVE) {
					if (x.getResolution() == Resolution.WONTFIX) {
						state = closedState;
						addNote(x.getNote());
					}
					else {
						throw new UnsupportedOperationException("Invalid information.");
					}
				}
				else {
					throw new UnsupportedOperationException("Invalid information.");
				}
			}
			else
				throw new UnsupportedOperationException("Invalid information.");
		}

		@Override
		public String getStateName() {
			return CONFIRMED_NAME;
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
			if (x.getCommand() == CommandValue.VERIFY) {
				state = closedState;
				addNote(x.getNote());
			}
			else if (x.getCommand() == CommandValue.REOPEN) {
				state = workingState;
				addNote(x.getNote());
			}
			else {
				throw new UnsupportedOperationException("Invalid information.");
			}
		}

		@Override
		public String getStateName() {
			return VERIFYING_NAME;
		}
		
		
	}
}


