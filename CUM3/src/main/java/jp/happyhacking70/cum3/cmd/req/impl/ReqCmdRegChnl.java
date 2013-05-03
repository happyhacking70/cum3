/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.req.ReqCmdChnlRscAbst;
import jp.happyhacking70.cum3.cmd.req.ReqCmdFromPrestrIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegChnl extends ReqCmdChnlRscAbst implements
		ReqCmdFromPrestrIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdRegChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @param doc
	 * @param rcses
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ReqCmdRegChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.RegChnl.name();

	}

}
