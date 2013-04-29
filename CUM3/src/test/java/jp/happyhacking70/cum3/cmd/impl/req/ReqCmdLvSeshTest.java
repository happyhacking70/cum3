/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdSeshAudTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdLvSeshTest extends ReqCmdSeshAudTestAbst {
	/**
	 * @throws IOException
	 */
	public ReqCmdLvSeshTest() throws IOException {
		super();
	}

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	@Override
	protected CmdAbst getCmdNormal() {
		return new ReqCmdLvSesh(seshName, audName);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "LvSesh";
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
		return new ReqCmdLvSesh(doc);
	}

}
