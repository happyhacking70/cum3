/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;

import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ResCmdSeshAbst extends CmdSeshAbst implements ResCmdIntf {

	protected String rslt;

	public ResCmdSeshAbst(String seshName, String rslt) {
		super(seshName);
		this.rslt = rslt;
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.RES;
	}

	public final String getRslt() {
		return rslt;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);
		cmdElem.setAttribute("RSLT", getRslt());
	}
}
