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
		Scanner scnr = new Scanner(x);
		scnr.useDelimiter(",");

		int ownerId = scnr.nextInt();
		String state = scnr.next();
		String type = scnr.next();
		String summary = scnr.next();
		String owner1 = scnr.next();
		boolean confirmed1 = scnr.nextBoolean();
		String resolution1 = scnr.next();
		ArrayList<String> notes1 = new ArrayList<String>();
		
		scnr.useDelimiter("\r?\n?[-]");
		while (scnr.hasNext()) {
			notes1.add(scnr.next());
		}
		scnr.close();
		return new Issue(ownerId, state, type, summary, owner1, confirmed1, resolution1, notes1);
	}
}
