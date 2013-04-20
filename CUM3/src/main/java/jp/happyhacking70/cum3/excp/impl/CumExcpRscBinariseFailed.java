/**
 * 
 */
package jp.happyhacking70.cum3.excp.impl;

import java.io.IOException;

import jp.happyhacking70.cum3.excp.CumExcpAbst;

/**
 * Channel Resource can not be binarized.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscBinariseFailed extends CumExcpAbst {

	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public CumExcpRscBinariseFailed(IOException e) {
		super(e);
	}

}
