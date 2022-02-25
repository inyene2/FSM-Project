/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;

/**
 * @author inyene2
 *
 */
public class Issue {
	
	private static final String I_ENHANCEMENT = "Enhancement";
	
	private static final String I_BUG = "Bug";
	
	private static final String NEW_NAME = "New";
	
	private static final String WORKING_NAME = "Working";
	
	private static final String CONFIRMED_NAME = "Confirmed";
	
	private static final String VERIFYING_NAME = "Verifying";
	
	private static final String CLOSED_NAME = "Closed";
	
	private int issueId;
	
	private String summary;
	
	private String owner;
	
	private boolean confirmed;
	
	private ArrayList<String> notes;
	
	private IssueType issueType;
	
	private Resolution resolution;
	
	private IssueState newState;
	
	private IssueState confirmedState;
	
	private IssueState closedState;
	
	private IssueState state;
	
	private IssueState verifyingState;
	
	private IssueState workingState;
	public Issue (int i, IssueType issue, String x, String y) {
		
	}
	
	public Issue (int a, String b, String c, String d, String e, boolean f, String g, ArrayList<String> h) {
		
	}
	
	private void setIssueId(int i) {
		
	}
	
	private void setState(String x) {
		
	}
	
	private void setIssueType(String x) {
		
	}
	
	private void setSummary(String x) {
		
	}
	
	private void setOwner(String x) {
		
	}
	
	private void setConfirmed(boolean x) {
		
	}
	
	private void setResolution(String x) {
		
	}
	
	private void setNotes(ArrayList<String> x) {
		
	}
	
	public int getIssueId() {
		return 0;
	}
	
	public String getStateName() {
		return null;
	}
	
	public String getIssueType() {
		return null;
	}
	
	public String getResolution() {
		return null;
	}
	
	public String getOwner() {
		return null;
	}
	
	public String getSummary() {
		return null;
	}
	
	public ArrayList<String> getNotes() {
		return null;
	}
	
	public String getNotesString() {
		return null;
	}
	
	public boolean isConfirmed () {
		return false;
	}
	
	public String toString() {
		return null;
	}
	
	private void addNote(String x) {
		
	}
	
	public void update(Command x) {
		
	}
	
	public enum IssueType {
		ENHANCEMENT, BUG;
	}
	
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


