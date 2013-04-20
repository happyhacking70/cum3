/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr;

import jp.happyhacking70.cum3.excp.CumExcpSeshChnlAudAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpAudExists extends CumExcpSeshChnlAudAbst {
	private static final long serialVersionUID = 1L;

	/**
	 * @param chnlName
	 * @param audName
	 */
	public CumExcpAudExists(String chnlName, String audName) {
		super(chnlName, audName);

	}

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcpAudExists(String seshName, CumExcpSeshChnlAudAbst e) {
		super(seshName, e);
	}

}
