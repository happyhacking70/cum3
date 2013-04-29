/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdSeshTestAbst extends CmdTestAbst {

	/**
	 * @throws IOException
	 */
	public CmdSeshTestAbst() throws IOException {
		super();
	}

	static final protected String seshName = "testSession";

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdSeshAbst#getSeshName()}.
	 */
	@Test
	final public void testGetSeshName() {
		CmdSeshAbst cmd = (CmdSeshAbst) getCmdNormal();
		assertEquals(seshName, cmd.getSeshName());
	}

	@Override
	protected void myAddonToFromDocToInstance(CmdAbst cmd) {
		assertEquals(seshName, ((CmdSeshAbst) cmd).getSeshName());
	}
}