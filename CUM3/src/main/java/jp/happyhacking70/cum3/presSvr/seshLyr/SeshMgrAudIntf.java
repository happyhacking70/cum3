/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
/**
 * @author happyhacking70@gmail.com
 *
 */
/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrAudIntf {

	/**
	 * <UL>
	 * <LI><B>add audience to session</B></LI>
	 * <LI><B>send NtfyCmdJoinSesh to <U>presenter</U></B></LI>
	 * <LI><B>send NtfyCmdRegChnl to <U>audience</U> for all existing
	 * channels</B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdJoinSesh
	 * @see NtfyCmdRegChnl
	 * 
	 * @param seshName
	 * @param audName
	 * @param sender
	 * @throws CumExcpAudExists
	 * @throws CumExcpSeshNotExist
	 */
	public void joinSesh(String seshName, String audName, CmdSenderIntf sender)
			throws CumExcpSeshNotExist, CumExcpAudExists;

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
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpAudExists
	 */
	public void joinChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudExists,
			CumExcpAudNotExist;

	/**
	 * 
	 * <UL>
	 * <LI><B>send NtfyCmdRjctChnl to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdRjctChnl
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 */
	public void rjctChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudExists;

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
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	public void lvChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>remove audience from session</B></LI>
	 * <LI><B>let audience leave from all the channels which audience is still
	 * joining</B></LI>
	 * <LI><B>no need to send NtfyCmdLvChnl to <U>presenter</U> because
	 * presenter takes care of it</B></LI>
	 * <LI><B>no need to send NtfyCmdLvChnl to <U>audience</U> because audience
	 * takes care of it</B></LI>
	 * <LI><B>send NtfyCmdLvSesh to <U>presenter</U></B></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdLvChnl
	 * @see NtfyCmdLvSesh
	 * 
	 * @param audName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void lvSesh(String seshName, String audName)
			throws CumExcpSeshNotExist, CumExcpAudNotExist;

	/**
	 * get channel resource
	 * 
	 * @param chnlName
	 * @param rscName
	 * @return channel resource
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String seshName, String chnlName, String rscName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpRscNotExist;

}
