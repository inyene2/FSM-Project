/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
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
		Issue i = new Issue(1, "new", "enhancement", "summary", "owner", false, "worksforme", a);
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
		assertEquals("", i.getOwner());
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
		fail();
	}
	/**
	 * Tests Issue.getNotes()
	 */
	@Test
	public void testGetNotes() {
		fail();
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
		Issue i = new Issue(1, "new", "enhancement", "summary", "owner", false, "worksforme", a);
		assertEquals("-[Enhancement] dis fire\n" + "-[Enhancement] deez\n" + "-[Enhancement] nuts\n" + "-[Enhancement] candace\n", i.getNotesString());
	}
	/**
	 * Tests Issue.getOwner()
	 */
	@Test
	public void testGetOwner() {
		fail();
	}
	/**
	 * Tests Issue.getResolution()
	 */
	@Test
	public void testGetResolution() {
		fail();
	}
	/**
	 * Tests Issue.getStateName()
	 */
	@Test
	public void testGetStateName() {
		fail();
	}
	/**
	 * Tests Issue.getSummary()
	 */
	@Test
	public void testGetSummary() {
		fail();
	}
	/**
	 * Tests Issue.isConfirmed()
	 */
	@Test
	public void testIsConfirmed() {
		fail();
	}
	/**
	 * Tests Issue.setConfirmed()
	 */
	@Test
	public void testSetConfirmed() {
		fail();
	}
	/**
	 * Tests Issue.setIssueId()
	 */
	@Test
	public void testSetIssueId() {
		fail();
	}
	/**
	 * Tests Issue.setIssueType()
	 */
	@Test
	public void testSetIssueType() {
		fail();
	}
	/**
	 * Tests Issue.setNotes()
	 */
	@Test
	public void testNotes() {
		fail();
	}
	/**
	 * Tests Issue.setOwner()
	 */
	@Test
	public void testSetOwner() {
		fail();
	}
	/**
	 * Tests Issue.setResolution()
	 */
	@Test
	public void testSetResolution() {
		fail();
	}
	/**
	 * Tests Issue.setState()
	 */
	@Test
	public void testSetState() {
		fail();
	}
	/**
	 * Tests Issue.setSummary()
	 */
	@Test
	public void testSetSummary() {
		fail();
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
		Issue i = new Issue(1, "new", "enhancement", "summary", "owner", false, "worksforme", a);
		assertEquals("*1,New,Enhancement,summary,owner,false,WorksForMe\n" + "-[Enhancement] dis fire\n" + "-[Enhancement] deez\n" + "-[Enhancement] nuts\n" + "-[Enhancement] candace\n", i.toString());
	}
	/**
	 * Tests Issue.update()
	 */
	@Test
	public void testUpdate() {
		fail();
	}
	
	/**
	 * Tests NewState() inner class
	 */
	@Test
	public void testNewState() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire");
		Issue i = new Issue(1, "new", "enhancement", "summary", "owner", false, "worksforme", a);
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WORKSFORME, "note");
		i.update(c);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		Issue i1 = new Issue(1, "new", "bug", "summary", "owner", false, "worksforme", a);
		Command c1 = new Command(CommandValue.CONFIRM, "ownerId", Resolution.WORKSFORME, "note");
		i1.update(c1);
		assertEquals("Confirmed", i1.getStateName());
		
		Issue i2 = new Issue(1, "new", "bug", "summary", "owner", false, "worksforme", a);
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
		Issue i = new Issue(1, "working", "enhancement", "summary", "owner", false, "worksforme", a);
		Command c = new Command(CommandValue.RESOLVE, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Verifying", i.getStateName());
		
		Issue i1 = new Issue(1, "new", "bug", "summary", "owner", false, "worksforme", a);
		Command c1 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WORKSFORME, "note");
		i1.update(c1);
		assertEquals("Closed", i1.getStateName());
		
		Issue i2 = new Issue(1, "new", "bug", "summary", "owner", false, "worksforme", a);
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
		Issue i = new Issue(1, "confirmed", "bug", "summary", "owner", false, "worksforme", a);
		Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("ownerId", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		Issue i1 = new Issue(1, "confirmed", "bug", "summary", "owner", false, "worksforme", a);
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
		Issue i = new Issue(1, "verifying", "bug", "summary", "owner", false, "fixed", a);
		Command c = new Command(CommandValue.VERIFY, "ownerId", Resolution.FIXED, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Closed", i.getStateName());
		
		Issue i1 = new Issue(1, "verifying", "enhancement", "summary", "owner", false, "fixed", a);
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
		Issue i = new Issue(1, "closed", "enhancement", "summary", "owner", false, "fixed", a);
		Command c = new Command(CommandValue.REOPEN, "ownerId", Resolution.FIXED, "note");
		Command c1 = new Command(CommandValue.RESOLVE, "ownerId", Resolution.WONTFIX, "note");
		i.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Working", i.getStateName());
		
		Issue i1 = new Issue(1, "closed", "bug", "summary", "owner20", true, "fixed", a);
		i1.update(c);
		assertEquals("owner", i.getOwner());
		assertEquals("Working", i1.getStateName());
		
		Issue i2 = new Issue(1, "closed", "bug", "summary", "owner20", true, "fixed", a);
		Issue i3 = new Issue(1, IssueType.ENHANCEMENT, "summary", "note");
		
		i2.update(c);
		assertEquals("Closed", i2.getStateName());
		i3.update(c);
		assertEquals("Closed", i3.getStateName());
		
		//Command c2 = new Command(CommandValue.ASSIGN, "ownerId", Resolution.WONTFIX, "note");
		Exception e1 = assertThrows(UnsupportedOperationException.class, () -> i1.update(c1));
		assertEquals("Invalid information.", e1.getMessage());
		
	}
}
