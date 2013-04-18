/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class Aud implements AudIntf {
	protected String audName;
	protected CmdSenderIntf sender;

	public Aud(String audName, CmdSenderIntf sender) {
		super();
		this.audName = audName;
		this.sender = sender;
	}

	public final String getAudName() {
		return audName;
	}

	/**
	 * @param cmd
	 */
	synchronized public void sendCmd(CmdChnlAbst cmd) {
		sender.sendCmd(cmd);
	}

}
