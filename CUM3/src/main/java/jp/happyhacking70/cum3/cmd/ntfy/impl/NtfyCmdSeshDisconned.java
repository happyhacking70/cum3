/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy.impl;

import jp.happyhacking70.cum3.cmd.ntfy.NtfyCmdSeshAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdSeshDisconned extends NtfyCmdSeshAbst {

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdSeshDisconned(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	public NtfyCmdSeshDisconned(String seshName) {
		super(seshName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "SeshDisconned";

	}

}
