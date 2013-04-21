/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpSeshAbst extends CumExcpAbst {

	private static final long serialVersionUID = 1L;

	protected String seshName = null;

	public CumExcpSeshAbst() {
		super();
	}

	/**
	 * @param seshName
	 */
	public CumExcpSeshAbst(String seshName) {
		super(seshName);
		this.seshName = seshName;
	}

	/**
	 * @return session name
	 */
	final public String getSeshName() {
		return seshName;
	}

}
