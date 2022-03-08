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
 * Tests IssueWriter class
 * @author inyene2
 *
 */
public class IssueWriterTest {

	/**
	 * Tests IssueWriter.writeIssuesToFile()
	 */
	@Test
	public void testWriteIssuesToFile() {
		ArrayList<Issue> issues = new ArrayList<Issue>();
		ArrayList<String> a = new ArrayList<String>();
		a.add("dis fire"); 
		issues.add(new Issue(1, "working", "enhancement", "summary", "owner", false, "worksforme", a));

		IssueWriter.writeIssuesToFile("test-files/actual_student_records_2.txt", issues);
		//Check that files are same.

		//checkFiles("test-files/expected_student_records_2.txt", "test-files/actual_student_records_2.txt");

		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> IssueWriter.writeIssuesToFile("/home/sesmith5/actual_student_records.txt", issues));
		assertEquals("Unable to save file.", exception.getMessage());
		
	}
}
