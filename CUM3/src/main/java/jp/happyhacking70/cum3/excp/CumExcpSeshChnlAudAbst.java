/**
 * 
 */
package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class CumExcpSeshChnlAudAbst extends CumExcpSeshChnlAbst {

	private static final long serialVersionUID = 1L;

	protected String audName;

	/**
	 * @param seshName
	 * @param e
	 */
	public CumExcpSeshChnlAudAbst(String seshName, CumExcpSeshChnlAudAbst e) {
		super(seshName, e.getChnlName());
		this.audName = e.getAudName();
	}

	/**
	 * @param chnlName
	 * @param audName
	 */
	public CumExcpSeshChnlAudAbst(String chnlName, String audName) {
		super(chnlName);
		this.audName = audName;
	}

	public CumExcpSeshChnlAudAbst(String seshName, String chnlName,
			String audName) {
		super(seshName, chnlName);
		this.audName = audName;
	}

	/**
	 * @return
	 */
	final public String getAudName() {
		return audName;
	}

}
