/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ReqCmdSeshTestAbst extends CmdSeshTestAbst {

	@Override
	final CmdTypes getCmdType() {
		return CmdTypes.REQ;
	}

}
