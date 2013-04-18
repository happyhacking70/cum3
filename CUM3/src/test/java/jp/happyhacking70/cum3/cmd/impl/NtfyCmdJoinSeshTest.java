/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.NtfyCmdSeshAudTestAbst;

import org.junit.BeforeClass;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdJoinSeshTest extends NtfyCmdSeshAudTestAbst {
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdSeshTestAbst#getCmdNormal()
	 */
	@Override
	protected CmdAbst getCmdNormal() {
		NtfyCmdJoinSesh cmd = new NtfyCmdJoinSesh(seshName, audName);
		return cmd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdSeshTestAbst#getXMLNormal()
	 */
	@Override
	protected String getXMLNormal() {
		return xml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdSeshTestAbst#getActionName()
	 */
	@Override
	protected String getActionName() {
		return "JoinSesh";
	}

}
