/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscExists extends CumExcp {

	private static final long serialVersionUID = 1L;

	protected String chnlName;
	protected String rscName;

	// public CumExcpRscExists(String rscName) {
	// super(rscName);
	// }
	public CumExcpRscExists(String seshName, CumExcpRscExists e) {
		super(seshName + "/" + e.getChnlName() + "/" + e.getRscName());
	}

	/**
	 * @param chnlName
	 * @param name
	 */
	public CumExcpRscExists(String chnlName, String rscName) {
		super();
		this.chnlName = chnlName;
		this.rscName = rscName;
	}

	public String getChnlName() {
		return chnlName;
	}

	public String getRscName() {
		return rscName;
	}

}
