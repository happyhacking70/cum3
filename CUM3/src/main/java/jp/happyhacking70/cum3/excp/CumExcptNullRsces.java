/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcptNullRsces extends CumExcp {

	private static final long serialVersionUID = 1L;

	protected String chnlName;

	public CumExcptNullRsces(String seshName, CumExcptNullRsces e) {
		super(seshName + "/" + e.getChnlName());
	}

	public CumExcptNullRsces(String chnlName) {
		super();
		this.chnlName = chnlName;
	}

	public String getChnlName() {
		return chnlName;
	}

}
