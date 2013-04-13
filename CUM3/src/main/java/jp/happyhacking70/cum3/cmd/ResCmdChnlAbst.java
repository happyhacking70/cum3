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
public abstract class ResCmdChnlAbst extends CmdChnlAbst implements ResCmdIntf {

	protected String rslt;

	public ResCmdChnlAbst(String seshName, String chnlName, String rslt) {
		super(seshName, chnlName);
		this.rslt = rslt;
	}

	@Override
	final protected void setCmdType() {
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
