/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * IssueManager class creates and handles IssueManager objects
 * @author inyene2
 *
 */
public class IssueManager {

	/** List of issues */
	private IssueList issueList;
	/** Single instance of IssueManager */
	private IssueManager singleton;
	/**
	 * Constructs IssueManager objects
	 */
	private IssueManager() {
		
	}
	/**
	 * Returns instance of IssueManager
	 * @return IssueManager
	 */
	public static IssueManager getInstance() {
		return null;
	}
	/**
	 * Saves issues to file
	 * @param x filename to save issues to
	 */
	public void saveIssuesToFile(String x) {
		
	}
	/**
	 * Loads issues from file
	 * @param x filename
	 */
	public void loadIssuesFromFile(String x) {
		
	}
	/**
	 * Creates new list of issues
	 */
	public void createNewIssueList() {
		
	}
	/**
	 * Returns issues list as 2d array
	 * @return 2d array of issues
	 */
	public String[][] getIssueListAsArray() {
		return null;
	}
	/**
	 * Returns issue list as 2d array by type
	 * @param x Issue type
	 * @return 2d array of issues
	 */
	public String[][] getIssueListAsArrayByIssueType(String x) {
		return null;
	}
	/**
	 * Returns issue by id
	 * @param id Issue id
	 * @return Issue
	 */
	public Issue getIssueById(int id) {
		return null;
	}
	/**
	 * Executes Issue command
	 * @param i issue id
	 * @param c Command c
	 */
	public void executeCommand(int i, Command c) {
		
	}
	/**
	 * Deletes Issue by id
	 * @param id Issue id
	 */
	public void deleteIssueById(int id) {
		
	}
	/**
	 * Adds issue to list
	 * @param type Issue type
	 * @param x Issue note
	 * @param y Issue owner
	 */
	public void addIssueToList(IssueType type, String x, String y) {
		
	}
}
