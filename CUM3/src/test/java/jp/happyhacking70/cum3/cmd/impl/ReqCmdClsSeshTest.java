/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;

import org.junit.BeforeClass;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsSeshTest extends ReqCmdSeshTestAbst {
	final static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	@Override
	CmdAbst getCmdNormal() {
		return new ReqCmdClsSesh(seshName);
	}

	@Override
	String getXMLNormal() {
		return xml;
	}

	@BeforeClass
	public static final void setBeforeClass() {
		System.out.println(xml);
	}

	@Override
	String getActionName() {
		return "ClsSesh";
	}

}
