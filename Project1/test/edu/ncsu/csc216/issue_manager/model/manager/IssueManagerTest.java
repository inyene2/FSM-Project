/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;


import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Tests IssueManager class
 * @author inyene2
 *
 */
public class IssueManagerTest {
	/**
	 * Tests IssueManager constructor
	 */
	@Test
	public void testManager() {
		IssueManager manager = IssueManager.getInstance();
		assertEquals(0, manager.getIssueListAsArray());
	}
	
	/**
	 * Tests IssueManager.addIssueToList()
	 */
	@Test
	public void testAddIssueToList() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		//Issue i = new Issue(1, "new", "enhancement", "summary", "owner", false, "worksforme", a);
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(1, manager.getIssueListAsArray().length);
		
	}
	
	/**
	 * Tests IssueManager.createNewIssuesList()
	 */
	@Test
	public void testCreateNewIssuesList() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(1, manager.getIssueListAsArray().length);
		manager.createNewIssueList();
		assertEquals(0, manager.getIssueListAsArray().clone().length);
	}
	
	/**
	 * Tests IssueManager.deleteIssuebyId()
	 */
	@Test
	public void testDeleteIssueById() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(1, manager.getIssueListAsArray().length);
		manager.deleteIssueById(1);
		assertEquals(0, manager.getIssueListAsArray().length);
	}
	
	/**
	 * Tests IssueManager.executeCommand()
	 */
	@Test
	public void testExecuteCommand() {
		fail();
	}
	
	/**
	 * Tests IssueManager.getIssueById
	 */
	@Test
	public void testGetIssueById() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(1, manager.getIssueListAsArray().length);
		assertEquals("summary", manager.getIssueById(1).getSummary());
	}
	
	/**
	 * Tests IssueManager.getIssueListAsArray()
	 */
	@Test
	public void testGetIssueListAsArray() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(1, manager.getIssueListAsArray().length);
	}
	
	/**
	 * Tests IssueManager.getIssueListAsArrayByIssueType()
	 */
	@Test
	public void testGetIssueListAsArrayByIssueType() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		assertEquals(0, manager.getIssueListAsArrayByIssueType("Enhancement").length);
	}
	
	/**
	 * Tests IssueManager.loadIssuesFromFile()
	 */
	@Test
	public void testLoadIssuesFromFile() {
		fail();
	}
	
	/**
	 * Tests IssueManager.saveIssuesToFile()
	 */
	@Test
	public void testSaveIssuesToFile() {
		IssueManager manager = IssueManager.getInstance();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		manager.saveIssuesToFile("test-files/actual_file");
		fail();
	}
}
