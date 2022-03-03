/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.io.IssueReader;
import edu.ncsu.csc216.issue_manager.model.io.IssueWriter;
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
	private static IssueManager singleton;
	/**
	 * Constructs IssueManager objects
	 */
	private IssueManager() {
		issueList = new IssueList();
	}
	/**
	 * Returns instance of IssueManager
	 * @return IssueManager
	 */
	public static IssueManager getInstance() {
		if (singleton == null) {
			singleton = new IssueManager();
		}
		return singleton;
	}
	/**
	 * Saves issues to file
	 * @param x filename to save issues to
	 */
	public void saveIssuesToFile(String x) {
			IssueWriter.writeIssuesToFile(x, issueList.getIssues());
	}
	/**
	 * Loads issues from file
	 * @param x filename
	 */
	public void loadIssuesFromFile(String x) {
			issueList.addIssues(IssueReader.readIssuesFromFile(x));
	}
	/**
	 * Creates new list of issues
	 */
	public void createNewIssueList() {
		issueList = new IssueList();
	}
	/**
	 * Returns issues list as 2d array
	 * @return 2d array of issues
	 */
	public String[][] getIssueListAsArray() {
		String[][] issuesL = new String[issueList.getIssues().size()][4];
		for (int i = 0; i < issueList.getIssues().size(); i++) {
			Issue a = issueList.getIssues().get(i);
			issuesL[i][0] = a.getIssueId() + "";
			issuesL[i][1] = a.getStateName();
			issuesL[i][2] = a.getIssueType();
			issuesL[i][3] = a.getSummary();
		}
		return issuesL;
	}
	/**
	 * Returns issue list as 2d array by type
	 * @param x Issue type
	 * @return 2d array of issues
	 */
	public String[][] getIssueListAsArrayByIssueType(String x) {
		ArrayList<Issue> issues1 = issueList.getIssuesByType(x);
		String[][] issuesL = new String[issues1.size()][4];
		for (int i = 0; i < issues1.size(); i++) {
			Issue a = issues1.get(i);
			issuesL[i][0] = a.getIssueId() + "";
			issuesL[i][1] = a.getStateName();
			issuesL[i][2] = a.getIssueType();
			issuesL[i][3] = a.getSummary();
		}
		return issuesL;
	}
	/**
	 * Returns issue by id
	 * @param id Issue id
	 * @return Issue
	 */
	public Issue getIssueById(int id) {
		for (int i = 0; i < issueList.getIssues().size(); i++) {
			if (issueList.getIssues().get(i).getIssueId() == id)
				return issueList.getIssues().get(i);
		}
		return null;
	}
	/**
	 * Executes Issue command
	 * @param i issue id
	 * @param c Command c
	 */
	public void executeCommand(int i, Command c) {
		issueList.executeCommand(i, c);
	}
	/**
	 * Deletes Issue by id
	 * @param id Issue id
	 */
	public void deleteIssueById(int id) {
		issueList.deleteIssueById(id);
	}
	/**
	 * Adds issue to list
	 * @param type Issue type
	 * @param x Issue note
	 * @param y Issue owner
	 */
	public void addIssueToList(IssueType type, String x, String y) {
		issueList.addIssue(type, x, y);
	}
}
