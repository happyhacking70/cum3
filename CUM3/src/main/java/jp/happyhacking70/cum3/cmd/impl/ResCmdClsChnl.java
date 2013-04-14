/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.ResCmdChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdClsChnl extends ResCmdChnlAbst {
	public enum RsltTypes {
		Clsed, NotExist
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rslt
	 */
	public ResCmdClsChnl(String seshName, String chnlName, RsltTypes rslt) {
		super(seshName, chnlName, rslt.name());
	}

	@Override
	protected void setActionName() {
		actionName = "ClsChnl";
	}

}
