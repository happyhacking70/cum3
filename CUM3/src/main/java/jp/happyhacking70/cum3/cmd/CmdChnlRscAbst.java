/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.concurrent.CopyOnWriteArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscJustName;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdChnlRscAbst extends CmdChnlAbst {
	final protected CopyOnWriteArrayList<ChnlRscIntf> rscData = new CopyOnWriteArrayList<ChnlRscIntf>();

	public CmdChnlRscAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	// /**
	// * @param doc
	// * @throws CumExcpIllegalCmdDoc
	// */
	// public CmdChnlRscAbst(Document doc, ArrayList<ChnlRscIntf> rsces)
	// throws CumExcpIllegalCmdDoc {
	// super(doc);
	// setChnlNameFromDoc(rsces);
	// }
	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public CmdChnlRscAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setChnlNameFromDoc(doc);
		if (cmdType == CmdAbst.CmdTypes.NTFY || cmdType == CmdAbst.CmdTypes.RES) {
			setRscFromDoc(doc);
		}
	}

	// protected static final String getChnlNameFromDoc(Document doc) {
	// return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
	// .getNamedItem("CHNL").getNodeValue();
	// }

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	protected void setRscFromDoc(Document doc) throws CumExcpIllegalCmdDoc {
		NodeList nodes = doc.getDocumentElement().getChildNodes().item(0)
				.getChildNodes();

		Node node;
		for (int i = 0; i < nodes.getLength(); ++i) {
			node = nodes.item(i);
			addRscData(new ChnlRscJustName(getRscName(node)));
		}
	}

	final protected String getRscName(Node node) throws CumExcpIllegalCmdDoc {
		if (node.getNodeName() != "RSC") {
			throw new CumExcpIllegalCmdDoc("Unknow Child:" + node.getNodeName());
		}
		NamedNodeMap attrs = node.getAttributes();
		Node n = attrs.getNamedItem("NAME");
		if (n == null) {
			throw new CumExcpIllegalCmdDoc("NoRscName");
		}
		return n.getNodeValue();
	}

	final public void addRscData(ChnlRscIntf chnlRsc) {
		rscData.add(chnlRsc);
	}

	final public CopyOnWriteArrayList<ChnlRscIntf> getRscData() {
		return rscData;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);

		for (ChnlRscIntf chnl : rscData) {
			Element rscElem = cmdElem.getOwnerDocument().createElement("RSC");
			rscElem.setAttribute("NAME", chnl.getName());
			cmdElem.appendChild(rscElem);
		}
	}

}
