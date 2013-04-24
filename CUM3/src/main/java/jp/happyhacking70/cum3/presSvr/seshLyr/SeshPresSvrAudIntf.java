/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshPresSvrAudIntf {

	/**
	 * <UL>
	 * <LI>add audience to session</LI>
	 * <LI>send NtfyCmdJoinSesh to <U>presenter</U></LI>
	 * <LI>send NtfyCmdRegChnl to <U>audience</U> for all existing channels</LI>
	 * </UL>
	 * 
	 * @see NtfyCmdJoinSesh
	 * @see NtfyCmdRegChnl
	 * 
	 * @param audName
	 * @param sender
	 * @throws CumExcpAudExists
	 */
	public void joinSesh(String audName, CmdSenderAbst sender)
			throws CumExcpAudExists;

	/**
	 * <UL>
	 * <LI>remove audience from session</LI>
	 * <LI>let audience leave from all the channels which audience is still
	 * joining</LI>
	 * <LI>no need to send NtfyCmdLvChnl to <U>presenter</U> because presenter
	 * takes care of it</LI>
	 * <LI>no need to send NtfyCmdLvChnl to <U>audience</U> because audience
	 * takes care of it</LI>
	 * <LI>send NtfyCmdLvSesh to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdLvChnl
	 * @see NtfyCmdLvSesh
	 * 
	 * @param audName
	 * @throws CumExcpAudNotExist
	 */
	public void lvSesh(String audName) throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI>add audience to channel</LI>
	 * <LI>send NtfyCmdJoinChnl to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdJoinChnl
	 * 
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpAudExists
	 */
	public void joinChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudNotExist, CumExcpAudExists;

	/**
	 * <UL>
	 * <LI>remove audience from channel</LI>
	 * <LI>send NtfyCmdLvChnl to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdLvChnl
	 * 
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	public void lvChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI>checks if audience is new comer</LI>
	 * <LI>send NtfyCmdRjctChnl to <U>presenter</U></LI>
	 * </UL>
	 * 
	 * @see NtfyCmdRjctChnl
	 * 
	 * @param chnlName
	 * @param audName
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudExists
	 */
	public void rjctChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudExists;

	/**
	 * get channel resource
	 * 
	 * @param chnlName
	 * @param rscName
	 * @return channel resource
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String chnlName, String rscName)
			throws CumExcpChnlNotExist, CumExcpRscNotExist;

}
