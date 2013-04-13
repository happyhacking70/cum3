/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class ReqCmdChnlTestAbst extends CmdChnlTestAbst {

	@Override
	final protected CmdTypes getCmdType() {
		return CmdTypes.REQ;
	}

}
