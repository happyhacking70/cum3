/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdTestAbst {

	abstract protected CmdAbst getCmdNormal();

	abstract protected CmdAbst getCmdNormal(Document doc)
			throws CumExcpIllegalCmdDoc;

	abstract protected String getXMLNormal();

	abstract protected String getActionName();

	abstract protected CmdTypes getCmdType();

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.CmdAbst#getActionName()}.
	 */
	@Test
	final public void testGetActionName() {
		CmdSeshAbst cmd = (CmdSeshAbst) getCmdNormal();
		assertEquals(getActionName(), cmd.getActionName());
	}

	/**
	 * Test method for {@link jp.happyhacking70.cum3.cmd.CmdAbst#getCmdType()}.
	 */
	@Test
	final public void testGetCmdType() {
		CmdSeshAbst cmd = (CmdSeshAbst) getCmdNormal();
		assertEquals(getCmdType(), cmd.getCmdType());
	}

	/**
	 * Test method for {@link jp.happyhacking70.cum3.cmd.CmdAbst#toXmlStr()}.
	 * 
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	final public void testToXmlStr() throws CumExcpXMLGenFailed {
		CmdAbst cmd = getCmdNormal();
		assertEquals(getXMLNormal(), cmd.toXmlStr());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl#ReqCmdClsChnl(org.w3c.dom.Document)}
	 * .
	 * 
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpXMLGenFailed
	 * @throws CumExcpIllegalCmdDoc
	 */
	@Test
	final public void fromDocToInstance() throws CumExcpIllegalCmdXML,
			CumExcpXMLGenFailed, ParserConfigurationException, SAXException,
			IOException, CumExcpIllegalCmdDoc {

		InputStream bais = new ByteArrayInputStream(getXMLNormal().getBytes(
				"utf-8"));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(bais);

		CmdAbst cmd = getCmdNormal(doc);

		assertEquals(getActionName(), cmd.getActionName());
		assertEquals(getCmdType(), cmd.getCmdType());
		myAddonToFromDocToInstance(cmd);
	}

	abstract protected void myAddonToFromDocToInstance(CmdAbst cmd);
}