/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr;

import jp.happyhacking70.cum3.excp.CumExcpSeshChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpChnlNotExist extends CumExcpSeshChnlAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public CumExcpChnlNotExist(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

}
