/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscNotExist extends CumExcp {

	private static final long serialVersionUID = 1L;

	protected String rscName;

	public CumExcpRscNotExist(String rscName) {
		super();
		this.rscName = rscName;
	}

	public String getRscName() {
		return rscName;
	}

}
