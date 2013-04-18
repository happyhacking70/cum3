/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * Add audience to the channel. Notification to Presenter is supposed to be sent
 * by sesh. This should not send notification.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlAudIntf {

	/**
	 * 
	 * 
	 * @param aud
	 * @return
	 * @throws CumExcpAudExists
	 */
	public NtfyCmdJoinChnl joinChnl(AudIntf aud) throws CumExcpAudExists;

	/**
	 * @param aud
	 * @throws CumExcpAudNotExist
	 */
	public NtfyCmdLvChnl lvChnl(AudIntf aud) throws CumExcpAudNotExist;

	/**
	 * @param rscName
	 * @return
	 * @throws CumExcpRscNotExist
	 */
	public ChnlRscIntf getRsc(String rscName) throws CumExcpRscNotExist;

}
