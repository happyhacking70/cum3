package jp.happyhacking70.cum3.cmd;

import java.io.ByteArrayOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Root of Command Request and Responce
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class CmdAbst implements XMLableCmdIntf {

	public static enum CmdTypes {
		REQ, RES, NTFY
	}

	protected CmdTypes cmdType;

	protected String actionName;

	public CmdAbst() {
		super();

		setCmdType();
		setActionName();
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 */
	public CmdAbst(Document doc) throws CumExcpIllegalCmdDoc {
		setCmdType();
		setActionName();

		Element rootNode = doc.getDocumentElement();
		checkRootName(rootNode);
		checkCmd(rootNode);

		Node cmdNode = rootNode.getElementsByTagName("CMD").item(0);
		checkType(cmdNode);
		checkActionName(cmdNode);
	}

	/**
	 * @param cmdNode
	 * @throws CumExcpIllegalCmdDoc
	 */
	private void checkActionName(Node cmdNode) throws CumExcpIllegalCmdDoc {
		String action = cmdNode.getAttributes().getNamedItem("ACTION")
				.getNodeValue();

		if (action.equals(this.getActionName()) == false) {
			throw new CumExcpIllegalCmdDoc("wrong action: " + action);
		}
	}

	/**
	 * @param item
	 * @throws CumExcpIllegalCmdDoc
	 */
	private void checkType(Node cmdNode) throws CumExcpIllegalCmdDoc {
		String type = cmdNode.getAttributes().getNamedItem("TYPE")
				.getNodeValue();

		if (type.equals(this.getCmdType().name()) == false) {
			throw new CumExcpIllegalCmdDoc("wrong type: " + type);
		}

	}

	/**
	 * @param childNodes
	 * @throws CumExcpIllegalCmdDoc
	 */
	private void checkCmd(Element rootNode) throws CumExcpIllegalCmdDoc {

		if (rootNode.getChildNodes().getLength() != 1) {
			throw new CumExcpIllegalCmdDoc("multiple cmds");
		}

		NodeList cmdNodeList = rootNode.getElementsByTagName("CMD");
		if (cmdNodeList.getLength() != 1) {
			throw new CumExcpIllegalCmdDoc("Cmd Should Appear ONCE");
		}
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpIllegalCmdDoc
	 */
	final protected void checkCmd(Document doc) throws CumExcpIllegalCmdDoc {
		NodeList cmdNodeList = doc.getDocumentElement().getElementsByTagName(
				"CMD");
		if (cmdNodeList.getLength() != 1) {
			throw new CumExcpIllegalCmdDoc(
					"Responce Command Should Appear ONCE");
		}

	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpIllegalCmdDoc
	 */
	final protected void checkRootName(Element rootNode)
			throws CumExcpIllegalCmdDoc {
		if (rootNode.getNodeName() != "CUM") {
			throw new CumExcpIllegalCmdDoc("Root is not CUM");
		}

	}

	abstract protected void setCmdType();

	abstract protected void setActionName();

	public final String getActionName() {
		return actionName;
	}

	public final CmdTypes getCmdType() {
		return cmdType;
	}

	final public String toXmlStr() throws CumExcpXMLGenFailed {
		String xmlStr = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transFactory.newTransformer();

			DOMSource source = new DOMSource(toXmlDom());
			transformer.transform(source, new StreamResult(baos));
			xmlStr = baos.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			throw new CumExcpXMLGenFailed();
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new CumExcpXMLGenFailed();
		}
		return xmlStr;
	}

	public Document toXmlDom() throws CumExcpXMLGenFailed {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new CumExcpXMLGenFailed();
		}
		DOMImplementation domImpl = builder.getDOMImplementation();
		org.w3c.dom.Document document = domImpl.createDocument("", "CUM", null);
		org.w3c.dom.Element root = document.getDocumentElement();

		org.w3c.dom.Element cmdElem = document.createElement("CMD");
		cmdElem.setAttribute("TYPE", cmdType.name());
		cmdElem.setAttribute("ACTION", actionName);

		configureDomCocument(cmdElem);
		root.appendChild(cmdElem);

		return document;
	}

	/**
	 * @param cmdElem
	 */
	abstract protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed;

	// protected NamedNodeMap getAttrs(Document document)
	// throws CumExcpIllegalCmdXML {
	//
	// Element rootNode = document.getDocumentElement();
	//
	// NodeList cmdNodeList = rootNode.getElementsByTagName("CMD");
	// if (cmdNodeList.getLength() != 1) {
	// throw new CumExcpIllegalCmdXML(
	// "Responce Command Should Appear ONCE");
	// }
	//
	// Node cmdNode = cmdNodeList.item(0);
	//
	// return cmdNode.getAttributes();
	// }
}
