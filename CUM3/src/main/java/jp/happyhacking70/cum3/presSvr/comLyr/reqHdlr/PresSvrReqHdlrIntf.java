/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr;

import java.util.List;
import java.util.Map;

import jp.happyhacking70.cum3.excp.impl.comLyr.CumExcpParamMissing;
import jp.happyhacking70.cum3.excp.impl.comLyr.CumExcpParamShouldOne;

/**
 * Interface of PresSvrReqHdlr
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface PresSvrReqHdlrIntf {
	/**
	 * Checks if there are enough parameters
	 * 
	 * @param params
	 * @throws CumExcpParamMissing
	 * @throws CumExcpParamShouldOne
	 */
	public abstract void checkParams(Map<String, List<String>> params)
			throws CumExcpParamMissing, CumExcpParamShouldOne;

	/**
	 * Set properties from parameters
	 * 
	 * @param params
	 */
	public abstract void setParams(Map<String, List<String>> params);

	/**
	 * handle request
	 */
	abstract public void handleReq();

}