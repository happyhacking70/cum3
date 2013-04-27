/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CmdFactory {
	HashMap<String, Class<? extends CmdAbst>> classMap = new HashMap<String, Class<? extends CmdAbst>>();

	public CmdFactory() {
		super();
		setClassMap();
	}

	protected void setClassMap() {
		classMap.put("ReqCmdRegSesh", ReqCmdRegSesh.class);
		classMap.put("ResCmdRegSesh", ResCmdRegSesh.class);
		classMap.put("ReqCmdClsSesh", ReqCmdClsSesh.class);
		classMap.put("ResCmdClsSesh", ResCmdClsSesh.class);
		classMap.put("NtfyCmdClsSesh", NtfyCmdClsSesh.class);
		classMap.put("ReqCmdRegChnl", ReqCmdRegChnl.class);
		classMap.put("ResCmdRegChnl", ResCmdRegChnl.class);
		classMap.put("NtfyCmdRegChnl", NtfyCmdRegChnl.class);
		classMap.put("ReqCmdClsChnl", ReqCmdClsChnl.class);
		classMap.put("ResCmdClsChnl", ResCmdClsChnl.class);
		classMap.put("NtfyCmdClsChnl", NtfyCmdClsChnl.class);
		classMap.put("ReqCmdJoinSesh", ReqCmdJoinSesh.class);
		classMap.put("ResCmdJoinSesh", ResCmdJoinSesh.class);
		classMap.put("NtfyCmdJoinSesh", NtfyCmdJoinSesh.class);
		classMap.put("ReqCmdJoinChnl", ReqCmdJoinChnl.class);
		classMap.put("ResCmdJoinChnl", ResCmdJoinChnl.class);
		classMap.put("NtfyCmdJoinChnl", NtfyCmdJoinChnl.class);
		classMap.put("ReqCmdLvChnl", ReqCmdLvChnl.class);
		classMap.put("ResCmdLvChnl", ResCmdLvChnl.class);
		classMap.put("NtfyCmdLvChnl", NtfyCmdLvChnl.class);
		classMap.put("ReqCmdLvSesh", ReqCmdLvSesh.class);
		classMap.put("ResCmdLvSesh", ResCmdLvSesh.class);
		classMap.put("NtfyCmdLvSesh", NtfyCmdLvSesh.class);
		classMap.put("ReqCmdRjctChnl", ReqCmdRjctChnl.class);
		classMap.put("ResCmdRjctChnl", ResCmdRjctChnl.class);
		classMap.put("NtfyCmdRjctChnl", NtfyCmdRjctChnl.class);

	}

	public CmdAbst getCmdInstance(String xml) throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		Document doc = getDom(xml);
		Node cmdNode = getCmdNode(doc);
		String type = getCmndType(cmdNode);
		String action = getAction(cmdNode);
		Class<? extends CmdAbst> myClass = classMap.get(getClassName(type,
				action));

		Class<?>[] types = new Class[] { Document.class };
		Object[] args = { doc };
		CmdAbst cmd;
		try {
			Constructor<? extends CmdAbst> constructor = myClass
					.getConstructor(types);
			cmd = constructor.newInstance(args);
		} catch (NoSuchMethodException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		} catch (SecurityException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		} catch (InstantiationException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		} catch (IllegalAccessException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		} catch (IllegalArgumentException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		} catch (InvocationTargetException e) {
			throw new CumExcpIllegalCmdDoc(xml);
		}

		return cmd;
	}

	protected String getClassName(String type, String action) {
		return (type + "Cmd" + action);
	}

	protected String getAction(Node cmdNode) {
		return cmdNode.getAttributes().getNamedItem("ACTION").getNodeValue();
	}

	protected String getCmndType(Node cmdNode) throws CumExcpIllegalCmdXML {
		String type = cmdNode.getAttributes().getNamedItem("TYPE")
				.getNodeValue();
		String ret;

		if (type.equals(CmdAbst.CmdTypes.REQ.name())) {
			ret = "Req";
		} else if (type.equals(CmdAbst.CmdTypes.RES.name())) {
			ret = "Res";
		} else if (type.equals(CmdAbst.CmdTypes.NTFY.name())) {
			ret = "Ntfy";
		} else {
			throw new CumExcpIllegalCmdXML("Unkown Type: [" + type + "]");
		}

		return ret;
	}

	protected Node getCmdNode(Document doc) throws CumExcpIllegalCmdDoc {
		Element rootNode = doc.getDocumentElement();
		if (rootNode.getNodeName() != "CUM") {
			throw new CumExcpIllegalCmdDoc("Root is not CUM");
		}

		NodeList nodeList = rootNode.getChildNodes();
		if (nodeList.getLength() != 1) {
			throw new CumExcpIllegalCmdDoc("Num of child node shold be one");
		}
		nodeList = rootNode.getElementsByTagName("CMD");
		if (nodeList.getLength() != 1) {
			throw new CumExcpIllegalCmdDoc("CMD ELEM SHOULD APPER ONCE");
		}
		return nodeList.item(0);

	}

	protected Document getDom(String xml) throws CumExcpIllegalCmdXML {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		// factory.setValidating(true);

		Document doc = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		} catch (UnsupportedEncodingException e) {
			throw new CumExcpIllegalCmdXML(xml);
		} catch (SAXException e) {
			throw new CumExcpIllegalCmdXML(xml);
		} catch (IOException e) {
			throw new CumExcpIllegalCmdXML(xml);
		} catch (ParserConfigurationException e) {
			throw new CumExcpIllegalCmdXML(xml);
		}
		return doc;
	}
}
