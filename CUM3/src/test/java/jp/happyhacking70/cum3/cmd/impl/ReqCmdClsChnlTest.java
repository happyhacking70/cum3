/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlTestAbst;

import org.junit.BeforeClass;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsChnlTest extends ReqCmdChnlTestAbst {
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	// String xmlWrongType =
	// "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
	// String xmlWrongAction =
	// "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChn\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		return new ReqCmdClsChnl(seshName, chnlName);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "ClsChnl";
	}

	// /**
	// * @throws CumExcpIllegalCmdDoc
	// * @throws CumExcpIllegalCmdDoc
	// * @throws ParserConfigurationException
	// * @throws IOException
	// * @throws SAXException
	// * @throws
	// *
	// */
	// @Test(expected = CumExcpIllegalCmdDoc.class)
	// public void testWrongAction() throws ParserConfigurationException,
	// SAXException, IOException, CumExcpIllegalCmdDoc {
	// InputStream bais = new ByteArrayInputStream(
	// xmlWrongAction.getBytes("utf-8"));
	//
	// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// DocumentBuilder builder = factory.newDocumentBuilder();
	// Document doc = builder.parse(bais);
	//
	// try {
	// new ReqCmdClsChnl(doc);
	// } catch (CumExcpIllegalCmdDoc e) {
	// if (e.getMessage().contains("wrong action") == false) {
	// fail();
	// } else {
	// throw e;
	// }
	// }
	// }
	//
	// /**
	// * @throws CumExcpIllegalCmdDoc
	// * @throws CumExcpIllegalCmdDoc
	// * @throws ParserConfigurationException
	// * @throws IOException
	// * @throws SAXException
	// * @throws
	// *
	// */
	// @Test(expected = CumExcpIllegalCmdDoc.class)
	// public void testWrongType() throws ParserConfigurationException,
	// SAXException, IOException, CumExcpIllegalCmdDoc {
	// InputStream bais = new ByteArrayInputStream(
	// xmlWrongType.getBytes("utf-8"));
	//
	// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// DocumentBuilder builder = factory.newDocumentBuilder();
	// Document doc = builder.parse(bais);
	//
	// try {
	// new ReqCmdClsChnl(doc);
	// } catch (CumExcpIllegalCmdDoc e) {
	// if (e.getMessage().contains("wrong type") == false) {
	// fail();
	// } else {
	// throw e;
	// }
	// }
	// }
}
