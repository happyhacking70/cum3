/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ntfy.NtfyCmdSeshAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdClsSesh extends NtfyCmdSeshAbst {

	/**
	 * @param seshName
	 */
	public NtfyCmdClsSesh(String seshName) {
		super(seshName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdClsSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsSesh.name();
	}

}
