/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdChnlTestAbst extends CmdChnlTestAbst {

	@Override
	final protected CmdTypes getCmdType() {
		return CmdTypes.NTFY;
	}

}