/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr;

import jp.happyhacking70.cum3.excp.CumExcpSeshAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpSeshNotExist extends CumExcpSeshAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param seshName
	 */
	public CumExcpSeshNotExist(String seshName) {
		super(seshName);
	}

}
