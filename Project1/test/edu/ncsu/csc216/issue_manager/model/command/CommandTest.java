package edu.ncsu.csc216.issue_manager.model.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
/**
 * Tests Command class
 * @author inyene2
 *
 */
public class CommandTest {
	
	
		/**
		 * Tests Command constructor
		 */
		@Test
		public void testCommand() {
			Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.DUPLICATE, "note");
			assertEquals(CommandValue.ASSIGN, c.getCommand());
			assertEquals("ownerId", c.getOwnerId());
			assertEquals(Resolution.DUPLICATE, c.getResolution());
			assertEquals("note", c.getNote());
		}
		
		/**
		 * Tests Command.getCommand()
		 */
		@Test
		public void testGetCommand() {
			Command c = new Command(CommandValue.CONFIRM, "ownerId", Resolution.DUPLICATE, "note");
			assertEquals(CommandValue.CONFIRM, c.getCommand());
		}
		
		/**
		 * Tests Command.getOwnerId()
		 */
		@Test
		public void testGetOwnerId() {
			Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.DUPLICATE, "note");
			assertEquals("ownerId", c.getOwnerId());
		}
		
		/**
		 * Tests Command.getNote()
		 */
		@Test
		public void testGetNote() {
			Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.DUPLICATE, "note");
			assertEquals("note", c.getNote());
		}
		
		/**
		 * Tests Command.getResolution()
		 */
		@Test
		public void testGetResolution() {
			Command c = new Command(CommandValue.ASSIGN, "ownerId", Resolution.DUPLICATE, "note");
			assertEquals(Resolution.DUPLICATE, c.getResolution());
		}



}
