/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.AcptAudDisconnedIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class Aud implements AudIntf {
	protected String audName;
	protected CmdSenderIntf sender;
	protected AcptAudDisconnedIntf acpter;

	public Aud(String audName, CmdSenderIntf sender, AcptAudDisconnedIntf acpter) {
		super();
		this.audName = audName;
		this.sender = sender;
		this.acpter = acpter;
	}

	public final String getAudName() {
		return audName;
	}

	/**
	 * @param cmd
	 * @throws CumExcpComError
	 */
	synchronized public void sendCmd(CmdAbst cmd) {
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			acpter.acceptAudDisconned(audName);
		}
	}
}
