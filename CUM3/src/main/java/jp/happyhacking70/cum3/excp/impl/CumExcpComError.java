/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl;

import jp.happyhacking70.cum3.excp.CumExcpAbst;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpComError extends CumExcpAbst {

	/**
	 * @param message
	 */
	public CumExcpComError(String message) {
		super(message);
	}

	/**
	 * @param e
	 */
	public CumExcpComError(CumExcpRscNotExist e) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 */
	public CumExcpComError(CumExcpRscBinariseFailed e) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 */
	public CumExcpComError(CumExcpXMLGenFailed e) {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
