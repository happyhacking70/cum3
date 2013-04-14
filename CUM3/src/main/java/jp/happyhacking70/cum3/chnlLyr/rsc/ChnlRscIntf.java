/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc;

import jp.happyhacking70.cum2.excp.CumExcpRscBinariseFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlRscIntf {
	public String getMimeType();

	public String getName();

	public byte[] getBinary() throws CumExcpRscBinariseFailed;
}
