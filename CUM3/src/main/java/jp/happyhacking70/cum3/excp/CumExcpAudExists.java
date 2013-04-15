/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpAudExists extends CumExcp {
	private static final long serialVersionUID = 1L;
	protected String chnlName;
	protected String audName;

	public CumExcpAudExists(String chnlName, String audName) {
		super();
		this.chnlName = chnlName;
		this.audName = audName;
	}

	public CumExcpAudExists(String seshName, CumExcpAudExists e) {
		super(seshName + "/" + e.getChnlName() + "/" + e.getAudName());
	}

	public String getChnlName() {
		return chnlName;
	}

	public String getAudName() {
		return audName;
	}
}
