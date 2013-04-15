/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpRscNull extends CumExcp {

	private static final long serialVersionUID = 1L;
	protected String chnlName;

	public CumExcpRscNull(String chnlName) {
		super();
		this.chnlName = chnlName;
	}

	public CumExcpRscNull(String seshName, CumExcpRscNull e) {
		super(seshName + "/" + e.getChnlName());
	}

	public String getChnlName() {
		return chnlName;
	}

}
