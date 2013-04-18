/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshAudIntf {

	/**
	 * <UL>
	 * <LI><B>add audience to session</B></LI>
	 * <LI><B>send NtfyCmdJoinSesh to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdJoinSesh
	 * 
	 * @param audName
	 * @param sender
	 * @throws CumExcpAudExists
	 */
	public void joinSesh(String audName, CmdSenderIntf sender)
			throws CumExcpAudExists;

	/**
	 * <UL>
	 * <LI><B>remove audience from session</B></LI>
	 * <LI><B>send NtfyCmdLvSesh to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdLvSesh
	 * 
	 * @param audName
	 * @throws CumExcpAudNotExist
	 */
	public void lvSesh(String audName) throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>add audience to channel</B></LI>
	 * <LI><B>send NtfyCmdJoinChnl to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdJoinChnl
	 * 
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpAudExists
	 */
	public void joinChnl(String chnlName, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpAudExists;

	/**
	 * <UL>
	 * <LI><B>remove audience from channel</B></LI>
	 * <LI><B>send NtfyCmdLvChnl to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdLvChnl
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void lvChnl(String seshName, String chnlName, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist;

	/**
	 * get channel resource
	 * 
	 * @param chnlName
	 * @param rscName
	 * @return channel resource
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String chnlName, String rscName)
			throws CumExcpChnlNotEixt, CumExcpRscNotExist;

}
