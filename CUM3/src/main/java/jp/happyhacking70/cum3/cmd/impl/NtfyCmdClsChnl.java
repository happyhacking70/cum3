/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.NtfyCmdChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdClsChnl extends NtfyCmdChnlAbst {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public NtfyCmdClsChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	@Override
	protected void setActionName() {
		actionName = "ClsChnl";
	}

}
