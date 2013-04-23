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
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPresSvrPrestrIntf {

	/**
	 * <UL>
	 * <LI><B>create new session</B></LI>
	 * <LI><B> register to sessions</B></LI>
	 * </UL>
	 * 
	 * @param seshName
	 * @param sender
	 * @throws CumExcpSeshExists
	 */
	public void regSesh(String seshName, CmdSenderAbst sender)
			throws CumExcpSeshExists;

	/**
	 * <UL>
	 * <LI><B>create new channel</B></LI>
	 * <LI><B>register to appropriate session</B></LI>
	 * <LI><B>send NtfyCmdRegChnl to <U>session</U> audiences </B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdRegChnl
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param chnlRsces
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	public void regChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpSeshNotExist,
			CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull;

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsSesh to <U>session</U> audiences </B></LI>
	 * <LI><B>remove session from sessions</B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdClsSesh
	 * @param seshName
	 * @throws CumExcpSeshNotExist
	 */
	public void clsSesh(String seshName) throws CumExcpSeshNotExist;

	/**
	 * <UL>
	 * <LI><B>send command to specific audience of specific <U>channel</U> </B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @param audName
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpSeshNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send command to all audiences of specific <U>channel</U> </B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpSeshNotExist,
			CumExcpChnlNotExist, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsChnl to all <U>channel</U> audiences</B></LI>
	 * <LI><B>close channel</B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdClsChnl
	 * @param seshName
	 * @param chnlName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 */
	public void clsChnl(String seshName, String chnlName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist;

}
