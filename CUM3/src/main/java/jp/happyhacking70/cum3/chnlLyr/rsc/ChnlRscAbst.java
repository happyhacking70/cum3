/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc;

import jp.happyhacking70.cum3.excp.CumExcpRscBinariseFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class ChnlRscAbst implements ChnlRscIntf {
	protected String name;

	public ChnlRscAbst(String name) {
		super();
		this.name = name;
	}

	abstract public String getMimeType();

	public String getName() {
		return name;
	}

	abstract public byte[] getBinary() throws CumExcpRscBinariseFailed;

}
