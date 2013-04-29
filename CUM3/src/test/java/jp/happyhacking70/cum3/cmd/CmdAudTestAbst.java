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
abstract public class CmdAudTestAbst extends CmdTestAbst {
	/**
	 * @throws IOException
	 */
	public CmdAudTestAbst() throws IOException {
		super();
	}

	static final protected String audName = "testAudience";

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdChnlAbst#getChnlName()}.
	 */
	@Test
	public void testGetAudName() {
		assertEquals(audName, ((CmdChnlAudAbst) getCmdNormal()).getAudName());
	}

	@Override
	protected void myAddonToFromDocToInstance(CmdAbst cmd) {
		assertEquals(audName, ((CmdChnlAudAbst) cmd).getAudName());
	}

}
