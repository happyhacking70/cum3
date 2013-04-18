/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.NtfyCmdChnlAudAbst;
import jp.happyhacking70.cum3.excp.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdJoinChnl extends NtfyCmdChnlAudAbst {

	/**
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 */
	public NtfyCmdJoinChnl(String seshName, String chnlName, String audName) {
		super(seshName, chnlName, audName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdJoinChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "JoinChnl";
	}

}
