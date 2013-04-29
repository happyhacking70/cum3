/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.CmdSeshTestAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdSeshTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsSeshTest extends ReqCmdSeshTestAbst {
	/**
	 * @throws IOException
	 */
	public ReqCmdClsSeshTest() throws IOException {
		super();
	}

	final static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	@Override
	protected CmdAbst getCmdNormal() {
		return new ReqCmdClsSesh(CmdSeshTestAbst.seshName);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "ClsSesh";
	}

	@BeforeClass
	public static final void setBeforeClass() {
		System.out.println(xml);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ReqCmdClsSesh(doc);
	}

}
