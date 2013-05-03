/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.req.ReqCmdFromAudIntf;
import jp.happyhacking70.cum3.cmd.req.ReqCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdJoinSesh extends ReqCmdSeshAudAbst implements
		ReqCmdFromAudIntf {

	/**
	 * @param seshName
	 * @param audName
	 */
	public ReqCmdJoinSesh(String seshName, String audName) {
		super(seshName, audName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ReqCmdJoinSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setActionName() {
		actionName = CmdActions.JoinSesh.name();
	}

}
