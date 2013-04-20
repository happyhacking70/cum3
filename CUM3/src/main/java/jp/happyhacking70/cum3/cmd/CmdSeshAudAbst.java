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
public abstract class CmdSeshAudAbst extends CmdSeshAbst {

	protected String audName;

	public CmdSeshAudAbst(String seshName, String audName) {
		super(seshName);
		this.audName = audName;
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public CmdSeshAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
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
