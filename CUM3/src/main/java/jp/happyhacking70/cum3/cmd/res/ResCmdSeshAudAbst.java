/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res;

import jp.happyhacking70.cum3.cmd.CmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class ResCmdSeshAudAbst extends CmdSeshAudAbst implements
		ResCmdIntf {
	protected String rslt;

	public ResCmdSeshAudAbst(String seshName, String audName, String rslt) {
		super(seshName, audName);
		this.rslt = rslt;
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdSeshAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.RES;
	}

	@Override
	public String getRslt() {
		return rslt;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);
		cmdElem.setAttribute("RSLT", getRslt());
	}
}
