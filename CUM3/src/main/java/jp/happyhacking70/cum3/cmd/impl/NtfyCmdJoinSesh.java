/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.NtfyCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdJoinSesh extends NtfyCmdSeshAudAbst {

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdJoinSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/**
	 * @param seshName
	 * @param audName
	 */
	public NtfyCmdJoinSesh(String seshName, String audName) {
		super(seshName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "JoinSesh";
	}

}
