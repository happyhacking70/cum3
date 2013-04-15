/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdClsChnl;
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

	public void clsChnl(String seshName, String chnlName) {
		ReqCmdClsChnl cmd = new ReqCmdClsChnl(seshName, chnlName);
		sender.sendCmd(cmd);
	}

	/**
	 * @param cmd
	 */
	public void sendCmd(CmdAbst cmd) {
		sender.sendCmd(cmd);
	}

}
