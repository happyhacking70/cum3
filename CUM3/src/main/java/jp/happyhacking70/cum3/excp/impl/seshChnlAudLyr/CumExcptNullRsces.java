/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr;

import jp.happyhacking70.cum3.excp.CumExcpSeshChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcptNullRsces extends CumExcpSeshChnlAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcptNullRsces(String seshName, CumExcpSeshChnlAbst e) {
		super(seshName, e);
	}

	/**
	 * @param chnlName
	 */
	public CumExcptNullRsces(String chnlName) {
		super(chnlName);
	}

}
