/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req.impl;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.req.ReqCmdFromPrestrIntf;
import jp.happyhacking70.cum3.cmd.req.ReqCmdSeshAbst;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsSesh extends ReqCmdSeshAbst implements
		ReqCmdFromPrestrIntf {

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
