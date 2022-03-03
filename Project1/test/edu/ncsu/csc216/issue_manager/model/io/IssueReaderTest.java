/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.Assert.assertEquals;
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

	/** Valid course records */
	private final String validTestFile = "test-files/issue1.txt";
	/** Invalid course records */
	private final String invalidTestFile = "test-files/invalid_course_records.txt";

	/**
	 * Tests IssueReader.readIssuesFromFile()
	 */
	@Test
	public void testReadIssuesFromFile() {
		ArrayList<Issue> issues = (ArrayList<Issue>) IssueReader.readIssuesFromFile(validTestFile);
		assertEquals(13, issues.size());
/*
		for (int i = 0; i < issues.size(); i++) {
			assertEquals(issues.get(i), issues.get(i).toString());
		} */
	}

	/**
	 * Tests readInvalidCourseRecords().
	 */
	@Test
	public void testReadInvalidFile() {
		assertThrows(IllegalArgumentException.class, () -> IssueReader.readIssuesFromFile(validTestFile));
		//assertEquals(0, issues.size());
	}
}
