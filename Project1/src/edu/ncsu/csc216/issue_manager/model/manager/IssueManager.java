/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * @author inyene2
 *
 */
public class IssueManager {

	private IssueList issueList;
	
	private IssueManager singleton;
	
	private IssueManager() {
		
	}
	
	public static IssueManager getInstance() {
		return null;
	}
	
	public void saveIssuesToFile(String x) {
		
	}
	
	public void loadIssuesFromFile(String x) {
		
	}
	
	public void createNewIssueList() {
		
	}
	
	public String[][] getIssueListAsArray() {
		return null;
	}
	
	public String[][] getIssueListAsArrayByIssueType(String x) {
		return null;
	}
	
	public Issue getIssueById(int id) {
		return null;
	}
	 
	public void executeCommand(int i, Command c) {
		
	}
	
	public void deleteIssueById(int id) {
		
	}
	
	public void addIssueToList(IssueType type, String x, String y) {
		
	}
}
