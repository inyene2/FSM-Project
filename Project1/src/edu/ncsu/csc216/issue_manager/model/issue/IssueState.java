/**
 * 
 */
package edu.ncsu.csc216.issue_manager.model.issue;

import edu.ncsu.csc216.issue_manager.model.command.Command;

/**
 * Outlines behavior for State concrete classes
 * @author inyene2
 *
 */
public interface IssueState {
	/**
	 * Updates state
	 * @param x Command x
	 */
	public void updateState(Command x);
	/**
	 * Returns State name
	 * @return State name
	 */
	public String getStateName();
}
