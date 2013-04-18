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
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshPrestrIntf {

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsSesh to all <U>session</U> audiences<B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdClsSesh
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
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void regChnl(String chnlName, ArrayList<ChnlRscIntf> chnlRsces)
			throws CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpChnlNotEixt, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>send NtfyCmdClsChnl to all <U>channel</U> audiences<B></LI>
	 * <LI><B>close channel<B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdClsChnl
	 * 
	 * @param chnlName
	 * 
	 * @throws CumExcpChnlNotEixt
	 */
	public void clsChnl(String chnlName) throws CumExcpChnlNotEixt;

	/**
	 * <UL>
	 * <LI><B>send command to <U>specific</U> audience<B></LI>
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
	 * <LI><B>send command to all <U>channel</U> audiences<B></LI>
	 * </UL>
	 * 
	 * @param cmd
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpChnlNotEixt,
			CumExcpAudNotExist;

}
