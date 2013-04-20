/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class CumExcpSeshChnlRscAbst extends CumExcpSeshChnlAbst {

	private static final long serialVersionUID = 1L;

	protected String rscName;

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcpSeshChnlRscAbst(String seshName, CumExcpSeshChnlRscAbst e) {
		super(seshName, e.getChnlName());
		this.rscName = e.getRscName();
	}

	/**
	 * @param chnlName
	 * @param rscName
	 */
	public CumExcpSeshChnlRscAbst(String chnlName, String rscName) {
		super(chnlName);
		this.rscName = rscName;
	}

	/**
	 * @return
	 */
	final public String getRscName() {
		return rscName;
	}

}
