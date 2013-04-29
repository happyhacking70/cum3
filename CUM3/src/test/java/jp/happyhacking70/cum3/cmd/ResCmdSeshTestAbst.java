/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ResCmdSeshTestAbst extends CmdSeshTestAbst implements
		ResCmdTestIntf {
	/**
	 * @throws IOException
	 */
	public ResCmdSeshTestAbst() throws IOException {
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
