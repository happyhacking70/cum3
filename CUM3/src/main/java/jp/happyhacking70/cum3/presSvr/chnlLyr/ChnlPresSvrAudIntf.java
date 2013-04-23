/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * Add audience to the channel. Notification to Presenter is supposed to be sent
 * by sesh. This should not send notification.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlPresSvrAudIntf {

	/**
	 * <UL>
	 * <LI><B>add audience to channel</B></LI>
	 * <LI><B>return NtfyCmdJoinChnl so that session can sent it to
	 * presenter</B></LI>
	 * </UL>
	 * 
	 * @param aud
	 * @return NtfyCmdJoinChnl
	 * @throws CumExcpAudExists
	 */
	public NtfyCmdJoinChnl joinChnl(AudIntf aud) throws CumExcpAudExists;

	/**
	 * <UL>
	 * <LI><B>remove audience from channel</B></LI>
	 * <LI><B>return NtfyCmdLvChnl so that session can sent it to presenter</B></LI>
	 * </UL>
	 * 
	 * @param aud
	 * @return NtfyCmdLvChnl
	 * @throws CumExcpAudNotExist
	 */
	public NtfyCmdLvChnl lvChnl(AudIntf aud) throws CumExcpAudNotExist;

	/**
	 * <UL>
	 * <LI><B>get channel resource</B></LI>
	 * </UL>
	 * 
	 * @param rscName
	 * @return ChnlRscIntf
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String rscName) throws CumExcpRscNotExist;

	/**
	 * <UL>
	 * <LI><B>just check if audience is new comer</B></LI>
	 * </UL>
	 * 
	 * @param audName
	 * @throws CumExcpAudExists
	 */
	public void rjctChnl(String audName) throws CumExcpAudExists;

}
