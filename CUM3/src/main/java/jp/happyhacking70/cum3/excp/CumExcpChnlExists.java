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

	public CumExcpChnlExists(String seshName, String chnlName) {
		super(seshName + "/" + chnlName);
	}

}
