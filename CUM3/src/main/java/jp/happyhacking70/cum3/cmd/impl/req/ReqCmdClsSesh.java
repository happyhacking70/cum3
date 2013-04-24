/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ReqCmdSeshAbst;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsSesh extends ReqCmdSeshAbst {

	/**
	 * @param seshName
	 */
	public ReqCmdClsSesh(String seshName) {
		super(seshName);
	}

	/**
	 * @param doc
	 */
	public ReqCmdClsSesh(Document doc) {
		super(doc);
	}

	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsSesh.name();
	}

}
