/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdChnlAudTestAbst extends CmdChnlTestAbst {
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
		super.myAddonToFromDocToInstance(cmd);
		assertEquals(audName, ((CmdChnlAudAbst) cmd).getAudName());
	}

}
