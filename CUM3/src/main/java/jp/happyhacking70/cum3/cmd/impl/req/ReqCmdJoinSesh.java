/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.PrstCmdIntf;
import jp.happyhacking70.cum3.cmd.ReqCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdJoinSesh extends ReqCmdSeshAudAbst implements PrstCmdIntf {

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
