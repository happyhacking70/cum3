/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import static org.junit.Assert.assertEquals;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.cmd.CmdTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdXMLGenFailedTest extends CmdTestAbst {
	static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"XMLGenFailed\" RSLT=\"Failed\" TYPE=\"RES\"/></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testStaticXml() {
		assertEquals(xml, ResCmdXMLGenFailed.xml);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal()
	 */
	@Override
	protected CmdAbst getCmdNormal() {
		return new ResCmdXMLGenFailed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ResCmdXMLGenFailed(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getXMLNormal()
	 */
	@Override
	protected String getXMLNormal() {
		return xml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getActionName()
	 */
	@Override
	protected String getActionName() {
		return "XMLGenFailed";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdType()
	 */
	@Override
	protected CmdTypes getCmdType() {
		return CmdAbst.CmdTypes.RES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#myAddonToFromDocToInstance(jp.
	 * happyhacking70.cum3.cmd.CmdAbst)
	 */
	@Override
	protected void myAddonToFromDocToInstance(CmdAbst cmd) {

	}

}
