/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface AudIntf {

	/**
	 * @return Audience Name
	 */
	String getAudName();

	/**
	 * @param seshName
	 * @param chnlName
	 */
	void clsChnl(String seshName, String chnlName);

	public void sendCmd(CmdAbst cmd);
}
