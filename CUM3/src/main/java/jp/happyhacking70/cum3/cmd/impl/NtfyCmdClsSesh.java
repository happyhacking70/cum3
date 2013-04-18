/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.NtfyCmdSeshAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdClsSesh extends NtfyCmdSeshAbst {

	/**
	 * @param seshName
	 */
	public NtfyCmdClsSesh(String seshName) {
		super(seshName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "ClsSesh";
	}

}
