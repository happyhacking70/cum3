/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface CmdSenderIntf {
	/**
	 * <UL>
	 * <LI>sedn command</LI>
	 * <LI>When {@link CumExcpXMLGenFailed} is detected, this should tell server
	 * administrator via {@link SvrAdmIntf#xmlGenErrDetected(XMLableCmdIntf)}</LI>
	 * </UL>
	 * 
	 * @param cmd
	 */
	void sendCmd(XMLableCmdIntf cmd);
}
