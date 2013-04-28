/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcptAdptrHdlrNotFound extends CumExcpAbst {
	protected CmdAbst cmd;

	private static final long serialVersionUID = 1L;

	/**
	 * @param cmd
	 */
	public CumExcptAdptrHdlrNotFound(CmdAbst cmd) {
		this.cmd = cmd;
	}

}
