/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.io;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * IssueReader class reads in Issues from file
 * 
 * @author inyene2
 *
 */
public class IssueReader {
	/**
	 * Constructs IssueReader objects
	 */
	public IssueReader() {
		// The explicit constructor is here, so that it is possible to provide Javadoc. 
	}

	/**
	 * Reads in Issues from file
	 * 
	 * @param fileName name of file
	 * @return list of issues
	 */
	public static List<Issue> readIssuesFromFile(String fileName) {
		String x = "";
		ArrayList<Issue> issues = new ArrayList<Issue>();
		try {
			Scanner fileReader = new Scanner(new FileInputStream(fileName)); // Create a file scanner to read the file
			while (fileReader.hasNextLine()) { // While we have more lines in the file
				x = x + fileReader.nextLine() + "\n";
			}
			if (x.length() == 0) {
				throw new IllegalArgumentException();
			}
			fileReader.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		Scanner scnr = new Scanner(x);
		scnr.useDelimiter("\\r?\\n?[*]");
		while (scnr.hasNext()) {
			Issue i = processIssue(scnr.next());
			issues.add(i);
		}
		// Close the Scanner b/c we're responsible with our file handles
		scnr.close();
		// Return the ArrayList with all the courses we read!
		return issues;
	}

	/**
	 * Process Issues by String
	 * 
	 * @param x String to process
	 * @return Processed Issue
	 */
	private static Issue processIssue(String x) {
		String resolution1;
		Scanner scnr = new Scanner(x);
		String fields = scnr.nextLine();
		Scanner scnr1 = new Scanner(fields);
		scnr1.useDelimiter(",");
		

		int issueId = scnr1.nextInt();
		String state = scnr1.next();
		String type = scnr1.next();
		String summary = scnr1.next();
		String owner1 = scnr1.next();
		if (owner1.length() == 0)
			owner1 = null;
		boolean confirmed1 = scnr1.nextBoolean();
		if (scnr1.hasNext())
			resolution1 = scnr1.next();
		else
			resolution1 = null;
		scnr1.close();
		ArrayList<String> notes1 = new ArrayList<String>();
		scnr.useDelimiter("\r?\n?[-]");
		while (scnr.hasNext()) {
			notes1.add("-" + scnr.next().trim());
		}
		scnr.close();
		return new Issue(issueId, state, type, summary, owner1, confirmed1, resolution1, notes1);
	}
}
