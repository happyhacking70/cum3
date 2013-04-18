/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlPrestrIntf {

	/**
	 * @param cmd
	 * @param aud
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, AudIntf aud)
			throws CumExcpAudNotExist;

	/**
	 * @param cmd
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpAudNotExist;

	/**
	 * Notify chnl-close should be sent to all audiences. Since session does not
	 * maintain which audience is joining channel, channel should tell all
	 * audiences that channel should be closed.
	 */
	public void clsChnl();

}
