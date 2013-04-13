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
public abstract class CmdChnlTestAbst extends CmdSeshTestAbst {
	static final protected String chnlName = "testChannel";

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdChnlAbst#getChnlName()}.
	 */
	@Test
	public void testGetChnlName() {
		assertEquals(chnlName, ((CmdChnlAbst) getCmdNormal()).getChnlName());
	}

}
