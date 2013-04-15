/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpAudNotExist extends CumExcp {

	protected String chnlName;
	protected String audName;

	private static final long serialVersionUID = 1L;

	public CumExcpAudNotExist(String chnlName, String audName) {
		super();
		this.chnlName = chnlName;
		this.audName = audName;
	}

	public CumExcpAudNotExist(String seshName, CumExcpAudNotExist e) {
		super(seshName + "/" + e.getChnlName() + "/" + e.getAudName());
	}

	public String getChnlName() {
		return chnlName;
	}

	public String getAudName() {
		return audName;
	}

}
