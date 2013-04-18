/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpChnlNotEixt extends CumExcp {

	private static final long serialVersionUID = 1L;

	protected String chanlName;

	public CumExcpChnlNotEixt(String chanlName) {
		super();
		this.chanlName = chanlName;
	}

	public CumExcpChnlNotEixt(String seshName, CumExcpChnlNotEixt e) {
		super(seshName + "/" + e.getChanlName());
	}

	public String getChanlName() {
		return chanlName;
	}

}
