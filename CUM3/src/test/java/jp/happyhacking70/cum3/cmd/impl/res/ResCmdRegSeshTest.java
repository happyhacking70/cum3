/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdSeshTestAbst;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegSeshTest extends ResCmdSeshTestAbst {

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegSesh\" RSLT=\"Reged\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
	static final ResCmdRegSesh.RsltTypes rslt = ResCmdRegSesh.RsltTypes.Reged;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		return new ResCmdRegSesh(seshName, rslt);
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
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ResCmdRegSesh(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.ResCmdTestIntf#getNormalRslt()
	 */
	public String getNormalRslt() {
		return rslt.name();

	}
}