/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class Aud implements AudIntf {
	protected String audName;
	protected CmdSenderAbst sender;

	/**
	 * @param audName
	 * @param sender
	 */
	public Aud(String audName, CmdSenderAbst sender) {
		super();
		this.audName = audName;
		this.sender = sender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.audLyr.AudIntf#getAudName()
	 */
	@Override
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
	@Override
	synchronized public void sendCmd(CmdAbst cmd) {
		sender.sendCmd(cmd);
	}
}
