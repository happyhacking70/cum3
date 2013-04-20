/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

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

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.RES;
	}

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
