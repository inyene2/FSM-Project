/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * IssueList class constructs and handles IssueList objects
 * @author inyene2
 *
 */
public class IssueList {
	/** IssueList counter */
	private int counter;
	/** List of issues */
	private ArrayList<Issue> issues;
	/**
	 * Constructs IssueList objects
	 */
	public IssueList() {
		counter = 1;
		issues = new ArrayList<Issue>();
	}
	/**
	 * Adds Issue to list
	 * @param type Issue type
	 * @param x Issue ownerId
	 * @param y Issue note
	 * @return Issue id
	 */
	public int addIssue(IssueType type, String x, String y) {
		Issue i = new Issue(counter, type, x, y);
		issues.add(i);
		counter++;
		return counter;
	}
	
	/**
	 * Adds issues to list
	 * @param issues1 list of Issues to add
	 */
	public void addIssues(List<Issue> issues1) {
		for (int i = 0; i < issues1.size(); i++) {
			addIssue(issues1.get(i));
		}
		
	}
	/**
	 * Adds Issue to list
	 * @param x Issue to add
	 */
	private void addIssue(Issue x) {
		
	}
	/**
	 * Returns list of Issues
	 * @return list of Issues
	 */
	public ArrayList<Issue> getIssues() {
		return null;
	}
	/**
	 * Returns Issue by type
	 * @param x type of Issue
	 * @return Issue
	 */
	public ArrayList<Issue> getIssuesByType(String x) {
		return null;
	}
	/**
	 * Returns Issue by Id
	 * @param x Issue Id
	 * @return Issue
	 */
	public Issue getIssueById(int x) {
		return null;
	}
	/**
	 * Deletes issue by id
	 * @param x Issue id
	 */
	public void deleteIssueById(int x) {
		
	}
	/**
	 * Executes Command c
	 * @param x Issue id
	 * @param c Command c
	 */
	public void executeCommand(int x, Command c) {
		
	}
}
