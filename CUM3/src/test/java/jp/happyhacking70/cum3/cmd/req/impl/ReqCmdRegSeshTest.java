/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req.impl;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdSeshTestAbst;
import jp.happyhacking70.cum3.cmd.req.ReqCmdFromPrestrIntf;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegSeshTest extends ReqCmdSeshTestAbst {
	/**
	 * @throws IOException
	 */
	public ReqCmdRegSeshTest() throws IOException {
		super();
	}

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		return new ReqCmdRegSesh(seshName);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "RegSesh";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdSeshTestAbst#getCmdNormal(org.w3c.dom.Document
	 * )
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) {

		return new ReqCmdRegSesh(doc);
	}

	@Test
	public void checkWhereFrom() {
		CmdAbst cmd = this.getCmdNormal();
		assertTrue(cmd instanceof ReqCmdFromPrestrIntf);
	}

}
