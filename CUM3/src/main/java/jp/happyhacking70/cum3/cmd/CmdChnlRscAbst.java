/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.List;
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
abstract public class CmdChnlRscAbst extends CmdChnlAbst implements
		CmdWithRscIntf {
	final protected CopyOnWriteArrayList<ChnlRscIntf> rscData = new CopyOnWriteArrayList<ChnlRscIntf>();

	public CmdChnlRscAbst(String seshName, String chnlName,
			List<ChnlRscIntf> rsces) {
		super(seshName, chnlName);
		for (ChnlRscIntf rsc : rsces) {
			addRscData(rsc);
		}
	}

	public CmdChnlRscAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdWithRscIntf#addRscData(jp.happyhacking70
	 * .cum3.chnlLyr.rsc.ChnlRscIntf)
	 */
	@Override
	final public void addRscData(ChnlRscIntf chnlRsc) {
		rscData.add(chnlRsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdWithRscIntf#getRscData()
	 */
	@Override
	final public List<ChnlRscIntf> getRscData() {
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
