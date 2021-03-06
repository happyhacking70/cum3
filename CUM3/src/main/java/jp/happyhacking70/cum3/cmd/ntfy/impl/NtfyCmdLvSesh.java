/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ntfy.NtfyCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdLvSesh extends NtfyCmdSeshAudAbst {

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdLvSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/**
	 * @param seshName
	 * @param audName
	 */
	public NtfyCmdLvSesh(String seshName, String audName) {
		super(seshName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.LvSesh.name();
	}

}
