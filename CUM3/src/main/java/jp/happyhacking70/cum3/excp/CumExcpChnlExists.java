/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpChnlExists extends CumExcp {

	private static final long serialVersionUID = 1L;
	protected String chnlName;

	public CumExcpChnlExists(String seshName, CumExcpChnlExists e) {
		super(seshName + "/" + e.getChnlName());
	}

	/**
	 * @param chnlName
	 */
	public CumExcpChnlExists(String chnlName) {
		this.chnlName = chnlName;
	}

	public String getChnlName() {
		return chnlName;
	}

}
