/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
//		ArrayList<Issue> issues = new ArrayList<Issue>();
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("dis fire"); 
//		a.add("deez nuts");
//		issues.add(new Issue(1, "Working", "Enhancement", "summary", "owner", false, "WorksForMe", a));
		ArrayList<Issue> issues = (ArrayList<Issue>) IssueReader.readIssuesFromFile("test-files/issue2.txt");

		IssueWriter.writeIssuesToFile("test-files/actual_issues_records.txt", issues);
		//Check that files are same.

		checkFiles("test-files/issue2.txt", "test-files/actual_issues_records.txt");

		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> IssueWriter.writeIssuesToFile("/home/sesmith5/actual_student_records.txt", issues));
		assertEquals("Unable to save file.", exception.getMessage());
		
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
