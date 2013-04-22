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

	/**
	 * @param audName
	 * @param sender
	 * @param acpter
	 */
	public Aud(String audName, CmdSenderIntf sender, AcptAudDisconnedIntf acpter) {
		super();
		this.audName = audName;
		this.sender = sender;
		this.acpter = acpter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.audLyr.AudIntf#getAudName()
	 */
	public final String getAudName() {
		return audName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.audLyr.AudIntf#sendCmd(jp.happyhacking70
	 * .cum3.cmd.CmdAbst)
	 */
	synchronized public void sendCmd(CmdAbst cmd) {
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			acpter.acceptAudDisconned(audName);
		}
	}
}
