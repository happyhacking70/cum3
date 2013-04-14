/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import static org.junit.Assert.assertEquals;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdChnlTestAbst;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdClsChnlTest extends ResCmdChnlTestAbst {
	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
	static final ResCmdClsChnl.RsltTypes rslt = ResCmdClsChnl.RsltTypes.Clsed;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		return new ResCmdClsChnl(seshName, chnlName,
				ResCmdClsChnl.RsltTypes.Clsed);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "ClsChnl";
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.ResCmdChnlAbst#getRslt()}.
	 */
	@Test
	public void testGetRslt() {
		assertEquals(((ResCmdClsChnl) getCmdNormal()).getRslt(), rslt.name());
	}
}
