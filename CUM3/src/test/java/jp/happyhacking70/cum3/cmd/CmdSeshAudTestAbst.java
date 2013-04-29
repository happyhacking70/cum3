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
abstract public class CmdSeshAudTestAbst extends CmdSeshTestAbst {
	/**
	 * @throws IOException
	 */
	public CmdSeshAudTestAbst() throws IOException {
		super();
	}

	static final protected String audName = "testAudience";

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdChnlAbst#getChnlName()}.
	 */
	@Test
	public void testGetAudName() {
		assertEquals(audName, ((CmdSeshAudAbst) getCmdNormal()).getAudName());
	}

	@Override
	protected void myAddonToFromDocToInstance(CmdAbst cmd) {
		super.myAddonToFromDocToInstance(cmd);
		assertEquals(audName, ((CmdSeshAudAbst) cmd).getAudName());

	}
}
