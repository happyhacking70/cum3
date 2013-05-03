/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.res.ResCmdSeshAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegSesh extends ResCmdSeshAbst {
	public enum RsltTypes {
		Reged, Exists
	}

	/**
	 * @param seshName
	 * @param rslt
	 */
	public ResCmdRegSesh(String seshName, RsltTypes rslt) {
		super(seshName, rslt.name());
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdRegSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.RegSesh.name();
	}

}
