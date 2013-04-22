/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshPrestrIntf {

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsSesh to all <U>session</U> audiences</B></LI>
	 * <LI><B>no need to send NtfyCmdClsChnl to presenter because presenter
	 * takes care of closing channels when session is closed</B></LI>
	 * <LI><B>no need to send NtfyCmdClsChnl to audiences because audience takes
	 * care of closing channels when session is closed</B></LI>
	 * </UL>
	 * 
	 * 
	 * @see NtfyCmdClsSesh
	 * @see NtfyCmdClsChnl
	 * 
	 */
	public void clsSesh();

	/**
	 * <UL>
	 * <LI><B>Create new channel</B></LI>
	 * <LI><B>Send NtfyCmdRegChnl to <U>session</U> audiences</B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdRegChnl
	 * 
	 * @param chnlName
	 * @param chnlRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	public void regChnl(String chnlName, ArrayList<ChnlRscIntf> chnlRsces)
			throws CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull;

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsChnl to all <U>session</U> audiences</B></LI>
	 * <LI><B>close channel</B></LI>
	 * </UL>
	 * Even audience rejected channel, audience will maintain channel so that
	 * he/she can join later. Audience should be notified when channel is
	 * closed.
	 * 
	 * @see NtfyCmdClsChnl
	 * 
	 * @param chnlName
	 * 
	 */
	public void clsChnl(String chnlName) throws CumExcpChnlNotEixt;

	/**
	 * <UL>
	 * <LI><B>send command to <U>specific</U> audience</B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @param audName
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send command to all <U>channel</U> audiences</B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpChnlNotEixt,
			CumExcpAudNotExist;

}
