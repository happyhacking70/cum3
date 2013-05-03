/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
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
public interface SeshMgrPresSvrAudIntf {

	/**
	 * <UL>
	 * <LI>add audience to session</LI>
	 * <LI>send {@link NtfyCmdJoinSesh} to <U>presenter</U></LI>
	 * <LI>send {@link NtfyCmdRegChnl} to <U>audience</U> for all existing
	 * channels</LI>
	 * </UL>
	 * 
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
	 * <LI>add audience to channel</LI>
	 * <LI>send {@link NtfyCmdJoinChnl} to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * 
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpAudExists
	 */
	public void joinChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudExists,
			CumExcpAudNotExist;

	/**
	 * 
	 * <UL>
	 * <LI>send {@link NtfyCmdRjctChnl} to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 */
	public void rjctChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudExists;

	/**
	 * <UL>
	 * <LI>remove audience from channel</LI>
	 * <LI>send {@link NtfyCmdLvChnl} to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * 
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void lvChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI>remove audience from session</LI>
	 * <LI>let audience leave from all the channels which audience is still
	 * joining</LI>
	 * <LI>no need to send {@link NtfyCmdLvChnl} to <U>presenter</U> because
	 * presenter takes care of it</LI>
	 * <LI>no need to send {@link NtfyCmdLvChnl} to <U>audience</U> because
	 * audience takes care of it</LI>
	 * <LI>send {@link NtfyCmdLvSesh} to <U>presenter</U></LI>
	 * </UL>
	 * 
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
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String seshName, String chnlName, String rscName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpRscNotExist;

}
