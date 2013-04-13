/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class NtfyCmdChnlAbst extends CmdChnlAbst implements
		NtfyCmdIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public NtfyCmdChnlAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

}
