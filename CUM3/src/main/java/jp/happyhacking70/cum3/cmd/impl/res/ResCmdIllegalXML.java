/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdIllegalXML extends CmdAbst implements ResCmdIntf {

	public ResCmdIllegalXML() {
		super();
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdIllegalXML(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.ResCmdIntf#getRslt()
	 */
	@Override
	public String getRslt() {
		return "Illegal";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setCmdType()
	 */
	@Override
	protected void setCmdType() {
		cmdType = CmdAbst.CmdTypes.RES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "IllegalXML";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdAbst#configureDomCocument(org.w3c.dom.Element
	 * )
	 */
	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		cmdElem.setAttribute("RSLT", getRslt());
	}

}
