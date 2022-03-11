/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
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
		manager.createNewIssueList();
		assertEquals(0, manager.getIssueListAsArray().length);
	}
	
	/**
	 * Tests IssueManager.addIssueToList()
	 */
	@Test
	public void testAddIssueToList() {
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
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
		manager.createNewIssueList();
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
		manager.createNewIssueList();
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
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
		manager.addIssueToList(IssueType.ENHANCEMENT, "summary", "note");
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		manager.executeCommand(1, c);
		Issue i = manager.getIssueById(1);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
	}
	
	/**
	 * Tests IssueManager.getIssueById
	 */
	@Test
	public void testGetIssueById() {
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
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
		manager.createNewIssueList();
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
		manager.createNewIssueList();
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
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
		manager.loadIssuesFromFile("test-files/issue1.txt");
		assertEquals(5, manager.getIssueListAsArray().length);
	}
	
	/**
	 * Tests IssueManager.saveIssuesToFile()
	 */
	@Test
	public void testSaveIssuesToFile() {
		IssueManager manager = IssueManager.getInstance();
		manager.createNewIssueList();
		manager.loadIssuesFromFile("test-files/issue8.txt");
		manager.saveIssuesToFile("test-files/actual_issues_records.txt");
		checkFiles("test-files/issues8_2.txt", "test-files/actual_issues_records.txt");
		
		String x = "deez";
		assertEquals(4, x.length());
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
