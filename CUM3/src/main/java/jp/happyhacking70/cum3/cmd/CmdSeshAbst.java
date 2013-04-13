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
abstract public class CmdSeshAbst extends CmdAbst {

	protected String seshName;

	public CmdSeshAbst(String seshName) {
		super();
		this.seshName = seshName;
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public CmdSeshAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setSeshNameFromDoc(doc);

	}

	protected final void setSeshNameFromDoc(Document doc) {
		this.seshName = getSeshNameFromDoc(doc);
	}

	public final String getSeshName() {
		return seshName;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		cmdElem.setAttribute("SESH", getSeshName());
	}

	protected static final String getSeshNameFromDoc(Document doc) {
		return doc.getDocumentElement().getChildNodes().item(0).getAttributes()
				.getNamedItem("SESH").getNodeValue();
	}
}
