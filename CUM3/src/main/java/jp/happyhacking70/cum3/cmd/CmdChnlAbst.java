/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdChnlAbst extends CmdSeshAbst {
	protected String chnlName;

	public CmdChnlAbst(String seshName, String chnlName) {
		super(seshName);
		this.chnlName = chnlName;
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public CmdChnlAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setChnlNameFromDoc(doc);
	}

	protected final void setChnlNameFromDoc(Document doc) {
		this.chnlName = getChnlNameFromDoc(doc);
	}

	public final String getChnlName() {
		return chnlName;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);
		cmdElem.setAttribute("CHNL", getChnlName());
	}

	protected static final String getChnlNameFromDoc(Document doc) {
		return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
				.getNamedItem("CHNL").getNodeValue();
	}

}
