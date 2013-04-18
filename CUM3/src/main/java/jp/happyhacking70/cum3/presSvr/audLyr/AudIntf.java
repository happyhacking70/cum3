/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface AudIntf {

	/**
	 * @return Audience Name
	 */
	String getAudName();

	public void sendCmd(CmdChnlAbst cmd);

}
