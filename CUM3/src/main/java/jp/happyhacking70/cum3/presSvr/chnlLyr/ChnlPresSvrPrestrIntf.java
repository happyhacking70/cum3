/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlPresSvrPrestrIntf {

	/**
	 * <UL>
	 * <LI>send command to <U>specific</U> audience</LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @param name
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, String name)
			throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI>send command to all <U>channel</U> audiences</LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpAudNotExist;

	/**
	 * returns NtfyCmdRegChnl so that session can send it to all <U>session</U>
	 * audiences
	 * 
	 * @return NtfyCmdRegChnl
	 */
	public NtfyCmdRegChnl getNtfyCmdRegChnl();

	/**
	 * returns NtfyCmdClsChnl so that session can send it to all <U>session</U>
	 * audiences
	 * 
	 * @return NtfyCmdClsChnl
	 */
	public NtfyCmdClsChnl getNtfyCmdClsChnl();
}
