/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface CmdSenderIntf {
	void sendCmd(XMLableCmdIntf cmd) throws CumExcpComError;

}
