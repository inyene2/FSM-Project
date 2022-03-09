/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Tests IssueList class
 * 
 * @author inyene2
 *
 */
public class IssueListTest {
	/**
	 * Tests IssueList constructor
	 */
	@Test
	public void testIssueList() {
		// Test with invalid file. Should have an empty catalog and schedule.
		IssueList il1 = new IssueList();
		assertEquals(0, il1.getIssues().size());
	}

	/**
	 * Tests IssueList.addIssue()
	 */
	@Test
	public void testAddIssue() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		IssueList il1 = new IssueList();
		il1.addIssue(IssueType.ENHANCEMENT, "owner", "note");
		
		assertEquals(1, il1.getIssues().size());
		assertTrue("Enhancement".equals(il1.getIssues().get(0).getIssueType()));
	}
	
	/**
	 * Tests IssueList.addIssue(List)
	 */
	@Test
	public void testAddIssueList() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		Issue i1 = new Issue(3, "Working", "Bug", "summary", "owner", false, "WorksForMe", a);
		Issue i2 = new Issue(2, "Verifying", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		
		ArrayList<Issue> b = new ArrayList<Issue>();
		b.add(i);
		b.add(i1);
		b.add(i2);
		IssueList il1 = new IssueList();
		il1.addIssues(b);
		
		assertEquals(3, il1.getIssues().size());
		assertTrue("New".equals(il1.getIssues().get(0).getStateName()));
		assertTrue("Verifying".equals(il1.getIssues().get(1).getStateName()));
		assertTrue("Working".equals(il1.getIssues().get(2).getStateName()));

	}

	/**
	 * Tests IssueList.deleteIssueById()
	 */
	@Test
	public void testDeleteIssueById() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		Issue i1 = new Issue(3, "Working", "Bug", "summary", "owner", false, "WorksForMe", a);
		Issue i2 = new Issue(2, "Verifying", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		
		ArrayList<Issue> b = new ArrayList<Issue>();
		b.add(i);
		b.add(i1);
		b.add(i2);
		IssueList il1 = new IssueList();
		il1.addIssues(b);
		
		il1.deleteIssueById(0);
		assertEquals(2, il1.getIssues().size());
		assertTrue("Verifying".equals(il1.getIssues().get(0).getStateName()));
		assertTrue("Working".equals(il1.getIssues().get(1).getStateName()));
		
	}

	/**
	 * Tests IssueList.executeCommand()
	 */
	@Test
	public void testExecuteCommand() {
		IssueList il1 = new IssueList();
		il1.addIssue(IssueType.BUG, "summary", "note");
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		il1.executeCommand(0, c);
		Issue i = il1.getIssues().get(0);
		assertTrue("ownerId".equals(i.getOwner()));
		assertTrue("Working".equals(i.getStateName()));
	}

	/**
	 * Tests IssueList.getIssueById
	 */
	@Test
	public void testGetIssueById() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "New", "Enhancement", "deeznuts", "owner", false, "WorksForMe", a);
		Issue i1 = new Issue(3, "Working", "Bug", "summary", "owner", false, "WorksForMe", a);
		Issue i2 = new Issue(2, "Verifying", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		
		ArrayList<Issue> b = new ArrayList<Issue>();
		b.add(i);
		b.add(i1);
		b.add(i2);
		IssueList il1 = new IssueList();
		il1.addIssues(b);
		
		assertTrue("deeznuts".equals(il1.getIssueById(0).getSummary()));
		assertTrue("Verifying".equals(il1.getIssueById(1).getStateName()));
	}

	/**
	 * Tests IssueList.getIssues
	 */
	@Test
	public void testGetIssues() {
		fail();
	}

	/**
	 * Tests IssueList.getIssuesByType
	 */
	@Test
	public void testGetIssuesByType() {
		IssueList il1 = new IssueList();
		il1.addIssue(IssueType.ENHANCEMENT, "summary", "note1");
		il1.addIssue(IssueType.ENHANCEMENT, "summary1", "note2");
		il1.addIssue(IssueType.BUG, "summary2", "note3");
		il1.addIssue(IssueType.BUG, "summary3", "note4");
		ArrayList<Issue> issues = il1.getIssuesByType("Bug");
		
		assertEquals(2, issues.size());
		
	}

}
