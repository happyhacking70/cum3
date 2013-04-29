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
abstract public class NtfyCmdSeshAudTestAbst extends CmdSeshAudTestAbst {
	/**
	 * @throws IOException
	 */
	public NtfyCmdSeshAudTestAbst() throws IOException {
		super();
	}

	@Override
	final protected CmdTypes getCmdType() {
		return CmdTypes.NTFY;
	}

}
