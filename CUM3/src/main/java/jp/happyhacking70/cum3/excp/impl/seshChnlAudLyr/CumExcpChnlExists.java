/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr;

import jp.happyhacking70.cum3.excp.CumExcpSeshChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpChnlExists extends CumExcpSeshChnlAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param chnlName
	 */
	public CumExcpChnlExists(String chnlName) {
		super(chnlName);
	}

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public CumExcpChnlExists(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcpChnlExists(String seshName, CumExcpSeshChnlAbst e) {
		super(seshName, e);

	}

}
