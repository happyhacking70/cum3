/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlAudIntf {
	public void joinChnl(AudIntf aud) throws CumExcpAudExists;

	public void lvChnl(AudIntf aud) throws CumExcpAudNotExist;

	public ChnlRscIntf getRsc(String rscName) throws CumExcpRscNotExist;

}
