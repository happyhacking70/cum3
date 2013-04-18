/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdSeshTestAbst extends CmdSeshTestAbst {

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdSeshTestAbst#getCmdType()
	 */
	@Override
	protected CmdTypes getCmdType() {
		return CmdTypes.NTFY;
	}

}
