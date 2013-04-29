/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdSeshTestAbst extends CmdSeshTestAbst {

	/**
	 * @throws IOException
	 */
	public NtfyCmdSeshTestAbst() throws IOException {
		super();
	}

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
