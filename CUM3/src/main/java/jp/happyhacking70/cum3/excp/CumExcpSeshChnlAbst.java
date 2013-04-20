/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CumExcpSeshChnlAbst extends CumExcpSeshAbst {

	private static final long serialVersionUID = 1L;
	protected String chnlName;

	/**
	 * @param chnlName
	 */
	public CumExcpSeshChnlAbst(String chnlName) {
		super();
		this.chnlName = chnlName;
	}

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public CumExcpSeshChnlAbst(String seshName, String chnlName) {
		super(seshName);
		this.chnlName = chnlName;
	}

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcpSeshChnlAbst(String seshName, CumExcpSeshChnlAbst e) {
		super(seshName);
		this.chnlName = e.getChnlName();
	}

	/**
	 * @return
	 */
	final public String getChnlName() {
		return chnlName;
	}

}
