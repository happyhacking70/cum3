/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;

/**
 * Not from presenter and audience. Internally required interface on
 * presentation server.
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshInternalIntf {

	/**
	 * <UL>
	 * <LI>sned command to all <U>session</U> audiences</LI>
	 * </UL>
	 * 
	 * @param cmd
	 */
	public void ntfySeshDisconned();

	public void ntfyAudDisconned(String audName) throws CumExcpComError;

	public String getSeshName();

	public void sendCmdToPrestr(XMLableCmdIntf cmd);

}