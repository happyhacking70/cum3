/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.cmd.res.ResCmdIntf;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ResCmdSeshAudTestAbst extends CmdSeshAudTestAbst
		implements ResCmdTestIntf {
	/**
	 * @throws IOException
	 */
	public ResCmdSeshAudTestAbst() throws IOException {
		super();
	}

	@Override
	final protected CmdTypes getCmdType() {
		return CmdTypes.RES;
	}

	@Override
	@Test
	final public void testGetRslt() {
		assertEquals(((ResCmdIntf) getCmdNormal()).getRslt(), getNormalRslt());

	}
}
