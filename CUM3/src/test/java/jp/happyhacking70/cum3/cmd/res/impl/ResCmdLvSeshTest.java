/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res.impl;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdSeshAudTestAbst;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdLvSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdLvSeshTest extends ResCmdSeshAudTestAbst {

	/**
	 * @throws IOException
	 */
	public ResCmdLvSeshTest() throws IOException {
		super();
	}

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvSesh\" AUD=\"testAudience\" RSLT=\"Left\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
	static final ResCmdLvSesh.RsltTypes rslt = ResCmdLvSesh.RsltTypes.Left;

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

	@Override
	protected CmdAbst getCmdNormal() {
		return new ResCmdLvSesh(seshName, audName, rslt.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ResCmdLvSesh(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.ResCmdTestIntf#getNormalRslt()
	 */
	@Override
	public String getNormalRslt() {
		return rslt.name();

	}

}
