/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.comLyr;

import jp.happyhacking70.cum3.excp.CumExcpAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpParamMissing extends CumExcpAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param requiredParam
	 */
	public CumExcpParamMissing(String requiredParam) {
		super(requiredParam);
	}

}
