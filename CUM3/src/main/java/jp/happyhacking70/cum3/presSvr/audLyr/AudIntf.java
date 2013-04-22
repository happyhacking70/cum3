/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdAudDisconned;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface AudIntf {

	/**
	 * @return Audience Name
	 */
	String getAudName();

	/**
	 * <UL>
	 * <LI>send command to audience</LI>
	 * </UL>
	 * <BR>
	 * <BR>
	 * 
	 * if communication error occurs:<BR>
	 * <UL>
	 * <LI>send {@link NtfyCmdAudDisconned} to presenter</LI>
	 * <LI>remove audience from session and channels</LI>
	 * </UL>
	 * 
	 * @param cmd
	 */
	public void sendCmd(CmdAbst cmd);

}
