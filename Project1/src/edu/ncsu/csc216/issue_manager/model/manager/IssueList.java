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
		issues = new ArrayList<Issue>();
		counter = 1;
	}
	/**
	 * Adds Issue to list
	 * @param type Issue type
	 * @param summary Issue summary
	 * @param note Issue note
	 * @return Issue id
	 */
	public int addIssue(IssueType type, String summary, String note) {
		Issue i = new Issue(counter, type, summary, note);
		addIssue(i);
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
			counter = issues.get(issues.size() - 1).getIssueId() + 1;
	}
	/**
	 * Adds Issue to list
	 * @param x Issue to add
	 */
	private void addIssue(Issue x) {
		for(int i = 0; i < issues.size(); i++) {
			if (x.equals(issues.get(i))) {
				return;
			}
		}
		if (issues.size() == 0) {
			issues.add(x);
		}
		else {
			for (int i = 0; i < issues.size(); i++) {
				if (x.getIssueId() < issues.get(i).getIssueId()) {
					issues.add(i, x);
				}
			}
		}
		
		issues.add(x);
		
//		if (issues.size() >= 1) {
//			counter = issues.get(issues.size() - 1).getIssueId() + 1;
//		}
//		else {
//			counter = 1;
//		}
	}
	/**
	 * Returns list of Issues
	 * @return list of Issues
	 */
	public ArrayList<Issue> getIssues() {
		return issues;
	}
	/**
	 * Returns Issue by type
	 * @param x type of Issue
	 * @return Issue
	 */
	public ArrayList<Issue> getIssuesByType(String x) {
		ArrayList<Issue> z = new ArrayList<Issue>();
		if (x.charAt(0) == 'b' || x.charAt(0) == 'B') {
			for (int i = 0; i < issues.size(); i++) {
				if (issues.get(i).getIssueType().equals("Bug")) {
					z.add(issues.get(i));
				}
			}
			return z;
		}
		else if (x.charAt(0) == 'E' || x.charAt(0) == 'e') {
			for (int i = 0; i < issues.size(); i++) {
				if (issues.get(i).getIssueType().equals("Enhancement")) {
					z.add(issues.get(i));
				}
			}
			return z;
		}
		else 
			return null;
		
	}
	/**
	 * Returns Issue by Id
	 * @param x Issue Id
	 * @return Issue
	 */
	public Issue getIssueById(int x) {
		for (int i = 0; i < issues.size(); i++) {
			if (issues.get(i).getIssueId() == x) {
				return issues.get(i);
			}
		}
		return null;
	}
	/**
	 * Deletes issue by id
	 * @param x Issue id
	 */
	public void deleteIssueById(int x) {
		for (int i = 0; i < issues.size(); i++) {
			if (issues.get(i).getIssueId() == x) {
				issues.remove(i);
			}
		}
	}
	/**
	 * Executes Command c
	 * @param x Issue id
	 * @param c Command c
	 */
	public void executeCommand(int x, Command c) {
		for (int i = 0; i < issues.size(); i++) {
			if (issues.get(i).getIssueId() == x) {
				issues.get(i).update(c);
			}
		}
	}
}
