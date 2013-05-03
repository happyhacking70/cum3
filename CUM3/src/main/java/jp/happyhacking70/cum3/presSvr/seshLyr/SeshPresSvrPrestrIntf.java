/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshPresSvrPrestrIntf {

	/**
	 * <UL>
	 * <LI>send {@link NtfyCmdClsSesh} to all <U>session</U> audiences</LI>
	 * <LI>no need to send {@link NtfyCmdClsChnl} to presenter because presenter
	 * takes care of closing channels when session is closed</LI>
	 * <LI>no need to send {@link NtfyCmdClsChnl} to audiences because audience
	 * takes care of closing channels when session is closed</LI>
	 * </UL>
	 * 
	 * 
	 */
	public void clsSesh();

	/**
	 * <UL>
	 * <LI>Create new channel</LI>
	 * <LI>Send {@link NtfyCmdRegChnl} to <U>session</U> audiences</LI>
	 * </UL>
	 * 
	 * @param chnlName
	 * @param chnlRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	public void regChnl(String chnlName, List<ChnlRscIntf> chnlRsces)
			throws CumExcpChnlExists, CumExcpRscExists, CumExcpRscNull;

	/**
	 * <UL>
	 * <LI>send {@link NtfyCmdClsChnl} to all <U>session</U> audiences</LI>
	 * <LI>close channel</LI>
	 * </UL>
	 * Even audience rejected channel, audience will maintain channel so that
	 * he/she can join later. Audience should be notified when channel is
	 * closed.
	 * 
	 * @param chnlName
	 * 
	 */
	public void clsChnl(String chnlName) throws CumExcpChnlNotExist;

	/**
	 * <UL>
	 * <LI>send command to <U>specific</U> audience</LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @param audName
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpChnlNotExist, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI>send command to all <U>channel</U> audiences</LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpChnlNotExist,
			CumExcpAudNotExist;

}
