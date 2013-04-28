/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPresSvrPrestrIntf {

	/**
	 * <UL>
	 * <LI>create new session</LI>
	 * <LI>register to sessions</LI>
	 * </UL>
	 * 
	 * @param seshName
	 * @param sender
	 * @throws CumExcpSeshExists
	 */
	public void regSesh(String seshName, CmdSenderIntf sender)
			throws CumExcpSeshExists;

	/**
	 * <UL>
	 * <LI>create new channel</LI>
	 * <LI>register to appropriate session</LI>
	 * <LI>send {@link NtfyCmdRegChnl} to <U>session</U> audiences</LI>
	 * </UL>
	 * 
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param lrscesist
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	public void regChnl(String seshName, String chnlName,
			List<ChnlRscIntf> lrscesist) throws CumExcpSeshNotExist,
			CumExcpChnlExists, CumExcpRscExists, CumExcpRscNull;

	/**
	 * <UL>
	 * <LI>send {@link NtfyCmdClsSesh} to <U>session</U> audiences</LI>
	 * <LI>remove session from sessions</LI>
	 * </UL>
	 * 
	 * @param seshName
	 * @throws CumExcpSeshNotExist
	 */
	public void clsSesh(String seshName) throws CumExcpSeshNotExist;

	/**
	 * <UL>
	 * <LI>send command to specific audience of specific <U>channel</U></LI>
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
	 * <LI>send command to all audiences of specific <U>channel</U></LI>
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
	 * <LI>send {@link NtfyCmdClsChnl} to all <U>channel</U> audiences</LI>
	 * <LI>close channel</LI>
	 * </UL>
	 * 
	 * @param seshName
	 * @param chnlName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 */
	public void clsChnl(String seshName, String chnlName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist;

}
