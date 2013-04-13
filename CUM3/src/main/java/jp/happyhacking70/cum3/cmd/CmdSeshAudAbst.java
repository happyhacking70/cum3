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
public abstract class CmdSeshAudAbst extends CmdSeshAbst {

	protected String audName;

	public CmdSeshAudAbst(String seshName, String audName) {
		super(seshName);
		this.audName = audName;
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
}
