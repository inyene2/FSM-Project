/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;


import static org.junit.Assert.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

/**
 * Tests Issue class
 * @author inyene2
 *
 */
public class IssueTest {
	
	
	/**
	 * Tests Issue constructor with all parameters
	 */
	@Test
	public void testIssueAllParameters() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals(1, i.getIssueId());
		assertEquals("New", i.getStateName());
		assertEquals("Enhancement", i.getIssueType());
		assertEquals("summary", i.getSummary());
		assertEquals("owner", i.getOwner());
		assertFalse(i.isConfirmed());
		assertEquals(1, a.size());
		assertEquals(a, i.getNotes());
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Issue(-1, "new", "enhancement", "summary", "owner", false, "worksforme", a));
		assertEquals("Issue cannot be created.", e1.getMessage());
	}
	
	/**
	 * Tests Issue constructor with 4 parameters
	 */
	@Test
	public void testIssue() {
		Issue i = new Issue(1, IssueType.BUG, "summary", "note");
		assertEquals(1, i.getIssueId());
		assertEquals("New", i.getStateName());
		assertEquals("Bug", i.getIssueType());
		assertEquals("summary", i.getSummary());
		assertEquals(null, i.getOwner());
		assertFalse(i.isConfirmed());
		assertEquals(1, i.getNotes().size());
		assertEquals("[New] note", i.getNotes().get(0));
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Issue(1, IssueType.BUG, "summary", null));
		assertEquals("Issue cannot be created.", e1.getMessage());
	}
	
	/**
	 * Tests Issue.getIssueType()
	 */
	@Test
	public void testGetIssueType() {
		Issue i = new Issue(1, IssueType.BUG, "summary", "note");
		assertEquals("Bug", i.getIssueType());
	}
	/**
	 * Tests Issue.getNotes()
	 */
	@Test
	public void testGetNotes() {
		Issue i = new Issue(1, IssueType.BUG, "summary", "note");
		assertEquals("[New] note", i.getNotes().get(0));
	}
	/**
	 * Tests Issue.getNotesString()
	 */
	@Test
	public void testGetNotesString() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("-dis fire\n" + "-deez\n" + "-nuts\n" + "-candace\n", i.getNotesString());
	}
	/**
	 * Tests Issue.getOwner()
	 */
	@Test
	public void testGetOwner() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("owner", i.getOwner());
	}
	/**
	 * Tests Issue.getResolution()
	 */
	@Test
	public void testGetResolution() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("WorksForMe", i.getResolution());
	}
	/**
	 * Tests Issue.getStateName()
	 */
	@Test
	public void testGetStateName() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("New", i.getStateName());
	}
	/**
	 * Tests Issue.getSummary()
	 */
	@Test
	public void testGetSummary() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("summary", i.getSummary());
	}
	/**
	 * Tests Issue.isConfirmed()
	 */
	@Test
	public void testIsConfirmed() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertFalse(i.isConfirmed());
	}
	/**
	 * Tests Issue.setConfirmed()
	 */
	@Test
	public void testSetConfirmed() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertFalse(i.isConfirmed());
	}
	/**
	 * Tests Issue.setIssueId()
	 */
	@Test
	public void testSetIssueId() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals(1, i.getIssueId());
	}
	/**
	 * Tests Issue.setIssueType()
	 */
	@Test
	public void testSetIssueType() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("deez");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("Enhancement", i.getIssueType());
	}
	/**
	 * Tests Issue.setNotes()
	 */
	@Test
	public void testNotes() {
		Issue i = new Issue(1, IssueType.BUG, "summary", "note");
		assertEquals("[New] note", i.getNotes().get(0));
	}
	/**
	 * Tests Issue.setOwner()
	 */
	@Test
	public void testSetOwner() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("deez");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("owner", i.getOwner());
	}
	/**
	 * Tests Issue.setResolution()
	 */
	@Test
	public void testSetResolution() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("deez");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("WorksForMe", i.getResolution());
	}
	/**
	 * Tests Issue.setState()
	 */
	@Test
	public void testSetState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("deez");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("New", i.getStateName());
	}
	/**
	 * Tests Issue.setSummary()
	 */
	@Test
	public void testSetSummary() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("deez");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("summary", i.getSummary());
	}
	/**
	 * Tests Issue.toString()
	 */
	@Test
	public void testToString() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		a.add("deez");
		a.add("nuts");
		a.add("candace");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		assertEquals("*1,New,Enhancement,summary,owner,false,WorksForMe\n" + "-dis fire\n" + "-deez\n" + "-nuts\n" + "-candace\n", i.toString());
	}
	/**
	 * Tests Issue.update()
	 */
	@Test
	public void testUpdate() {
		Issue i = new Issue(1, IssueType.ENHANCEMENT, "summary", "note");
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		i.update(c);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
	}
	
	/**
	 * Tests NewState() inner class
	 */
	@Test
	public void testNewState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "New", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		i.update(c);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		Issue i1 = new Issue(1, "New", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c1 = new Command(CommandValue.CONFIRM, "ownerId", Resolution.WORKSFORME, "note");
		i1.update(c1);
		assertEquals("Confirmed", i1.getStateName());
		
		Issue i2 = new Issue(1, "New", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c2 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WORKSFORME, "note");
		i2.update(c2);
		assertEquals("WorksForMe", i2.getResolution());
		assertEquals("Closed", i2.getStateName());
		
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i.update(c1));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
	
	/**
	 * Tests WorkingState() inner class
	 */
	@Test
	public void testWorkingState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "Working", "Enhancement", "summary", "owner", false, "WorksForMe", a);
		Command c = new Command(CommandValue.RESOLVE, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Verifying", i.getStateName());
		
		Issue i1 = new Issue(1, "New", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c1 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WORKSFORME, "note");
		i1.update(c1);
		assertEquals("Closed", i1.getStateName());
		
		Issue i2 = new Issue(1, "New", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c2 = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i2.update(c2));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
	
	/**
	 * Tests ConfirmedState() inner class
	 */
	@Test
	public void testConfirmedState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "Confirmed", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		Issue i1 = new Issue(1, "Confirmed", "Bug", "summary", "owner", false, "WorksForMe", a);
		Command c1 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WONTFIX, "note");
		Command c2 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.FIXED, "note");
		i1.update(c1);
		assertEquals("Closed", i1.getStateName());
		
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i1.update(c2));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
	
	/**
	 * Tests VerifyingState() inner class
	 */
	@Test
	public void testVerifyingState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "Verifying", "Bug", "summary", "owner", false, "Fixed", a);
		Command c = new Command(CommandValue.VERIFY, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Closed", i.getStateName());
		
		Issue i1 = new Issue(1, "Verifying", "Enhancement", "summary", "owner", false, "Fixed", a);
		Command c1 = new Command(CommandValue.REOPEN, "ownerId", Resolution.WONTFIX, "note");
		Command c2 = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WONTFIX, "note");
		i1.update(c1);
		assertEquals("Working", i1.getStateName());
		
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i1.update(c2));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
	
	/**
	 * Tests ClosedState() inner class
	 */
	@Test
	public void testClosedState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "Closed", "Enhancement", "summary", "owner", false, "Fixed", a);
		Issue i1 = new Issue(1, "Closed", "Bug", "summary", "owner", true, "Fixed", a);
		Issue i2 = new Issue(1, "Closed", "Bug", "summary", "", true, "Fixed", a);
		Issue i3 = new Issue(1, "Closed", "Enhancement", "summary", "", true, "Fixed", a);
		Issue i4 = new Issue(1, "Closed", "Bug", "summary", "", false, "Fixed", a);
		Command c = new Command(CommandValue.REOPEN, "ownerId", Resolution.FIXED, "note");
		Command c1 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WONTFIX, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		i1.update(c);
		assertEquals("owner", i1.getOwner());
		assertEquals("Working", i1.getStateName());
		
		i2.update(c);
		assertEquals(null, i2.getOwner());
		assertEquals("Confirmed", i2.getStateName());
		
		i3.update(c);
		assertEquals(null, i3.getOwner());
		assertEquals("New", i3.getStateName());
		
		i4.update(c);
		assertEquals(null, i4.getOwner());
		assertEquals("New", i4.getStateName());
		
		Issue i5 = new Issue(1, "Closed", "Bug", "summary", "owner", true, "Fixed", a);
		//Command c2 = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WONTFIX, "note");
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i5.update(c1));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
}
