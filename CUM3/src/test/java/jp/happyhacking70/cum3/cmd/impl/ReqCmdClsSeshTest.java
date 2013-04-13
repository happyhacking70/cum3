/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsSeshTest {
	static String seshName = "testSession";
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
	ReqCmdClsSesh cmdByParams = new ReqCmdClsSesh(seshName);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdSeshAbst#getSeshName()}.
	 */
	@Test
	public void testGetSeshName() {
		assertEquals(seshName, cmdByParams.getSeshName());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdAbst#getActionName()}.
	 */
	@Test
	public void testGetActionName() {
		assertEquals("ClsSesh", cmdByParams.getActionName());
	}

	/**
	 * Test method for {@link jp.happyhacking70.cum3.cmd.CmdAbst#getCmdType()}.
	 */
	@Test
	public void testGetCmdType() {
		assertEquals(CmdAbst.CmdTypes.REQ, cmdByParams.getCmdType());
	}

	/**
	 * Test method for {@link jp.happyhacking70.cum3.cmd.CmdAbst#toXmlStr()}.
	 * 
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testToXmlStr() throws CumExcpXMLGenFailed {
		assertEquals(xml, cmdByParams.toXmlStr());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.impl.ReqCmdClsChnl#ReqCmdClsChnl(org.w3c.dom.Document)}
	 * .
	 * 
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testReqCmdClsChnlDocument() throws CumExcpIllegalCmdXML,
			CumExcpXMLGenFailed, ParserConfigurationException, SAXException,
			IOException {

		InputStream bais = new ByteArrayInputStream(xml.getBytes("utf-8"));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(bais);

		ReqCmdClsSesh cmd = new ReqCmdClsSesh(doc);

		assertEquals(seshName, cmd.getSeshName());

	}
}
