/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc;

import jp.happyhacking70.cum3.excp.impl.CumExcpRscBinariseFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscJustName extends ChnlRscAbst {

	/**
	 * @param name
	 */
	public ChnlRscJustName(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscAbst#getMimeType()
	 */
	@Override
	public String getMimeType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscAbst#getBinary()
	 */
	@Override
	public byte[] getBinary() throws CumExcpRscBinariseFailed {
		return null;
	}

}
