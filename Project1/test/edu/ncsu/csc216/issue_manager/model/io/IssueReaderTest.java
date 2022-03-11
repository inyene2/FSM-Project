/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	private final String validTestFile = "test-files/issue8.txt";
	/** Invalid Isseus file */
	private final String invalidTestFile = "test-files/issue0.txt";
	
	/**
	 * Tests IssueReader.readIssuesFromFile()
	 */
	@Test
	public void testReadIssuesFromFile() {
		ArrayList<Issue> issues = (ArrayList<Issue>) IssueReader.readIssuesFromFile(validTestFile);
		assertEquals(1, issues.size());
		assertEquals("Confirmed", issues.get(0).getStateName());
		assertEquals(2, issues.get(0).getIssueId());
        assertEquals("Bug", issues.get(0).getIssueType());
        assertEquals("Issue description", issues.get(0).getSummary());
        assertEquals(null, issues.get(0).getOwner());
        assertTrue(issues.get(0).isConfirmed());
        assertEquals("Fixed", issues.get(0).getResolution());
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
