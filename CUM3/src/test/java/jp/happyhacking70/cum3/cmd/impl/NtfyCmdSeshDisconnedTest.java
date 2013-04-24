/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.NtfyCmdSeshTestAbst;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdSeshDisconned;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdSeshDisconnedTest extends NtfyCmdSeshTestAbst {
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"SeshDisconned\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";

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
		return new NtfyCmdSeshDisconned(seshName);
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
		return "SeshDisconned";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new NtfyCmdSeshDisconned(doc);
	}

}
