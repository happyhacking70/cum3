/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy.impl;

import jp.happyhacking70.cum3.cmd.ntfy.NtfyCmdAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdAudDisconned extends NtfyCmdAudAbst {
	protected String audName;

	/**
	 * @param audName
	 */
	public NtfyCmdAudDisconned(String audName) {
		super(audName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdAudDisconned(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
		setAudNameFromDoc(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "AudDisconned";

	}

}
