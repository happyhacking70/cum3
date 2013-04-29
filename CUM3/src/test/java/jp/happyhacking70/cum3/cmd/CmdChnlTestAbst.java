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
public abstract class CmdChnlTestAbst extends CmdSeshTestAbst {
	/**
	 * @throws IOException
	 */
	public CmdChnlTestAbst() throws IOException {
		super();
	}

	static final protected String chnlName = "testChannel";

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdChnlAbst#getChnlName()}.
	 */
	@Test
	public void testGetChnlName() {
		assertEquals(chnlName, ((CmdChnlAbst) getCmdNormal()).getChnlName());
	}

	@Override
	protected void myAddonToFromDocToInstance(CmdAbst cmd) {
		super.myAddonToFromDocToInstance(cmd);
		assertEquals(chnlName, ((CmdChnlAbst) cmd).getChnlName());
	}

}
