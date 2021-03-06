/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * IssueWriter class writes out Issues to file
 * @author inyene2
 *
 */
public class IssueWriter {
	/**
	 * Constructs IssueWriter objects
	 */
	public IssueWriter() {
		// The explicit constructor is here, so that it is possible to provide Javadoc. 
	}
	/**
	 * Writes out list of Issues to file
	 * @param fileName filename to write to 
	 * @param issues list of issues
	 */
	public static void writeIssuesToFile(String fileName, List<Issue> issues) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}

		for (int i = 0; i < issues.size(); i++) {
			Issue issue = issues.get(i);
			fileWriter.print(issue.toString());
		}

		fileWriter.close();
	}
}

