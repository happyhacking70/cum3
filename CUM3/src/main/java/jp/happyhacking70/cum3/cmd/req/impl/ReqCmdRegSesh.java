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
public class ReqCmdRegSesh extends ReqCmdSeshAbst implements ReqCmdFromPrestrIntf {

	/**
	 * @param seshName
	 */
	public ReqCmdRegSesh(String seshName) {
		super(seshName);
	}

	/**
	 * @param doc
	 */
	public ReqCmdRegSesh(Document doc) {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.RegSesh.name();
	}

}
