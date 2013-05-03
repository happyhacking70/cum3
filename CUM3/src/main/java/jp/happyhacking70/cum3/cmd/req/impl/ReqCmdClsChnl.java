/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.req.ReqCmdChnlAbst;
import jp.happyhacking70.cum3.cmd.req.ReqCmdFromPrestrIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsChnl extends ReqCmdChnlAbst implements
		ReqCmdFromPrestrIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdClsChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	public ReqCmdClsChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);

	}

	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsChnl.name();
	}

}
