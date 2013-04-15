/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface ChnlPrestrIntf {

	public void sendChnlCmd(CmdAbst cmd, AudIntf aud) throws CumExcpAudNotExist;

	public void sendChnlCmd(CmdAbst cmd) throws CumExcpAudNotExist;

	public void clsChnl(String seshName);

}
