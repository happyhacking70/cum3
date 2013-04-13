/**
 * 
 */
package jp.happyhacking70.cum3.cmd;


/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ReqCmdSeshAudAbst extends CmdSeshAudAbst implements
		ReqCmdIntf {

	/**
	 * @param seshName
	 * @param audName
	 */
	public ReqCmdSeshAudAbst(String seshName, String audName) {
		super(seshName, audName);
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.REQ;
	}

}
