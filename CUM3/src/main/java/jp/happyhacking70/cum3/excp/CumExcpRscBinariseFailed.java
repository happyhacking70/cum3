/**
 * 
 */
package jp.happyhacking70.cum3.excp;

import java.io.IOException;

/**
 * Channel Resource can not be binarized.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscBinariseFailed extends CumExcp {

	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public CumExcpRscBinariseFailed(IOException e) {
		super(e);
	}

}
