/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlPrestrIntf {

	/**
	 * <UL>
	 * <LI><B>send command to <U>specific</U> audience</B></LI>
	 * </UL>
	 * 
	 * 
	 * @param cmd
	 * @param aud
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, AudIntf aud)
			throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send command to all <U>channel</U> audiences</B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsChnl to all <U>channel</U> audiences</B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdClsChnl
	 */
	public void clsChnl();

	/**
	 * returns NtfyCmdRegChnl so that session can send it to all <U>session</U>
	 * audiences
	 * 
	 * @return NtfyCmdRegChnl
	 */
	public NtfyCmdRegChnl getNtfyCmdRegChnl();

}
