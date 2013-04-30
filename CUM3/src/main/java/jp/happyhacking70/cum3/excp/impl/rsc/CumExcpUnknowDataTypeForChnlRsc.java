/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.rsc;

import jp.happyhacking70.cum3.excp.CumExcpAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpUnknowDataTypeForChnlRsc extends CumExcpAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public CumExcpUnknowDataTypeForChnlRsc(String dataType) {
		super(dataType);
	}

}
