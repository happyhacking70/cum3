/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import jp.happyhacking70.cum3.cmd.ReqCmdChnlAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdJoinChnl extends ReqCmdChnlAudAbst {

	public ReqCmdJoinChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	public ReqCmdJoinChnl(String seshName, String chnlName, String audName) {
		super(seshName, chnlName, audName);
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
