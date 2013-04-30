/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl.rsc;

import jp.happyhacking70.cum3.excp.CumExcpAbst;

/**
 * Channel Resource can not be binarized.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscInstantiateFailed extends CumExcpAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public CumExcpRscInstantiateFailed(Exception e) {
		super(e);
	}

}
