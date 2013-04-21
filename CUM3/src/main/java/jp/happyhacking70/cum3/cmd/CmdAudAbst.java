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
abstract public class CmdAudAbst extends CmdAbst {

	protected String audName;

	public CmdAudAbst(String audName) {
		super();
		this.audName = audName;
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public CmdAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setSeshNameFromDoc(doc);

	}

	protected final void setSeshNameFromDoc(Document doc) {
		this.audName = getSeshNameFromDoc(doc);
	}

	public final String getAudName() {
		return audName;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		cmdElem.setAttribute("AUD", getAudName());
	}

	protected static final String getSeshNameFromDoc(Document doc) {
		return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
				.getNamedItem("AUD").getNodeValue();
	}

	/**
	 * @param doc
	 */
	protected final void setAudNameFromDoc(Document doc) {
		this.audName = getAudNameFromDoc(doc);
	}

	/**
	 * @param doc
	 * @return audience name
	 */
	protected static final String getAudNameFromDoc(Document doc) {
		return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
				.getNamedItem("AUD").getNodeValue();
	}

}
