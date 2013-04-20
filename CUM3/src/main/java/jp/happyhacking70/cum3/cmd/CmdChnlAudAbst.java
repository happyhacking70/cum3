/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdChnlAudAbst extends CmdChnlAbst {
	protected String audName;

	public CmdChnlAudAbst(String seshName, String chnlName, String audName) {
		super(seshName, chnlName);
		this.audName = audName;
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public CmdChnlAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setAudNameFromDoc(doc);
	}

	protected final void setAudNameFromDoc(Document doc) {
		this.audName = getAudNameFromDoc(doc);
	}

	public final String getAudName() {
		return audName;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);
		cmdElem.setAttribute("AUD", getAudName());
	}

	protected static final String getAudNameFromDoc(Document doc) {
		return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
				.getNamedItem("AUD").getNodeValue();
	}
}
