/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.NtfyCmdChnlAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdLvChnl extends NtfyCmdChnlAudAbst {

	public NtfyCmdLvChnl(String seshName, String chnlName, String audName) {
		super(seshName, chnlName, audName);
	}

	public NtfyCmdLvChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "LvChnl";
	}
}
