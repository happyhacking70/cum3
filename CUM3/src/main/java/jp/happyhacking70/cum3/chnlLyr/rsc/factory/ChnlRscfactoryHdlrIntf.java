/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc.factory;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlRscfactoryHdlrIntf {
	public ChnlRscIntf getChnlRsc(String name, byte[] bin)
			throws CumExcpRscInstantiateFailed;
}
