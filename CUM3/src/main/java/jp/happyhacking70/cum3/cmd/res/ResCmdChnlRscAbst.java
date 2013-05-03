/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlRscAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ResCmdChnlRscAbst extends CmdChnlRscAbst implements
		ResCmdIntf {

	protected String rslt;

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ResCmdChnlRscAbst(String seshName, String chnlName, String rslt) {
		super(seshName, chnlName);
		this.rslt = rslt;
	}

	public ResCmdChnlRscAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rsces
	 * @param name
	 */
	public ResCmdChnlRscAbst(String seshName, String chnlName,
			List<ChnlRscIntf> rsces, String rslt) {
		super(seshName, chnlName, rsces);
		this.rslt = rslt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setCmdType()
	 */
	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.RES;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.ResCmdIntf#getRslt()
	 */
	@Override
	public final String getRslt() {
		return rslt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdChnlRscAbst#configureDomCocument(org.w3c
	 * .dom.Element)
	 */
	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);
		cmdElem.setAttribute("RSLT", getRslt());
	}
}
