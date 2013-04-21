/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.impl.NtfyCmdSeshDisconned;

/**
 * <UL>
 * <LI>Accept the case session is disconnected</LI>
 * <LI>send {@link NtfyCmdSeshDisconned} to all <U>session</U> audiences</LI>
 * <LI>remove session from sessions</LI>
 * </UL>
 * <BR>
 * Recommended way<BR>
 * <UL>
 * <LI>return to caller as soon as possible</LI>
 * <LI>remaining tasks are executed asynchronously</LI>
 * </UL>
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface AcptSeshDisconnedIntf {
	void acceptSeshDisconned(String seshName);
}
