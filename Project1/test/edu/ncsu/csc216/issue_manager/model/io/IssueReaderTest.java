/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
/**
 * Tests IssueReader
 * 
 * @author inyene2
 *
 */
public class IssueReaderTest {

	/** Valid Issues file */
	private final String validTestFile = "test-files/issue1.txt";
	/** Invalid Isseus file */
	private final String invalidTestFile = "test-files/issue0.txt";
	
	/**
	 * Tests IssueReader.readIssuesFromFile()
	 */
	@Test
	public void testReadIssuesFromFile() {
		ArrayList<Issue> issues = (ArrayList<Issue>) IssueReader.readIssuesFromFile(validTestFile);
		assertEquals(5, issues.size());
		
		assertEquals("New", issues.get(0).getStateName());
		assertEquals("Confirmed", issues.get(1).getStateName());
		assertEquals("Working", issues.get(2).getStateName());
		assertEquals("Verifying", issues.get(3).getStateName());
		assertEquals("Closed", issues.get(4).getStateName());
		
		assertEquals(1, issues.get(0).getIssueId());
		assertEquals(3, issues.get(1).getIssueId());
		assertEquals(7, issues.get(2).getIssueId());
		assertEquals(14, issues.get(3).getIssueId());
		assertEquals(15, issues.get(4).getIssueId());

		assertEquals("New", issues.get(0).getStateName());
        assertEquals("Enhancement", issues.get(0).getIssueType());
        assertEquals("Issue description", issues.get(0).getSummary());
        assertEquals(null, issues.get(0).getOwner());
        assertFalse(issues.get(0).isConfirmed());
        //assertEquals("[New] Note 1", issues.get(0).getNotesString());
	}

	/**
	 * Tests readInvalidCourseRecords().
	 */
	@Test
	public void testReadInvalidFile() {
		assertThrows(IllegalArgumentException.class, () -> IssueReader.readIssuesFromFile(invalidTestFile));
		//assertEquals(0, issues.size());
	}
}
