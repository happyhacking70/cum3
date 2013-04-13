/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdSeshAbst extends CmdSeshAbst implements
		NtfyCmdIntf {

	/**
	 * @param seshName
	 */
	public NtfyCmdSeshAbst(String seshName) {
		super(seshName);
	}

	@Override
	final protected void setCmdType() {
		cmdType = CmdTypes.NTFY;
	}
}
