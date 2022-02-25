/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * @author inyene2
 *
 */
public class IssueList {
	private int counter;
	
	private ArrayList<Issue> issues;
	
	public IssueList() {
		
	}
	
	public int addIssue(IssueType type, String x, String y) {
		return 0;
	}
	
	public void addIssues(ArrayList<Issue> issues) {
		
	}
	
	private void addIssue(Issue x) {
		
	}
	
	public ArrayList<Issue> getIssues() {
		return null;
	}
	
	public ArrayList<Issue> getIssuesByType(String x) {
		return null;
	}
	
	public Issue getIssueById(int x) {
		return null;
	}
	
	public void executeCommand(int x, Command c) {
		
	}
}
