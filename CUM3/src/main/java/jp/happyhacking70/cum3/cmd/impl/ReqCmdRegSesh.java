/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.ReqCmdSeshAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegSesh extends ReqCmdSeshAbst {

	/**
	 * @param seshName
	 */
	public ReqCmdRegSesh(String seshName) {
		super(seshName);
	}

	@Override
	protected void setActionName() {
		actionName = "RegSesh";
	}

}
